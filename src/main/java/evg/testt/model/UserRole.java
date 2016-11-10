package evg.testt.model;

/**
 * TODO: refactor this code, see @{Role}
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
