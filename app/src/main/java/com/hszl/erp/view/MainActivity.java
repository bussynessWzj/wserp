package com.hszl.erp.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;

import com.hszl.erp.R;
import com.hszl.erp.base.BaseActivity1;
import com.hszl.erp.base.BaseMvpActivity;
import com.hszl.erp.contract.MainContract;
import com.hszl.erp.present.MainPresent;
import com.hszl.erp.ui.MyRadioButton;
import com.hszl.erp.utils.ImmersionUtils;

public class MainActivity extends BaseMvpActivity<MainPresent,MainContract.IMainView> implements RadioGroup.OnCheckedChangeListener,MainContract.IMainView {

    RadioGroup rg;
    MainPresent present;
    Button btn;
    //    MyRadioButton rbHome,rbMessage,rbFile,rbMy;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        ImmersionUtils.setTrans(this);
        super.onCreate(savedInstanceState);
        initLayout(R.layout.act_main);
        ImmersionUtils.immersionTop(this, rlTop);
        initview();
//        present =  mPresent;
    }

    protected void initview() {
        rg = findViewById(R.id.rg);
        btn=findViewById(R.id.btn);
        rg.setOnCheckedChangeListener(this);
        btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        click();
    }

    @Override
    protected MainPresent createPresent() {
        return new MainPresent();
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        int checkid = group.getCheckedRadioButtonId();
        switch (checkid) {
            case R.id.rbHome:
                present.changeFragment();
                break;
            case R.id.rbMessage:
                break;
            case R.id.rbFile:
                break;
            case R.id.rbMy:
                break;
        }
    }

    @Override
    public void showRedCircle(MyRadioButton myRadioButton) {
        myRadioButton.setShow(true);
    }

    /*******************以下代码为模拟测试当首页收到消息之后或者请求消息的接口之后拿到数据是否显示红点********************************/

    /**
     * 触发获取是否有未处理消息的接口
     */
    public void click()
    {
        present.getMessage();
    }

    public RadioGroup getRg()
    {
        return rg;
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showError(String message) {

    }
}
