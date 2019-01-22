package com.hszl.erp.present;

import com.hszl.erp.base.BasePresent;
import com.hszl.erp.contract.FileCabinetContract;
import com.hszl.erp.model.FileCabinetModel;

public class FileCabinetPresent extends BasePresent<FileCabinetContract.IFileCabinetView> implements FileCabinetContract.IFileCabinetPresent,FileCabinetModel.FileCabinetCallBack {

    FileCabinetContract.IFileCabinetModel model;

    public FileCabinetPresent() {
        model=new FileCabinetModel();
        ((FileCabinetModel) model).setBack(this);
    }

    @Override
    public void getData() {

    }

    @Override
    public void getFileInfoSuccess() {

    }

    @Override
    public void getFileInfoFailed() {

    }

    @Override
    public void networkFailed() {

    }
}
