package com.bzu.fshiner.parttimejob.activity;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bzu.fshiner.parttimejob.R;

/**
 * Created by Administrator on 2017/5/17.
 */

public class PersonalFragment extends Fragment {
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        return inflater.inflate(R.layout.personal_fragment,container,false);
    }
}
