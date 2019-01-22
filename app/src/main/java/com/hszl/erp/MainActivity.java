package com.hszl.erp;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.widget.TextView;

import com.google.gson.Gson;
import com.hszl.erp.entity.User;
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

public class MainActivity extends AppCompatActivity {

    private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    mTextMessage.setText(R.string.title_home);
                    item.setIcon(R.drawable.home);
                    return true;
                case R.id.navigation_dashboard:
                    mTextMessage.setText(R.string.title_dashboard);
                    item.setIcon(R.drawable.file);
                    return true;
                case R.id.navigation_notifications:
                    mTextMessage.setText(R.string.title_notifications);
                    item.setIcon(R.drawable.my);
                    return true;
            }
            return false;
        }
    };


//    String str="{\"success\":1,\"msg\":\"登录成功\",\"id\":\"ae05743e-a038-4356-8d9b-efdaf71ec78c\",\"img\":\"/Files/PhotoFile/ae05743e-a038-4356-8d9b-efdaf71ec78c.jpg\",\"birthday\":\"1987-03-16\",\"username\":\"超级管理员\",\"mobilephone\":\"18988888888\"}";
    TabLayout tabWork;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tabWork=findViewById(R.id.tabWork);
        tabWork.addTab(tabWork.newTab().setText("已办"));
        tabWork.addTab(tabWork.newTab().setText("待办"));
        tabWork.addTab(tabWork.newTab().setText("委托"));
//        Gson gson=new Gson();
//        User user=gson.fromJson(str,User.class);
//        Log.e("user",user.toString());
//        mTextMessage = (TextView) findViewById(R.id.message);
//        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
//        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
//        getBreakage(10,1,"");
    }


    public void  getBreakage(int pageSize, int pageNum, String keyValue)
    {
        Map<String,Object> map=new HashMap<>();
        map.put("UserName","admin");
        map.put("UserPwd","1");
        String json=DataUtils.toJson(map);
        HttpInterface service=Constant.retrofit.create(HttpInterface.class);
        RequestBody body=RequestBody.create(MediaType.parse("application/json; charset=utf-8"),json);
        Call<User> call=service.login(body);
        call.enqueue(new Callback<User>()
        {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                Log.e("usersuccess","成功了");
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Log.e("userfailed",t.toString());
            }
        });
    }

}
