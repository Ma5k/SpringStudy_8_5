package com.wisely.ch8_5;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching	//在SpringBoot中还是要使用@EnableCaching开启缓存支持。
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
