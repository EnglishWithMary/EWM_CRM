package evg.testt.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.List;

import net.sf.oval.constraint.Length;
import net.sf.oval.constraint.MatchPattern;
import org.springframework.beans.factory.annotation.Autowired;

@Entity(name = "departments")
public class Department extends BaseModel{

//    @Autowired
    @Length(min = 3, max = 20, message = "The size of Department name should be between 3 and 20 included")
    @MatchPattern(pattern = "[A-Za-z0-9\\s]", message = "Department name should consist only of chars and digits")
    private String name;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "department", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Employee> employees;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}
