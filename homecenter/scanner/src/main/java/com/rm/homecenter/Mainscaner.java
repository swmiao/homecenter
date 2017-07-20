package com.rm.homecenter;

import com.rm.homecenter.domain.FileAttribute;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.io.File;
import java.util.UUID;

@SpringBootApplication
@Configuration
@ComponentScan(basePackages="com.rm.homecenter")
@EnableAutoConfiguration
public class Mainscaner {

	public static void main(String[] args) {
		SpringApplication.run(Mainscaner.class, args);


	}
}
