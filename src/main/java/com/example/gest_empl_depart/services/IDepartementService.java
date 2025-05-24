package com.example.gest_empl_depart.services;
import com.example.gest_empl_depart.services.dto.DepartementDto;
import com.example.gest_empl_depart.services.models.Departement;
import java.util.List;

public interface IDepartementService {
    List<DepartementDto> getDepartements();
    Departement saveDepartement(DepartementDto departement);
    void deleteDepartement(int id);
    void updateDepartement(int id,DepartementDto departement);
}
