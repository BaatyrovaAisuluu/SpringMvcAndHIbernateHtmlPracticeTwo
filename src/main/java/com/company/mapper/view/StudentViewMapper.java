package com.company.mapper.view;

import com.company.dto.response.StudentResponse;
import com.company.model.Student;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class StudentViewMapper {

    public StudentResponse viewStudent(Student student) {
        if (student == null) {
            return null;
        }

        StudentResponse studentResponse = new StudentResponse();

        studentResponse.setId(String.valueOf(student.getId()));
        studentResponse.setFirstName(student.getFirstName());
        studentResponse.setEmail(student.getEmail());
        studentResponse.setLastName(student.getLastName());
        studentResponse.setStudyFormat(student.getStudyFormat());
        return studentResponse;
    }

    public List<StudentResponse> viewStudent(List<Student> students) {
        List<StudentResponse> studentResponses = new ArrayList<>();
        for (Student s : students
        ) {
            studentResponses.add(viewStudent(s));
        }
        return studentResponses;
    }
}
