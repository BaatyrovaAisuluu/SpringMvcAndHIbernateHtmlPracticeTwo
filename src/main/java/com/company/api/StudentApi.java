package com.company.api;

import com.company.dto.request.StudentRequest;
import com.company.dto.response.StudentResponse;
import com.company.model.Student;
import com.company.service.GroupService;
import com.company.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/student/{GroupId}")
public class StudentApi {

    private final StudentService studentService;
    private final GroupService groupService;

    @GetMapping
    public List<Student> getAllStudent() {
        return studentService.getStudent();
    }

    @PostMapping("/saveStudent")
    public StudentResponse createStudent(@PathVariable("GroupId") Long id,
                                         @RequestBody StudentRequest studentRequest) {
        studentRequest.setGroupId(groupService.getGroupById(id));
        return studentService.create(id, studentRequest);
    }

    @PutMapping("/updateStudent/{idStu}")
    public StudentResponse updateStudent(@RequestBody StudentRequest studentRequest,@PathVariable("idStu") Long id) {
        return studentService.update(id, studentRequest);
    }

    @DeleteMapping("/deleteStu/{deleteStu}")
    public void deleteStudentById(@PathVariable("deleteStu") Long id) {
        studentService.delete(id);
    }

    @GetMapping("/getId/{id}")
    public Optional<Student> getStudentById(@PathVariable("id") Long id) {
        return studentService.findById(id);
    }
}
