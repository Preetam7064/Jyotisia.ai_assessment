package com.example.jyotisiaai;

import android.animation.ObjectAnimator;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.Toast;


public class Fragment1 extends Fragment {
    Button btn;
    View v;
    RelativeLayout rela1,rela2;
    ProgressBar mprogressBar;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v=inflater.inflate(R.layout.fragment_1, container, false);
        btn=v.findViewById(R.id.onButton);
        rela1=v.findViewById(R.id.Rela_1);
        rela2=v.findViewById(R.id.Rela_2);
        mprogressBar = v.findViewById(R.id.circular_progress_bar);
        MyCustomListener listener=new MyCustomListener();
        btn.setOnClickListener(listener);
        return v;
    }
    public class MyCustomListener implements View.OnClickListener
    {

        @Override
        public void onClick(View view) {
            Toast.makeText(getActivity(), "Button Clicked", Toast.LENGTH_SHORT).show();
            rela1.setVisibility(View.INVISIBLE);
            rela2.setVisibility(View.VISIBLE);


            ObjectAnimator anim = ObjectAnimator.ofInt(mprogressBar, "progress", 0, 100);
            anim.setDuration(15000);
            anim.setInterpolator(new DecelerateInterpolator());
            anim.start();
            replaceFragment(new Fragment2());
        }
    }
    private void replaceFragment(Fragment fragment) {
        Fragment frag=new Fragment2();
        FragmentManager fragmentManager=getActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout,fragment);
        fragmentTransaction.commit();
    }
}