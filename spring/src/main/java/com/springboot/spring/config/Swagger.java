package com.springboot.spring.config;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableSwagger2
public class Swagger {
    @Bean
	public Docket application() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.paths(PathSelectors.ant("/student/*"))
				.apis( RequestHandlerSelectors.basePackage("com.springboot.spring.*"))
				.build()
				.apiInfo(applicationinfo());

				
	}
    private ApiInfo applicationinfo() {
            
            
            return new ApiInfo(
                    
                    
                    
                    Collections.emptyList());
        }
    
}
