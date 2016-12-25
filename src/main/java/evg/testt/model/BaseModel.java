package evg.testt.model;

import lombok.Data;

import javax.persistence.*;

@MappedSuperclass
@SqlResultSetMapping(name ="personnel" )
//@SqlResultSetMapping(
//        name="personnel",
//        classes={
//                @ConstructorResult(
//                        targetClass=Personnel.class,
//                        columns={
//                                @ColumnResult(name="firstName"),
//                                @ColumnResult(name="lastName"),
//                                @ColumnResult(name="role")
//                        }
//                )
//        }
//)
//
//@NamedNativeQuery(name="personnel", query="SELECT * FROM personnel", resultSetMapping="personnel")
public @Data
class BaseModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BaseModel baseModel = (BaseModel) o;

        return id.equals(baseModel.id);
    }

    @Override
    public int hashCode() {
        int hash = 1;
        hash = hash * 31 + (id == null ? 0 : id.hashCode());
        return hash;
    }
}
