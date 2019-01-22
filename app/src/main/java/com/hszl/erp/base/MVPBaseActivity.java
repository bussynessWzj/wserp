package com.hszl.erp.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
@Deprecated
public abstract class MVPBaseActivity<T extends BasePresent<V>,V> extends AppCompatActivity {

    protected T mPresent;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(setLayoutId());
        if (mPresent==null)
        {
            mPresent=createPresent();
            mPresent.attachView((V) this);
        }
//        initView();
//        initData();
    }

//    protected abstract void initData();
//
//    protected abstract void initView();

    protected abstract T createPresent();

    protected abstract int setLayoutId();

}
