package com.company.service;

import com.company.dto.request.GroupRequest;
import com.company.dto.response.GroupResponse;
import com.company.model.Group;

import java.util.List;
import java.util.Optional;

public interface GroupService {

    List<Group> getGroup();

    GroupResponse create(Long id, GroupRequest groupRequest);

    GroupResponse update(Long id, GroupRequest groupRequest);

    void delete(Long id);

    Group getGroupById(Long id);

    Optional<Group> findById(Long id);

}
