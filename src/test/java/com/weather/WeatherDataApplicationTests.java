package com.weather;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class WeatherDataApplicationTests {


		@Autowired
		private ApplicationContext context;

		@Test
		void testRestTemplateBeanExists() {
			assertTrue(context.containsBean("restTemplate"));
		}


}
