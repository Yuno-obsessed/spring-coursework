package com.sanity.nil.dto.mapper;

import com.sanity.nil.dto.request.UserRequest;
import com.sanity.nil.model.User;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-05-18T12:26:02+0200",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.6 (Oracle Corporation)"
)
@Component
public class UserRequestMapperImpl implements UserRequestMapper {

    @Override
    public User toEntity(UserRequest dto) {
        if ( dto == null ) {
            return null;
        }

        User user = new User();

        user.setId( dto.getId() );

        user.setFirstName( org.apache.commons.text.WordUtils.capitalizeFully(dto.getFirstName()) );
        user.setLastName( org.apache.commons.text.WordUtils.capitalizeFully(dto.getLastName()) );
        user.setUsername( dto.getUsername().trim().toLowerCase() );

        return user;
    }

    @Override
    public UserRequest toDto(User entity) {
        if ( entity == null ) {
            return null;
        }

        UserRequest userRequest = new UserRequest();

        userRequest.setId( entity.getId() );
        userRequest.setFirstName( entity.getFirstName() );
        userRequest.setLastName( entity.getLastName() );
        userRequest.setUsername( entity.getUsername() );

        return userRequest;
    }
}
