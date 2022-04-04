package com.company.seviceImpl;

import com.company.dto.request.CourseRequest;
import com.company.dto.response.CourseResponse;
import com.company.mapper.edit.CourseEditMapper;
import com.company.mapper.view.CourseViewMapper;
import com.company.model.Course;
import com.company.repository.CourseRepository;
import com.company.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;
    private final CourseEditMapper courseEditMapper;
    private final CourseViewMapper courseViewMapper;

    @Override
    public List<Course> getCourse() {
        List<Course> courses = courseRepository.findAll();
        return courses;
    }

    @Override
    public CourseResponse create(Long id, CourseRequest courseRequest) {
        return courseViewMapper.viewCourse(courseRepository.save
                (courseEditMapper.create(id, courseRequest)));

    }

    @Override
    public CourseResponse update(Long id, CourseRequest courseRequest) {
        Course course = courseRepository.findById(id).get();
        courseEditMapper.Update(course, courseRequest);
        return courseViewMapper.viewCourse(courseRepository.save(course));
    }

    @Override
    public void delete(Long id) {
        courseRepository.deleteById(id);

    }

    @Override
    public Course getCourseById(Long id) {
        return courseRepository.getById(id);
    }

    @Override
    public Course findById(Long id) {
        return courseRepository.findById(id).orElseThrow(()->new RuntimeException("does not exist" +id));
    }
}
