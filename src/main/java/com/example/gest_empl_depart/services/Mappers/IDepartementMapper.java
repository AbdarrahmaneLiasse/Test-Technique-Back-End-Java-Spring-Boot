package com.example.gest_empl_depart.services.Mappers;

import com.example.gest_empl_depart.services.dto.DepartementDto;
import com.example.gest_empl_depart.services.models.Departement;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IDepartementMapper {
    DepartementDto toDto(Departement departement);
    Departement toEntity(DepartementDto departementDto);

    Departement map(DepartementDto departementDto);
}
