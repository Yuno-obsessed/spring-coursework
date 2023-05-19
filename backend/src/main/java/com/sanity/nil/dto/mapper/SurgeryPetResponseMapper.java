package com.sanity.nil.dto.mapper;

import com.sanity.nil.dto.response.SurgeryPetResponse;
import com.sanity.nil.model.Surgery;
import org.mapstruct.Mapper;

/**
 * Mapper used for mapping SurgeryPetResponse fields
 */
@Mapper(componentModel = "spring")
public interface SurgeryPetResponseMapper {

    Surgery toEntity(SurgeryPetResponse dto);

    SurgeryPetResponse toDto(Surgery entity);
}
