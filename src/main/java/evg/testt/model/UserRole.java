package evg.testt.model;

/**
 * Created by clay on 05.10.16.
 */
public enum UserRole {
    ADMIN,
    DIRECTOR,
    TEACHER,
    STUDENT;

    String userRole;

    private String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }
}
