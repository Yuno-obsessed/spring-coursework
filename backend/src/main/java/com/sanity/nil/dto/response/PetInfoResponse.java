package com.sanity.nil.dto.response;

import com.sanity.nil.model.Analysis;
import com.sanity.nil.model.Diagnosis;
import com.sanity.nil.model.Type;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class PetInfoResponse {

    private String name;
    private Type type;
    private List<Diagnosis> diagnosis;
    private List<Analysis> analysis;
}
