package com.example.buildservice;

import org.springframework.boot.SpringApplication;

import com.example.buildservice.config.TestcontainersConfig;

public class TestBuildserviceApplication {

	public static void main(String[] args) {
		SpringApplication.from(BuildserviceApplication::main).with(TestcontainersConfig.class).run(args);
	}

}
