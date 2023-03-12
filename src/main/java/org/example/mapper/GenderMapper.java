package org.example.mapper;

import org.example.dto.EmployeeDto;
import org.example.model.Employee;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.ValueMapping;
import org.mapstruct.ValueMappings;

@Mapper
public interface GenderMapper {

    @ValueMappings({
       @ValueMapping(source = "MALE", target = "HOMME"),
       @ValueMapping(source = "FEMALE", target = "FEMME")
    }) EmployeeDto.GenderDto toDto(Employee.Gender gender);

    @InheritInverseConfiguration
    Employee.Gender toGender(EmployeeDto.GenderDto dto);
}
