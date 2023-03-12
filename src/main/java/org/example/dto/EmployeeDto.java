package org.example.dto;

import org.example.model.Employee;

public record EmployeeDto(
        String id,
        String first_name,
        String last_name,
        String birth_date,
        ProfessionDto professionDto,
        GenderDto gender,
        String full_name
) {
    public record ProfessionDto(String profession, int annual_salary) {}

    public enum GenderDto {
        HOMME, FEMME
    }
}
