package com.example.gest_empl_depart.controllers;
import com.example.gest_empl_depart.services.IDepartementService;
import com.example.gest_empl_depart.services.dto.DepartementDto;
import com.example.gest_empl_depart.services.models.Departement;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("departements")
public class DepartementControllers {
    private final IDepartementService departementService;

    public DepartementControllers(IDepartementService departementService) {
        this.departementService = departementService;
    }

    @GetMapping
    public List<DepartementDto> getAllDepartements() {
        return departementService.getDepartements();
    }

    @PostMapping
    public ResponseEntity<DepartementDto> saveDepartement(@RequestBody DepartementDto departement, UriComponentsBuilder uriBuilder) {
        Departement departement1=departementService.saveDepartement(departement);
        var uri=uriBuilder.path("/departements/{id}").buildAndExpand(departement1.getId()).toUri();
        return ResponseEntity.created(uri).body(departement);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DepartementDto> deleteDepartement(@PathVariable Integer id) {
        departementService.deleteDepartement(id);
        return ResponseEntity.noContent().build();  // HTTP 202 Accepted
    }

    @PutMapping("/{id}")
    public ResponseEntity<DepartementDto> updateDepartement(@PathVariable Integer id, @RequestBody DepartementDto departement) {
        departementService.updateDepartement(id, departement);
        return ResponseEntity.accepted().build();

    }
}

