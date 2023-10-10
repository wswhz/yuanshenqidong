package com.example.myapplication.fragments;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;

import com.example.myapplication.R;
import com.example.myapplication.adapters.QQMessageAdapter;
import com.example.myapplication.beans.QQMessageBean;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class QQMessageFragment extends Fragment {
    private ListView lvMessage;
    private List<QQMessageBean> lvData;
    @Nullable
    @org.jetbrains.annotations.Nullable
    @Override
    public View onCreateView(@NonNull @org.jetbrains.annotations.NotNull LayoutInflater inflater, @Nullable @org.jetbrains.annotations.Nullable ViewGroup container, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.activity_qqmessage,container,false);
        lvMessage=view.findViewById(R.id.lvmessage);
        lvData=getMessageList();
        QQMessageAdapter adapter=new QQMessageAdapter(lvData,this.getContext());
        lvMessage.setAdapter(adapter);
        registerForContextMenu(lvMessage);
        return view;
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

    @Override
    public void onCreateContextMenu(@NonNull @NotNull ContextMenu menu, @NonNull @NotNull View v, @Nullable @org.jetbrains.annotations.Nullable ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getActivity().getMenuInflater ().inflate(R.menu.menu_message,menu);
    }
    @Override
    public boolean onContextItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.menuitem_gotop:
                goTop(item);
                break;
            case R.id.menuitem_deletemsg:
                deleteMsg(item);
                break;
        }
        return super.onContextItemSelected(item);
    }

    private void deleteMsg(MenuItem item) {
        ContextMenu.ContextMenuInfo info = item.getMenuInfo();
        AdapterView.AdapterContextMenuInfo contextMenuInfo=
                (AdapterView.AdapterContextMenuInfo) info;
        int position = contextMenuInfo.position;
        String qname = lvData.get (position).getQq_name();
        Toast.makeText(getContext(),item.getTitle() +" "+
                qname,Toast.LENGTH_SHORT).show();
    }

    private void goTop(MenuItem item) {
        ContextMenu.ContextMenuInfo info=item.getMenuInfo();
        AdapterView.AdapterContextMenuInfo contextMenuInfo=
                (AdapterView.AdapterContextMenuInfo) info;
        int position = contextMenuInfo.position;
        String qname =lvData.get (position) .getQq_name();
        Toast.makeText(getContext(),item.getTitle() +" "+qname,Toast.LENGTH_SHORT).show();
    }
}
