package com.bzu.fshiner.parttimejob.model;

import cn.bmob.v3.BmobUser;

/**
 * Created by CYZ on 2017/5/21.
 */
//这是特殊对象，表是他内定的，继承BmobUser而不是BmobObject。  nickName是子类User的属性。
public class User extends BmobUser {
    private String nickName; //昵称

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }
}
