package com.example.myapplication.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myapplication.R;
import com.example.myapplication.beans.QQContactBean;

import java.util.List;
import java.util.Map;

public class QQContactAdapter extends BaseExpandableListAdapter {
    private List<String>groupdata;
    private Map<String,List<QQContactBean>>childdata;
    private Context context;


    @Override
    public int getGroupCount() {
        return groupdata.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return childdata.get (groupdata.get (groupPosition)) .size ();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return childdata.get (groupdata.get (groupPosition));
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return childdata.get (groupdata.get (groupPosition)) .get (childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded,View
            convertView, ViewGroup parent) {
    GroupHolder holder;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_contact_group, parent, false);
            holder = new GroupHolder();
            holder.tv_grouptitle = (TextView)
                    convertView.findViewById(R.id.tv_grouptitle);
            holder.tv_groupcount = (TextView)
                    convertView.findViewById(R.id.tv_groupcount);
            convertView.setTag(holder);
        } else {
            holder = (GroupHolder) convertView.getTag();
        }
        holder.tv_grouptitle.setText (groupdata.get (groupPosition));
        holder.tv_groupcount.setText(childdata.get(groupdata.get (groupPosition)) . size ()+"");
        return convertView;

    }

    @Override
    public View getChildView(int groupPosition, int childPosition ,boolean isLastChild, View convertview, ViewGroup parent)  {
        ChildHolder holder;if (convertview == null){
            convertview= LayoutInflater.from(context).inflate(
                    R.layout.item_contact_child, parent, false);
            holder=new ChildHolder();
            holder.imgIcon= (ImageView) convertview.findViewById(R.id.imgIcon);
            holder.tvName=(TextView) convertview.findViewById(R.id.tvName);
            holder.tvOnlineMode=(TextView) convertview.findViewById(R.id.tv_OnlineMode);
            holder.tvAction=(TextView) convertview.findViewById(R.id.tv_Action);
            convertview.setTag(holder);
        }else{
            holder= (ChildHolder) convertview.getTag();
        }
        QQContactBean contactBean= childdata.get (groupdata.get (groupPosition)) .get (childPosition);
        holder.imgIcon.setImageResource(contactBean.getImg());
        holder.tvName.setText(contactBean.getName());
        holder.tvOnlineMode.setText("[" + contactBean.getOnlinemode() +"] ");
        holder.tvAction.setText (contactBean.getNewacton());
        return convertview;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {

        return true;
    }
    static class GroupHolder{
        TextView tv_grouptitle;
        TextView tv_groupcount;
    }
    static class ChildHolder{
        ImageView imgIcon;
        TextView tvName;
        TextView tvOnlineMode;
        TextView tvAction;
    }
    public QQContactAdapter(List<String> groupdata,Map<String,List<QQContactBean>> childdata,Context context){
        this.groupdata=groupdata;
        this.childdata=childdata;
        this.context=context;
    }
}
