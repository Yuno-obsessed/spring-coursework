package com.sanity.nil.dto.response;

import lombok.Data;

import java.time.LocalDate;

@Data
public class SurgeryResponse {

//    private Long id;
//    private PetResponse pet;
    private String name;
    private String description;
    private Integer difficulty;
    private LocalDate date;
}
