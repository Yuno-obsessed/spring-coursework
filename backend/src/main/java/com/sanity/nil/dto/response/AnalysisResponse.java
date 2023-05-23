package com.sanity.nil.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sanity.nil.model.Pet;
import lombok.Data;

import java.time.LocalDate;

@Data
public class AnalysisResponse {

//    private Long id;
//    private PetResponse pet;
    @JsonProperty(value = "blood_rate")
    private Float bloodRate;
    @JsonProperty(value = "urine_rate")
    private Float urineRate;
    private LocalDate date;
}
