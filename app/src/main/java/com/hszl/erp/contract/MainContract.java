package com.hszl.erp.contract;

import com.hszl.erp.base.BaseView;
import com.hszl.erp.ui.MyRadioButton;

public class MainContract {


    public interface IMainPresent
    {
        void changeFragment();
        void getMessage();  //获取底部导航栏是否有未处理消息
    }

    public interface IMainView extends BaseView {
        void showRedCircle(MyRadioButton myRadioButton);
    }

    public interface IMainModel{
        void getMessage();
    }
}
