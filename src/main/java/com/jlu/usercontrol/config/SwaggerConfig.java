package com.jlu.usercontrol.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Tag;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.DocExpansion;
import springfox.documentation.swagger.web.UiConfiguration;
import springfox.documentation.swagger.web.UiConfigurationBuilder;

@Configuration
public class SwaggerConfig {

    public static final String TAG_USER_CONTROLLER = "user-controller";

    @Bean
    public Docket api(){
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.jlu.usercontrol"))
                .paths(PathSelectors.any())
                .build()
                .tags(new Tag(TAG_USER_CONTROLLER, "Operations pertaining to User management"))
                .apiInfo(buildApiInfo())
                ;
    }

    private ApiInfo buildApiInfo() {
        return new ApiInfoBuilder()
                .title("Menu Items API")
                .description("REST API for interacting with menu items")
                .version("1.0.0")
                .contact(new Contact("Joshua Luppes", "www.joshualuppes.com", "joshua.luppes@gmail.com"))
                .license("Apache License Version 2.0")
                .licenseUrl("https://www.apache.org/licenses/LICENSE-2.0")
                .build();
    }

    @Bean
    UiConfiguration buildUiConfig() {
        return UiConfigurationBuilder.builder()
                .docExpansion(DocExpansion.FULL)
                .build();
    }
}
