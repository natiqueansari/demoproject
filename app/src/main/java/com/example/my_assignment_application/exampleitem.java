package com.example.my_assignment_application;

public class exampleitem {
    private int mImageResource;
    private  String mtext1;
    private String mtext2;
    public exampleitem(int imageresource,String text1,String text2){
        mImageResource=imageresource;
        mtext1=text1;
        mtext2=text2;
    }
    public int getImageResource(){
        return mImageResource;
    }

    public String getMtext1() {
        return mtext1;
    }

    public String getMtext2() {
        return mtext2;
    }
}
