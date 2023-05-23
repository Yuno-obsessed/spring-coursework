package com.sanity.nil.service;

import com.sanity.nil.dto.mapper.PetRequestMapper;
import com.sanity.nil.dto.mapper.PetResponseMapper;
import com.sanity.nil.dto.request.PetRequest;
import com.sanity.nil.dto.request.TypeSetRequest;
import com.sanity.nil.dto.response.*;
import com.sanity.nil.exception.NoSuchElementFoundException;
import com.sanity.nil.model.Pet;
import com.sanity.nil.model.Type;
import com.sanity.nil.repository.AnalysisRepository;
import com.sanity.nil.repository.DiagnosisRepository;
import com.sanity.nil.repository.PetRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static com.sanity.nil.common.Constants.*;

/**
 * Service used for Pet related operations
 */
@Slf4j(topic = "PetService")
@Service
@RequiredArgsConstructor
public class PetService {

    private final PetRepository petRepository;
    private final DiagnosisService diagnosisService;
    private final AnalysisService analysisService;
    private final TypeService typeService;
    private final UserService userService;
    private final PetRequestMapper petRequestMapper;
    private final PetResponseMapper petResponseMapper;

    /**
     * Fetches a single pet by the given id
     *
     * @param id
     * @return PetResponse
     */
    public PetResponse findById(long id) {
        return petRepository.findById(id)
                .map(petResponseMapper::toDto)
                .orElseThrow(() -> new NoSuchElementFoundException(NOT_FOUND_PET));
    }

    /**
     * Fetches a single pet (entity) by the given id
     *
     * @param id
     * @return Pet
     */
    public Pet getById(long id) {
        return petRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementFoundException(NOT_FOUND_TYPE));
    }

    /**
     * Fetches all pets based on the given paging and sorting parameters
     *
     * @param pageable
     * @return List of PetResponse
     */
    @Transactional(readOnly = true)
    public Page<PetResponse> findAll(Pageable pageable) {
        final Page<PetResponse> pets = petRepository.findAll(pageable)
                .map(petResponseMapper::toDto);

        if (pets.isEmpty())
            throw new NoSuchElementFoundException(NOT_FOUND_RECORD);
        return pets;
    }

    /**
     * Fetches all pets based on the given userId
     *
     * @param userId
     * @return List of PetResponse
     */
    @Transactional(readOnly = true)
    public List<PetResponse> findAllByUserId(long userId) {
        final List<PetResponse> pets = petRepository.findAllByUserId(userId).stream()
                .map(petResponseMapper::toDto).toList();

        if (pets.isEmpty())
            throw new NoSuchElementFoundException(NOT_FOUND_RECORD);
        return pets;
    }

    /**
     * Fetches a detailed pet info by the given id
     *
     * @param id
     * @return PetInfoResponse
     */
    public PetInfoResponse getInfoById(Long id) {
        Pet pet = petRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementFoundException());
        List<DiagnosisResponse> diagnosisList = new ArrayList<>(diagnosisService.findAllByPetId(id));
        List<AnalysisResponse> analysisList = new ArrayList<>(analysisService.findAllByPetId(id));
        diagnosisList.sort(Comparator.comparing(DiagnosisResponse::getDate));
        analysisList.sort(Comparator.comparing(AnalysisResponse::getDate));
        return PetInfoResponse.builder()
                .name(pet.getName())
                .type(pet.getType().getName())
                .diagnosis(diagnosisList)
                .analysis(analysisList)
                .build();
    }

    /**
     * Fetches counts of all pets by selected type
     *
     * @param types
     * @return selected type names and count of each type
     */
    @Transactional(readOnly = true)
    public Map<String, Long> findAllByType(TypeSetRequest types) {
        return petRepository.findAll().stream()
                .filter(pet -> types.getIds().isEmpty() || types.getIds().contains(pet.getType().getId()))
                .collect(Collectors.groupingBy(x -> x.getType().getName(), Collectors.counting()));
        // if we need to return TypeResponse instead of String (type names), we can use this:
        // .collect(Collectors.groupingBy(x -> typeResponseMapper.toDto(x.getType()), Collectors.counting()));
    }

    /**
     * Creates a new pet using the given request parameters
     *
     * @param request
     * @return id of the created pet
     */
    public CommandResponse create(PetRequest request) {
        final Pet pet = petRequestMapper.toEntity(request);
        pet.setType(typeService.getById(request.getTypeId()));
        pet.setUser(userService.getById(request.getUserId()));
        petRepository.save(pet);
        log.info(CREATED_PET);
        return CommandResponse.builder().id(pet.getId()).build();
    }

    /**
     * Updates pet using the given request parameters
     *
     * @param request
     * @return id of the updated pet
     */
    public CommandResponse update(PetRequest request) {
        if (!petRepository.existsById(request.getId()))
            throw new NoSuchElementFoundException(NOT_FOUND_PET);

        final Pet pet = petRequestMapper.toEntity(request);
        pet.setType(typeService.getById(request.getTypeId()));
        pet.setUser(userService.getById(request.getUserId()));
        petRepository.save(pet);
        log.info(UPDATED_PET);
        return CommandResponse.builder().id(pet.getId()).build();
    }

    /**
     * Deletes pet by the given id
     *
     * @param id
     */
    public void deleteById(long id) {
        final Pet pet = petRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementFoundException(NOT_FOUND_PET));
        petRepository.delete(pet);
        log.info(DELETED_PET);
    }
}
