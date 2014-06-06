package hello.domain;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by bourges on 06/06/14.
 */
public interface PersonRepository extends CrudRepository<Person, Long>, QueryDslPredicateExecutor<Person> {
    Page<Person> findAll(Pageable pageable);
}
