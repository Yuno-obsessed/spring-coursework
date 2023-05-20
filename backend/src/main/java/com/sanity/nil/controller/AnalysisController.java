package com.sanity.nil.controller;

import com.sanity.nil.dto.request.AnalysisRequest;
import com.sanity.nil.dto.response.AnalysisResponse;
import com.sanity.nil.dto.response.ApiResponse;
import com.sanity.nil.dto.response.CommandResponse;
import com.sanity.nil.service.AnalysisService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
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
    @GetMapping("/pet/{petId}")
    public ResponseEntity<ApiResponse<List<AnalysisResponse>>> findAllByPetId(@PathVariable long petId) {
        final List<AnalysisResponse> response = analysisService.findAllByPetId(petId);
        return ResponseEntity.ok(new ApiResponse<>(Instant.now(clock).toEpochMilli(), SUCCESS, response));
    }

    /**
     * Creates a new analysis using the given request parameters
     *
     * @param request
     * @return id of the created analysis
     */
    @PreAuthorize("hasRole(T(com.sanity.nil.model.RoleType).ROLE_USER)")
    @PostMapping
    public ResponseEntity<ApiResponse<CommandResponse>> create(@Valid @RequestBody AnalysisRequest request) {
        final CommandResponse response = analysisService.create(request);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new ApiResponse<>(Instant.now(clock).toEpochMilli(), SUCCESS, response));
    }

    /**
     * Updates analysis using the given request parameters
     *
     * @return id of the updated analysis
     */
    @PreAuthorize("hasRole(T(com.sanity.nil.model.RoleType).ROLE_USER)")
    @PutMapping
    public ResponseEntity<ApiResponse<CommandResponse>> update(@Valid @RequestBody AnalysisRequest request) {
        final CommandResponse response = analysisService.update(request);
        return ResponseEntity.ok(new ApiResponse<>(Instant.now(clock).toEpochMilli(), SUCCESS, response));
    }
}
