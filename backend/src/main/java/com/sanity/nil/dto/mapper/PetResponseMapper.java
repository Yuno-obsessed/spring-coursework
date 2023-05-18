package com.sanity.nil.dto.mapper;

import com.sanity.nil.dto.response.PetResponse;
import com.sanity.nil.model.Pet;
import org.mapstruct.Mapper;

/**
 * Mapper used for mapping PetResponse fields
 */
@Mapper(componentModel = "spring")
public interface PetResponseMapper {

    Pet toEntity(PetResponse dto);

    PetResponse toDto(Pet entity);
}
