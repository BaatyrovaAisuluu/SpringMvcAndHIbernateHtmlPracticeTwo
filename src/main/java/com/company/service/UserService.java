package com.company.service;

import com.company.dto.request.admin.AdminRequest;
import com.company.dto.request.admin.AdminResponse;
import com.company.model.User;


public interface UserService {

    AdminResponse saveUser(AdminRequest user);


}