package fr.test.boot.web;

import fr.test.boot.domain.Person;
import fr.test.boot.service.PersonService;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by bourges on 09/06/14.
 */
@RestController
public class SampleController {
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

}
