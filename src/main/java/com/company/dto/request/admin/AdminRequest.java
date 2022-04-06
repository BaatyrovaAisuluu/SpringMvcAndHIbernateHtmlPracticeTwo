package com.company.dto.request.admin;

import com.company.model.AuthInfo;
import com.company.model.Role;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AdminRequest {
    private String firstName;
    private String lastName;
    private String email;
    private String password;

}
