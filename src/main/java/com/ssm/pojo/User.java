package com.ssm.pojo;

import java.util.List;

public class User {
    private Long id;

    private String userName;

    private String password;
//性别处理
    private SexEnum sex;

    private String mobile;

    private String tel;

    private String email;

    private String note;
//    与用户信息表，一对一级联
    private UserInfo userInfo;
//    与角色role表，一对多级联
    private List<Role> roleList;

    public User(Long id, String userName, String password, SexEnum sex, String mobile, String tel, String email, String note, UserInfo userInfo, List<Role> roleList) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.sex = sex;
        this.mobile = mobile;
        this.tel = tel;
        this.email = email;
        this.note = note;
        this.userInfo = userInfo;
        this.roleList = roleList;
    }

    public User() {
        super();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public SexEnum getSex() {
        return sex;
    }

    public void setSex(SexEnum sex) {
        this.sex = sex;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public List<Role> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<Role> roleList) {
        this.roleList = roleList;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}