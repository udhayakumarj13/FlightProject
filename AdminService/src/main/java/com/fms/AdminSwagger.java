package com.fms;
import static springfox.documentation.builders.PathSelectors.regex;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class AdminSwagger {

	@Bean
	public Docket postsApi() {
		return new Docket(DocumentationType.SWAGGER_2). apiInfo(metadata()).select().paths(regex("/admin.*")).build();
	}

	@SuppressWarnings("deprecation")
	private ApiInfo metadata() {
	return new ApiInfoBuilder().title("Flight Reservation System rds").description("Welcome to CTS Microservices Team").termsOfServiceUrl("https://www....../").contact("Udhay").version("1.0").build();	
	}
}