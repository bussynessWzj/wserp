package com.hszl.erp.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.hszl.erp.entity.File;
import com.hszl.erp.utils.Viewholder;

import java.util.List;

public class PersonalFileAdapter extends BaseQuickAdapter<File,Viewholder> {

    public PersonalFileAdapter(int layoutResId, @Nullable List<File> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(Viewholder helper, File item) {

    }
}
