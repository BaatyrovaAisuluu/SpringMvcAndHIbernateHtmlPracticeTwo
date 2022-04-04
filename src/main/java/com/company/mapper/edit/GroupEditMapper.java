package com.company.mapper.edit;

import com.company.dto.request.GroupRequest;
import com.company.model.Group;
import com.company.repository.CourseRepository;
import org.springframework.stereotype.Component;

@Component
public class GroupEditMapper {

    public final CourseRepository courseRepository;

    public GroupEditMapper(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public Group create(Long id, GroupRequest groupRequest) {

        if (groupRequest == null) {
            return null;
        }

        Group group = new Group();
        group.setGroupName(groupRequest.getGroupName());
        group.setDateOfStart(groupRequest.getDateOfStart());
        group.setDateOfFinish(groupRequest.getDateOfFinish());
        group.AddCourse(courseRepository.getById(id));
        return group;
    }

    public void update(Group group, GroupRequest groupRequest) {
        group.setGroupName(groupRequest.getGroupName());
        group.setDateOfStart(groupRequest.getDateOfStart());
        group.setDateOfFinish(groupRequest.getDateOfFinish());
    }
}
