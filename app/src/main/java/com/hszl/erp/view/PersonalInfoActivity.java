package com.hszl.erp.view;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.hszl.erp.R;
import com.hszl.erp.base.BaseMvpActivity;
import com.hszl.erp.contract.PersonalInfoContract;
import com.hszl.erp.present.PersonalInfoPresent;
import com.hszl.erp.utils.ImmersionUtils;

public class PersonalInfoActivity extends BaseMvpActivity<PersonalInfoPresent,PersonalInfoContract.IPersonalInfoView> implements
        PersonalInfoContract.IPersonalInfoView {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        ImmersionUtils.setTrans(this);
        super.onCreate(savedInstanceState);
        initLayout(R.layout.activity_personal_info);
    }

    @Override
    protected PersonalInfoPresent createPresent() {
        return new PersonalInfoPresent();
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
