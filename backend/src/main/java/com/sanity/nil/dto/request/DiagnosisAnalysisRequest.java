package com.sanity.nil.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class DiagnosisAnalysisRequest {

    @NotBlank
    private Long id;
}
