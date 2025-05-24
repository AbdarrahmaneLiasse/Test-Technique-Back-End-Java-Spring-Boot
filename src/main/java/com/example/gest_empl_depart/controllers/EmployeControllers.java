package com.example.gest_empl_depart.controllers;
import com.example.gest_empl_depart.services.IEmployeeService;
import com.example.gest_empl_depart.services.dto.EmployeeDTO;
import com.example.gest_empl_depart.services.models.Employee;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@Validated
@RestController
@RequestMapping("/employees")
public class EmployeControllers {
    private IEmployeeService employeeService;
    EmployeControllers(IEmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public List<EmployeeDTO> getAllEmployees(@RequestParam(required = false) Integer departement) {
        if (departement != null) {
            return employeeService.getEmployeesByDepId(departement);
        }
        return employeeService.getAllEmployees();
    }

    @GetMapping("/salaire")
    public List<EmployeeDTO> getEmployeesBySalary(@Parameter(description = "Salaire minimum") @RequestParam Double min) {
        return employeeService.getEmployeesBySalaryMin(min);
    }



    @PostMapping
    public ResponseEntity<EmployeeDTO> saveEmployee(@Valid @RequestBody EmployeeDTO employee, UriComponentsBuilder uriBuilder) {
        Employee employee1=employeeService.saveEmployee(employee);
        var uri=uriBuilder.path("/employees/{id}").buildAndExpand(employee1.getId()).toUri();
        return ResponseEntity.created(uri).body(employee);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<EmployeeDTO> deleteEmployee(@PathVariable Integer id) {
        employeeService.deleteEmployeeById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmployeeDTO> updateEmployee(@PathVariable Integer id,@Valid @RequestBody EmployeeDTO employee) {
        employeeService.updateEmployee(id,employee);
        return ResponseEntity.ok(employee);
    }
}


