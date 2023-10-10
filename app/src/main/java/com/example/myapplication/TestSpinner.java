package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class TestSpinner extends AppCompatActivity {

    // 声明一个 Spinner 对象
    private Spinner spinner;

    // 声明一个包含五个国家名称的数组
    private String[] countries = {"中国", "美国", "俄罗斯", "英国", "法国"};

    // 重写 onCreate() 方法，初始化界面
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // 调用父类的 onCreate() 方法
        super.onCreate(savedInstanceState);

        // 设置布局文件
        setContentView(R.layout.activity_test_spinner);

        // 获取 Spinner 对象
        spinner = (Spinner) findViewById(R.id.spinner);

        // 创建一个 ArrayAdapter 对象，将 countries 数组绑定到 Spinner 上
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                R.layout.support_simple_spinner_dropdown_item,
                countries);

        // 将 Adapter 设置到 Spinner 上
        spinner.setAdapter(adapter);

        // 设置 Spinner 的监听器
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                // 获取选中的国家名称
                String country = countries[i];

                // 显示 Toast 消息
                Toast.makeText(TestSpinner.this, country, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                // 什么也不做
            }
        });
    }
}