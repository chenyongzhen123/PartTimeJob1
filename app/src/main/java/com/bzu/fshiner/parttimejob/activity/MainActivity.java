package com.bzu.fshiner.parttimejob.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.bzu.fshiner.parttimejob.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView tv_top;
    private TextView tv_list;
    private TextView tv_send;
    private TextView tv_personal;
    private FrameLayout fragment_container;
    private ListFragment f1;
    private SendFragment f2;
    private PersonalFragment f3;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //ui组件初始化与事件绑定
        tv_top=(TextView)this.findViewById(R.id.tv_top);
        tv_list=(TextView)this.findViewById(R.id.tv_list);
        tv_send=(TextView)this.findViewById(R.id.tv_send);
        tv_personal=(TextView)this.findViewById(R.id.tv_personal);
        button= (Button) findViewById(R.id.btn_send);
        fragment_container=(FrameLayout)findViewById(R.id.fragment_container);
        tv_list.setOnClickListener(this);
        tv_send.setOnClickListener(this);
        tv_personal.setOnClickListener(this);
    }

    //重置所有文本的选中状态
    public void selected(){
        tv_list.setSelected(false);
        tv_send.setSelected(false);
        tv_personal.setSelected(false);
    }

    //隐藏所有的Fragment
    private void hideAllFragment(android.app.FragmentTransaction transaction) {
        if(f1!=null){
            transaction.hide(f1);
        }
        if(f2!=null){
            transaction.hide(f2);
        }
        if(f3!=null){
            transaction.hide(f3);
        }
    }
    @Override
    public void onClick(View view){
       android.app.FragmentTransaction transaction=getFragmentManager().beginTransaction();
        hideAllFragment(transaction);
        switch(view.getId()){
            case R.id.tv_list:
                selected();
                tv_list.setSelected(true);
                if(f1==null){
                    f1 = new ListFragment();
                    transaction.add(R.id.fragment_container,f1);
                }else{
                    transaction.show(f1);
                }
                break;

            case R.id.tv_send:
                selected();
                tv_send.setSelected(true);
                if(f2==null){
                    f2 = new SendFragment();
                    transaction.add(R.id.fragment_container,f2);
                }else{
                    transaction.show(f2);
                }
                break;

            case R.id.tv_personal:
                selected();
                tv_personal.setSelected(true);
                if(f3==null){
                    f3 = new PersonalFragment();
                    transaction.add(R.id.fragment_container,f3);
                }else{
                    transaction.show(f3);
                }
                break;
        }
        transaction.commit();
    }



}
