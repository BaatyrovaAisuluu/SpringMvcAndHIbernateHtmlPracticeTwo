package com.company.mapper.view;

import com.company.dto.request.admin.AdminResponse;
import com.company.model.User;
import org.springframework.stereotype.Component;

@Component
public class AdminViewMapper {
    public AdminResponse viewUser(User user) {
        if (user == null) {
            return null;
        }
        AdminResponse adminResponse = new AdminResponse();
             adminResponse.setId(String.valueOf(user.getId()));
        adminResponse.setFirstName(user.getFirstName());
        adminResponse.setLastName(user.getLastName());

        return adminResponse;
    }
}
