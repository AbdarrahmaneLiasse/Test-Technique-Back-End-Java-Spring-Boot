package com.example.gest_empl_depart.services;

import com.example.gest_empl_depart.exceptions.EmailAlreadyExistException;
import com.example.gest_empl_depart.exceptions.ResourceNotFoundException;
import com.example.gest_empl_depart.repositories.IDepartementRepository;
import com.example.gest_empl_depart.repositories.IEmployeRepository;
import com.example.gest_empl_depart.services.Mappers.IEmployeeMapper;
import com.example.gest_empl_depart.services.dto.EmployeeDTO;
import com.example.gest_empl_depart.services.models.Departement;
import com.example.gest_empl_depart.services.models.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeService implements IEmployeeService{
private final IEmployeRepository  employeRepository;
    private IEmployeeMapper employeeMapper;
    @Autowired
    private final IDepartementRepository departementRepository;

    EmployeService(IEmployeRepository employeRepository, IEmployeeMapper employeeMapper, IDepartementRepository departementRepository) {
        this.employeRepository = employeRepository;
        this.employeeMapper = employeeMapper;
        this.departementRepository = departementRepository;
    }

    @Override
    public List<EmployeeDTO> getAllEmployees() {
        List<Employee> employee=employeRepository.findAll();
        List<EmployeeDTO> employeeDTOS=employee.stream().map(employeeMapper::toDto).toList();
        return employeeDTOS;
    }

    @Override
    public Employee saveEmployee(EmployeeDTO employee) {
        if (employee.getPrénom() == null || employee.getPrénom().isBlank()) {
            throw new IllegalArgumentException("Le prénom est obligatoire");
        }
        if (employeRepository.existsByEmail(employee.getEmail())) {
            throw new EmailAlreadyExistException("Email already exists: " + employee.getEmail());
        }
        if (employee.getDépartement() == null) {
            throw new IllegalArgumentException("Department ID cannot be null");
        }
        Departement departement = departementRepository.findById(employee.getDépartement())
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Department not found with id: " + employee.getDépartement() +
                                ". Please verify the department exists or create it first."));

        Employee employee1 = employeeMapper.toEntity(employee);
        employee1.setDépartement(departement);

        try {
            employeRepository.save(employee1);
        } catch (Exception e) {
            throw new RuntimeException("Failed to save employee: " + e.getMessage(), e);
        }
        return employee1;
    }

    @Override
    public void deleteEmployeeById(Integer id) {
        Employee employee=employeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee not found with id: " + id));
        employee.setId(Long.parseLong(id.toString()));
        employeRepository.delete(employee);
    }

    @Override
    public void updateEmployee(Integer id, EmployeeDTO employee) {
        if (employeRepository.existsByEmail(employee.getEmail())) {
            throw new EmailAlreadyExistException("Email already exists: " + employee.getEmail());
        }
        if (employee.getDépartement() == null) {
            throw new IllegalArgumentException("Department ID cannot be null");
        }
        Departement departement = departementRepository.findById(employee.getDépartement())
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Department not found with id: " + employee.getDépartement() +
                                ". Please verify the department exists or create it first."));

        try {
        Employee employee1=employeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee not found with id: " + id));
        employeeMapper.map(employee,employee1);
        employee1.setDépartement(departement);

            employeRepository.save(employee1);
        } catch (Exception e) {
            throw new RuntimeException("Failed to update employee: " + e.getMessage(), e);
        }
    }

    @Override
    public List<EmployeeDTO> getEmployeesBySalaryMin(Double min) {
        List<Employee> employees=employeRepository.findBySalaireGreaterThanEqual(min);
        List<EmployeeDTO> employeeDTOS=employees.stream().map(employeeMapper::toDto).toList();
        return employeeDTOS;
    }

    @Override
    public List<EmployeeDTO> getEmployeesByDepId(Integer department) {
        List<Employee> employees=employeRepository.findByDepartementID(Long.parseLong(department.toString()));
        List<EmployeeDTO> employeeDTOList=employees.stream().map(employeeMapper::toDto).toList();
        return employeeDTOList;
    }
}
