package com.hszl.erp.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;
import android.support.annotation.Nullable;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;

import com.hszl.erp.R;
import com.hszl.erp.base.BaseMvpActivity;
import com.hszl.erp.contract.WriteEmailContract;
import com.hszl.erp.present.WriteEmailPresent;
import com.hszl.erp.utils.DataUtils;
import com.hszl.erp.utils.ImmersionUtils;
import com.hszl.erp.utils.MyPopUtil;

public class WriteEmailActivity extends BaseMvpActivity<WriteEmailPresent,WriteEmailContract.IWriteEmailView> implements
        WriteEmailContract.IWriteEmailView {
    Bitmap out;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        ImmersionUtils.setTrans(this);
        super.onCreate(savedInstanceState);
        initLayout(R.layout.activity_write_email);
        ImmersionUtils.immersionTop(this,rlTop);
        showRightImg(R.drawable.more);
        showLeftImg(R.drawable.back1);
        setTitle("写邮件");

    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId())
        {
            case R.id.imgRight:
                View view =WriteEmailActivity.this.getWindow().getDecorView();
                view.setDrawingCacheEnabled(true);
                view.buildDrawingCache(true);
                Bitmap bitmap =view.getDrawingCache();
                out=DataUtils.blurBitmap(WriteEmailActivity.this,bitmap);
                MyPopUtil myPopUtil=new MyPopUtil.Builder(this)
                        .setHeight(1000)
                        .setWidth(1500)
                        .setResouceId(R.layout.pop_email_more)
                        .setFocuse(true).builder();
                View view1=myPopUtil.getItemView(R.id.ll);
                view1.setBackground(new BitmapDrawable(getResources(),out));
//                myPopUtil.showAsLocation(this.getWindow().getDecorView(),0,0,Gravity.TOP);
                myPopUtil.showAtLocation(R.layout.activity_write_email,Gravity.TOP|Gravity.CENTER_HORIZONTAL,0,0);
                break;
        }
    }



    @Override
    protected WriteEmailPresent createPresent() {
        return new WriteEmailPresent();
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
