package com.ssm.vo;

public class UserLoginVo {
    private Long id;
    private String userName;
    private String password;
    private String email;

    public UserLoginVo(Long id, String userName, String password, String email) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.email = email;
    }

    public UserLoginVo(Long id, String password, String email) {
        this.id = id;
        this.password = password;
        this.email = email;
    }

    public UserLoginVo() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
