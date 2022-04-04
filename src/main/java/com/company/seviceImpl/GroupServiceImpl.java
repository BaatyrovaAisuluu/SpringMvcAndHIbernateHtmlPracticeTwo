package com.company.seviceImpl;

import com.company.dto.request.GroupRequest;
import com.company.dto.response.GroupResponse;
import com.company.mapper.edit.GroupEditMapper;
import com.company.mapper.view.GroupViewMapper;
import com.company.model.Group;
import com.company.repository.GroupRepository;
import com.company.service.GroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class GroupServiceImpl implements GroupService {

    private final GroupRepository groupRepository;
    private final GroupEditMapper groupEditMapper;
    private final GroupViewMapper groupViewMapper;

    @Override
    public List<Group> getGroup() {
        return groupRepository.findAll();
    }

    @Override
    public GroupResponse create(Long id, GroupRequest groupRequest) {
        return groupViewMapper.viewCourse(groupRepository.
                save(groupEditMapper.create(id, groupRequest)));
    }

    @Override
    public GroupResponse update(Long id, GroupRequest groupRequest) {
        Group group = groupRepository.findById(id).get();
        groupEditMapper.update(group, groupRequest);
        return groupViewMapper.viewCourse(groupRepository.save(group));
    }

    @Override
    public void delete(Long id) {
        groupRepository.deleteById(id);
    }

    @Override
    public Group getGroupById(Long id) {
        return groupRepository.getById(id);
    }

    @Override
    public Optional<Group> findById(Long id) {
        return groupRepository.findById(id);
    }
}
