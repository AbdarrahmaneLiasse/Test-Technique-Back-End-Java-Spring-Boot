package com.example.gest_empl_depart.services.Mappers;

import com.example.gest_empl_depart.services.dto.EmployeeDTO;
import com.example.gest_empl_depart.services.models.Departement;
import com.example.gest_empl_depart.services.models.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
@Mapper(componentModel = "spring")
public interface IEmployeeMapper {

    @Mapping(source = "département.id", target = "département")
    EmployeeDTO toDto(Employee employee);

    @Mapping(source = "département", target = "département")

    Employee toEntity(EmployeeDTO employeeDTO);
    void map(EmployeeDTO employeeDTO,@MappingTarget Employee employee);


    // Helper method for reverse mapping (you can inject a service here)
    default Departement map(Integer id) {
        if (id == null) {
            return null;
        }
        Departement d = new Departement();
        d.setId(Long.parseLong(id.toString()));
        return d;
    }

    // If you want the reverse as well
    default Integer map(Departement d) {
        return d == null ? null : Integer.parseInt(d.getId().toString());
    }
}


