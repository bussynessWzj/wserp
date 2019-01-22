package com.hszl.erp.present;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.widget.RadioGroup;

import com.hszl.erp.base.BasePresent;
import com.hszl.erp.contract.MainContract;
import com.hszl.erp.model.MainModel;
import com.hszl.erp.ui.MyRadioButton;
import com.hszl.erp.view.MainActivity;

public class MainPresent extends BasePresent<MainContract.IMainView> implements MainContract.IMainPresent,MainModel.MainCallBack {

    MainContract.IMainModel model;

    public MainPresent() {
        model=new MainModel();
        ((MainModel) model).setCallBack(this);
    }

    @Override
    public void changeFragment() {

    }


    public void getMessage() {
        model.getMessage();
    }

    /**
     * 展示group中的哪个button需要小红点
     * @param group
     */
    public void hasNotDone(RadioGroup group)
    {
        //根据消息来判断获取radiogroup第几个
        MyRadioButton myRadioButton = (MyRadioButton) group.getChildAt(0);
        ((MainActivity)getView()).showRedCircle(myRadioButton);
    }

    @Override
    public void getMessageSuccess() {
        ((MainActivity)getView()).runOnUiThread(new Runnable() {
            @Override
            public void run() {
                hasNotDone(((MainActivity)getView()).getRg());
            }
        });
    }
}
