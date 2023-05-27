package com.sanity.nil.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.time.LocalDate;

@Data
public class AnalysisRequest {

    private Long id;

    private Long petId;
    @DecimalMin(value = "0.00", inclusive = true)
    @DecimalMax(value = "9999.99", inclusive = true)
    @Digits(integer = 4, fraction = 2)
    @JsonProperty(value = "blood_rate")
    @NotNull
    private Float bloodRate;

    @DecimalMin(value = "0.00", inclusive = true)
    @DecimalMax(value = "9999.99", inclusive = true)
    @Digits(integer = 4, fraction = 2)
    @NotNull()
    @JsonProperty(value = "urine_rate")
    private Float urineRate;
    private LocalDate date;
}
