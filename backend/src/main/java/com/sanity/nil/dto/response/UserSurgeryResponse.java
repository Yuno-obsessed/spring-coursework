package com.sanity.nil.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class UserSurgeryResponse {

    UserResponse user;
    List<SurgeryResponse> surgeries;
}
