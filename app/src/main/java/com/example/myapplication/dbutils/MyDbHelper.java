package com.example.myapplication.dbutils;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.myapplication.R;

public class MyDbHelper extends SQLiteOpenHelper {
    public MyDbHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql="CREATE TABLE [QQ_Login]("+
                "[qq_num] VARCHAR(20) PRIMARY KEY NOT NULL,"+
                "[qq_name] VARCHAR NOT NULL,"+
                "[qq_pwd] VARCHAR NOT NULL," +
                "[qq_img] INT,"+
                "[qq_online] VARCHAR,[qq_action] VARCHAR,"+
                "[belong_country] VARCHAR);";
        db.execSQL(sql);
        initData(db);
    }

    private void initData(SQLiteDatabase db) {
        String countries[] = new String[]{"蜀","魏","吴"};
        String nums[][] = new String[][]{
                {"1001","1002","1003","1004","1005","1006"},
                {"2001","2002","2003"}, {"3001", "3002","3003"}
        };
        String names[][] = new String[][]{
                {"刘备","关羽","张飞","赵云","黄忠","魏延"},
                {"曹操","许褚","张辽"},{"孙权", "鲁肃","吕蒙"}
        };
        int icons[][]=new int[][]{
                {R.drawable.liubei,R.drawable.guanyu,R.drawable.zhangfei,
                        R.drawable.zhaoyun,R.drawable.huangzhong,R.drawable.weiyan},
                {R.drawable.caocao,R.drawable.xuchu,R.drawable.zhangliao},{R.drawable.sunquan,R.drawable.lusu,R.drawable.lvmeng}
        };
        String sql="insert into QQ_Login(qq_num,qq_name,qq_pwd,qq_img," +
                "qq_online,qq_action,belong_country) "+"values(?,?,?,?,?,?,?)";
        for(int i=0;i<countries.length;i++){
            for(int j=0;j<names[i].length;j++){
                db.execSQL(sql,new Object[]{nums[i][j],names[i][j],
                        "123456",icons[i][j],"4G在线",
                        "天天向上",countries[i]});
                }}
            }
            @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
