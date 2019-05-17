package com.hiynn.module.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * description Swagger2Config
 *
 * @author LouLvLin
 * @version 1.0
 * @date 2019年04月18日 13:45
 */
@Configuration
@EnableSwagger2
public class Swagger2Config {
	@Bean
	public Docket createDocket() {
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(apiInfo())
				.groupName("groupMaster")
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.hiynn.module.controller"))
				.paths(PathSelectors.any())
				.build();
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
				.title("Project RESTful APIs")
				.description("project api document")
				.contact(new Contact("loulvlin", "", "loulvlin@hiynn.com"))
				.version("1.0")
				.build();
	}

}


