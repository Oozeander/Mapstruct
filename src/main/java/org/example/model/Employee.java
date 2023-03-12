package org.example.model;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.UUID;

@Builder
@Getter(AccessLevel.PUBLIC)
@Setter(AccessLevel.PUBLIC)
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
//@Accessors(fluent = true) // Not to be integrated with Mapstruct...
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Employee {

    UUID employeeId;
    String firstName, lastName;
    LocalDate birthDate;

    Profession profession;

    Gender gender;

    @Builder
    public record Profession(String name, int salary) {}

    public enum Gender {
        MALE("Homme"), FEMALE("Femme");

        private String fr;

        Gender(String fr) {
            this.fr = fr;
        }

        public String getFr() {
            return this.fr;
        }
    }
}
