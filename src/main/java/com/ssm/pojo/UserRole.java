package com.ssm.pojo;

public class UserRole {
    private Long id;

    private Long roleId;

    private Long userId;

    public UserRole(Long id, Long roleId, Long userId) {
        this.id = id;
        this.roleId = roleId;
        this.userId = userId;
    }

    public UserRole() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}