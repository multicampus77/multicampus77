package com.multi.bookstore.user.model.dto;

import java.util.Date;

public class User {
    private String id;
    private String pw;
    private String name;
    private String email;
    private String address;
    private Date createDate;
    private String phone;
    private boolean delete_yn;
    private boolean admin_yn;

    public User() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPw() {
        return pw;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public boolean isDelete_yn() {
        return delete_yn;
    }

    public void setDelete_yn(boolean delete_yn) {
        this.delete_yn = delete_yn;
    }

    public boolean isAdmin_yn() {
        return admin_yn;
    }

    public void setAdmin_yn(boolean admin_yn) {
        this.admin_yn = admin_yn;
    }

    @Override
    public String toString() {
        return "com.multi.bookstore.user.model.dto.User{" +
                "id='" + getId() + '\'' +
                ", pw='" + getPw() + '\'' +
                ", name='" + getName() + '\'' +
                ", email='" + getEmail() + '\'' +
                ", address='" + getAddress() + '\'' +
                ", createDate=" + getCreateDate() +
                ", phone='" + getPhone() + '\'' +
                ", delete_yn=" + isDelete_yn() +
                ", admin_yn=" + isAdmin_yn() +
                '}';
    }
}
