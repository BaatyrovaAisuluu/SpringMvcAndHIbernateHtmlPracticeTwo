package com.company.mapper.edit;

import com.company.dto.request.TeacherRequest;
import com.company.dto.request.admin.AdminRequest;
import com.company.model.AuthInfo;
import com.company.model.Role;
import com.company.model.Teacher;
import com.company.model.User;
import com.company.repository.CourseRepository;
import com.company.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class AdminEditMapper {

    public User create(AdminRequest adminRequest) {

        if (adminRequest == null) {
            return null;
        }
        User user=new User();
        user.setFirstName(adminRequest.getFirstName());
        user.setLastName(adminRequest.getLastName());

        AuthInfo authInfo=new AuthInfo();
        authInfo.setRole(Role.ADMIN);
        authInfo.setPassword(adminRequest.getPassword());
        authInfo.setEmail(adminRequest.getEmail());

        user.setAuthInfo(authInfo);
        return user;
    }
}
