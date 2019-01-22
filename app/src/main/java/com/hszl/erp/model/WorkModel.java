package com.hszl.erp.model;


import com.hszl.erp.contract.WorkConstract;
import com.hszl.erp.entity.Work;
import com.hszl.erp.http.BaseCallback;

import java.util.ArrayList;
import java.util.List;

public class WorkModel implements WorkConstract.IWorkModel {

    WorkCallBack back;

    public void setBack(WorkCallBack back) {
        this.back = back;
    }

    @Override
    public void getWaitData() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                List<Work> list=new ArrayList<>();
                for (int i = 0; i < 10; i++) {
                    Work work=new Work();
                    work.setTitle("待办报告");
                    work.setDate("15:"+(36+i));
                    work.setName("喜洋洋");
                    work.setStatus("0");
                    list.add(work);
                }
                back.getDataSuccess(list);
            }
        }).start();

    }

    @Override
    public void getDoneData() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                List<Work> list=new ArrayList<>();
                for (int i = 0; i < 10; i++) {
                    Work work=new Work();
                    work.setTitle("已办报告");
                    work.setDate("15:"+(36+i));
                    work.setName("喜洋洋");
                    work.setStatus("1");
                    list.add(work);
                }
                back.getDataSuccess(list);
            }
        }).start();
    }

    @Override
    public void getDelegateData() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                List<Work> list=new ArrayList<>();
                for (int i = 0; i < 10; i++) {
                    Work work=new Work();
                    work.setTitle("委托报告");
                    work.setDate("15:"+(36+i));
                    work.setName("喜洋洋");
                    work.setStatus("2");
                    list.add(work);
                }
                back.getDataSuccess(list);
            }
        }).start();
    }

    public interface WorkCallBack extends BaseCallback {
        void getDataSuccess(List<Work> list);
        void getDataFailed();
    }
}
