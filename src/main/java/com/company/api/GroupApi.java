package com.company.api;

import com.company.dto.request.GroupRequest;
import com.company.dto.response.GroupResponse;
import com.company.model.Group;
import com.company.service.CourseService;
import com.company.service.GroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/group/{courseId}")
public class GroupApi {

    private final GroupService groupService;
    private final CourseService courseService;

    @GetMapping
    public List<Group> getAll() {
        return groupService.getGroup();
    }

    @PostMapping("/saveGroup")
    public GroupResponse create(@PathVariable("courseId") Long id, @RequestBody GroupRequest groupRequest) {
        groupRequest.setCourseId(courseService.getCourseById(id));
        return groupService.create(id, groupRequest);
    }

    @PatchMapping("/update/{updateId}")
    public GroupResponse update(@PathVariable("updateId") Long id, @RequestBody GroupRequest groupRequest) {
        return groupService.update(id, groupRequest);
    }

    @DeleteMapping("/delete/{deleteId}")
    public void delete(@PathVariable("deleteId") Long id) {
        groupService.delete(id);
    }

    @GetMapping("/groupId/{GroupId}")
    public Optional<Group> getIdGroup(@PathVariable("GroupId") Long id) {
        return groupService.findById(id);
    }
}
