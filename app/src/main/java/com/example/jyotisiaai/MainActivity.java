package com.example.jyotisiaai;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    RadioGroup rg;
    RadioButton r1,r2,r3,r4,r5;
    static int color=R.color.black;
    RelativeLayout relativeLayout1,relativeLayout2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        rg=findViewById(R.id.toggle);
        r1=findViewById(R.id.off);
        r2=findViewById(R.id.on);
        r3=(RadioButton) findViewById(R.id.today);
        r4=(RadioButton) findViewById(R.id.last_days);
        r5=(RadioButton) findViewById(R.id.last_days2);
        relativeLayout1=findViewById(R.id.rela_3);
        relativeLayout2=findViewById(R.id.rela_5);

        replaceFragment(new Fragment1());

        r1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Toast.makeText(MainActivity.this, "R1 Clicked", Toast.LENGTH_SHORT).show();
                relativeLayout1.setVisibility(View.VISIBLE);
                relativeLayout2.setVisibility(View.GONE);
                replaceFragment(new Fragment1());
            }
        });
        r2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                replaceFragment(new Fragment2());
                relativeLayout1.setVisibility(View.INVISIBLE);
                relativeLayout2.setVisibility(View.VISIBLE);
            }
        });


    }

    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager=getSupportFragmentManager();
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout,fragment);
        fragmentTransaction.commit();
    }
}