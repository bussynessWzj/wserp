package com.hszl.erp.contract;

import com.hszl.erp.base.BaseView;

public class SettingContract {
    public interface ISettingView extends BaseView
    {

    }

    public interface ISettingPresent
    {
        void saveConfigration(String ip,String port);
    }
}
