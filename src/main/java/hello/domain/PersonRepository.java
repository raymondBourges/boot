package hello.domain;

import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Created by bourges on 06/06/14.
 */
@RepositoryRestResource(collectionResourceRel = "person", path = "person")
public interface PersonRepository extends CrudRepository<Person, Long>, QueryDslPredicateExecutor<Person> {
}
