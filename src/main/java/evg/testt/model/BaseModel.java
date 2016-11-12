package evg.testt.model;



import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

//@ToString(exclude = "id")
//@EqualsAndHashCode(exclude = "id")
@MappedSuperclass
public class BaseModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BaseModel baseModel = (BaseModel) o;

        return id.equals(baseModel.id);
    }

    /*@Override public int hashCode() {
        return id.hashCode();
    }*/


    @Override
    public int hashCode() {
        int hash = 1;
        hash = hash * 31 + (id == null ? 0 : id.hashCode());
        return hash;
    }

}
