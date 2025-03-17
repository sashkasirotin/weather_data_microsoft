**weather app**
**description:**
a java-spring boot app the has 2 api rest endpoints deployed using a ci-cd pipline of git actions witch is pushing every commit to master to the azure clude aks cluster ,and uses acr and azure sql db and sql server to store and fetch the weather data.

**my endpoins from postman by azure public ip:20.217.218.171 using this resource group MC_WeatherAppGroup_WeatherAppCluster_israelcentral**

**examples:
today weather
curl --location 'http://20.217.218.171/weather/fetch/today?location=tel-aviv'
hystory weather by dates
curl --location 'http://20.217.218.171/weather/fetch/history?location=jerusalem&startDate=2025-02-12&endDate=2025-03-12'**


**AZURE SETUP GUIDE**

1. AZURE ACCOUNT LOGIN
az login

2. RESOURCE GROUP SETUP
# Create main resource group
az group create --name WeatherResourceGroup --location israelcentral

# Register required providers
az provider register --namespace Microsoft.Compute
az provider register --namespace Microsoft.Sql
az provider register --namespace Microsoft.Insights
az provider register --namespace Microsoft.ContainerService

3. SQL DATABASE SETUP
# Create SQL Server
az sql server create --name weatherdata-sql-server --resource-group WeatherResourceGroup --location israelcentral --admin-user sqladmin --admin-password Alexsirotin!

# Create Database
az sql db create --resource-group WeatherResourceGroup --server weatherdata-sql-server --name weatherdb --service-objective Basic

# Configure firewall rule
az sql server firewall-rule create --resource-group WeatherResourceGroup --server weatherdata-sql-server --name AllowMyIP --start-ip-address 46.116.126.210 --end-ip-address 46.116.126.210

# Get connection string
az sql db show-connection-string --server weatherdata-sql-server --name weatherdb --client jdbc

4. AKS CLUSTER SETUP
# Create resource group for AKS
az group create --name WeatherAppGroup --location israelcentral

# Create AKS cluster
az aks create --resource-group WeatherAppGroup --name WeatherAppCluster --node-count 2 --enable-addons monitoring --generate-ssh-keys

# Get cluster credentials
az aks get-credentials --resource-group WeatherAppGroup --name WeatherAppCluster

5. AZURE CONTAINER REGISTRY (ACR)
# Create ACR
az acr create --resource-group WeatherAppGroup --name weatherappregistryalex --sku Basic

# Login to ACR
az acr login --name weatherappregistryalex

6. LINUX VM SETUP FOR DOCKER/KUBERNETES
# Create Ubuntu VM
az vm create --resource-group weatherDataTask --name WeatherAppVM --image Ubuntu2204 --size Standard_B1s --admin-username azureuser --generate-ssh-keys --public-ip-address

# Install essential tools
sudo apt-get update && sudo apt-get install -y docker.io kubectl helm

# Configure Docker permissions
sudo usermod -aG docker $USER && newgrp docker

7. DOCKER IMAGE MANAGEMENT
# Build and tag image
docker build -t weather-app:v1 .
docker tag weather-app:v1 weatherappregistryalex.azurecr.io/weather-app:v1

# Push to ACR
docker push weatherappregistryalex.azurecr.io/weather-app:v1

8. KUBERNETES DEPLOYMENT
# Create Helm chart
helm create weather-app

# Deploy to AKS
helm upgrade --install weather-app ./weather-app --set image.repository=weatherappregistryalex.azurecr.io/weather-app --set image.tag=latest

# Verify deployment
kubectl get pods
kubectl get svc

9. INGRESS CONTROLLER SETUP
# Add ingress-nginx repo
helm repo add ingress-nginx https://kubernetes.github.io/ingress-nginx
helm repo update

# Install ingress controller
helm install nginx-ingress ingress-nginx/ingress-nginx --namespace ingress-nginx --create-namespace --set controller.replicaCount=2 --set controller.service.externalTrafficPolicy=Local

# Verify ingress
kubectl get svc -n ingress-nginx

10. KEY VAULT SETUP
# Create Key Vault
az keyvault create --name alexSirotinKeyVault --resource-group WeatherAppGroup --location israelcentral

# Store secrets
az keyvault secret set --vault-name alexSirotinKeyVault --name user --value sqladmin
az keyvault secret set --vault-name alexSirotinKeyVault --name password --value Alexsirotin!

11. SERVICE PRINCIPAL SETUP
# Create service principal
az ad sp create-for-rbac --name "WeatherAppServicePrincipal"

# Assign roles
az role assignment create --assignee <service-principal-id> --role Contributor --scope /subscriptions/<subscription-id>
az role assignment create --assignee <service-principal-id> --role AcrPush --scope /subscriptions/<subscription-id>/resourceGroups/WeatherAppGroup/providers/Microsoft.ContainerRegistry/registries/weatherappregistryalex

12. CI/CD PIPELINE (EXAMPLE)
# ARM Template deployment
az deployment group create --resource-group WeatherAppGroup --template-file arm-template.json --parameters @parameters.json

VERIFICATION COMMANDS
# Check AKS nodes
kubectl get nodes

# Check ACR images
az acr repository list --name weatherappregistryalex

# Check SQL Server status
az sql server show --name weatherdata-sql-server --resource-group WeatherResourceGroup

# Get public IP
az network public-ip show --resource-group MC_WeatherAppGroup_WeatherAppCluster_israelcentral --name weather-app-public-ip --query ipAddress -o tsv

TROUBLESHOOTING TIPS
# Check pod logs
kubectl logs <pod-name>

# Describe pod issues
kubectl describe pod <pod-name>

# Check ingress events
kubectl get events -n ingress-nginx

GITHUB REPOSITORY SETUP
git init
git add .
git commit -m "Initial deployment setup"
git branch -M main
git remote add origin https://github.com/sashkasirotin/weather_data_microsoft.git
git push -u origin main
