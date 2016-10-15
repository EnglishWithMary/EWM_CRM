package evg.testt.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

/**
 * Created by clay on 05.10.16.
 */

@Entity(name = "roles")
public class Role extends BaseModel {

    private UserRole userRole;

//    @OneToOne
//    @JoinColumn(name = "user_id")
    private Integer userId;

    public void setUserRole(UserRole userRole) {
        this.userRole = userRole;
    }

    public UserRole getUserRole() {
        return userRole;
    }


    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
