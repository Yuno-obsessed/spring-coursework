package com.sanity.nil.dto.request;

import jakarta.validation.constraints.*;
import lombok.Data;

import java.util.Date;

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
    private Integer difficulty;
    private Date date;
}
