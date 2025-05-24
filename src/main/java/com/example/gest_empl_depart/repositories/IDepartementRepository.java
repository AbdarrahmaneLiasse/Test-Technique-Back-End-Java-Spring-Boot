package com.example.gest_empl_depart.repositories;

import com.example.gest_empl_depart.services.models.Departement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDepartementRepository extends JpaRepository<Departement,Integer> {

}
