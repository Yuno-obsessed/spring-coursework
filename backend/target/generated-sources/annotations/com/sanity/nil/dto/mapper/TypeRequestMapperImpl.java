package com.sanity.nil.dto.mapper;

import com.sanity.nil.dto.request.TypeRequest;
import com.sanity.nil.model.Type;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-05-18T12:26:02+0200",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.6 (Oracle Corporation)"
)
@Component
public class TypeRequestMapperImpl implements TypeRequestMapper {

    @Override
    public Type toEntity(TypeRequest dto) {
        if ( dto == null ) {
            return null;
        }

        Type type = new Type();

        type.setId( dto.getId() );
        type.setDescription( dto.getDescription() );

        type.setName( org.apache.commons.text.WordUtils.capitalizeFully(dto.getName()) );

        return type;
    }

    @Override
    public TypeRequest toDto(Type entity) {
        if ( entity == null ) {
            return null;
        }

        TypeRequest typeRequest = new TypeRequest();

        typeRequest.setId( entity.getId() );
        typeRequest.setName( entity.getName() );
        typeRequest.setDescription( entity.getDescription() );

        return typeRequest;
    }
}
