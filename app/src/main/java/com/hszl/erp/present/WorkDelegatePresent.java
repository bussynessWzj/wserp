package com.hszl.erp.present;

import com.hszl.erp.base.BasePresent;
import com.hszl.erp.contract.WorkDelegateContract;

public class WorkDelegatePresent extends BasePresent<WorkDelegateContract.IWorkDelegateView> implements WorkDelegateContract.IWorkDelegatePresent{

    WorkDelegateContract.IWorkDelegateModel model;

    public WorkDelegatePresent() {
//        this.model = ;
    }

    @Override
    public void searchInfo() {

    }
}
