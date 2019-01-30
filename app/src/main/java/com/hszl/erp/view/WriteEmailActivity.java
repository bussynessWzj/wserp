package com.hszl.erp.view;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.hszl.erp.R;
import com.hszl.erp.base.BaseMvpActivity;
import com.hszl.erp.contract.WriteEmailContract;
import com.hszl.erp.present.WriteEmailPresent;
import com.hszl.erp.utils.ImmersionUtils;

public class WriteEmailActivity extends BaseMvpActivity<WriteEmailPresent,WriteEmailContract.IWriteEmailView> implements
        WriteEmailContract.IWriteEmailView {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        ImmersionUtils.setTrans(this);
        super.onCreate(savedInstanceState);
        initLayout(R.layout.activity_write_email);
    }

    @Override
    protected WriteEmailPresent createPresent() {
        return new WriteEmailPresent();
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
