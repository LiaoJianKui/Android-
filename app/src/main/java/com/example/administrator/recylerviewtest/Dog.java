package com.example.administrator.recylerviewtest;

/**
 * Created by Administrator on 2017/2/20.
 */

public class Dog {
    private String name;
    private int dogImg;
    Dog(String name,int dogImg){
        this.name=name;
        this.dogImg=dogImg;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDogImg() {
        return dogImg;
    }

    public void setDogImg(int dogImg) {
        this.dogImg = dogImg;
    }
}
