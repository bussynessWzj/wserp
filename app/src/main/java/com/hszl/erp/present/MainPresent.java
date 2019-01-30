package com.hszl.erp.present;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.widget.RadioGroup;

import com.hszl.erp.R;
import com.hszl.erp.base.BasePresent;
import com.hszl.erp.contract.MainContract;
import com.hszl.erp.fragment.FileCabinetFragment;
import com.hszl.erp.fragment.HomeFragment;
import com.hszl.erp.fragment.MyFragment;
import com.hszl.erp.model.MainModel;
import com.hszl.erp.ui.MyRadioButton;
import com.hszl.erp.view.MainActivity;

public class MainPresent extends BasePresent<MainContract.IMainView> implements MainContract.IMainPresent,MainModel.MainCallBack {

    MainContract.IMainModel model;
    MyFragment myFragment;
    FileCabinetFragment fileCabinetFragment;
    HomeFragment homeFragment;

    public MainPresent() {
        model=new MainModel();
        ((MainModel) model).setCallBack(this);
    }

    @Override
    public void changeFragment(int resid) {
        switch (resid)
        {
            case R.id.rbHome:
                getView().getFM().beginTransaction().show(homeFragment)
                        .hide(fileCabinetFragment)
                        .hide(myFragment)
                        .commit();
                break;
            case R.id.rbMessage:
                break;
            case R.id.rbFile:
                getView().getFM().beginTransaction().show(fileCabinetFragment)
                        .hide(homeFragment)
                        .hide(myFragment)
                        .commit();
                break;
            case R.id.rbMy:
                getView().getFM().beginTransaction().show(myFragment)
                        .hide(homeFragment)
                        .hide(fileCabinetFragment)
                        .commit();
                break;
        }
    }




    public void getMessage() {
        model.getMessage();
    }

    @Override
    public void restoreFragment(Bundle savedInstanceState) {
        FragmentManager fm=getView().getFM();
        if (savedInstanceState!=null)
        {
           myFragment= (MyFragment) fm.findFragmentByTag(MyFragment.class.getSimpleName());
           fileCabinetFragment= (FileCabinetFragment) fm.findFragmentByTag(FileCabinetFragment.class.getSimpleName());
           homeFragment= (HomeFragment) fm.findFragmentByTag(HomeFragment.class.getSimpleName());
            fm.beginTransaction().show(homeFragment)
                    .hide(fileCabinetFragment)
                    .hide(myFragment).commit();

        }else
        {
            myFragment=MyFragment.newInstance();
            fileCabinetFragment=FileCabinetFragment.newInstance();
            homeFragment=HomeFragment.newInstance();
            fm.beginTransaction().add(R.id.flFragment,myFragment,MyFragment.class.getSimpleName())
                    .add(R.id.flFragment,fileCabinetFragment,FileCabinetFragment.class.getSimpleName())
                    .add(R.id.flFragment,homeFragment,HomeFragment.class.getSimpleName())
                    .hide(myFragment)
                    .hide(fileCabinetFragment).commit();
        }
        ((MainActivity)getView()).getRg().check(R.id.rbHome);
    }

    /**
     * 展示group中的哪个button需要小红点
     * @param group
     */
    public void hasNotDone(RadioGroup group)
    {
        //根据消息来判断获取radiogroup第几个
        MyRadioButton myRadioButton = (MyRadioButton) group.getChildAt(0);
        ((MainActivity)getView()).showRedCircle(myRadioButton);
    }

    @Override
    public void getMessageSuccess() {
        ((MainActivity)getView()).runOnUiThread(new Runnable() {
            @Override
            public void run() {
                hasNotDone(((MainActivity)getView()).getRg());
            }
        });
    }
}
