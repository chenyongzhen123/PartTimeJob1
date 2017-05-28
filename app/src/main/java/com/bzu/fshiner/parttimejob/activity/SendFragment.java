package com.bzu.fshiner.parttimejob.activity;

import android.app.Fragment;
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
    private EditText et_title,et_price,et_sex,et_personNum,et_phone,et_time,et_address,et_description;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        return inflater.inflate(R.layout.send_fragment,container,false);

    }
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initView();
        Button btn_send = (Button) getActivity().findViewById(R.id.btn_send);
        btn_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title=et_title.getText().toString();
                String price=et_price.getText().toString();
                String sex=et_sex.getText().toString();
                String personNum=et_personNum.getText().toString();
                String phone=et_phone.getText().toString();
                String time=et_time.getText().toString();
                String address=et_address.getText().toString();
                String description=et_description.getText().toString();
                String id=BmobUser.getCurrentUser().getObjectId();
                Job job=new Job();
                job.setTitle(title);
                job.setPrice(price);
                job.setSex(sex);
                job.setPersonNum(personNum);
                job.setPhone(phone);
                job.setTime(time);
                job.setAddress(address);
                job.setDescription(description);
                job.setPublisher(id);
                job.save(new SaveListener<String>() {
                    @Override
                    public void done(String s, BmobException e) {
                        if (e == null) {
                            Toast.makeText(getActivity(), "发布成功", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(getActivity(), ListFragment.class);
                            startActivity(intent);
                        } else {
                           // Toast.makeText(getActivity(), "发布失败" + e.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });
    }


        //  }else{
        //      Toast.makeText(CreateJob.this, "有空值", Toast.LENGTH_SHORT).show();
        //  }
    private void initView() {
        et_title = (EditText) getActivity().findViewById(R.id.et_title);
        et_price = (EditText) getActivity().findViewById(R.id.et_price);
        et_sex = (EditText) getActivity().findViewById(R.id.et_sex);
        et_personNum = (EditText) getActivity().findViewById(R.id.et_personNum);
        et_phone = (EditText) getActivity().findViewById(R.id.et_phone);
        et_time = (EditText) getActivity().findViewById(R.id.et_time);
        et_address = (EditText) getActivity().findViewById(R.id.et_address);
        et_description = (EditText) getActivity().findViewById(R.id.et_description);
    }


}
