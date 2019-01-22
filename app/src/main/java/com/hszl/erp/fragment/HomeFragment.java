package com.hszl.erp.fragment;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;


import com.hszl.erp.R;
import com.hszl.erp.adapter.HomeAdapter;
import com.hszl.erp.base.MVPBaseFragment;
import com.hszl.erp.contract.HomeContract;
import com.hszl.erp.entity.Home;
import com.hszl.erp.present.HomePresent;
import com.hszl.erp.view.WorkFlowActivity;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends MVPBaseFragment<HomePresent,HomeContract.IHomeView> implements HomeContract.IHomeView,View.OnClickListener {

    LinearLayout llWaitWork,llDoneWork,llDelegateWork,llCreateWork;
    TextView tvWaitWork,tvDoneWork,tvDelegateWork;
    RecyclerView rvInfo;
    GridLayoutManager gridLayoutManager;
    HomeAdapter adapter;
    List<Home> list=new ArrayList<>();

    @Override
    protected View initLayout(LayoutInflater inflater, ViewGroup container) {
        return inflater.inflate(R.layout.frg_home,container,false);
    }


    @Override
    protected void initData() {
        mPresent.getData();
    }

    @Override
    protected void initView(View view) {
        llWaitWork=view.findViewById(R.id.llWaitWork);
        llDoneWork=view.findViewById(R.id.llDoneWork);
        llDelegateWork=view.findViewById(R.id.llDelegateWork);
        llCreateWork=view.findViewById(R.id.llCreateWork);
        tvWaitWork=view.findViewById(R.id.tvWaitWork);
        tvDoneWork=view.findViewById(R.id.tvDoneWork);
        tvDelegateWork=view.findViewById(R.id.tvDelegateWork);
        rvInfo=view.findViewById(R.id.rvInfo);
        llWaitWork.setOnClickListener(this);
        llDoneWork.setOnClickListener(this);
        llDelegateWork.setOnClickListener(this);
        llCreateWork.setOnClickListener(this);
        gridLayoutManager=new GridLayoutManager(getActivity(),4);
        adapter=new HomeAdapter(R.layout.item_home,list);
        rvInfo.setLayoutManager(gridLayoutManager);
        rvInfo.setAdapter(adapter);
    }

    @Override
    protected HomePresent creatPresent(MVPBaseFragment mvpBaseFragment) {
        return new HomePresent();
    }

    @Override
    public void setWorkWait(String count) {
        tvWaitWork.setText(count);
    }

    @Override
    public String getWorkWait() {
        return tvWaitWork.getText().toString();
    }

    @Override
    public void setWorkDone(String count) {
        tvDoneWork.setText(count);
    }

    @Override
    public String getWorkDone() {
        return tvDoneWork.getText().toString();
    }

    @Override
    public void setDelegateWork(String count) {
        tvDelegateWork.setText(count);
    }

    @Override
    public String getDelegateWork() {
        return tvDelegateWork.getText().toString();
    }

    @Override
    public void notifyGridLayoutRefresh() {
        mPresent.notifyGridLayoutRefresh(adapter);
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

    @Override
    public void onClick(View v) {
        Intent intent=new Intent();
        switch (v.getId())
        {
            case R.id.llWaitWork:
                intent.putExtra("tag","wait");
                intent.setClass(getActivity(),WorkFlowActivity.class);
                getActivity().startActivity(intent);
                break;
            case R.id.llDoneWork:
                intent.putExtra("tag","done");
                intent.setClass(getActivity(),WorkFlowActivity.class);
                getActivity().startActivity(intent);
                break;
            case R.id.llDelegateWork:
                intent.putExtra("tag","delegate");
                intent.setClass(getActivity(),WorkFlowActivity.class);
                getActivity().startActivity(intent);
                break;
            case R.id.llCreateWork:
                break;
        }
    }
}
