package com.sanity.nil.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.time.LocalDate;

@Data
public class SurgeryRequest {

    private Long id;
    @NotNull()
    private Long petId;
    @NotNull()
    private Long userId;
    @NotBlank
    @Size(min = 5, max = 50)
    private String description;
    @Min(1)
    @Max(10)
    @JsonProperty(value = "difficulty")
    private Integer difficulty;
    private LocalDate date;
}
