package com.sanity.nil.dto.response;

import lombok.Data;

import java.util.Date;

@Data
public class SurgeryResponse {

    private Long id;
    private PetResponse pet;
    private UserResponse user;
    private String description;
    private Integer difficulty;
    private Date date;
}
