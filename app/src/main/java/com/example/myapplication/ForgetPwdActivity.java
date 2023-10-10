package com.example.myapplication; // 包名

import androidx.appcompat.app.AppCompatActivity; // 导入 AppCompatActivity 类

import android.os.Bundle; // 导入 Bundle 类

public class ForgetPwdActivity extends AppCompatActivity { // 忘记密码活动类

    @Override
    protected void onCreate(Bundle savedInstanceState) { // 重写 onCreate() 方法
        super.onCreate(savedInstanceState); // 调用父类的 onCreate() 方法
        setContentView(R.layout.activity_forget_pwd); // 设置布局文件
    }
}