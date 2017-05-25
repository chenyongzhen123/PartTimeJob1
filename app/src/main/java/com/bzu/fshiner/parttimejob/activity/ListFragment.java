package com.bzu.fshiner.parttimejob.activity;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.bzu.fshiner.parttimejob.R;
import com.bzu.fshiner.parttimejob.adapter.JobAdapter;
import com.bzu.fshiner.parttimejob.model.Job;

import java.util.List;

import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;

/**
 * Created by Administrator on 2017/5/9.
 */

public class ListFragment extends Fragment {
    private ListView listview;
    private Context mContext;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.mContext = getActivity();
    }
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState){
        return inflater.inflate(R.layout.list_fragment,container,false);

    }
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        listview = (ListView) getActivity().findViewById(R.id.list);
        refresh();
    }
    public void refresh() {
        BmobQuery<Job> query = new BmobQuery<Job>();
        query.setLimit(50);
        query.findObjects(new FindListener<Job>() {
            @Override
            public void done(List<Job> list, BmobException e) {
                if(e==null){
                    listview.setAdapter(new JobAdapter(mContext,R.layout.job_item,list));
                }
            }

        });

    }
}
