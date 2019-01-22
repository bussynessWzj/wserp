package com.hszl.erp.contract;


import com.hszl.erp.base.BaseView;
import com.hszl.erp.entity.User;

public class LoginContract {
    public interface ILoginPresent
    {
        void login(String username,String pwd);
        void remenberPwd(User user);
        User getUser();
    }

    public interface ILoginMode
    {
        void login(String username,String pwd);
    }

    public interface ILoginView extends BaseView
    {
        void login(String username,String pwd);
        String getUserName();
        void setUserName(String userName);
        String getPwd();
        void setPwd(String pwd);
        void remenberPwd(User user);
        String getPwdFromLocal();
    }
}
