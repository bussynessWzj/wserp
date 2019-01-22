package com.hszl.erp.adapter;

import android.support.annotation.Nullable;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.hszl.erp.R;
import com.hszl.erp.entity.Work;
import com.hszl.erp.utils.Viewholder;

import java.util.List;

public class WorkAdapter extends BaseQuickAdapter<Work,Viewholder> {


    public WorkAdapter(int layoutResId, @Nullable List<Work> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(Viewholder helper, Work item) {
        helper.setText(R.id.tvTitle,item.getTitle())
                .setText(R.id.tvDate,item.getDate())
                .setText(R.id.tvName,item.getName());
        TextView status=helper.getView(R.id.tvStatus);
        //下面估计是根据状态值显示相关文字
        if (item.getStatus().equals("0"))
        {
            status.setText("待处理");
        }else if (item.getStatus().equals("1"))
        {
            status.setText("运行中");
        }
        else if (item.getStatus().equals("2"))
        {
            status.setText("已完成");
        }
        else if (item.getStatus().equals("3"))
        {
            status.setText("已终止");
        }
        else if (item.getStatus().equals("4"))
        {
            status.setText("委托中");
        }
        else if (item.getStatus().equals("5"))
        {
            status.setText("已失效");
        }

    }
}
