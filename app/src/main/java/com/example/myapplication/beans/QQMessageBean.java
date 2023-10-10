package com.example.myapplication.beans;

public class QQMessageBean {
    private String qq_name;
    private int qq_icon;
    private String lastmsg_time;
    private String lasttitle;
    private int notreadmsg_count;

    public int getNotreamsg_count() {
        return notreadmsg_count;
    }

    public void setNotreamsg_count(int notreamsg_count) {
        this.notreadmsg_count = notreamsg_count;
    }

    public QQMessageBean(String qq_name, int qq_icon, String lastmsg_time, String lasttitle, int notreadmsg_count) {
        this.qq_name = qq_name;
        this.qq_icon = qq_icon;
        this.lastmsg_time = lastmsg_time;
        this.lasttitle = lasttitle;
        this.notreadmsg_count = notreadmsg_count;
    }

    public String getQq_name() {
        return qq_name;
    }

    public void setQq_name(String qq_name) {
        this.qq_name = qq_name;
    }

    public int getQq_icon() {
        return qq_icon;
    }

    public void setQq_icon(int qq_icon) {
        this.qq_icon = qq_icon;
    }

    public String getLastmag_time() {
        return lastmsg_time;
    }

    public void setLastmag_time(String lastmag_time) {
        this.lastmsg_time = lastmag_time;
    }

    public String getLasttitle() {
        return lasttitle;
    }

    public void setLasttitle(String lasttitle) {
        this.lasttitle = lasttitle;
    }

    public int getNotreadmsg_count() {
        return notreadmsg_count;
    }

    public void setNotreadmsg_count(int notreadmsg_count) {
        this.notreadmsg_count = notreadmsg_count;
    }


}
