package com.hszl.erp.contract;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.hszl.erp.base.BaseView;

public class HomeContract {

    public interface IHomePresent
    {
        void getData();
    }

    public interface IHomeView extends BaseView
    {
        void setWorkWait(String count);
        String getWorkWait();
        void setWorkDone(String count);
        String getWorkDone();
        void setDelegateWork(String count);
        String getDelegateWork();
        void notifyGridLayoutRefresh();
    }

    public interface IHomeModel
    {
        void getData();
    }
}
