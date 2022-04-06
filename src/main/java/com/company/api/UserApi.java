package com.company.api;

import com.company.dto.request.admin.AdminRequest;
import com.company.dto.request.admin.AdminResponse;
import com.company.model.AuthInfo;
import com.company.model.Role;
import com.company.model.User;
import com.company.service.UserService;
import com.company.seviceImpl.AuthService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import javax.annotation.security.PermitAll;

@RestController
@RequestMapping("/api/admin")
@AllArgsConstructor
public class UserApi {

    private final UserService userService;


    @PostMapping("/save")
    @PermitAll
    public AdminResponse saveAdmin( @RequestBody AdminRequest user){
             return userService.saveUser(user);

    }
}
