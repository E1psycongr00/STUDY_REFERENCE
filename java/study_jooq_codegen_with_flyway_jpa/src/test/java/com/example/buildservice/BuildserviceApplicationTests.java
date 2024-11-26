package com.example.buildservice;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

import com.example.buildservice.config.TestcontainersConfig;

@Import(TestcontainersConfig.class)
@SpringBootTest
class BuildserviceApplicationTests {

	@Test
	void contextLoads() {
	}

}
