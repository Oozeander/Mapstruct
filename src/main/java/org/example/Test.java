package org.example;

import org.example.model.Employee;
import org.example.model.UpdateEmployee;

import java.time.LocalDate;
import java.time.Month;

import static org.example.mapper.EmployeeMapper.EMPLOYEE_MAPPER;

public class Test {
    public static void main(String[] args) {
        var employee = Employee.builder()
                .firstName("Billel")
                .lastName("KETROUCI")
                .birthDate(LocalDate.of(1996, Month.SEPTEMBER, 9))
                .gender(Employee.Gender.MALE)
                .profession(
                        Employee.Profession.builder()
                                .name("Software Engineer")
                                .salary(45_000)
                                .build()
                )
                .build();
        var dto = EMPLOYEE_MAPPER.toDto(employee);
        System.out.println(dto + "\n" + EMPLOYEE_MAPPER.toEmployee(dto));

        System.out.println(EMPLOYEE_MAPPER.updateEmployeeFromDto(
                UpdateEmployee.builder()
                        .firstName("Billel")
                        .lastName("KETROUCI")
                        .birth_date(LocalDate.of(1996, Month.SEPTEMBER, 9))
                        .build(),
                Employee.builder().build()
        ));
    }
}
