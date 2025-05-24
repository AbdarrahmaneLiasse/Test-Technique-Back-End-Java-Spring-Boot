package com.example.gest_empl_depart.services.Mappers;

import com.example.gest_empl_depart.services.dto.DepartementDto;
import com.example.gest_empl_depart.services.models.Departement;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-05-24T16:44:08+0100",
    comments = "version: 1.6.3, compiler: javac, environment: Java 23.0.2 (Oracle Corporation)"
)
@Component
public class IDepartementMapperImpl implements IDepartementMapper {

    @Override
    public DepartementDto toDto(Departement departement) {
        if ( departement == null ) {
            return null;
        }

        DepartementDto departementDto = new DepartementDto();

        departementDto.setNom( departement.getNom() );
        departementDto.setDescription( departement.getDescription() );

        return departementDto;
    }

    @Override
    public Departement toEntity(DepartementDto departementDto) {
        if ( departementDto == null ) {
            return null;
        }

        Departement departement = new Departement();

        departement.setNom( departementDto.getNom() );
        departement.setDescription( departementDto.getDescription() );

        return departement;
    }

    @Override
    public Departement map(DepartementDto departementDto) {
        if ( departementDto == null ) {
            return null;
        }

        Departement departement = new Departement();

        departement.setNom( departementDto.getNom() );
        departement.setDescription( departementDto.getDescription() );

        return departement;
    }
}
