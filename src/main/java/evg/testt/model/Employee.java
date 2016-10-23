package evg.testt.model;

import net.sf.oval.constraint.Length;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name = "employees")
public class Employee extends BaseModel{

    @Length(min = 1, max = 20, message = "The size of Name name should be at least 1 char")
    private String firstName;

    @Length(min = 1, max = 20, message = "The size of Name name should be at least 1 char")
    private String secondName;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}
