package com.hszl.erp.fragment;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.hszl.erp.R;
import com.hszl.erp.adapter.CabinetAdapter;
import com.hszl.erp.entity.Cabinet;
import com.hszl.erp.present.CommonalityPresent;
import com.hszl.erp.base.MVPBaseFragment;
import com.hszl.erp.contract.CommonalityContract;

import java.util.ArrayList;
import java.util.List;

public class CommonalityFragment extends MVPBaseFragment<CommonalityPresent,CommonalityContract.ICommonalityView> implements
        CommonalityContract.ICommonalityView,BaseQuickAdapter.OnItemClickListener {

    RecyclerView rvInfo;
    CabinetAdapter adapter;
    SwipeRefreshLayout srl;    //该控件作加载等待标识控件使用，目前没有接口不确定是否列表是否支持刷新需要刷新功能添加该控件相应的监听就行
    List<Cabinet> list=new ArrayList<>();
    LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getActivity());
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
        Toast.makeText(getActivity(),message,Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView(View view) {
        rvInfo=view.findViewById(R.id.rvInfo);
        srl=view.findViewById(R.id.srl);
        srl.setColorSchemeColors(getResources().getColor(R.color.colorAccent));
        adapter=new CabinetAdapter(R.layout.item_cabinet,list);
        rvInfo.setLayoutManager(linearLayoutManager);
        rvInfo.setAdapter(adapter);
        adapter.setOnItemClickListener(this);
    }

    @Override
    protected CommonalityPresent creatPresent(MVPBaseFragment<CommonalityPresent, CommonalityContract.ICommonalityView> commonalityPresentICommonalityViewMVPBaseFragment) {
        return new CommonalityPresent();
    }

    @Override
    protected View initLayout(LayoutInflater inflater, ViewGroup container) {
        View view=inflater.inflate(R.layout.frg_cabinet,container,false);
        return view;
    }

    @Override
    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {

    }
}
