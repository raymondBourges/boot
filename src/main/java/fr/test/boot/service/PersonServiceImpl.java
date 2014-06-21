package fr.test.boot.service;

import com.mysema.query.types.expr.BooleanExpression;
import fr.test.boot.domain.Person;
import fr.test.boot.domain.PersonRepository;
import fr.test.boot.domain.QPerson;
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

    @Override
    public List<Person> personNameContains(String content) {
        if (content == null) {
            return getAllPersons();
        }
        final BooleanExpression where =
                QPerson.person.name.upper().contains(content.toUpperCase());
        List<Person> list = new ArrayList<Person>();
        for (Person person : personRepository.findAll(where)) {
            list.add(person);
        }
        return list;
    }

    @Override
    public void addSomePersons() {
        personRepository.save(new Person("Sharapova", "Maria"));
        personRepository.save(new Person("Halep", "Simona"));
        personRepository.save(new Person("Nadal", "Rafael"));
        personRepository.save(new Person("Djokovic", "Novak"));
    }
}
