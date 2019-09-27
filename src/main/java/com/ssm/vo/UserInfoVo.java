package com.ssm.vo;

import java.util.List;

public class UserInfoVo {
    private List<UserLoginVo> userLoginList=null;
    private String userName;
//性别处理
//    女
    private List<FemaleHealthVo> femaleHealthVoList=null;
//     男
    private List<MaleHealthVo> maleHealthVoList=null;
    private String mobile;

    private String tel;

    private String note;
//    角色名称，在role中
    private String roleName;
//    头像信息，在userInfo中
    private byte[] headImage;

    public UserInfoVo() {
    }

    public List<UserLoginVo> getUserLoginList() {
        return userLoginList;
    }

    public void setUserLoginList(List<UserLoginVo> userLoginList) {
        this.userLoginList = userLoginList;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public List<FemaleHealthVo> getFemaleHealthVoList() {
        return femaleHealthVoList;
    }

    public void setFemaleHealthVoList(List<FemaleHealthVo> femaleHealthVoList) {
        this.femaleHealthVoList = femaleHealthVoList;
    }

    public List<MaleHealthVo> getMaleHealthVoList() {
        return maleHealthVoList;
    }

    public void setMaleHealthVoList(List<MaleHealthVo> maleHealthVoList) {
        this.maleHealthVoList = maleHealthVoList;
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

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public byte[] getHeadImage() {
        return headImage;
    }

    public void setHeadImage(byte[] headImage) {
        this.headImage = headImage;
    }
}