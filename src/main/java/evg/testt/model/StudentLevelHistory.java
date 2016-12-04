package evg.testt.model;

import lombok.Data;
import javax.persistence.*;
import java.util.Date;

@Entity(name = "StudentLevelHistory")
public @Data class StudentLevelHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @ManyToOne
    private Student student;

    @Column(name = "typeLevel")
    @Enumerated(EnumType.ORDINAL)
    private CheckpointTypeEnum checkpointType;

    @Temporal(TemporalType.DATE)
    private Date checkpointDate;

    @Column(name = "grammar")
    @Enumerated(EnumType.ORDINAL)
    private LevelClassifierEnum grammar;

    @Column(name = "speaking")
    @Enumerated(EnumType.ORDINAL)
    private LevelClassifierEnum speaking;

    @Column(name = "listening")
    @Enumerated(EnumType.ORDINAL)
    private LevelClassifierEnum listening;

    @Column(name = "reading")
    @Enumerated(EnumType.ORDINAL)
    private LevelClassifierEnum reading;

    @Column(name = "vocabulary")
    @Enumerated(EnumType.ORDINAL)
    private LevelClassifierEnum vocabulary;

    @Column(name = "pronunciation")
    @Enumerated(EnumType.ORDINAL)
    private LevelClassifierEnum pronunciation;

    @Column(name = "writing")
    @Enumerated(EnumType.ORDINAL)
    private LevelClassifierEnum writing;

    @Column(name = "fluency")
    @Enumerated(EnumType.ORDINAL)
    private LevelClassifierEnum fluency;

    @Column(name = "spelling")
    @Enumerated(EnumType.ORDINAL)
    private LevelClassifierEnum spelling;

}