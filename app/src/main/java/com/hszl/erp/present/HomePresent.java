package com.hszl.erp.present;

import android.support.v4.app.Fragment;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.hszl.erp.base.BasePresent;
import com.hszl.erp.contract.HomeContract;
import com.hszl.erp.model.HomeModel;

public class HomePresent extends BasePresent<HomeContract.IHomeView> implements HomeContract.IHomePresent,HomeModel.HomeCallBack {

    HomeContract.IHomeModel homeModel;

    public HomePresent() {
        homeModel=new HomeModel();
        ((HomeModel) homeModel).setHomeCallBack(this);
    }

    @Override
    public void getData() {

    }


    @Override
    public void getDataSuccess() {
        getView().notifyGridLayoutRefresh();
    }

    @Override
    public void getDataFailed() {

    }

    @Override
    public void networkFailed() {

    }

    public void notifyGridLayoutRefresh(BaseQuickAdapter baseQuickAdapter)
    {

    }
}
