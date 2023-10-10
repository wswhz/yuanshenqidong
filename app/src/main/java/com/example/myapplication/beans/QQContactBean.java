package com.example.myapplication.beans;

public class QQContactBean {
    private String name;
    private  int  img;
    private String  onlinemode;
    private  String newacton;
    private String num;
    private String belong_country;


    public QQContactBean(String num,  String name ,int img, String onlinemode,String newacton, String belong_country) {
        this.name = name;
        this.img = img;
        this.onlinemode = onlinemode;
        this.newacton = newacton;
        this.num = num;
        this.belong_country = belong_country;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getBelong_country() {
        return belong_country;
    }

    public void setBelong_country(String belong_country) {
        this.belong_country = belong_country;
    }

    public QQContactBean(String name, int img, String onlinemode, String newacton) {
        this.name = name;
        this.img = img;
        this.onlinemode = onlinemode;
        this.newacton = newacton;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getOnlinemode() {
        return onlinemode;
    }

    public void setOnlinemode(String onlinemode) {
        this.onlinemode = onlinemode;
    }

    public String getNewacton() {
        return newacton;
    }

    public void setNewacton(String newacton) {
        this.newacton = newacton;
    }
}
