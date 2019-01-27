package com.hszl.erp.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.EditText;

import com.hszl.erp.R;
import com.hszl.erp.adapter.GroupFileAdapter;
import com.hszl.erp.base.BaseMvpActivity;
import com.hszl.erp.contract.GroupFileContract;
import com.hszl.erp.entity.File;
import com.hszl.erp.present.GroupFilePresent;
import com.hszl.erp.utils.ImmersionUtils;

import java.util.ArrayList;
import java.util.List;

public class GroupFileActivity extends BaseMvpActivity<GroupFilePresent,GroupFileContract.IGroupFileView> implements
      GroupFileContract.IGroupFileView{

    String title;//根据点击的item项的内容带过来的标题
    EditText etSearch;
    RecyclerView rvInfo;
    GroupFileAdapter adapter;
    List<File> list=new ArrayList<>();
    LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        ImmersionUtils.setTrans(this);
        super.onCreate(savedInstanceState);
        initLayout(R.layout.activity_file);
        ImmersionUtils.immersionTop(this,rlTop);
        setTitle(title);
        initview();
    }

    private void initview() {
        etSearch=findViewById(R.id.etSearch);
        rvInfo=findViewById(R.id.rvInfo);
        adapter=new GroupFileAdapter(R.layout.item_file,list);
        rvInfo.setLayoutManager(linearLayoutManager);
        rvInfo.setAdapter(adapter);
    }

    @Override
    protected GroupFilePresent createPresent() {
        return new GroupFilePresent();
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
