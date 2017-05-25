package com.bzu.fshiner.parttimejob.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.bzu.fshiner.parttimejob.R;

import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobUser;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SaveListener;

public class LoginActivity extends AppCompatActivity {
    private EditText et_user,et_pass;
    private CheckBox checkBox;
    private SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Bmob.initialize(this, "9e4765b20da085368f0ddb6ebf126c1f");
        initView();
        sharedPreferences=getSharedPreferences("rememberpassword", Context.MODE_PRIVATE);
        boolean isRemember=sharedPreferences.getBoolean("rememberpassword",false);
        if(isRemember){
            String name=sharedPreferences.getString("name","");
            String password=sharedPreferences.getString("password","");
            et_user.setText(name);
            et_pass.setText(password);
            checkBox.setChecked(true);
        }
    }
    //登录
    public void login(View view){
        BmobUser bu2 = new BmobUser();
        bu2.setUsername(et_user.getText().toString());
        bu2.setPassword(et_pass.getText().toString());
        bu2.login(new SaveListener<Object>() {
            @Override
            public void done(Object o, BmobException e) {
                if(e==null){
                    Toast.makeText(LoginActivity.this,"登录成功",Toast.LENGTH_LONG).show();
                    SharedPreferences.Editor editor=sharedPreferences.edit();
                    if(checkBox.isChecked()){
                        editor.putBoolean("rememberpassword",true);
                        editor.putString("name",et_user.getText().toString());
                        editor.putString("password",et_pass.getText().toString());
                    }else{
                        editor.clear();
                    }
                    editor.commit();
                    Intent intent = new Intent(LoginActivity.this,MainActivity.class);
                    startActivity(intent);
                }else{
                    Toast.makeText(LoginActivity.this,"登录失败"+e.getMessage(),Toast.LENGTH_LONG).show();
                }
            }
        });
    }
    public void res(View view){
        Intent intent = new Intent(this,RegisterActivity.class);
        startActivity(intent);
    }
    private void initView() {
        et_user = (EditText) findViewById(R.id.etName);
        et_pass = (EditText) findViewById(R.id.etPassword);
        checkBox= (CheckBox) findViewById(R.id.checkBox);
    }
}
