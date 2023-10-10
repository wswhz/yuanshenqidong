package com.example.myapplication.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.myapplication.R;
import com.example.myapplication.adapters.QQContactAdapter;
import com.example.myapplication.beans.QQContactBean;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class QQContactFragment extends Fragment {
    private ExpandableListView lv;
    private String countries[] = new String[]{"蜀","魏","吴"};
    private String names[][] = new String[][] {
            {"刘备","关羽","张飞","赵云","黄忠","魏延"},{"曹操","许裙","张辽"},{"孙权","鲁肃","吕蒙"}};
    private int icons[][]=new int[][]{
            {R.drawable.liubei,R.drawable.guanyu,
                    R.drawable.zhangfei,R.drawable.zhaoyun,R.drawable.huangzhong,R.drawable.weiyan},
            {R.drawable.caocao,R.drawable.xuchu,R.drawable.zhangliao},
            {R.drawable.sunquan,R.drawable.lusu,R.drawable.lvmeng}};
    private List<String> groupData;
    private Map<String, List<QQContactBean>> childData;
    @Nullable
    @org.jetbrains.annotations.Nullable
    @Override
    public View onCreateView(@NonNull @NotNull LayoutInflater inflater, @Nullable @org.jetbrains.annotations.Nullable ViewGroup container, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {

        View view=inflater.inflate(R.layout.activity_qqcontact,container,false);
        lv=view.findViewById(R.id.exlvContact) ;
        childData = new HashMap<String, List<QQContactBean>>();
        groupData = new ArrayList<String>();
        initialData() ;
       QQContactAdapter adapter=new QQContactAdapter(groupData, childData, this.getContext());
        lv.setAdapter (adapter);
        return view;
    }
    private void initialData() {
        for (int i = 0;i <countries.length; i++) {
            groupData.add(countries[i]);
            List<QQContactBean> list=new ArrayList<QQContactBean>();
            for (int j= 0;j <names[i].length; j++){
                QQContactBean p = new QQContactBean (names[i][j],icons[i][j],"4G在线","天天向上");
                list.add(p);
            }
            childData.put(countries[i],list);
        }
    }
}
