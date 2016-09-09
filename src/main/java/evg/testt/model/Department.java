package evg.testt.model;

import javax.persistence.Entity;

@Entity(name = "departments")
public class Department extends BaseModel{

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
