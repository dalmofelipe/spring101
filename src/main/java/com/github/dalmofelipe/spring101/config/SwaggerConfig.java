package com.github.dalmofelipe.spring101.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.headers.Header;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.media.StringSchema;
import io.swagger.v3.oas.models.parameters.Parameter;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
    // Swagger = http://localhost:8080/swagger-ui.html
    // OpenApi = http://localhost:8083/v3/api-docs
    @Bean
    public OpenAPI customOpenAPI(@Value("${springdoc.version}") String appVersion) {
      return new OpenAPI()
        .components(
                new Components()
                        .addSecuritySchemes("basicScheme", new SecurityScheme().type(SecurityScheme.Type.HTTP).scheme("basic"))
                        .addParameters("myHeader1", new Parameter().in("header").schema(new StringSchema()).name("myHeader1"))
                        .addHeaders("myHeader2", new Header().description("myHeader2 header").schema(new StringSchema()))
        )
        .info(new Info()
        .title("Spring101 API")
        .version(appVersion)
        .description("This is a sample server Spring101 server. You can find out more about Swagger at [http://swagger.io](http://swagger.io) or on [irc.freenode.net, #swagger](http://swagger.io/irc/). For this sample, you can use the api key `special-key` to test the authorization filters.")
        .termsOfService("http://swagger.io/terms/")
        .license(new License().name("Apache 2.0").url("http://springdoc.org")));
    }
}

