package com.sanity.nil.controller;

import com.sanity.nil.dto.request.AnalysisRequest;
import com.sanity.nil.dto.request.SurgeryRequest;
import com.sanity.nil.dto.response.*;
import com.sanity.nil.service.AnalysisService;
import com.sanity.nil.service.SurgeryService;
import com.sanity.nil.service.UserService;
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
    private final UserService userService;

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
    public ResponseEntity<ApiResponse<UserSurgeryResponse>> findAllByUserId(@PathVariable long userId) {
        final List<SurgeryResponse> surgeries = surgeryService.findAllByUserId(userId);
        final UserResponse user = userService.findById(userId);
        final UserSurgeryResponse response = new UserSurgeryResponse(user, surgeries);
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
    public ResponseEntity<ApiResponse<SurgeryResponse>> update(@Valid @RequestBody SurgeryRequest request) {
        final SurgeryResponse response = surgeryService.update(request);
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
