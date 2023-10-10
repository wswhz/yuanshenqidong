package com.example.myapplication; // 包名

import androidx.appcompat.app.AppCompatActivity; // 导入 AppCompatActivity 类
import android.os.Bundle; // 导入 Bundle 类
import android.view.View; // 导入 View 类
import android.widget.Button; // 导入 Button 类
import android.widget.EditText; // 导入 EditText 类
import android.widget.RadioButton; // 导入 RadioButton 类
import android.widget.RadioGroup; // 导入 RadioGroup 类
import android.widget.Toast; // 导入 Toast 类

public class RegisterQQ extends AppCompatActivity { // QQ 注册活动类

    // 声明一个 RadioGroup 对象
    private RadioGroup radioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) { // 重写 onCreate() 方法
        super.onCreate(savedInstanceState); // 调用父类的 onCreate() 方法
        setContentView(R.layout.activity_register_qq); // 设置布局文件

        // 获取 RadioGroup 对象
        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);

        // 获取 注册 QQ 按钮
        Button btnRegisterQQ = (Button) findViewById(R.id.btn_RegisterQQ);

        // 设置 注册 QQ 按钮的点击事件
        btnRegisterQQ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { // 注册 QQ 按钮被点击时

                // 获取 QQ 号码输入框
                EditText editText_Phone = (EditText) findViewById(R.id.editText_InputQQNum);

                // 获取 密码输入框
                EditText editText_Password = (EditText) findViewById(R.id.editText_InputPassword);

                // 获取 邮箱输入框
                EditText editText_Email = (EditText) findViewById(R.id.editText_InputEmail);

                // 获取选中的 RadioButton 控件
                RadioButton radioButton = (RadioButton) findViewById(radioGroup.getCheckedRadioButtonId());

                // 显示 Toast 消息
                Toast.makeText(RegisterQQ.this, "QQ号: " + editText_Phone.getText().toString()
                                + "\n密码" + editText_Password.getText().toString()
                                + "\n邮箱" + editText_Email.getText().toString()
                                + "\n性别: " + radioButton.getText().toString()
                        , Toast.LENGTH_SHORT).show();
            }
        });
    }
}