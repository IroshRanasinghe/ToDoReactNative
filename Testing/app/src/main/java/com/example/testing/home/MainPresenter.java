package com.example.testing.home;

import android.widget.TextView;

public class MainPresenter {

    private MyView myView;
    private TextView textView;

    public MainPresenter(MyView myView, TextView textView) {
        this.myView = myView;
        this.textView = textView;
    }

    public void startSpalsh() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i =60; i>=0;i--){
                    try{
                        Thread.sleep(1000);
                       myView.showToast(i+" s");
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }
}
