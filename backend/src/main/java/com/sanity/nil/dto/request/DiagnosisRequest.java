package com.sanity.nil.dto.request;

import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDate;

@Data
public class DiagnosisRequest {

    private Long id;
    private Long petId;
    @Size(min = 10, max = 75)
    private String description;
    private LocalDate date;
}
