package org.example.mapper;

import org.example.dto.EmployeeDto;
import org.example.model.Employee;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProfessionMapper {

    ProfessionMapper PROFESSION_MAPPER = Mappers.getMapper(ProfessionMapper.class);

    @Mappings({
            @Mapping(source = "name", target = "profession"),
            @Mapping(source = "salary", target = "annual_salary")
    }) EmployeeDto.ProfessionDto toDto(Employee.Profession profession);

    @InheritInverseConfiguration
    Employee.Profession toProfession(EmployeeDto.ProfessionDto dto);
}
