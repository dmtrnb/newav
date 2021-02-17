package org.example.newav.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.*;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Tag;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.stream.Collectors;
import java.util.stream.Stream;

@Configuration
@EnableSwagger2
public class SwaggerConfig extends WebMvcConfigurationSupport {

    @Value("${app.title: API}")
    private String title;
    @Value("${app.desc: desc}")
    private String description;
    @Value("${app.version: 1.0.0}")
    private String version;
    @Value("${app.author: author}")
    private String author;
    @Value("${app.site: site}")
    private String site;
    @Value("${app.email: email}")
    private String email;

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.withClassAnnotation(RestController.class))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo())
                .useDefaultResponseMessages(false)
                .consumes(Stream.of("application/json").collect(Collectors.toSet()))
                .produces(Stream.of("application/json").collect(Collectors.toSet()))
                .protocols(Stream.of("http").collect(Collectors.toSet()))
                .tags(new Tag("Ads", "Операции с отзывами", 1));
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title(title)
                .description(description)
                .version(version)
                .contact(new Contact(author, site, email))
                .build();
    }

    @Override
    public void addResourceHandlers( ResourceHandlerRegistry registry )
    {
        registry.addResourceHandler( "swagger-ui.html" )
                .addResourceLocations( "classpath:/META-INF/resources/" );
        registry.addResourceHandler( "/webjars/**" )
                .addResourceLocations( "classpath:/META-INF/resources/webjars/" );
    }
}
