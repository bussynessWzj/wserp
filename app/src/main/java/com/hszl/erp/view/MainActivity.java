package com.hszl.erp.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.RadioGroup;

import com.hszl.erp.R;
import com.hszl.erp.base.BaseActivity1;
import com.hszl.erp.base.BaseMvpActivity;
import com.hszl.erp.contract.MainContract;
import com.hszl.erp.present.MainPresent;
import com.hszl.erp.ui.MyRadioButton;
import com.hszl.erp.utils.ImmersionUtils;

public class MainActivity extends BaseMvpActivity<MainPresent,MainContract.IMainView> implements
        RadioGroup.OnCheckedChangeListener,MainContract.IMainView {

    FrameLayout flFragment;
    RadioGroup rg;
    //    MyRadioButton rbHome,rbMessage,rbFile,rbMy;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        ImmersionUtils.setTrans(this);
        super.onCreate(savedInstanceState);
        initLayout(R.layout.act_main);
        ImmersionUtils.immersionTop(this, rlTop);
        initview();
        initFragment(savedInstanceState);
        rg.check(R.id.rbHome);
    }

    @Override
    public FragmentManager getFM() {
        return this.getSupportFragmentManager();
    }

    protected void initFragment(Bundle savedInstanceState) {
        mPresent.restoreFragment(savedInstanceState);
    }


    protected void initview() {
        flFragment=findViewById(R.id.flFragment);
        rg = findViewById(R.id.rg);
        rg.setOnCheckedChangeListener(this);
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
                mPresent.changeFragment(R.id.rbHome);
                break;
            case R.id.rbMessage:
                break;
            case R.id.rbFile:
                mPresent.changeFragment(R.id.rbFile);
                break;
            case R.id.rbMy:
                mPresent.changeFragment(R.id.rbMy);
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
        mPresent.getMessage();
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
