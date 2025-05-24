package com.example.gest_empl_depart.services.Mappers;

import com.example.gest_empl_depart.services.dto.EmployeeDTO;
import com.example.gest_empl_depart.services.models.Departement;
import com.example.gest_empl_depart.services.models.Employee;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-05-24T16:44:08+0100",
    comments = "version: 1.6.3, compiler: javac, environment: Java 23.0.2 (Oracle Corporation)"
)
@Component
public class IEmployeeMapperImpl implements IEmployeeMapper {

    @Override
    public EmployeeDTO toDto(Employee employee) {
        if ( employee == null ) {
            return null;
        }

        EmployeeDTO employeeDTO = new EmployeeDTO();

        Long id = employeeDépartementId( employee );
        if ( id != null ) {
            employeeDTO.setDépartement( id.intValue() );
        }
        employeeDTO.setNom( employee.getNom() );
        employeeDTO.setPrénom( employee.getPrénom() );
        employeeDTO.setEmail( employee.getEmail() );
        employeeDTO.setPoste( employee.getPoste() );
        employeeDTO.setSalaire( employee.getSalaire() );

        return employeeDTO;
    }

    @Override
    public Employee toEntity(EmployeeDTO employeeDTO) {
        if ( employeeDTO == null ) {
            return null;
        }

        Employee employee = new Employee();

        employee.setDépartement( map( employeeDTO.getDépartement() ) );
        employee.setNom( employeeDTO.getNom() );
        employee.setPrénom( employeeDTO.getPrénom() );
        employee.setEmail( employeeDTO.getEmail() );
        employee.setPoste( employeeDTO.getPoste() );
        if ( employeeDTO.getSalaire() != null ) {
            employee.setSalaire( employeeDTO.getSalaire() );
        }

        return employee;
    }

    @Override
    public void map(EmployeeDTO employeeDTO, Employee employee) {
        if ( employeeDTO == null ) {
            return;
        }

        employee.setNom( employeeDTO.getNom() );
        employee.setPrénom( employeeDTO.getPrénom() );
        employee.setEmail( employeeDTO.getEmail() );
        employee.setPoste( employeeDTO.getPoste() );
        if ( employeeDTO.getSalaire() != null ) {
            employee.setSalaire( employeeDTO.getSalaire() );
        }
        employee.setDépartement( map( employeeDTO.getDépartement() ) );
    }

    private Long employeeDépartementId(Employee employee) {
        Departement département = employee.getDépartement();
        if ( département == null ) {
            return null;
        }
        return département.getId();
    }
}
