package hello;

import hello.domain.Person;
import hello.service.PersonService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;
import java.util.List;

@RestController
@EnableAutoConfiguration
@ComponentScan
public class Example {

    @Inject
    private PersonService personService;

    @RequestMapping("/")
    String home() {
        return "Hello World!";
    }

    @RequestMapping("/persons")
    List<Person> getPersons() {
        return personService.getAllPersons();
    }


    public static void main(String[] args) throws Exception {
        SpringApplication.run(Example.class, args);
    }

}
