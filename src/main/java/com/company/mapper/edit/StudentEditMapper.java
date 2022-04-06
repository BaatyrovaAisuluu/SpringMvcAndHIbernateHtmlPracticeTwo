package com.company.mapper.edit;

import com.company.dto.request.StudentRequest;
import com.company.model.AuthInfo;
import com.company.model.Role;
import com.company.model.Student;
import com.company.repository.AuthInfoRepository;
import com.company.repository.GroupRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class StudentEditMapper {

    private final GroupRepository groupRepository;
    private final AuthInfoRepository authInfoRepository;


    public Student create(Long id, StudentRequest studentRequest) {

        if (studentRequest == null) {
            return null;
        }

        Student student = new Student();
        student.setFirstName(studentRequest.getFirstName());
        student.setLastName(studentRequest.getLastName());

        AuthInfo authInfo=new AuthInfo();
        authInfo.setEmail(studentRequest.getEmail());
        authInfo.setRole(Role.STUDENT);
        authInfo.setPassword(studentRequest.getPassword());
        student.setAuthInfo(authInfoRepository.getById(id));
        student.setAuthInfo(authInfo);


        student.setStudyFormat(studentRequest.getStudyFormat());
        student.setGroup(groupRepository.getById(id));

        return student;
    }

    public void update(Student student, StudentRequest studentRequest) {
        student.setFirstName(studentRequest.getFirstName());

        student.setLastName(studentRequest.getLastName());
        student.setStudyFormat(studentRequest.getStudyFormat());
    }
}
