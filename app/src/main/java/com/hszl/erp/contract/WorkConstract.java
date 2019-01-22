package com.hszl.erp.contract;

import com.hszl.erp.base.BaseView;

public class WorkConstract {

    public interface IWorkView extends BaseView
    {
        void getData();
        String getSearch();
        void setSearch(String str);
    }

    public interface IWorkPresent
    {
        void getData();
    }

    public interface IWorkModel{
        void getWaitData();
        void getDoneData();
        void getDelegateData();
    }
}
