package com.bzu.fshiner.parttimejob.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.bzu.fshiner.parttimejob.R;
import com.bzu.fshiner.parttimejob.model.User;

import cn.bmob.v3.Bmob;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SaveListener;

public class RegisterActivity extends AppCompatActivity {

    private EditText et_user,et_pass,et_nick;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        Bmob.initialize(this, "9e4765b20da085368f0ddb6ebf126c1f");
        initView();
    }
    //注册
    public void Register(View view) {
        User bu = new User();
        bu.setUsername(et_user.getText().toString());
        bu.setPassword(et_pass.getText().toString());
       // bu.setNickName(et_nick.getText().toString());
        bu.signUp(new SaveListener<Object>() {

            @Override
            public void done(Object o, BmobException e) {
                if(e==null){
                    Toast.makeText(RegisterActivity.this,"注册成功",Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(RegisterActivity.this,LoginActivity.class);
                    startActivity(intent);
                }else{
                    Toast.makeText(RegisterActivity.this,"注册失败"+e.getMessage(), Toast.LENGTH_LONG).show();
                }
            }
        });
    }
    private void initView() {
        et_user = (EditText) findViewById(R.id.etUserName);
        et_pass = (EditText) findViewById(R.id.etPassword);
      //  et_nick= (EditText) findViewById(R.id.et_nickName);
    }
    /*public void login1(View view){
        Intent intent = new Intent(RegisterActivity.this,LoginActivity.class);
        startActivity(intent);
    }*/
}
