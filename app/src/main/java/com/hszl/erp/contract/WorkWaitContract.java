package com.hszl.erp.contract;

import com.hszl.erp.base.BaseView;

public class WorkWaitContract {

    public interface IWorkWaitView extends BaseView {
        String getSearch();
        void setSearch(String str);
    }

    public interface IWorkWaitPresent{
        void searchInfo();
    }

    public interface IWorkWaitModel{
        void searchInfo();
    }
}
