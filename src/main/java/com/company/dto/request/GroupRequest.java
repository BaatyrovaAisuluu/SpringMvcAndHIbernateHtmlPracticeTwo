package com.company.dto.request;

import com.company.model.Course;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class GroupRequest {

    private String groupName;
    private String dateOfStart;
    private String dateOfFinish;
    private Course courseId;
}
