package com.hszl.erp.base;

import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

public abstract class BasePresent<T> {


    private Reference<T> mViewRef;

    /**
     * 绑定View层 这里有可能是activity有可能是fragment
     * @param view
     */
    public void attachView(T view)
    {
        mViewRef=new WeakReference<>(view);
    }

    /**
     * 获得绑定的View层
     * @return
     */
    protected T getView()
    {
        if (isViewAttached())
        {
            return mViewRef.get();
        }else
        {
            return null;
        }
    }

    /**
     * 是否绑定了View层
     * @return
     */
    private  boolean isViewAttached(){
        if (mViewRef!=null&&mViewRef.get()!=null)
        {
            return true;
        }
        return false;
    }

    /**
     * 解绑View层，避免内存泄漏
     */
    public void detachView() {
        if (mViewRef != null)
        {
            mViewRef.clear();
            mViewRef=null;
        }
    }
}
