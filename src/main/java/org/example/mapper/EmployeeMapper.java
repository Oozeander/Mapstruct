package org.example.mapper;

import org.example.dto.EmployeeDto;
import org.example.model.Employee;
import org.example.model.UpdateEmployee;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper(uses = {ProfessionMapper.class, GenderMapper.class}) // (componentModel="spring") for DI in Spring apps
public interface EmployeeMapper {
    // Use abstract class to inject beans into the mapper for use, should be avoided

    // No need for this if DI is used
    EmployeeMapper EMPLOYEE_MAPPER = Mappers.getMapper(EmployeeMapper.class);

    @Mappings({
            // In case employeeId is null => set to defaultExpression in java or defaultValue in plain text
            @Mapping(source = "employeeId", target = "id", defaultExpression = "java(java.util.UUID.randomUUID().toString())"),
            @Mapping(source = "firstName", target = "first_name"),
            @Mapping(source = "lastName", target = "last_name"),
            @Mapping(source = "birthDate", target = "birth_date", dateFormat = "dd/MM/yyyy"), // Date format
            @Mapping(source = "gender", target = "gender"), // Optional as both source and target have same names
            @Mapping(source = "profession", target = "professionDto"),
            //@Mapping(source = "profession.name", target = "professionDto.profession"),
            //@Mapping(source = "profession.salary", target = "professionDto.annual_salary")
            @Mapping(source = "employee", target = "full_name", qualifiedByName = {"fullName"})
    }) EmployeeDto toDto(Employee employee);

    @BeforeMapping // on abstract classes only
    default void beforeMappingToDto(Employee employee, @MappingTarget EmployeeDto dto) {
        // Used to apply logic before the mapping to dto in contrast of employee
    }

    @AfterMapping // on abstract classes only
    default void afterMappingToDto(@MappingTarget EmployeeDto dto) {
        // Used to apply logic after the mapping
    }

    @InheritInverseConfiguration
    Employee toEmployee(EmployeeDto dto);

    // Update, returns T or void, works on every matching property, add mapping for different ones
    @Mapping(source = "birth_date", target = "birthDate")
    Employee updateEmployeeFromDto(UpdateEmployee updateEmployee, @MappingTarget Employee employee);

    // Custom mapping method
    @Named("fullName")
    default String getFullName(Employee employee) {
        return employee.getFirstName().concat(" ").concat(employee.getLastName());
    }
}
