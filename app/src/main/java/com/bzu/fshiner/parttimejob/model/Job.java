package com.bzu.fshiner.parttimejob.model;

import cn.bmob.v3.BmobObject;

/**
 * Created by CYZ on 2017/5/21.
 */
// 自己写的表  该实体类要继承BmobObject
public class Job extends BmobObject {
    private String title;
    private String sex;
    private String phone;
    private String Adders;
    private String publisher;
    private String address;
    private String price;
    private Integer personNum;
    private String description;


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAdders() {
        return Adders;
    }

    public void setAdders(String adders) {
        Adders = adders;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Integer getPersonNum() {
        return personNum;
    }

    public void setPersonNum(Integer personNum) {
        this.personNum = personNum;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
