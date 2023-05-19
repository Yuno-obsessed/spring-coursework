package com.sanity.nil.dto.request;

import lombok.Data;

import java.util.Date;

@Data
public class SurgeryRequest {

    private Long id;
    private Long petId;
    private Long userId;
    private String description;
    private Integer difficulty;
    private Date date;
}
