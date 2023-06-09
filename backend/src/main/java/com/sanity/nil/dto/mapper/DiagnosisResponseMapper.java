package com.sanity.nil.dto.mapper;

import com.sanity.nil.dto.response.DiagnosisResponse;
import com.sanity.nil.model.Diagnosis;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * Mapper used for mapping DiagnosisPesponse fields
 */
@Mapper(componentModel = "spring")
public interface DiagnosisResponseMapper {

    Diagnosis toEntity(DiagnosisResponse dto);

    @Mapping(source = "pet.id", target = "petId")
    DiagnosisResponse toDto(Diagnosis entity);
}
