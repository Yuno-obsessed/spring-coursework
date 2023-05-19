package com.sanity.nil.dto.response;

import lombok.Data;

import java.util.Date;

@Data
public class SurgeryPetResponse {

    private Long id;
    private String description;
    private Integer difficulty;
    private Date date;
}
