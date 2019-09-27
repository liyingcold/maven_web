package com.ssm.pojo;

public class UserInfo {
    private Long id;

    private Long userId;

    private String note;

    private byte[] headImage;

    public UserInfo(Long id, Long userId, String note, byte[] headImage) {
        this.id = id;
        this.userId = userId;
        this.note = note;
        this.headImage = headImage;
    }

    public UserInfo() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public byte[] getHeadImage() {
        return headImage;
    }

    public void setHeadImage(byte[] headImage) {
        this.headImage = headImage;
    }
}