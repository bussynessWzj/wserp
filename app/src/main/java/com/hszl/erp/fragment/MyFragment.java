package com.hszl.erp.fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hszl.erp.R;
import com.hszl.erp.base.MVPBaseFragment;
import com.hszl.erp.contract.MyContract;
import com.hszl.erp.present.MyPresent;

public class MyFragment extends MVPBaseFragment<MyPresent,MyContract.IMyView> implements
        MyContract.IMyView {
    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showError(String message) {

    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView(View view) {

    }

    @Override
    protected MyPresent creatPresent(MVPBaseFragment<MyPresent, MyContract.IMyView> myPresentIMyViewMVPBaseFragment) {
        return new MyPresent();
    }

    @Override
    protected View initLayout(LayoutInflater inflater, ViewGroup container) {
        View view=inflater.inflate(R.layout.frg_my,container,false);
        return view;
    }

    public static MyFragment newInstance()
    {
        MyFragment myFragment=new MyFragment();
        return myFragment;
    }
}
