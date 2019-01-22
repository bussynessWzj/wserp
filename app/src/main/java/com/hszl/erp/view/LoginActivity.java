package com.hszl.erp.view;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

import com.hszl.erp.R;
import com.hszl.erp.base.BaseActivity1;
import com.hszl.erp.base.BaseMvpActivity;
import com.hszl.erp.contract.LoginContract;
import com.hszl.erp.entity.User;
import com.hszl.erp.present.LoginPresent;
import com.hszl.erp.utils.ImmersionUtils;

public class LoginActivity extends BaseMvpActivity<LoginPresent,LoginContract.ILoginView> implements LoginContract.ILoginView,
        CompoundButton.OnCheckedChangeListener {

    EditText etUserName,etPwd;
    Button btnLogin;
    SwipeRefreshLayout srl;
    CheckBox cbRemenberPwd;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        ImmersionUtils.setTrans(this);
        super.onCreate(savedInstanceState);
        initLayout(R.layout.activity_login);
        ImmersionUtils.immersionTop(this,rlTop);
        initview();
        setTitle("登录");
        start();
    }

    public void start()
    {
        if (cbRemenberPwd.isChecked()) {
            if (mPresent.getUser() != null) {
                etPwd.setText(getPwdFromLocal());
            }
        }
    }


    protected void initview() {
        cbRemenberPwd=findViewById(R.id.cbRemenberPwd);
        etUserName=findViewById(R.id.etUserName);
        etPwd=findViewById(R.id.etPwd);
        btnLogin=findViewById(R.id.btnLogin);
        srl=findViewById(R.id.srl);
        srl.setColorSchemeColors(getResources().getColor(R.color.colorAccent));
        btnLogin.setOnClickListener(this);
        cbRemenberPwd.setOnCheckedChangeListener(this);
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId())
        {
            case R.id.btnLogin:
                login(getUserName(),getPwd());
                break;
        }
    }

    @Override
    protected LoginPresent createPresent() {
        return new LoginPresent();
    }

    @Override
    public void login(String username, String pwd) {
        mPresent.login(username,pwd);
    }

    @Override
    public String getUserName() {
        return etUserName.getText().toString();
    }

    @Override
    public void setUserName(String userName) {
        etUserName.setText(userName);
    }

    @Override
    public String getPwd() {
        return etPwd.getText().toString();
    }

    @Override
    public void setPwd(String pwd) {
        etPwd.setText(pwd);
    }

    @Override
    public void remenberPwd(User user) {
        mPresent.remenberPwd(user);
    }

    @Override
    public String getPwdFromLocal() {
        return mPresent.getUser().getPwd();
    }

    @Override
    public void showLoading() {
        srl.setRefreshing(true);
    }

    @Override
    public void hideLoading() {
        srl.setRefreshing(false);
    }

    @Override
    public void showError(String message) {
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if (isChecked)
            mPresent.remenberPwd(mPresent.getUser());
    }
}
