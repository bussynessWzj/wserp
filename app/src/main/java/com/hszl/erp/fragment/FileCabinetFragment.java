package com.hszl.erp.fragment;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.hszl.erp.R;
import com.hszl.erp.adapter.TabLayoutAdapter;
import com.hszl.erp.base.MVPBaseFragment;
import com.hszl.erp.contract.FileCabinetContract;
import com.hszl.erp.present.FileCabinetPresent;

import java.util.ArrayList;
import java.util.List;

public class FileCabinetFragment extends MVPBaseFragment<FileCabinetPresent,FileCabinetContract.IFileCabinetView>
        implements FileCabinetContract.IFileCabinetView,SwipeRefreshLayout.OnRefreshListener {

    TabLayout tlInfo;
    ViewPager vpInfo;
    TabLayoutAdapter adapter;
    CommonalityFragment commonalityFragment;
    PersonalFragment personalFragment;
    List<Fragment> list=new ArrayList<>();

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {
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
        tlInfo=view.findViewById(R.id.tlInfo);
        vpInfo=view.findViewById(R.id.vpInfo);
        adapter=new TabLayoutAdapter(this.getChildFragmentManager(),list,new String[]{"公共","个人"});
        vpInfo.setAdapter(adapter);
        tlInfo.setupWithViewPager(vpInfo);
        tlInfo.getTabAt(0).select();
    }

    @Override
    protected FileCabinetPresent creatPresent(MVPBaseFragment<FileCabinetPresent, FileCabinetContract.IFileCabinetView> fileCabinetPresentIFileCabinetViewMVPBaseFragment) {
        return new FileCabinetPresent();
    }

    @Override
    protected View initLayout(LayoutInflater inflater, ViewGroup container) {
        View view=inflater.inflate(R.layout.frg_file_cabinet,container,false);
        initFragment();
        return view;
    }

    private void initFragment() {
        commonalityFragment=new CommonalityFragment();
        personalFragment=new PersonalFragment();
        list.add(commonalityFragment);
        list.add(personalFragment);
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

    public static FileCabinetFragment newInstance()
    {
        FileCabinetFragment fileCabinetFragment=new FileCabinetFragment();
        return fileCabinetFragment;
    }
}
