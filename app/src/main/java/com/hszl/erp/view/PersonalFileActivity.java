package com.hszl.erp.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.EditText;

import com.hszl.erp.R;
import com.hszl.erp.adapter.GroupFileAdapter;
import com.hszl.erp.adapter.PersonalFileAdapter;
import com.hszl.erp.base.BaseMvpActivity;
import com.hszl.erp.contract.PersonalContract;
import com.hszl.erp.entity.File;
import com.hszl.erp.present.PersonalFileContract;
import com.hszl.erp.present.PersonalFilePresent;
import com.hszl.erp.utils.ImmersionUtils;

import java.util.ArrayList;
import java.util.List;

public class PersonalFileActivity extends BaseMvpActivity<PersonalFilePresent,PersonalFileContract.IPersonalFileView> implements
        PersonalContract.IPersonalView {


    EditText etSearch;
    RecyclerView rvInfo;
    PersonalFileAdapter adapter;
    List<File> list=new ArrayList<>();
    LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        ImmersionUtils.setTrans(this);
        super.onCreate(savedInstanceState);
        initLayout(R.layout.activity_file);
        ImmersionUtils.immersionTop(this,rlTop);
        setTitle(R.string.file_cabinet_actPersonal_title);
        showLeftImg(R.drawable.back1);
        initview();
    }

    private void initview() {
        etSearch=findViewById(R.id.etSearch);
        rvInfo=findViewById(R.id.rvInfo);
        adapter=new PersonalFileAdapter(R.layout.item_file,list);
        rvInfo.setLayoutManager(linearLayoutManager);
        rvInfo.setAdapter(adapter);
    }

    @Override
    protected PersonalFilePresent createPresent() {
        return new PersonalFilePresent();
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showError(String message) {

    }
}
