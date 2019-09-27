package com.ssm.vo;

import java.util.List;

public class RoleVo {
    private Long id;

    private String roleName;

    private String note;
//    关联用户信息，一对多关联
    private List<UserInfoVo> userList;

    public RoleVo(Long id, String roleName, String note) {
        this.id = id;
        this.roleName = roleName;
        this.note = note;
    }

    public RoleVo() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public List<UserInfoVo> getUserList() {
        return userList;
    }

    public void setUserList(List<UserInfoVo> userList) {
        this.userList = userList;
    }
}