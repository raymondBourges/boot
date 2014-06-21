package fr.test.boot.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.rest.webmvc.config.RepositoryRestMvcConfiguration;

/**
 * Created by bourges on 21/06/14.
 */
@Configuration
//no antoConfiguration for spring-data-rest in boot 1.0.X:
@Import(RepositoryRestMvcConfiguration.class)
public class SampleConfig {
}
