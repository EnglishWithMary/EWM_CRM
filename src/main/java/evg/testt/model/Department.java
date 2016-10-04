package evg.testt.model;

//import net.sf.oval.constraint.Size;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.List;

import net.sf.oval.constraint.Length;
import net.sf.oval.constraint.Size;
import org.springframework.validation.annotation.Validated;

@Entity(name = "departments")
public class Department extends BaseModel{

    //@MatchPattern(pattern = "[A-Za-z0-9\\s]")
    //don't know, does it really nessesary?
    //@Size(min = 3, max = 20, message = "The name must be between 3 and 20 characters")
    @Length(min = 3, max = 20, message = "The size should be between 3 and 20 included")
    private String name;

    //@Size
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
