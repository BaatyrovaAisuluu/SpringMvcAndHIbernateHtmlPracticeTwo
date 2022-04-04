package com.company.mapper.view;

import com.company.dto.response.GroupResponse;
import com.company.model.Group;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class GroupViewMapper {

    public GroupResponse viewCourse(Group group) {
        if (group == null) {
            return null;
        }

        GroupResponse groupResponse = new GroupResponse();
        groupResponse.setId(String.valueOf(group.getId()));
        groupResponse.setGroupName(group.getGroupName());
        groupResponse.setDateOfStart(group.getDateOfStart());
        groupResponse.setDateOfFinish(group.getDateOfFinish());
        return groupResponse;

    }

    public List<GroupResponse> viewGroup(List<Group> groups) {
        List<GroupResponse> groupResponses = new ArrayList<>();
        for (Group g : groups
        ) {
            groupResponses.add(viewCourse(g));
        }
        return groupResponses;
    }


}
