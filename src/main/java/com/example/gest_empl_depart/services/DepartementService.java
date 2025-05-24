package com.example.gest_empl_depart.services;
import com.example.gest_empl_depart.exceptions.ResourceNotFoundException;
import com.example.gest_empl_depart.services.Mappers.IDepartementMapper;
import com.example.gest_empl_depart.services.dto.DepartementDto;
import com.example.gest_empl_depart.services.models.Departement;
import com.example.gest_empl_depart.repositories.IDepartementRepository;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartementService implements IDepartementService {
    private final IDepartementRepository departementRepository;
    private IDepartementMapper departementMapper;


    public DepartementService(IDepartementRepository departementRepository,IDepartementMapper departementMapper) {
        this.departementRepository = departementRepository;
        this.departementMapper = departementMapper;
    }

    @Override
    public List<DepartementDto> getDepartements() {
        return departementRepository.findAll().stream().map(D->departementMapper.toDto(D)).toList();
    }


    @Override
    public Departement saveDepartement(DepartementDto departement) {
        Departement departement1=departementMapper.toEntity(departement);
        departementRepository.save(departement1);
        return departement1;
    }

    @Override
    public void deleteDepartement(int id) {
        Departement departement=departementRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Departement not found"+id));
        departementRepository.delete(departement);

    }

    @Override
    public void updateDepartement(int id,DepartementDto departement) {
        Departement departement1=departementRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Departement not found"));
        Departement d=departementMapper.toEntity(departement);
        d.setId(departement1.getId());
        departementRepository.save(d);
    }
}
