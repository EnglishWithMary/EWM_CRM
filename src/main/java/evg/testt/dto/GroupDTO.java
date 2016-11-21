package evg.testt.dto;

import evg.testt.model.Teacher;
import lombok.Data;
import net.sf.oval.constraint.Length;

import java.util.List;

/**
 * Created by abonent63 on 20.11.16.
 */
import java.util.List;

public @Data class GroupDTO {

    @Length(min = 2, max = 20, message = "Wrong name.")
    private String name;

    private Integer teacherId;

}
