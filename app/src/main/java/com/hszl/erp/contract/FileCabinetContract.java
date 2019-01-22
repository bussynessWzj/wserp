package com.hszl.erp.contract;

import com.hszl.erp.base.BaseView;

public class FileCabinetContract {

    public interface IFileCabinetView extends BaseView {
        void getData();
    }

    public interface IFileCabinetPresent {
        void getData();
    }

    public interface IFileCabinetModel
    {
        void getData();
    }
}
