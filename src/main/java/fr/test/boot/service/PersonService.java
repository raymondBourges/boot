package fr.test.boot.service;

import fr.test.boot.domain.Person;

import java.util.List;

/**
 * Created by bourges on 06/06/14.
 */
public interface PersonService {

    public List<Person> getAllPersons();

    public List<Person> personNameContains(String content);

    public void addSomePersons();
}
