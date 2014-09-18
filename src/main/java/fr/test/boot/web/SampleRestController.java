package fr.test.boot.web;

import fr.test.boot.domain.Person;
import fr.test.boot.service.PersonService;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.AuthenticationUserDetailsService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by bourges on 09/06/14.
 */
@RestController
public class SampleRestController {
    @Inject
    PersonService personService;

    @RequestMapping("/")
    String home() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String user = auth.getName();
        return "Hello World! (user: " + user + ")";
    }

    @RequestMapping("/query")
    List<Person> queryDslExample(@Param("name") String name) {
        return personService.personNameContains(name);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    void addSomePersons() {
        personService.addSomePersons();
    }

}
