package com.hszl.erp.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;

import com.hszl.erp.R;
import com.hszl.erp.adapter.TabLayoutAdapter;
import com.hszl.erp.base.BaseMvpActivity;
import com.hszl.erp.contract.WorkFlowContract;
import com.hszl.erp.fragment.WorkDelegateFragment;
import com.hszl.erp.fragment.WorkDoneFragment;
import com.hszl.erp.fragment.WorkWaitFragment;
import com.hszl.erp.present.WorkFlowPresent;
import com.hszl.erp.utils.ImmersionUtils;

import java.util.ArrayList;
import java.util.List;


/**
 * 需要调试数据加载的数量不对
 */
public class WorkFlowActivity extends BaseMvpActivity<WorkFlowPresent,WorkFlowContract.IWorkFlowActivity> implements WorkFlowContract.IWorkFlowActivity {

    TabLayout tabWork;
    ViewPager vpInfo;
    TabLayoutAdapter adapter;
    List<Fragment> list=new ArrayList<>();
    WorkWaitFragment waitFragment;
    WorkDoneFragment doneFragment;
    WorkDelegateFragment delegateFragment;
    String tag;

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
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        ImmersionUtils.setTrans(this);
        super.onCreate(savedInstanceState);
        initLayout(R.layout.activity_workflow);
        ImmersionUtils.immersionTop(this,rlTop);
        showRightTv("+委托",getResources().getColor(R.color.login_setting));
        showLeftImg(R.drawable.back1);
        setTitle("工作流");
        initview();
        tag=getIntent().getStringExtra("tag");
        initFragment(savedInstanceState);
        bindViewPageAndTabLayout();
        tabSelect(tag);
    }

    private void tabSelect(String tag) {
        if (tag.equals("wait"))
        {
            tabWork.getTabAt(0).select();
        }else if (tag.equals("done"))
        {
            tabWork.getTabAt(1).select();
        }else if (tag.equals("delegate"))
        {
            tabWork.getTabAt(2).select();
        }
    }

    public void initFragment(Bundle savedInstanceState)
    {
        waitFragment=new WorkWaitFragment();
        doneFragment=new WorkDoneFragment();
        delegateFragment=new WorkDelegateFragment();
        list.add(waitFragment);
        list.add(doneFragment);
        list.add(delegateFragment);
        adapter.notifyDataSetChanged();
    }

    private void initview() {
        tabWork=findViewById(R.id.tabWork);
        vpInfo=findViewById(R.id.vpInfo);
        FragmentManager fragmentManager=this.getSupportFragmentManager();
        adapter=new TabLayoutAdapter(fragmentManager,list,new String[]{"待办","已办","委托"});
        vpInfo.setAdapter(adapter);
    }

    @Override
    protected WorkFlowPresent createPresent() {
        return new WorkFlowPresent();
    }

    protected void bindViewPageAndTabLayout()
    {
        tabWork.setupWithViewPager(vpInfo);
    }
}
