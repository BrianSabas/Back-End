package com.porfolio.app.configuration;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/*
 * Configuracion para la documentacion usando Swagger v2
 * url1: http://localhost:9000/api/v2/api-docs
 * url2: http://localhost:9000/api/swagger-ui/index.html
 */

@EnableSwagger2
@EnableAutoConfiguration
@Configuration
public class SwaggerConfig {

	private ApiInfo apiInfo() {
		return new ApiInfo("Porfolio REST API", "Final API.", "API TOS", "Terms of service",
				new Contact("", "www.brian.com", "brian@gmail.com"), "License of API",
				"API license URL", Collections.emptyList());
	}
	
	private ApiInfo apiInfo2() {
		//Informacion de contacto
		Contact contact = new Contact("", "www.brian.com", "brian@gmail.com");
	       
	    @SuppressWarnings("rawtypes")
		List<VendorExtension> vendorExtensions = new ArrayList<>();
	    
	    return new ApiInfoBuilder()
	    		.title("Porfolio REST API")
	    		.version("1.0.0")
	            .description("Porfolio Final API.")
	            .termsOfServiceUrl("Terms of service")
	            .contact(contact)
	            .license("License of API")
	            .licenseUrl("http://localhost:9000/api/")
	            .extensions(vendorExtensions)
	            .build();
	}

    @Bean
    Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
        		.select()
                .apis(RequestHandlerSelectors.basePackage("com.porfolio.app.controller"))                
                .paths(PathSelectors.any())
                .build().apiInfo(this.apiInfo2());
    }

}
