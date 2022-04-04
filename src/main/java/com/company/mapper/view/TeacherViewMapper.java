package com.company.mapper.view;

import com.company.dto.response.TeacherResponse;
import com.company.model.Teacher;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TeacherViewMapper {

    public TeacherResponse viewTeacher(Teacher teacher) {
        if (teacher == null) {
            return null;
        }

        TeacherResponse teacherResponse = new TeacherResponse();
        teacherResponse.setId(String.valueOf(teacher.getId()));
        teacherResponse.setTeacherFirstName(teacher.getTeacherFirstName());
        teacherResponse.setEmail(teacher.getEmail());
        teacherResponse.setLastName(teacher.getLastName());
        return teacherResponse;
    }

    public List<TeacherResponse> viewStudent(List<Teacher> teachers) {
        List<TeacherResponse> teacherResponses = new ArrayList<>();
        for (Teacher s : teachers
        ) {
            teacherResponses.add(viewTeacher(s));
        }
        return teacherResponses;
    }
}
