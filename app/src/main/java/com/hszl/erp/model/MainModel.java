package com.hszl.erp.model;

import com.hszl.erp.contract.MainContract;

public class MainModel implements MainContract.IMainModel {

    MainCallBack callBack;

    public void setCallBack(MainCallBack callBack) {
        this.callBack = callBack;
    }

    @Override
    public void getMessage() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(6000);
                    callBack.getMessageSuccess();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    public interface MainCallBack{
        void getMessageSuccess();
    }
}
