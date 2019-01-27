package com.hszl.erp.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.hszl.erp.entity.Cabinet;
import com.hszl.erp.utils.Viewholder;

import java.util.List;

public class CabinetAdapter extends BaseQuickAdapter<Cabinet,Viewholder> {


    public CabinetAdapter(int layoutResId, @Nullable List<Cabinet> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(Viewholder helper, Cabinet item) {

    }
}
