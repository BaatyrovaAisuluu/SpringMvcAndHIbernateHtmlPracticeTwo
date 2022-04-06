package com.company.seviceImpl;

import com.company.dto.request.StudentRequest;
import com.company.dto.response.StudentResponse;
import com.company.mapper.edit.StudentEditMapper;
import com.company.mapper.view.StudentViewMapper;
import com.company.model.Student;
import com.company.repository.StudentRepository;
import com.company.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final StudentEditMapper studentEditMapper;
    private final StudentViewMapper studentViewMapper;
    private final PasswordEncoder passwordEncoder;

    @Override
    public List<Student> getStudent() {
        return studentRepository.findAll();
    }

    @Override
    public StudentResponse create(Long id, StudentRequest studentRequest) {
        studentRequest.setPassword(passwordEncoder.encode(studentRequest.getPassword()));
        return studentViewMapper.viewStudent(studentRepository.
                save(studentEditMapper.create(id, studentRequest)));
    }

    @Override
    public StudentResponse update(Long id, StudentRequest studentRequest) {
        Student student = studentRepository.findById(id).get();
        studentEditMapper.update(student, studentRequest);
        return studentViewMapper.viewStudent(studentRepository.save(student));
    }

    @Override
    public void delete(Long id) {
        studentRepository.deleteById(id);
    }

    @Override
    public Student getStudentById(Long id) {
        return studentRepository.getById(id);
    }

    @Override
    public Optional<Student> findById(Long id) {
        return studentRepository.findById(id);
    }
}
