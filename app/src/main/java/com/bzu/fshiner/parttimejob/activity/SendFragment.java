package com.bzu.fshiner.parttimejob.activity;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.bzu.fshiner.parttimejob.R;
import com.bzu.fshiner.parttimejob.model.Job;

import cn.bmob.v3.BmobUser;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SaveListener;

/**
 * Created by Administrator on 2017/5/17.
 */

public class SendFragment extends Fragment {

    private EditText ettitle,etaddress,etphone;
    private Context mContext;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.mContext = getActivity();
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        return inflater.inflate(R.layout.send_fragment,container,false);

    }
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initView();
        Button button = (Button) getActivity().findViewById(R.id.fabu);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createJob();
            }
        });
    }
    public void createJob(){
        Job job = new Job();
        String title = ettitle.getText().toString();
        String address = etaddress.getText().toString();
        String phone =etphone.getText().toString();
        String id = BmobUser.getCurrentUser().getObjectId();
        // if(" ".equals(title)&&" ".equals(phone)&&" ".equals(address)) {    //验证空失败。
        job.setTitle(title);
        job.setAddress(address);
        job.setPhone(phone);
        job.setPublisher(id);
        job.save(new SaveListener<String>() {
            @Override
            public void done(String s, BmobException e) {
                if (e == null) {
                    Toast.makeText(mContext, "发布成功", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(mContext,ListFragment.class);
                    startActivity(intent);
                } else {
                   // Toast.makeText(mContext, "发布失败" + e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });
        //  }else{
        //      Toast.makeText(CreateJob.this, "有空值", Toast.LENGTH_SHORT).show();
        //  }
    }
    private void initView() {
        ettitle= (EditText)getActivity().findViewById(R.id.editText);
        etaddress= (EditText) getActivity().findViewById(R.id.editText4);
        etphone= (EditText) getActivity().findViewById(R.id.editText5);
    }


}
