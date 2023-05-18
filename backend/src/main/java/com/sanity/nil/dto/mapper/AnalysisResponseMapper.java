package com.sanity.nil.dto.mapper;

import com.sanity.nil.dto.response.AnalysisResponse;
import com.sanity.nil.model.Analysis;
import org.mapstruct.Mapper;

/**
 * Mapper used for mapping AnalysisPesponse fields
 */
@Mapper(componentModel = "spring")
public interface AnalysisResponseMapper {


    Analysis toEntity(AnalysisResponse dto);

    AnalysisResponse toDto(Analysis entity);
}
