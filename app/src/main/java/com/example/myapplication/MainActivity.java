package com.example.myapplication;

import androidx.annotation.IdRes;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.myapplication.adapters.QQFragmentPagerAdapter;
import com.example.myapplication.beans.QQContactBean;
import com.example.myapplication.fragments.QQContactFragment;
import com.example.myapplication.fragments.QQMessageFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends FragmentActivity {
    private ViewPager vp;
    private RadioGroup radioGroup;
    private RadioButton rbMessage,rbContect;
    public static QQContactBean loginedUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        vp=findViewById(R.id.viewPager);
        QQFragmentPagerAdapter adapter=new QQFragmentPagerAdapter(getSupportFragmentManager(),getFragmentsList());
        vp.setAdapter(adapter);
        rbMessage=findViewById(R.id.rbMessage);
        rbContect=findViewById(R.id.rbContact);
        radioGroup=findViewById(R.id.radioGroup2);

        vp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
            switch (position){
                case 0:
                    rbMessage.setChecked(true);
                    break;
                case 1:
                    rbContect.setChecked(true);
                    break;
            }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup,@IdRes int checkedId) {
                switch (checkedId){
                    case R.id.rbMessage:
                        vp.setCurrentItem(0);
                        break;
                    case R.id.rbContact:
                        vp.setCurrentItem(1);
                        break;
                }
            }

        });
    }
    private List<Fragment> getFragmentsList(){
        QQMessageFragment f1=new QQMessageFragment();
        QQContactFragment f2=new QQContactFragment();
        List<Fragment> data=new ArrayList<Fragment>();
        data.add(f1);
        data.add(f2);
    return data;
    }

}