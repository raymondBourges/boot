package fr.test.boot.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by bourges on 06/06/14.
 */
@Entity
@RequiredArgsConstructor
@NoArgsConstructor
public class Person {
    @Getter @Setter @Id @GeneratedValue private Long id;
    @Getter @Setter @NonNull private String name;
    @Getter @Setter @NonNull private String firstName;
}
