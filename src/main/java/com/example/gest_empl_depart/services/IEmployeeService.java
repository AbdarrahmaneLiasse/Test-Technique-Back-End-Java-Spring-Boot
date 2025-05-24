package com.example.gest_empl_depart.services;


import com.example.gest_empl_depart.services.dto.EmployeeDTO;
import com.example.gest_empl_depart.services.models.Employee;

import java.util.List;

public interface IEmployeeService{
    List<EmployeeDTO> getAllEmployees();
    Employee saveEmployee(EmployeeDTO employee);
    void deleteEmployeeById(Integer id);
    void updateEmployee(Integer id,EmployeeDTO employee);

    List<EmployeeDTO> getEmployeesBySalaryMin(Double min);

    List<EmployeeDTO> getEmployeesByDepId(Integer department);
}
