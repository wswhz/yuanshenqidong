package com.example.myapplication;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.adapters.QQMessageAdapter;
import com.example.myapplication.beans.QQMessageBean;

import java.util.ArrayList;
import java.util.List;

public class QQMessageActivity extends AppCompatActivity {
    private ListView lvMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qqmessage);
        lvMessage=(ListView) findViewById(R.id.lvmessage);

        QQMessageAdapter adapter=new QQMessageAdapter(getMessageList(),this);
        lvMessage.setAdapter(adapter);
    }
    private List<QQMessageBean> getMessageList(){
        ArrayList<QQMessageBean> data=new ArrayList<QQMessageBean>();
        String[] names=new String[]{"刘备","曹操","孙权","张飞","关羽","赵云",
                "诸葛亮","黄忠","魏延"};
        int[] imgs=new int[]{R.drawable.liubei,R.drawable.caocao,
                R.drawable.sunquan,R.drawable.zhangfei,R.drawable.guanyu,R.drawable.zhaoyun, R.drawable.zhugeliang,R.drawable.huangzhong,
        R.drawable.weiyan};
        for(int i=0;i<names.length;i++) {
            QQMessageBean m=new QQMessageBean(names[i],imgs[i],"下午2:30",
                    "hello",3);
            data.add(m);
        }
        return data;
        }


    }

