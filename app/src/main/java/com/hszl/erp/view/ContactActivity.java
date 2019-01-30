package com.hszl.erp.view;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.hszl.erp.R;
import com.hszl.erp.base.BaseMvpActivity;
import com.hszl.erp.contract.ContactContract;
import com.hszl.erp.present.ContactPresent;
import com.hszl.erp.utils.ImmersionUtils;

public class ContactActivity extends BaseMvpActivity<ContactPresent,ContactContract.IContactView> implements
        ContactContract.IContactView{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        ImmersionUtils.setTrans(this);
        super.onCreate(savedInstanceState);
        initLayout(R.layout.activity_contact);
        ImmersionUtils.immersionTop(this,rlTop);
        setTitle("联系方式");
        showRightTv("保存",getResources().getColor(R.color.main_checked));
        showLeftImg(R.drawable.back1);
    }

    @Override
    protected ContactPresent createPresent() {
        return new ContactPresent();
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
