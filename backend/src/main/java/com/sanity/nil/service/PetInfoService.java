package com.sanity.nil.service;

import com.sanity.nil.dto.response.PetInfoResponse;
import com.sanity.nil.exception.NoSuchElementFoundException;
import com.sanity.nil.model.Analysis;
import com.sanity.nil.model.Diagnosis;
import com.sanity.nil.model.Pet;
import com.sanity.nil.repository.AnalysisRepository;
import com.sanity.nil.repository.DiagnosisRepository;
import com.sanity.nil.repository.PetRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class PetInfoService {

    private final PetRepository petRepository;
    private final DiagnosisRepository diagnosisRepository;
    private final AnalysisRepository analysisRepository;

    /**
     * Fetches a detailed pet info by the given id
     *
     * @param id
     * @return PetInfoResponse
     */
    public PetInfoResponse findById(Long id) {
        Pet pet = petRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementFoundException());
        return PetInfoResponse.builder()
                .name(pet.getName())
                .type(pet.getType())
                .diagnosis(diagnosisRepository.findAllByPetId(id))
                .analysis(analysisRepository.findAllByPetId(id))
                .build();
    }
}
