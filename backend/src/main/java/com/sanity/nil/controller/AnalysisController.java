package com.sanity.nil.controller;

import com.sanity.nil.dto.response.AnalysisResponse;
import com.sanity.nil.dto.response.ApiResponse;
import com.sanity.nil.dto.response.PetResponse;
import com.sanity.nil.model.Analysis;
import com.sanity.nil.service.AnalysisService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.time.Clock;
import java.time.Instant;
import java.util.List;

import static com.sanity.nil.common.Constants.SUCCESS;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
@RequestMapping("/api/v1/analysis")
@RequiredArgsConstructor
public class AnalysisController {

    private final Clock clock;
    private final AnalysisService analysisService;

    /**
     * Fetches all analysis based on the given petId
     *
     * @param petId
     * @return List of AnalysisResponse
     */
    @PreAuthorize("hasRole(T(com.sanity.nil.model.RoleType).ROLE_USER)")
    @GetMapping("/pets/{petId}")
    public ResponseEntity<ApiResponse<List<AnalysisResponse>>> findAllByPetId(@PathVariable long petId) {
        final List<AnalysisResponse> response = analysisService.findAllByPetId(petId);
        return ResponseEntity.ok(new ApiResponse<>(Instant.now(clock).toEpochMilli(), SUCCESS, response));
    }
}
