package com.sanity.nil.dto.mapper;

import com.sanity.nil.dto.response.SurgeryResponse;
import com.sanity.nil.model.Surgery;
import org.mapstruct.Mapper;

/**
 * Mapper used for mapping SurgeryUserResponse fields
 */
@Mapper(componentModel = "spring")
public interface SurgeryResponseMapper {

    Surgery toEntity(SurgeryResponse dto);

    SurgeryResponse toDto(Surgery entity);

}
