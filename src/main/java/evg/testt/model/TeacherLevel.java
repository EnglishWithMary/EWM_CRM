package evg.testt.model;

/**
 * Created by oleksiy on 05.12.16.
 */
import lombok.Data;
import javax.persistence.*;

@Entity(name = "TeacherLevel")
public @Data class TeacherLevel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @ManyToOne
    private Teacher teacher;

    @Column(name = "level")
    @Enumerated(EnumType.ORDINAL)
    private TeacherLevelEnum level;

}
