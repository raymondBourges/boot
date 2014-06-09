package fr.test.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.rest.webmvc.config.RepositoryRestMvcConfiguration;

@Configuration
@Import(RepositoryRestMvcConfiguration.class)
@EnableAutoConfiguration
@ComponentScan
public class Example {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Example.class, args);
    }

}
