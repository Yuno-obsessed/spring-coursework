package com.sanity.nil.service;

import com.sanity.nil.dto.mapper.AnalysisResponseMapper;
import com.sanity.nil.dto.request.AnalysisRequest;
import com.sanity.nil.dto.response.AnalysisResponse;
import com.sanity.nil.dto.response.CommandResponse;
import com.sanity.nil.dto.response.PetResponse;
import com.sanity.nil.exception.NoSuchElementFoundException;
import com.sanity.nil.model.Analysis;
import com.sanity.nil.repository.AnalysisRepository;
import com.sanity.nil.repository.PetRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

import static com.sanity.nil.common.Constants.*;

@Slf4j(topic = "AnalysisService")
@Service
@RequiredArgsConstructor
public class AnalysisService {

    private final AnalysisRepository analysisRepository;
    private final PetRepository petRepository;
    private final AnalysisResponseMapper analysisResponseMapper;

    /**
     * Fetches all analysis based on the given petId
     *
     * @param petId
     * @return List of AnalysisResponse
     */
    @Transactional(readOnly = true)
    public List<AnalysisResponse> findAllByPetId(long petId) {
        final List<AnalysisResponse> analysisList = analysisRepository.findAllByPetId(petId).stream()
                .map(analysisResponseMapper::toDto).toList();

        if (analysisList.isEmpty())
            throw new NoSuchElementFoundException(NOT_FOUND_RECORD);
        return analysisList;
    }

    /**
     * Creates a new analysis using the given request parameters
     *
     * @param request
     * @return id of the created analysis
     */
    public CommandResponse create(AnalysisRequest request){
       final Analysis analysis = Analysis.builder()
               .pet(petRepository.findById(request.getPetId()).orElseThrow(
                       () -> new NoSuchElementFoundException(NOT_FOUND_ANALYSIS)
               ))
               .bloodRate(request.getBloodRate())
               .urineRate(request.getUrineRate())
               .date(request.getDate())
               .build();
       analysisRepository.save(analysis);
       log.info(CREATED_ANALYSIS);
       return CommandResponse.builder().id(analysis.getId()).build();
    }

    /**
     * Updates analysis using the given request parameters
     *
     * @param request
     * @return id of the updated analysis
     */
    public CommandResponse update(AnalysisRequest request){
        if (analysisRepository.existsById(request.getId())){
            throw new NoSuchElementFoundException(NOT_FOUND_ANALYSIS);
        }
        final Analysis analysis = Analysis.builder()
                .pet(petRepository.findById(request.getPetId()).orElseThrow(
                        () -> new NoSuchElementFoundException()
                ))
                .bloodRate(request.getBloodRate())
                .urineRate(request.getUrineRate())
                .date(request.getDate())
                .build();
        analysisRepository.save(analysis);
        log.info(UPDATED_ANALYSIS);
        return CommandResponse.builder().id(request.getId()).build();
    }

    /**
     * Deletes analysis by the given id
     *
     * @param id
     */
    public void deleteById(long id) {
        final Analysis analysis = analysisRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementFoundException(NOT_FOUND_ANALYSIS));
        analysisRepository.delete(analysis);
        log.info(DELETED_ANALYSIS);
    }
}
