package com.sanity.nil.service;

import com.sanity.nil.dto.mapper.SurgeryRequestMapper;
import com.sanity.nil.dto.mapper.SurgeryResponseMapper;
import com.sanity.nil.dto.request.SurgeryRequest;
import com.sanity.nil.dto.response.CommandResponse;
import com.sanity.nil.dto.response.PetResponse;
import com.sanity.nil.dto.response.SurgeryResponse;
import com.sanity.nil.exception.NoSuchElementFoundException;
import com.sanity.nil.model.Surgery;
import com.sanity.nil.repository.SurgeryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static com.sanity.nil.common.Constants.*;

@Slf4j
@Service
@RequiredArgsConstructor
public class SurgeryService {

    private final SurgeryRepository surgeryRepository;
    private final PetService petService;

    private final SurgeryResponseMapper surgeryResponseMapper;
    private final SurgeryRequestMapper surgeryRequestMapper;

    /**
     * Fetches a single surgery (entity) by the given id
     *
     * @param id
     * @return Surgery
     */
    public Surgery getById(long id) {
        return surgeryRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementFoundException(NOT_FOUND_SURGERY));
    }

    /**
     * Fetches all surgeries based on the given petId
     *
     * @param petId
     * @return List of SurgeryResponse
     */
    @Transactional(readOnly = true)
    public List<SurgeryResponse> findAllByPetId(Long petId) {
        final List<SurgeryResponse> surgeries = surgeryRepository.findAllByPetId(petId).stream()
                .map(surgeryResponseMapper::toDto).toList();

        if (surgeries.isEmpty())
            throw new NoSuchElementFoundException(NOT_FOUND_RECORD);
        return surgeries;
    }

    /**
     * Fetches all surgeries based on the given userId after today's date
     *
     * @param userId
     * @return List of SurgeryResponse
     */
    @Transactional(readOnly = true)
    public List<SurgeryResponse> findAllByUserId(Long userId) {
        final List<PetResponse> pets = petService.findAllByUserId(userId);
        List<Surgery> surgeries = new ArrayList<>();
        pets.forEach(pet -> surgeries.addAll(surgeryRepository.findAllByPetId(pet.getId())));
        List<SurgeryResponse> response = new ArrayList<>(surgeries.stream().filter(surgery -> surgery.getDate().isAfter(LocalDate.now()))
                .map(surgeryResponseMapper::toDto).toList());

        if (surgeries.isEmpty() || response.isEmpty())
            throw new NoSuchElementFoundException(NOT_FOUND_RECORD);
        response.sort(Comparator.comparing(SurgeryResponse::getDate));
        return response;
    }

    /**
     * Creates a new surgery using the given request parameters
     *
     * @param request
     * @return id of the created surgery
     */
    public CommandResponse create(SurgeryRequest request) {
        Surgery surgery = surgeryRequestMapper.toEntity(request);
        surgery.setPet(petService.getById(request.getPetId()));
        surgeryRepository.save(surgery);
        log.info(CREATED_SURGERY);
        return CommandResponse.builder().id(surgery.getId()).build();
    }

    /**
     * Updates surgery using the given request parameters
     *
     * @param request
     * @return id of the updated surgery
     */
    public CommandResponse update(SurgeryRequest request) {
        final Surgery surgery = surgeryRepository.findById(request.getId())
                .orElseThrow(() -> new NoSuchElementFoundException(NOT_FOUND_USER));
        surgery.setPet(petService.getById(request.getPetId()));
        surgery.setDate(request.getDate());
        surgeryRepository.save(surgery);
        log.info(UPDATED_SURGERY);
        return CommandResponse.builder().id(surgery.getId()).build();
    }

    /**
     * Deletes surgery by the given id
     *
     * @param id
     */
    public void deleteById(long id) {
        final Surgery surgery = surgeryRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementFoundException(NOT_FOUND_USER));
        surgeryRepository.delete(surgery);
        log.info(DELETED_SURGERY);
    }
}
