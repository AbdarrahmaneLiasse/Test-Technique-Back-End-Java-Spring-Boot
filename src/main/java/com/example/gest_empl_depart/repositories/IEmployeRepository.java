package com.example.gest_empl_depart.repositories;

import com.example.gest_empl_depart.services.models.Employee;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IEmployeRepository extends JpaRepository<Employee,Integer> {

    boolean existsByEmail(@Email(message = "Format d'Email invalide") @NotBlank(message = "L'email ne peut pas etre vide") String email);

    List<Employee> findBySalaireGreaterThanEqual(double salaireIsGreaterThan);
    @Query("SELECT e FROM Employee e WHERE e.département.id = :id")
    List<Employee> findByDepartementID(Long id);
}
