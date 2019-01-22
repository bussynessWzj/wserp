package com.hszl.erp.contract;

import com.hszl.erp.base.BaseView;

public class WorkDoneContract {

    public interface IWorkDoneView extends BaseView
    {
        String getSearch();
        void setSearch(String str);
    }

    public interface IWorkDonePresent
    {
        void searchInfo();
    }

    public interface IWorkDoneModel
    {
        void searchInfo();
    }
}
