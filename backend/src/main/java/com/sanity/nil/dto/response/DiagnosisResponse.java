package com.sanity.nil.dto.response;

import com.sanity.nil.model.Pet;
import lombok.Data;

import java.time.LocalDate;

@Data
public class DiagnosisResponse {

    private Long id;
//    private PetResponse pet;
    private String description;
    private LocalDate date;
}
