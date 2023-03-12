package org.example.model;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Builder
@Getter(AccessLevel.PUBLIC)
@Setter(AccessLevel.PUBLIC)
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
//@Accessors(fluent = true) // Not to be integrated with Mapstruct...
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UpdateEmployee {

    String firstName, lastName;
    LocalDate birth_date;
}
