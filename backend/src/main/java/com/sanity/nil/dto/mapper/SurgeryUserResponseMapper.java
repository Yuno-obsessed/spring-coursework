package com.sanity.nil.dto.mapper;

import com.sanity.nil.dto.response.SurgeryPetResponse;
import com.sanity.nil.dto.response.SurgeryUserResponse;
import com.sanity.nil.model.Surgery;
import org.mapstruct.Mapper;

/**
 * Mapper used for mapping SurgeryUserResponse fields
 */
@Mapper(componentModel = "spring")
public interface SurgeryUserResponseMapper {

    Surgery toEntity(SurgeryUserResponse dto);

    SurgeryUserResponse toDto(Surgery entity);

}
