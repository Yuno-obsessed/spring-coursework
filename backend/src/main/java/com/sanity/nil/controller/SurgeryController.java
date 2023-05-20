package com.sanity.nil.controller;

import com.sanity.nil.dto.request.AnalysisRequest;
import com.sanity.nil.dto.request.SurgeryRequest;
import com.sanity.nil.dto.response.AnalysisResponse;
import com.sanity.nil.dto.response.ApiResponse;
import com.sanity.nil.dto.response.CommandResponse;
import com.sanity.nil.dto.response.SurgeryResponse;
import com.sanity.nil.service.AnalysisService;
import com.sanity.nil.service.SurgeryService;
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
@RequestMapping("/api/v1/surgery")
@RequiredArgsConstructor
public class SurgeryController {

    private final Clock clock;
    private final SurgeryService surgeryService;

    /**
     * Fetches all surgeries based on the given petId
     *
     * @param petId
     * @return List of SurgeryResponse
     */
    @PreAuthorize("hasRole(T(com.sanity.nil.model.RoleType).ROLE_USER)")
    @GetMapping("/pet/{petId}")
    public ResponseEntity<ApiResponse<List<SurgeryResponse>>> findAllByPetId(@PathVariable long petId) {
        final List<SurgeryResponse> response = surgeryService.findAllByPetId(petId);
        return ResponseEntity.ok(new ApiResponse<>(Instant.now(clock).toEpochMilli(), SUCCESS, response));
    }

    /**
     * Fetches all surgeries based on the given userId
     *
     * @param userId
     * @return List of SurgeryResponse
     */
    @PreAuthorize("hasRole(T(com.sanity.nil.model.RoleType).ROLE_USER)")
    @GetMapping("/user/{userId}")
    public ResponseEntity<ApiResponse<List<SurgeryResponse>>> findAllByUserId(@PathVariable long userId) {
        final List<SurgeryResponse> response = surgeryService.findAllByPetId(userId);
        return ResponseEntity.ok(new ApiResponse<>(Instant.now(clock).toEpochMilli(), SUCCESS, response));
    }

    /**
     * Creates a new surgery using the given request parameters
     *
     * @param request
     * @return id of the created surgery
     */
    @PreAuthorize("hasRole(T(com.sanity.nil.model.RoleType).ROLE_USER)")
    @PostMapping
    public ResponseEntity<ApiResponse<CommandResponse>> create(@Valid @RequestBody SurgeryRequest request) {
        final CommandResponse response = surgeryService.create(request);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new ApiResponse<>(Instant.now(clock).toEpochMilli(), SUCCESS, response));
    }

    /**
     * Updates surgery using the given request parameters
     *
     * @param request
     * @return id of the updated surgery
     */
    @PreAuthorize("hasRole(T(com.sanity.nil.model.RoleType).ROLE_USER)")
    @PutMapping
    public ResponseEntity<ApiResponse<CommandResponse>> update(@Valid @RequestBody SurgeryRequest request) {
        final CommandResponse response = surgeryService.update(request);
        return ResponseEntity.ok(new ApiResponse<>(Instant.now(clock).toEpochMilli(), SUCCESS, response));
    }

    /**
     *  Deletes surgery using id
     *
     * @param id
     * @return id of the deleted surgery
     */
    @PreAuthorize("hasRole(T(com.sanity.nil.model.RoleType).ROLE_USER)")
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteById(@PathVariable long id){
        surgeryService.deleteById(id);
        return ResponseEntity
                .status(HttpStatus.NO_CONTENT)
                .build();
    }
}
