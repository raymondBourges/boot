package hello;

import hello.domain.Person;
import hello.service.PersonService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.webmvc.config.RepositoryRestMvcConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;
import java.util.List;

@Configuration
@Import(RepositoryRestMvcConfiguration.class)
@EnableAutoConfiguration
@ComponentScan
@RestController
public class Example {
    @Inject
    PersonService personService;

    @RequestMapping("/")
    String home() {
        return "Hello World!";
    }

    @RequestMapping("/query")
    List<Person> queryDslExample(@Param("name") String name) {
        return personService.personNameContains(name);
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Example.class, args);
    }

}
