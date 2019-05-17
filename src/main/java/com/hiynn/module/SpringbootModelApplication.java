package com.hiynn.module;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
* description  SpringbootModelApplication
* @author LouLvLin
* @date  2019/4/10  10:34
* @param 
* @return 
**/
@SpringBootApplication
@ServletComponentScan
@MapperScan(basePackages="com.hiynn.module.dao")
@EnableTransactionManagement
@EnableCaching
public class SpringbootModelApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootModelApplication.class, args);
	}

}
