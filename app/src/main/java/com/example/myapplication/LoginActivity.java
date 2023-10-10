package com.example.myapplication; // 包名

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity; // 导入 AppCompatActivity 类

import android.content.DialogInterface;
import android.content.Intent; // 导入 Intent 类
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle; // 导入 Bundle 类
import android.view.Menu;
import android.view.MenuItem;
import android.view.View; // 导入 View 类
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView; // 导入 TextView 类
import android.widget.Toast;

import com.example.myapplication.beans.QQContactBean;
import com.example.myapplication.dbutils.DB_Params;
import com.example.myapplication.dbutils.MyDbHelper;

public class LoginActivity extends AppCompatActivity { // 登录活动类
    private TextView tvRegisterQQ;
    private TextView tvForgetPwd;
    private Button btnLogin;
    private EditText etQQName;
    private EditText etQQPwd;
    private CheckBox chkRememberPwd;
    @Override
    protected void onCreate(Bundle savedInstanceState) { // 重写 onCreate() 方法
        super.onCreate(savedInstanceState); // 调用父类的 onCreate() 方法
        setContentView(R.layout.activity_login); // 设置布局文件
        etQQName=(EditText) findViewById(R.id.etQQName);
        etQQPwd= (EditText) findViewById(R.id.etQQPwd);
        chkRememberPwd=(CheckBox)findViewById(R.id.chkRememberPwd);

        btnLogin = (Button) findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyDbHelper helper = new MyDbHelper(getApplicationContext(),
                        DB_Params.DB_NAME,null, DB_Params.DB_VER);
                SQLiteDatabase db = helper.getReadableDatabase();
                String sql = "select * from QQ_Login where qq_num=? and qq_pwd=?";
                Cursor cursor = db.rawQuery(sql, new String[]{etQQName.getText().toString().trim(),etQQPwd.getText().toString().trim()});
                if (cursor.moveToNext()){
                    MainActivity.loginedUser = new QQContactBean(
                            cursor.getString(cursor.getColumnIndex("qq_num")),
                            cursor.getString(cursor.getColumnIndex("qq_name")),
                            cursor.getInt (cursor.getColumnIndex("qq_img")),
                            cursor.getString(cursor.getColumnIndex("qq_online")),
                            cursor.getString(cursor.getColumnIndex("qq_action")),
                            cursor.getString(cursor.getColumnIndex("belong_country")));

                if(chkRememberPwd.isChecked()){
                    SharedPreferences settings=getSharedPreferences(
                            "setting",MODE_PRIVATE);
                    SharedPreferences.Editor editor=settings.edit();
                    editor.putString("qqnum",etQQName.getText().toString());
                    editor.putString("pwd",etQQPwd.getText().toString());
                    editor.commit();

                }
                Intent intent = new Intent(LoginActivity.this,MainActivity.class);
                startActivity(intent); }
                else{
                    Toast.makeText(getApplicationContext(),"用户名或密码错误",Toast.LENGTH_LONG).show();
                }
            }

        });

        // 获取忘记密码文本框
        TextView tvForgetPwd = (TextView) findViewById(R.id.tvForgetPwd);

        // 设置忘记密码文本框的点击事件
        tvForgetPwd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { // 忘记密码文本框被点击时
                // 创建一个 Intent 对象，跳转到忘记密码活动
                Intent intent = new Intent(LoginActivity.this, ForgetPwdActivity.class);

                // 启动忘记密码活动
                startActivity(intent);
            }
        });

        // 获取 QQ 注册文本框
        TextView tvRegisterQQ = (TextView) findViewById(R.id.tvRegistQQ);

        // 设置 QQ 注册文本框的点击事件
        tvRegisterQQ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { // QQ 注册文本框被点击时
                // 创建一个 Intent 对象，跳转到 QQ 注册活动
                Intent intent = new Intent(LoginActivity.this, RegisterQQ.class);

                // 启动 QQ 注册活动
                startActivity(intent);
            }
        });
        SharedPreferences settings = getSharedPreferences ("setting", MODE_PRIVATE);
        etQQName.setText(settings.getString("qqnum",""));
        etQQPwd.setText(settings.getString("pwd",""));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_login,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        switch (item.getItemId()){
            case R.id.menuitem_About:
                builder.setTitle(R.string.dialog_about_title)
                        .setIcon(R.mipmap.ic_launcher)
                        .setMessage(R.string.dialog_about_message)
                        .setPositiveButton(R.string.dialog_btn_ok,null).show();
               break;
            case R.id.menuite_Exit:
                builder.setTitle(R.string.dialog_exit_title)
                        .setIcon(R.mipmap.ic_launcher)
                        .setMessage(R.string.dialog_exit_message)
                        .setPositiveButton(R.string.dialog_btn_yes,
                                new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        System.exit(0);
                                    }
                                })
                                .setNegativeButton(R.string.dialog_btn_no,null).show();
                break;
        }
        return true;
    }
}