package com.company.mapper.edit;

import com.company.dto.request.TeacherRequest;
import com.company.model.Teacher;
import com.company.repository.CourseRepository;
import org.springframework.stereotype.Component;

@Component
public class TeacherEditMapper {

    private final CourseRepository courseRepository;

    public TeacherEditMapper(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public Teacher create(Long id, TeacherRequest teacherRequest) {

        if (teacherRequest == null) {
            return null;
        }
        Teacher teacher = new Teacher();
        teacher.setTeacherFirstName(teacherRequest.getTeacherFirstName());
        teacher.setEmail(teacherRequest.getEmail());
        teacher.setLastName(teacherRequest.getLastName());
        teacher.setCourse(courseRepository.getById(id));
        return teacher;
    }

    public void update(Teacher teacher, TeacherRequest teacherRequest) {
      teacher.setTeacherFirstName(teacherRequest.getTeacherFirstName());
      teacher.setLastName(teacherRequest.getLastName());
      teacher.setEmail(teacherRequest.getEmail());

    }
}
