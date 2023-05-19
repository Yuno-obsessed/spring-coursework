package com.sanity.nil.dto.response;

import lombok.Data;

import java.util.Date;

@Data
public class SurgeryUserResponse {

    private Long id;
    private String petName;
    private String description;
    private Integer difficulty;
    private Date date;
}
