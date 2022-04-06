package com.company.api;

import com.company.dto.request.StudentRequest;
import com.company.dto.response.StudentResponse;
import com.company.model.AuthInfo;
import com.company.model.Student;
import com.company.service.GroupService;
import com.company.service.StudentService;
import com.company.seviceImpl.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.PermitAll;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/student/{GroupId}")
public class StudentApi {

    private final StudentService studentService;
    private final GroupService groupService;
    private final AuthService authService;

    @GetMapping
    @PreAuthorize("hasAnyAuthority('ADMIN','STUDENT','TEACHER')")
    public List<Student> getAllStudent() {
        return studentService.getStudent();
    }


    @PostMapping("/register")
    @PermitAll
    public StudentResponse createStudent(@PathVariable("GroupId") Long id,
                                         @RequestBody StudentRequest studentRequest) {

        studentRequest.setGroupId(groupService.getGroupById(id));
        return studentService.create(id, studentRequest);
    }

    @PutMapping("/updateStudent/{idStu}")
    @PermitAll
    public StudentResponse updateStudent(@RequestBody StudentRequest studentRequest,@PathVariable("idStu") Long id) {
        return studentService.update(id, studentRequest);
    }

    @DeleteMapping("/deleteStu/{deleteStu}")
    @PermitAll
    public void deleteStudentById(@PathVariable("deleteStu") Long id) {
        studentService.delete(id);
    }

    @GetMapping("/getId/{id}")
    @PermitAll
    public Optional<Student> getStudentById(@PathVariable("id") Long id) {
        return studentService.findById(id);
    }
}
