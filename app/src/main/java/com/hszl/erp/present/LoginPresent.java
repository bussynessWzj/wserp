package com.hszl.erp.present;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;

import com.hszl.erp.base.BasePresent;
import com.hszl.erp.contract.LoginContract;
import com.hszl.erp.entity.User;
import com.hszl.erp.model.LoginModel;
import com.hszl.erp.utils.SPUtils;
import com.hszl.erp.view.LoginActivity;

public class LoginPresent extends BasePresent<LoginContract.ILoginView> implements LoginContract.ILoginPresent,LoginModel.CallBack {

    LoginContract.ILoginMode iLoginMode;
    public LoginPresent() {
        iLoginMode=new LoginModel();
        ((LoginModel) iLoginMode).setCallBack(this);
    }

    @Override
    public User getUser() {
       return SPUtils.getUser();
    }

    @Override
    public void remenberPwd(User user) {
        if (!SPUtils.saveUser(user))
        {
            ((LoginActivity)getView()).showError("保存用户失败");
        }
    }

    @Override
    public void login(String username, String pwd) {
        ((LoginActivity)getView()).showLoading();
        iLoginMode.login(username,pwd);
    }

    @Override
    public void loginSuccess(User user) {
        SPUtils.saveUser(user);
        ((LoginActivity)getView()).hideLoading();
    }

    @Override
    public void loginFailed() {

    }

    @Override
    public void networkFailed() {

    }
}
