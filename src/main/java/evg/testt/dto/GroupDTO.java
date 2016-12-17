package evg.testt.dto;

import lombok.Data;
import javax.validation.constraints.Size;

public @Data class GroupDTO {

    @Size(min = 2, max = 20, message = "Name length must have 2-20 chars")
    private String name;

    private Integer teacherId;

    private Integer studentId;

    private Integer groupId;

}
