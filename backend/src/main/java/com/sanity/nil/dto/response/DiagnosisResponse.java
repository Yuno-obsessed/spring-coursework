package com.sanity.nil.dto.response;

import com.sanity.nil.model.Pet;
import lombok.Data;

import java.util.Date;

@Data
public class DiagnosisResponse {

    private Long id;
    private Pet pet;
    private String description;
    private Date date;
}
