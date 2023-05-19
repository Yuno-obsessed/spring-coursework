package com.sanity.nil.service;

import com.sanity.nil.dto.mapper.SurgeryPetResponseMapper;
import com.sanity.nil.dto.mapper.SurgeryRequestMapper;
import com.sanity.nil.dto.mapper.SurgeryUserResponseMapper;
import com.sanity.nil.dto.request.ProfileRequest;
import com.sanity.nil.dto.request.SurgeryRequest;
import com.sanity.nil.dto.request.UserRequest;
import com.sanity.nil.dto.response.CommandResponse;
import com.sanity.nil.dto.response.SurgeryPetResponse;
import com.sanity.nil.dto.response.SurgeryUserResponse;
import com.sanity.nil.dto.response.UserResponse;
import com.sanity.nil.exception.ElementAlreadyExistsException;
import com.sanity.nil.exception.NoSuchElementFoundException;
import com.sanity.nil.model.Role;
import com.sanity.nil.model.RoleType;
import com.sanity.nil.model.Surgery;
import com.sanity.nil.model.User;
import com.sanity.nil.repository.PetRepository;
import com.sanity.nil.repository.SurgeryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.text.WordUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static com.sanity.nil.common.Constants.*;

@Slf4j
@Service
@RequiredArgsConstructor
public class SurgeryService {

    private SurgeryRepository surgeryRepository;
    private PetRepository petRepository;
    private PetService petService;

    private SurgeryPetResponseMapper surgeryPetResponseMapper;
    private SurgeryUserResponseMapper surgeryUserResponseMapper;
    private SurgeryRequestMapper surgeryRequestMapper;

    /**
     * Fetches a single surgery (entity) by the given id
     *
     * @param id
     * @return User
     */
    public Surgery getById(long id) {
        return surgeryRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementFoundException(NOT_FOUND_SURGERY));
    }

    /**
     * Fetches all surgeries based on the given petId
     *
     * @param petId
     * @return List of SurgeryPetResponse
     */
    @Transactional(readOnly = true)
    public List<SurgeryPetResponse> findAllByPetId(Long petId) {
        final List<SurgeryPetResponse> surgeries = surgeryRepository.findAllByPetId(petId).stream()
                .map(surgeryPetResponseMapper::toDto).toList();

        if (surgeries.isEmpty())
            throw new NoSuchElementFoundException(NOT_FOUND_RECORD);
        return surgeries;
    }

    /**
     * Fetches all surgeries based on the given userId
     *
     * @param userId
     * @return List of SurgeryPetResponse
     */
    @Transactional(readOnly = true)
    public List<SurgeryUserResponse> findAllByUserId(Long userId) {
        final List<SurgeryUserResponse> surgeries = surgeryRepository.findAllByUserId(userId).stream()
                .map(surgeryUserResponseMapper::toDto).toList();

        if (surgeries.isEmpty())
            throw new NoSuchElementFoundException(NOT_FOUND_RECORD);
        return surgeries;
    }

    /**
     * Creates a new surgery using the given request parameters
     *
     * @param request
     * @return id of the created surgery
     */
    public CommandResponse create(SurgeryRequest request) {
        final Surgery surgery = surgeryRequestMapper.toEntity(request);
        surgery.setPet(petRepository.findById(request.getPetId()))
        userRepository.save(user);
        log.info(CREATED_USER);
        return CommandResponse.builder().id(user.getId()).build();
    }

    /**
     * Updates user using the given request parameters
     *
     * @param request
     * @return id of the updated user
     */
    public CommandResponse update(ProfileRequest request) {
        final User user = userRepository.findById(request.getId())
                .orElseThrow(() -> new NoSuchElementFoundException(NOT_FOUND_USER));

        // update admin role of the user based on the request
        if (request.getRoles() != null && request.getRoles().contains(RoleType.ROLE_ADMIN.name()))
            user.addRole(new Role(2L, RoleType.ROLE_ADMIN));
        else
            user.removeRole(new Role(2L, RoleType.ROLE_ADMIN));

        user.setFirstName(WordUtils.capitalizeFully(request.getFirstName()));
        user.setLastName(WordUtils.capitalizeFully(request.getLastName()));
        userRepository.save(user);
        log.info(UPDATED_USER);
        return CommandResponse.builder().id(user.getId()).build();
    }

    /**
     * Deletes user by the given id
     *
     * @param id
     */
    public void deleteById(long id) {
        final User user = userRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementFoundException(NOT_FOUND_USER));
        userRepository.delete(user);
        log.info(DELETED_USER);
    }
}
