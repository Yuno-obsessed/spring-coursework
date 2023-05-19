package com.sanity.nil.dto.mapper;

import com.sanity.nil.dto.request.SurgeryRequest;
import com.sanity.nil.model.Surgery;
import org.mapstruct.Mapper;

/**
 * Mapper used for mapping SurgeryPetResponse fields
 */
@Mapper(componentModel = "spring")
public interface SurgeryRequestMapper {

    Surgery toEntity(SurgeryRequest dto);

    SurgeryRequest toDto(Surgery entity);
}
