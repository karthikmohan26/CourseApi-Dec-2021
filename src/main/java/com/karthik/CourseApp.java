package com.karthik;

import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

//Step 4 Basic COnfiguration
//Tells that it is a Spring Application
@SpringBootApplication
// Step 2: Swagger
@EnableSwagger2
public class CourseApp {

	public static void main(String[] args) {

		// Step 5
		// Sets up Default Configuration
		// Starts Application Context
		// Performs the Class path Scan(@Service)
		// Starts Tomcat Server
		SpringApplication.run(CourseApp.class, args);

	}

	// Step-3 Swagger - Start
	@Bean
	public Docket SpringBootConfiguration() {

		return new Docket(DocumentationType.SWAGGER_2).
				select().
				// To be Verified 
			    //paths(PathSelectors.ant("/api/*")).
				apis(RequestHandlerSelectors.basePackage("com.karthik")).
				build().
				apiInfo(apiDetails());
}
	
	private ApiInfo apiDetails() {
		
		return new ApiInfo("Contact API", 
				"Sample Course API", 
				"v1 ",
				 "www.google.com",
				new springfox.documentation.service.Contact("Karthik", "www.karthik.com", "karthik.mohan22@gmail.com"), 
				"Karthik License" , 
				"www.karthik.com",
				Collections.EMPTY_LIST);
		
		
	}
	
	//Step 3- Swagger - End

}
