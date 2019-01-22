package com.hszl.erp.adapter;

import android.support.annotation.Nullable;
import android.widget.ImageView;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.hszl.erp.R;
import com.hszl.erp.entity.Home;
import com.hszl.erp.utils.Viewholder;

import java.util.List;

public class HomeAdapter extends BaseQuickAdapter<Home,Viewholder> {

    public HomeAdapter(int layoutResId, @Nullable List<Home> data) {
        super(layoutResId, data);
    }

    int[] imageResource=new int[]{R.drawable.stamp,R.drawable.email,R.drawable.news,R.drawable.notice
            ,R.drawable.meeting,R.drawable.production,R.drawable.procurement,R.drawable.storage
            , R.drawable.sales,R.drawable.finance};

    @Override
    protected void convert(Viewholder helper, Home item) {
        String[] text=mContext.getResources().getStringArray(R.array.home_grid_text);
        //根据item的相应的信息 从text数组里给相应的textview和imageview赋值
        TextView tvInfo =helper.getView(R.id.tvInfo);
        ImageView imgInfo=helper.getView(R.id.imgInfo);
        //如下赋值，text数组和imageResource数组下标对应是为同一个下标
//        tvInfo.setText(text[0]);
//        imgInfo.setImageResource(imageResource[0]);
    }
}
