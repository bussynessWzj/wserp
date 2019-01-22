package com.hszl.erp.contract;

import com.hszl.erp.base.BaseView;

public class WorkDelegateContract {

    public interface IWorkDelegateView extends BaseView{
        String getSearch();
        void setSearch(String str);
    }

    public interface IWorkDelegatePresent
    {
        void searchInfo();
    }

    public interface IWorkDelegateModel
    {
        void searchInfo();
    }
}
