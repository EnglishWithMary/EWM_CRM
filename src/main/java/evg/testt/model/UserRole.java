package evg.testt.model;

public enum UserRole {
    ROLE_ADMIN(1), ROLE_MANAGER(2), ROLE_TEACHER(3), ROLE_STUDENT(4);

    private int roleId;

    UserRole(int id){
        roleId = id;
    }

    public int getRoleId()
    {
        return roleId;
    }
}
