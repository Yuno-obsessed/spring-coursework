package com.sanity.nil.dto.mapper;

import com.sanity.nil.dto.response.SurgeryResponse;
import com.sanity.nil.model.Surgery;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * Mapper used for mapping SurgeryUserResponse fields
 */
@Mapper(componentModel = "spring")
public interface SurgeryResponseMapper {

    Surgery toEntity(SurgeryResponse dto);

    @Mapping(source = "pet.name", target = "name")
    @Mapping(source = "pet.id", target = "petId")
    SurgeryResponse toDto(Surgery entity);

}
