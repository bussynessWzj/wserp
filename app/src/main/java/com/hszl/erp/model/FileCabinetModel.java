package com.hszl.erp.model;

import com.hszl.erp.http.BaseCallback;

public class FileCabinetModel implements com.hszl.erp.contract.FileCabinetContract.IFileCabinetModel {


    FileCabinetCallBack back;

    public void setBack(FileCabinetCallBack back) {
        this.back = back;
    }

    @Override
    public void getData() {

    }

    public interface FileCabinetCallBack extends BaseCallback
    {
        void getFileInfoSuccess();
        void getFileInfoFailed();
    }
}
