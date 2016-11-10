package evg.testt.model;

public enum UserRole {
    ROLE_ADMIN,
    ROLE_MANAGER,
    ROLE_TEACHER,
    ROLE_STUDENT;


    String userRole;

    private String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }
}
