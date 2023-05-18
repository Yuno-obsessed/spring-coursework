package com.sanity.nil.dto.mapper;

import com.sanity.nil.dto.response.TypeResponse;
import com.sanity.nil.model.Type;
import org.mapstruct.Mapper;

/**
 * Mapper used for mapping TypeResponse fields
 */
@Mapper(componentModel = "spring")
public interface TypeResponseMapper {

    Type toEntity(TypeResponse dto);

    TypeResponse toDto(Type entity);
}
