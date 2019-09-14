package com.infy;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class ContactsInfoSwaggerConfig {

	@Bean
	public Docket swaggerConfiguration() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.paths(PathSelectors.ant("/contacts-info/*"))
				.apis(RequestHandlerSelectors.basePackage("com.infy"))
				.build()
				.apiInfo(apiInfo());
	}
	
	private ApiInfo apiInfo() {
		return new ApiInfo("Contacts Info API", "API providing contacts", "1.0", "Free to use", 
				new Contact("Dharma Teja", "http://github.com/dharma37eng/", "dharma37eng@gmail.com"),
				"API License", "http://github.com/dharma37eng/", Collections.emptyList());
	}

}
