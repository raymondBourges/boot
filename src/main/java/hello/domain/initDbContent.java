package hello.domain;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.inject.Inject;

/**
 * Created by bourges on 06/06/14.
 */
@Component
public class initDbContent implements CommandLineRunner {

    @Inject
    private PersonRepository personRepository;

    @Override
    public void run(String... args) {
        personRepository.save(new Person("Sharapova", "Maria"));
        personRepository.save(new Person("Halep", "Simona"));
        personRepository.save(new Person("Nadal", "Rafael"));
        personRepository.save(new Person("Djokovic", "Novak"));
    }
}
