package com.hszl.erp.model;

import com.hszl.erp.contract.HomeContract;
import com.hszl.erp.http.BaseCallback;

public class HomeModel implements HomeContract.IHomeModel {

    HomeCallBack homeCallBack;

    public void setHomeCallBack(HomeCallBack homeCallBack) {
        this.homeCallBack = homeCallBack;
    }

    @Override
    public void getData() {

    }

    public interface HomeCallBack extends BaseCallback
    {
        void getDataSuccess();
        void getDataFailed();
    }
}
