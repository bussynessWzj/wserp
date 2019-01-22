package com.hszl.erp.fragment;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.hszl.erp.R;
import com.hszl.erp.base.MVPBaseFragment;
import com.hszl.erp.contract.FileCabinetContract;
import com.hszl.erp.present.FileCabinetPresent;

public class FileCabinetFragment extends MVPBaseFragment<FileCabinetPresent,FileCabinetContract.IFileCabinetView>
        implements FileCabinetContract.IFileCabinetView,SwipeRefreshLayout.OnRefreshListener {

    SwipeRefreshLayout srl;
    RecyclerView rvInfo;
    EditText etSearch;
    LinearLayoutManager linearLayoutManager;

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
        Toast.makeText(getActivity(),"网络出错",Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void initData() {
        //首先清空数据源在调用接口
        getData();
    }

    @Override
    protected void initView(View view) {
        srl=view.findViewById(R.id.srl);
        rvInfo=view.findViewById(R.id.rvInfo);
        etSearch=view.findViewById(R.id.etSearch);
        srl.setColorSchemeColors(getResources().getColor(R.color.colorAccent));
        srl.setOnRefreshListener(this);
        linearLayoutManager=new LinearLayoutManager(getActivity());

    }

    @Override
    protected FileCabinetPresent creatPresent(MVPBaseFragment<FileCabinetPresent, FileCabinetContract.IFileCabinetView> fileCabinetPresentIFileCabinetViewMVPBaseFragment) {
        return new FileCabinetPresent();
    }

    @Override
    protected View initLayout(LayoutInflater inflater, ViewGroup container) {
        View view=inflater.inflate(R.layout.frg_file_cabinet,container,false);
        return view;
    }

    @Override
    public void getData() {
        mPresent.getData();
    }

    @Override
    public void onRefresh() {
        //首先清空数据源
        mPresent.getData();
    }
}
