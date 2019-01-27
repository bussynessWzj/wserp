package com.hszl.erp.contract;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import com.hszl.erp.base.BaseView;
import com.hszl.erp.ui.MyRadioButton;

public class MainContract {


    public interface IMainPresent
    {
        void changeFragment(int resid);
        void getMessage();  //获取底部导航栏是否有未处理消息
        void restoreFragment(Bundle savedInstanceState);
    }

    public interface IMainView extends BaseView {
        void showRedCircle(MyRadioButton myRadioButton);
        FragmentManager getFM();
    }

    public interface IMainModel{
        void getMessage();
    }
}
