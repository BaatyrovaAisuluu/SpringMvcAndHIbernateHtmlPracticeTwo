package com.company.seviceImpl;

import com.company.dto.request.TeacherRequest;
import com.company.dto.response.TeacherResponse;
import com.company.mapper.edit.TeacherEditMapper;
import com.company.mapper.view.TeacherViewMapper;
import com.company.model.Teacher;
import com.company.repository.TeacherRepository;
import com.company.service.TeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class TeacherServiceImpl implements TeacherService {

    private final TeacherRepository teacherRepository;
    private final TeacherEditMapper teacherEditMapper;
    private final TeacherViewMapper teacherViewMapper;

    @Override
    public List<Teacher> getTeacher() {
        return teacherRepository.findAll();
    }

    @Override
    public TeacherResponse create(Long id, TeacherRequest teacherRequest) {
        return teacherViewMapper.viewTeacher(teacherRepository.
                save(teacherEditMapper.create(id, teacherRequest)));
    }

    @Override
    public TeacherResponse update(Long id, TeacherRequest teacherRequest) {
        Teacher teacher = teacherRepository.findById(id).get();
        teacherEditMapper.update(teacher, teacherRequest);
        return teacherViewMapper.viewTeacher(teacherRepository.save(teacher));
    }

    @Override
    public void delete(Long id) {
        teacherRepository.deleteById(id);
    }

    @Override
    public Teacher getTeacherById(Long id) {
        return teacherRepository.getById(id);
    }

    @Override
    public Optional<Teacher> findById(Long id) {
        return teacherRepository.findById(id);
    }
}
