package com.hyc.onlineBookManagement;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.hyc.onlineBookManagement.dao")
public class OnlineBookManagementApplication {
	public static void main(String[] args) {
		SpringApplication.run(OnlineBookManagementApplication.class, args);
	}

}
