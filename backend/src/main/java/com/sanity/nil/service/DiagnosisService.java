package com.sanity.nil.service;

import com.sanity.nil.dto.mapper.AnalysisResponseMapper;
import com.sanity.nil.dto.mapper.DiagnosisResponseMapper;
import com.sanity.nil.dto.request.DiagnosisRequest;
import com.sanity.nil.dto.response.AnalysisResponse;
import com.sanity.nil.dto.response.CommandResponse;
import com.sanity.nil.dto.response.DiagnosisResponse;
import com.sanity.nil.exception.NoSuchElementFoundException;
import com.sanity.nil.model.Diagnosis;
import com.sanity.nil.repository.DiagnosisRepository;
import com.sanity.nil.repository.PetRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

import static com.sanity.nil.common.Constants.*;

@Slf4j(topic = "DiagnosisService")
@Service
@RequiredArgsConstructor
public class DiagnosisService {

    private final PetRepository petRepository;
    private final DiagnosisRepository diagnosisRepository;
    private final DiagnosisResponseMapper diagnosisResponseMapper;

    /**
     * Fetches all diagnosis based on the given petId
     *
     * @param petId
     * @return List of DiagnosisResponse
     */
    @Transactional(readOnly = true)
    public List<DiagnosisResponse> findAllByPetId(long petId) {
        final List<DiagnosisResponse> diagnosisList = diagnosisRepository.findAllByPetId(petId).stream()
                .map(diagnosisResponseMapper::toDto).toList();

        if (diagnosisList.isEmpty())
            throw new NoSuchElementFoundException(NOT_FOUND_RECORD);
        return diagnosisList;
    }

    /**
     * Creates a new diagnosis using the given request parameters
     *
     * @param request
     * @return id of the created diagnosis
     */
    public CommandResponse create(DiagnosisRequest request){
        final Diagnosis diagnosis = Diagnosis.builder()
                .pet(petRepository.findById(request.getId()).orElseThrow(
                        () -> new NoSuchElementFoundException(NOT_FOUND_PET)
                ))
                .description(request.getDescription())
                .date(LocalDate.now())
                .build();
        diagnosisRepository.save(diagnosis);
        log.info(CREATED_DIAGNOSIS);
        return CommandResponse.builder().id(diagnosis.getId()).build();
    }

    /**
     * Updates diagnosis using the given request parameters
     *
     * @param request
     * @return id of the updated diagnosis
     */
    public CommandResponse update(DiagnosisRequest request){
        if (diagnosisRepository.existsById(request.getId())){
            throw new NoSuchElementFoundException(NOT_FOUND_DIAGNOSIS);
        }
        final Diagnosis diagnosis = Diagnosis.builder()
                .pet(petRepository.findById(request.getId()).orElseThrow(
                        () -> new NoSuchElementFoundException(NOT_FOUND_PET)
                ))
                .description(request.getDescription())
                .date(LocalDate.now())
                .build();
        diagnosisRepository.save(diagnosis);
        log.info(UPDATED_DIAGNOSIS);
        return CommandResponse.builder().id(request.getId()).build();
    }

    /**
     * Deletes diagnosis by the given id
     *
     * @param id
     */
    public void deleteById(long id) {
        final Diagnosis diagnosis = diagnosisRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementFoundException(NOT_FOUND_DIAGNOSIS));
        diagnosisRepository.delete(diagnosis);
        log.info(DELETED_DIAGNOSIS);
    }
}
