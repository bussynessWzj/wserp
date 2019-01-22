package com.hszl.erp.view;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.hszl.erp.R;
import com.hszl.erp.base.BaseMvpActivity;
import com.hszl.erp.contract.SettingContract;
import com.hszl.erp.present.SettingPresent;
import com.hszl.erp.utils.ImmersionUtils;

public class SettingActivity extends BaseMvpActivity<SettingPresent,SettingContract.ISettingView> implements SettingContract.ISettingView {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        ImmersionUtils.setTrans(this);
        super.onCreate(savedInstanceState);
        initLayout(R.layout.activity_setting);
        ImmersionUtils.immersionTop(this,rlTop);
    }

    @Override
    protected SettingPresent createPresent() {
        return new SettingPresent();
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
