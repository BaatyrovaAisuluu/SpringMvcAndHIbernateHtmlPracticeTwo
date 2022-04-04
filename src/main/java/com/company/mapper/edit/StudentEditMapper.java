package com.company.mapper.edit;

import com.company.dto.request.StudentRequest;
import com.company.model.Student;
import com.company.repository.GroupRepository;
import org.springframework.stereotype.Component;

@Component
public class StudentEditMapper {

    private final GroupRepository groupRepository;

    public StudentEditMapper(GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }

    public Student create(Long id, StudentRequest studentRequest) {

        if (studentRequest == null) {
            return null;
        }

        Student student = new Student();
        student.setFirstName(studentRequest.getFirstName());
        student.setLastName(studentRequest.getLastName());
        student.setEmail(studentRequest.getEmail());
        student.setStudyFormat(studentRequest.getStudyFormat());
        student.setGroup(groupRepository.getById(id));

        return student;
    }

    public void update(Student student, StudentRequest studentRequest) {
        student.setFirstName(studentRequest.getFirstName());
        student.setEmail(studentRequest.getEmail());
        student.setLastName(studentRequest.getLastName());
        student.setStudyFormat(studentRequest.getStudyFormat());
    }
}
