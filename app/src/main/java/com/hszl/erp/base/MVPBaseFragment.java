package com.hszl.erp.base;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public abstract class MVPBaseFragment<T extends BasePresent<V>,V> extends Fragment {
    protected T mPresent;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=initLayout(inflater, container);
        if (mPresent == null)
        {
            mPresent=creatPresent(this);
            mPresent.attachView((V) this);
        }
        initView(view);
        initData();
        return view;

    }

    /**
     * 初始化fragment所需显示的数据
     */
    protected abstract void initData();

    /**
     * 初始化fragment里面的控件
     * @param view
     */
    protected abstract void initView(View view);

    protected abstract T creatPresent(MVPBaseFragment<T,V> tvmvpBaseFragment);

    protected abstract View initLayout(LayoutInflater inflater, ViewGroup container);

    public boolean isAdd()
    {
        return this.isAdded();
    }
}
