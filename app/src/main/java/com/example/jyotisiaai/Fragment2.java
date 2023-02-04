package com.example.jyotisiaai;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class Fragment2 extends Fragment {

    View v;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v=inflater.inflate(R.layout.fragment_2, container, false);
        MainActivity mainActivity=new MainActivity();
        //mainActivity.relativeLayout2.setVisibility(View.VISIBLE);
        return v;
    }
}