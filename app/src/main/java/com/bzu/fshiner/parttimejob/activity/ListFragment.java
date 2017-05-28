package com.bzu.fshiner.parttimejob.activity;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

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

public class ListFragment extends Fragment implements AdapterView.OnItemClickListener,AbsListView.OnScrollListener {
    private ListView listview;
    private Context mContext;
   // private JobAdapter jobAdapter;
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
        listview.setOnItemClickListener(this);
        listview.setOnScrollListener(this);
        refresh();

    }
    public void refresh() {
        BmobQuery<Job> query = new BmobQuery<Job>();
        query.setLimit(50);
        query.findObjects(new FindListener<Job>() {
            @Override
            public void done(List<Job> list, BmobException e) {
                if(e==null){
                    listview.setAdapter(new JobAdapter(mContext,R.layout.list_item,list));

                }
            }

        });

    }

    @Override
    public void onScrollStateChanged(AbsListView absListView, int i) {

    }

    @Override
    public void onScroll(AbsListView absListView, int i, int i1, int i2) {

    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
        Bundle bundle = new Bundle();
        Intent intent = new Intent(getActivity(),MoreActivity.class);
        startActivity(intent);
    }
}
