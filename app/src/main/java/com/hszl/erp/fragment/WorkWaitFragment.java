package com.hszl.erp.fragment;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.hszl.erp.R;
import com.hszl.erp.adapter.WorkAdapter;
import com.hszl.erp.base.MVPBaseFragment;
import com.hszl.erp.contract.WorkConstract;
import com.hszl.erp.entity.Work;
import com.hszl.erp.present.WorkPresent;

import java.util.ArrayList;
import java.util.List;

public class WorkWaitFragment extends MVPBaseFragment<WorkPresent,WorkConstract.IWorkView> implements WorkConstract.IWorkView,
        SwipeRefreshLayout.OnRefreshListener {
    SwipeRefreshLayout srl;
    RecyclerView rvInfo;
    EditText etSearch;
    WorkAdapter adapter;
    List<Work> list=new ArrayList<>();
    LinearLayoutManager linearLayoutManager;

    @Override
    protected void initData() {
        list.clear();
        mPresent.getData();//调用接口
    }

    @Override
    protected void initView(View view) {
        srl=view.findViewById(R.id.srl);
        rvInfo=view.findViewById(R.id.rvInfo);
        etSearch=view.findViewById(R.id.etSearch);
        adapter=new WorkAdapter(R.layout.item_work,list);
        linearLayoutManager=new LinearLayoutManager(getActivity());
        rvInfo.setLayoutManager(linearLayoutManager);
        rvInfo.setAdapter(adapter);
        srl.setColorSchemeColors(getResources().getColor(R.color.colorAccent));
        srl.setOnRefreshListener(this);
    }

    @Override
    protected WorkPresent creatPresent(MVPBaseFragment<WorkPresent, WorkConstract.IWorkView> workPresentIWorkViewMVPBaseFragment) {
        return new WorkPresent();
    }

//    @Override
//    protected WorkWaitPresent creatPresent(MVPBaseFragment<WorkWaitPresent, WorkWaitContract.IWorkWaitView> workWaitPresentIWorkWaitViewMVPBaseFragment) {
//        return new WorkWaitPresent();
//    }

    @Override
    protected View initLayout(LayoutInflater inflater, ViewGroup container) {
        View view=inflater.inflate(R.layout.frg_work,container,false);
        return view;
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
    public void getData() {
        mPresent.getData();
    }

    @Override
    public String getSearch() {
        return etSearch.getText().toString();
    }

    @Override
    public void setSearch(String str) {
        etSearch.setText(str);
    }

    @Override
    public void onRefresh() {
        list.clear();
        mPresent.getData();
    }

    public BaseQuickAdapter getAdapter()
    {
        return  adapter;
    }
}
