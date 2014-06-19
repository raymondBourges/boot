package fr.test.boot.domain;

import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Component;

/**
 * Created by bourges on 06/06/14.
 */
@RepositoryRestResource(collectionResourceRel="persons", path="persons")
@Component
public interface PersonRepository extends CrudRepository<Person, Long>, QueryDslPredicateExecutor<Person> {
}
