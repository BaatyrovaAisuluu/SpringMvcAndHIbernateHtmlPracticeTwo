package com.company.api;

import com.company.dto.request.TeacherRequest;
import com.company.dto.response.TeacherResponse;
import com.company.model.Teacher;
import com.company.service.CourseService;
import com.company.service.TeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/teacher/{courseId}")
public class TeacherApi {

    private final TeacherService teacherService;
    private final CourseService courseService;

    @GetMapping
    private List<Teacher> getAllTeacher() {
        return teacherService.getTeacher();
    }

    @PostMapping("/saveTeacher")
    public TeacherResponse createTeacher(@PathVariable("courseId") Long id, @RequestBody TeacherRequest teacherRequest) {
            if(courseService.getCourseById(id).getTeacher()==null){
                teacherRequest.setCourse(courseService.getCourseById(id));
                return teacherService.create(id, teacherRequest);

            }else {
                throw new RuntimeException("not found");
            }
    }

    @PutMapping("/updateTea/{updateTea}")
    public TeacherResponse updateTeacher(@RequestBody TeacherRequest teacherRequest         ,@PathVariable("updateTea") Long id) {
        return teacherService.update(id, teacherRequest);
    }

    @DeleteMapping("/delete/{deleteTea}")
    public void deleteTeacherById(@PathVariable("deleteTea") Long id) {
        teacherService.delete(id);
    }

    @GetMapping("/getIdTeacher/{idTeacher}")
    public Optional<Teacher> getTeacherById(@PathVariable("idTeacher") Long id) {
        return teacherService.findById(id);
    }
}
