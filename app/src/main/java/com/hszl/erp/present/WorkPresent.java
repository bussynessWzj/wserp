package com.hszl.erp.present;

import android.support.v4.app.Fragment;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.hszl.erp.base.BasePresent;
import com.hszl.erp.contract.WorkConstract;
import com.hszl.erp.contract.WorkDelegateContract;
import com.hszl.erp.entity.Work;
import com.hszl.erp.fragment.WorkDelegateFragment;
import com.hszl.erp.fragment.WorkDoneFragment;
import com.hszl.erp.fragment.WorkWaitFragment;
import com.hszl.erp.model.WorkModel;

import java.util.List;

public class WorkPresent extends BasePresent<WorkConstract.IWorkView> implements WorkConstract.IWorkPresent,WorkModel.WorkCallBack {

    WorkConstract.IWorkModel model;

    public WorkPresent() {
        model=new WorkModel();
        ((WorkModel) model).setBack(this);
    }

    @Override
    public void getData() {
        //根据getview的类型的不同调用不同的接口 3个查询接口都在model里面写出来，统一的回调在回调里去判断类型生成不同的
        //实例对象
        if (getView() instanceof WorkDoneFragment)
        {
            model.getDoneData();//调用接口
        }else if (getView() instanceof WorkWaitFragment)
        {
            model.getWaitData();
        }else if (getView() instanceof WorkDelegateFragment)
        {
            model.getDelegateData();
        }

    }

    @Override
    public void getDataSuccess(final List<Work> list) {
        ((Fragment)getView()).getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if (getView() instanceof WorkDoneFragment)
                {
                    //调用adapter刷新
                    BaseQuickAdapter adapter =((WorkDoneFragment)getView()).getAdapter();
                    List<Work> list1=adapter.getData();
                    list1.addAll(list);
                    adapter.notifyDataSetChanged();
                }else if (getView() instanceof WorkWaitFragment)
                {
                    //实例化对象然后调用adapter刷新
                    BaseQuickAdapter adapter =((WorkWaitFragment)getView()).getAdapter();
                    List<Work> list1=adapter.getData();
                    list1.addAll(list);
                    adapter.notifyDataSetChanged();
                }else if (getView() instanceof WorkDelegateFragment)
                {
                    //实例化对象然后调用adapter刷新
                    BaseQuickAdapter adapter =((WorkDelegateFragment)getView()).getAdapter();
                    List<Work> list1=adapter.getData();
                    list1.addAll(list);
                    adapter.notifyDataSetChanged();
                }
            }
        });

    }

    @Override
    public void getDataFailed() {

    }

    @Override
    public void networkFailed() {

    }
}
