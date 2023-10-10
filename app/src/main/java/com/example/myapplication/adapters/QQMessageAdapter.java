package com.example.myapplication.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myapplication.R;
import com.example.myapplication.beans.QQMessageBean;

import java.util.List;

public class QQMessageAdapter extends BaseAdapter {

    private List<QQMessageBean> data;
    private Context context;
    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position) ;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public QQMessageAdapter(List<QQMessageBean> data, Context context) {
        this.data = data;
        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(
                    R.layout.item_qqmessage, parent, false);
            holder=new ViewHolder();
            holder.qqicon= (ImageView)
                    convertView.findViewById(R.id.imgIcon);
            holder.qqname = (TextView)
                    convertView.findViewById(R.id.tvName);
            holder.lasttitle = (TextView)
                    convertView.findViewById(R.id.tv_OnlineMode);
            holder.lastmsgtime = (TextView)
                    convertView.findViewById(R.id.tv_lastmsgtime);
           holder.notreadmsgcount = (TextView)
                    convertView.findViewById(R.id.tv_Action);
           convertView.setTag(holder);
        }else {
            holder=(ViewHolder) convertView.getTag();
        }
            QQMessageBean msg = data.get(position);
            holder.qqicon.setImageResource(msg.getQq_icon());
            holder.qqname.setText(msg.getQq_name());
            holder.lasttitle.setText(msg.getLasttitle());
            holder.lastmsgtime.setText(msg.getLastmag_time());
            holder.notreadmsgcount.setText(msg.getNotreadmsg_count() + "");

        return convertView;
    }
    static class ViewHolder{
        ImageView qqicon;
        TextView qqname;
        TextView lasttitle;
        TextView lastmsgtime;
        TextView notreadmsgcount;
    }
}
