package com.hszl.erp.model;

import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import com.hszl.erp.contract.LoginContract;
import com.hszl.erp.entity.User;
import com.hszl.erp.http.BaseCallback;
import com.hszl.erp.http.HttpInterface;
import com.hszl.erp.utils.Constant;
import com.hszl.erp.utils.DataUtils;

import java.util.HashMap;
import java.util.Map;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginModel implements LoginContract.ILoginMode {

    CallBack callBack;

    public void setCallBack(CallBack callBack) {
        this.callBack = callBack;
    }

    @Override
    public void login(String username, String pwd) {
        Map<String,Object> map=new HashMap<>();
        map.put("UserName",username);
        map.put("UserPwd",pwd);
        String json=DataUtils.toJson(map);
        HttpInterface service=Constant.retrofit.create(HttpInterface.class);
        RequestBody body=RequestBody.create(MediaType.parse("application/json; charset=utf-8"),json);
        Call<User> call=service.login(body);
        call.enqueue(new Callback<User>()
        {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                User user=response.body();
                if (response.code()==200)
                {
                    callBack.loginSuccess(user);
                }else
                {
                    callBack.loginFailed();
                }
//                if (user!=null)
//                {
//                    if (user.getSuccess()==0)
//                    {
//                        Toast.makeText(LoginActivity.this,user.getMsg(),Toast.LENGTH_SHORT).show();
//                        return;
//                    }
//                    user.setLoginpwd(etPwd.getText().toString());
//                    SPUtils.saveUser(user);
//                    Intent intent=new Intent();
//                    //                    intent.setClass(LoginActivity.this,MainActivity1.class);
//                    intent.setClass(LoginActivity.this,MainActivity.class);
//                    LoginActivity.this.startActivity(intent);
//                    Log.e("user",user.getUsername());
//                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Log.e("user",t.toString());
                callBack.networkFailed();
            }
        });
    }




   public interface CallBack extends BaseCallback
    {
        void loginSuccess(User user);
        void loginFailed();
    }
}
