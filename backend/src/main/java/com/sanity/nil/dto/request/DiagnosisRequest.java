package com.sanity.nil.dto.request;

import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class DiagnosisRequest {

    private Long id;
    @Size(min = 10, max = 75)
    private String description;
}
