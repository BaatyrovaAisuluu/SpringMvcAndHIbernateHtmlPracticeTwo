package com.company.mapper.edit;

import com.company.dto.request.TeacherRequest;
import com.company.model.AuthInfo;
import com.company.model.Role;
import com.company.model.Teacher;
import com.company.repository.AuthInfoRepository;
import com.company.repository.CourseRepository;
import com.company.seviceImpl.AuthService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class TeacherEditMapper {

    private final CourseRepository courseRepository;
    private final AuthInfoRepository authInfoRepository;


    public Teacher create(Long id, TeacherRequest teacherRequest) {

        if (teacherRequest == null) {
            return null;
        }
        Teacher teacher = new Teacher();
        teacher.setTeacherFirstName(teacherRequest.getTeacherFirstName());
        teacher.setLastName(teacherRequest.getLastName());
        teacher.setCourse(courseRepository.getById(id));

        AuthInfo authInfo=new AuthInfo();
        authInfo.setRole(Role.TEACHER);
        authInfo.setPassword(teacherRequest.getPassword());
        teacher.setAuthInfo(authInfoRepository.getById(id));
        authInfo.setEmail(teacherRequest.getEmail());

        teacher.setAuthInfo(authInfo);
        return teacher;
    }

    public void update(Teacher teacher, TeacherRequest teacherRequest) {
      teacher.setTeacherFirstName(teacherRequest.getTeacherFirstName());
      teacher.setLastName(teacherRequest.getLastName());
        AuthInfo authInfo=new AuthInfo();
        teacher.getAuthInfo().setEmail(teacherRequest.getEmail());
        teacher.getAuthInfo().setPassword(teacherRequest.getPassword());
        authInfo.setRole(Role.TEACHER);
        teacher.setAuthInfo(authInfo);

    }
}
