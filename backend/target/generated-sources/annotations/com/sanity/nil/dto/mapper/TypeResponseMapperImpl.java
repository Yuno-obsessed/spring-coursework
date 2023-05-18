package com.sanity.nil.dto.mapper;

import com.sanity.nil.dto.response.TypeResponse;
import com.sanity.nil.model.Type;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-05-18T12:26:01+0200",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.6 (Oracle Corporation)"
)
@Component
public class TypeResponseMapperImpl implements TypeResponseMapper {

    @Override
    public Type toEntity(TypeResponse dto) {
        if ( dto == null ) {
            return null;
        }

        Type type = new Type();

        type.setId( dto.getId() );
        type.setName( dto.getName() );
        type.setDescription( dto.getDescription() );

        return type;
    }

    @Override
    public TypeResponse toDto(Type entity) {
        if ( entity == null ) {
            return null;
        }

        TypeResponse typeResponse = new TypeResponse();

        typeResponse.setId( entity.getId() );
        typeResponse.setName( entity.getName() );
        typeResponse.setDescription( entity.getDescription() );

        return typeResponse;
    }
}
