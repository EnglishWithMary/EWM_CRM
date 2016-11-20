package evg.testt.dto;

import evg.testt.model.Teacher;
import lombok.Data;

import java.util.List;

public @Data class GroupDTO {

    private String name;

    private List<Teacher> teacherList;

}
