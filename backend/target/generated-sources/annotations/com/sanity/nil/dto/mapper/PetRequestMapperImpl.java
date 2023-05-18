package com.sanity.nil.dto.mapper;

import com.sanity.nil.dto.request.PetRequest;
import com.sanity.nil.model.Pet;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-05-18T12:26:02+0200",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.6 (Oracle Corporation)"
)
@Component
public class PetRequestMapperImpl implements PetRequestMapper {

    @Override
    public Pet toEntity(PetRequest dto) {
        if ( dto == null ) {
            return null;
        }

        Pet pet = new Pet();

        pet.setId( dto.getId() );

        pet.setName( org.apache.commons.text.WordUtils.capitalizeFully(dto.getName()) );

        return pet;
    }

    @Override
    public PetRequest toDto(Pet entity) {
        if ( entity == null ) {
            return null;
        }

        PetRequest petRequest = new PetRequest();

        petRequest.setId( entity.getId() );
        petRequest.setName( entity.getName() );

        return petRequest;
    }
}
