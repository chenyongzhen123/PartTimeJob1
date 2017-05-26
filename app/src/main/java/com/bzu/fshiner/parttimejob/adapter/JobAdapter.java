package com.bzu.fshiner.parttimejob.adapter;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import com.bzu.fshiner.parttimejob.R;
import com.bzu.fshiner.parttimejob.model.Job;
import java.util.List;

/**
 * Created by CYZ on 2017/5/24.
 */

public class JobAdapter extends ArrayAdapter<Job> {
    private int rescourID;
    public JobAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull List<Job> objects) {
        super(context, resource, objects);
        rescourID=resource;
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Job bu = getItem(position);
        View view;
        ViewHolder viewHolder;
        if(convertView==null){
            view = LayoutInflater.from(getContext()).inflate(rescourID, null);
            viewHolder = new ViewHolder();
            viewHolder.tvUsername=(TextView) view.findViewById(R.id.tvuser);
            view.setTag(viewHolder);
        }else {
            view =convertView;
            viewHolder=(ViewHolder)view.getTag();
        }
        viewHolder.tvUsername.setText(bu.getTitle());
        viewHolder.tvUsername.setFocusable(false);
        

        return view;
    }
    class ViewHolder{
        TextView tvUsername;
    }
}
