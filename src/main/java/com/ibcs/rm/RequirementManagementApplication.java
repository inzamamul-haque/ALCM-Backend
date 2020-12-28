package com.ibcs.rm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class RequirementManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(RequirementManagementApplication.class, args);
	}

}
