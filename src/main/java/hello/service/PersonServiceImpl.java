package hello.service;

import hello.domain.Person;
import hello.domain.PersonRepository;
import org.springframework.stereotype.Component;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by bourges on 06/06/14.
 */
@Component
public class PersonServiceImpl implements PersonService {

    @Inject
    private PersonRepository personRepository;

    public List<Person> getAllPersons () {
        List<Person> list = new ArrayList<Person>();
        for (Person person : personRepository.findAll()) {
            list.add(person);
        }
        return list;
    }
}
