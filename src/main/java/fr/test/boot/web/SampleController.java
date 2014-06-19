package fr.test.boot.web;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.rest.webmvc.config.RepositoryRestMvcConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by bourges on 09/06/14.
 */
@Controller
@Configuration
//no antoConfiguration for spring-data-rest in boot 1.0.X:
@Import(RepositoryRestMvcConfiguration.class)
public class SampleController {
    @RequestMapping("/app")
    public String doIt() {
        return "app";
    }

}
