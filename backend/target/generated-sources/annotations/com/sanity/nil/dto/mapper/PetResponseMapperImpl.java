package com.sanity.nil.dto.mapper;

import com.sanity.nil.dto.response.PetResponse;
import com.sanity.nil.dto.response.RoleResponse;
import com.sanity.nil.dto.response.TypeResponse;
import com.sanity.nil.dto.response.UserResponse;
import com.sanity.nil.model.Pet;
import com.sanity.nil.model.Role;
import com.sanity.nil.model.Type;
import com.sanity.nil.model.User;
import java.util.LinkedHashSet;
import java.util.Set;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-05-18T12:26:02+0200",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.6 (Oracle Corporation)"
)
@Component
public class PetResponseMapperImpl implements PetResponseMapper {

    @Override
    public Pet toEntity(PetResponse dto) {
        if ( dto == null ) {
            return null;
        }

        Pet pet = new Pet();

        pet.setId( dto.getId() );
        pet.setName( dto.getName() );
        pet.setType( typeResponseToType( dto.getType() ) );
        pet.setUser( userResponseToUser( dto.getUser() ) );

        return pet;
    }

    @Override
    public PetResponse toDto(Pet entity) {
        if ( entity == null ) {
            return null;
        }

        PetResponse petResponse = new PetResponse();

        petResponse.setId( entity.getId() );
        petResponse.setName( entity.getName() );
        petResponse.setType( typeToTypeResponse( entity.getType() ) );
        petResponse.setUser( userToUserResponse( entity.getUser() ) );

        return petResponse;
    }

    protected Type typeResponseToType(TypeResponse typeResponse) {
        if ( typeResponse == null ) {
            return null;
        }

        Type type = new Type();

        type.setId( typeResponse.getId() );
        type.setName( typeResponse.getName() );
        type.setDescription( typeResponse.getDescription() );

        return type;
    }

    protected Role roleResponseToRole(RoleResponse roleResponse) {
        if ( roleResponse == null ) {
            return null;
        }

        Role role = new Role();

        role.setId( roleResponse.getId() );
        role.setType( roleResponse.getType() );

        return role;
    }

    protected Set<Role> roleResponseSetToRoleSet(Set<RoleResponse> set) {
        if ( set == null ) {
            return null;
        }

        Set<Role> set1 = new LinkedHashSet<Role>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( RoleResponse roleResponse : set ) {
            set1.add( roleResponseToRole( roleResponse ) );
        }

        return set1;
    }

    protected User userResponseToUser(UserResponse userResponse) {
        if ( userResponse == null ) {
            return null;
        }

        User user = new User();

        user.setId( userResponse.getId() );
        user.setFirstName( userResponse.getFirstName() );
        user.setLastName( userResponse.getLastName() );
        user.setUsername( userResponse.getUsername() );
        user.setRoles( roleResponseSetToRoleSet( userResponse.getRoles() ) );

        return user;
    }

    protected TypeResponse typeToTypeResponse(Type type) {
        if ( type == null ) {
            return null;
        }

        TypeResponse typeResponse = new TypeResponse();

        typeResponse.setId( type.getId() );
        typeResponse.setName( type.getName() );
        typeResponse.setDescription( type.getDescription() );

        return typeResponse;
    }

    protected RoleResponse roleToRoleResponse(Role role) {
        if ( role == null ) {
            return null;
        }

        RoleResponse roleResponse = new RoleResponse();

        roleResponse.setId( role.getId() );
        roleResponse.setType( role.getType() );

        return roleResponse;
    }

    protected Set<RoleResponse> roleSetToRoleResponseSet(Set<Role> set) {
        if ( set == null ) {
            return null;
        }

        Set<RoleResponse> set1 = new LinkedHashSet<RoleResponse>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( Role role : set ) {
            set1.add( roleToRoleResponse( role ) );
        }

        return set1;
    }

    protected UserResponse userToUserResponse(User user) {
        if ( user == null ) {
            return null;
        }

        UserResponse userResponse = new UserResponse();

        userResponse.setId( user.getId() );
        userResponse.setUsername( user.getUsername() );
        userResponse.setFirstName( user.getFirstName() );
        userResponse.setLastName( user.getLastName() );
        userResponse.setRoles( roleSetToRoleResponseSet( user.getRoles() ) );

        return userResponse;
    }
}
