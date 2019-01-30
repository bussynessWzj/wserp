package com.hszl.erp.base;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.hszl.erp.R;

public abstract class BaseMvpActivity<T extends BasePresent<V>,V> extends AppCompatActivity implements View.OnClickListener  {

    public RelativeLayout rlTop;
    FrameLayout flContent;
    TextView tvTitle, tvLeft, tvRight;
    ImageView imgLeft, imgRight, imgRight1;

    public T mPresent;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(setLayoutId());
        if (mPresent==null)
        {
            mPresent=createPresent();
            mPresent.attachView((V) this);
        }
        initView();
    }

    protected abstract T createPresent();
    

    public void initLayout(int resid)
    {
        View view=LayoutInflater.from(this).inflate(resid,flContent,false);
        flContent.addView(view);
    }

    protected void initView() {
        rlTop=findViewById(R.id.rlTop);
        flContent = findViewById(R.id.flContent);
        tvTitle = findViewById(R.id.tvTitle);
        tvLeft = findViewById(R.id.tvLeft);
        tvRight = findViewById(R.id.tvRight);
        imgLeft = findViewById(R.id.imgLeft);
        imgRight = findViewById(R.id.imgRight);
        imgRight1 = findViewById(R.id.imgRight1);
        tvLeft.setOnClickListener(this);
        tvRight.setOnClickListener(this);
        imgLeft.setOnClickListener(this);
        imgRight.setOnClickListener(this);
        imgRight1.setOnClickListener(this);
        tvLeft.setVisibility(View.INVISIBLE);
        tvRight.setVisibility(View.INVISIBLE);
        imgLeft.setVisibility(View.GONE);
        imgRight.setVisibility(View.GONE);
        imgRight1.setVisibility(View.GONE);
    }

    protected int setLayoutId() {
        return R.layout.test;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresent.detachView();
    }

    /**
     * 设置标题
     * @param title
     */
    public void setTitle(String title)
    {
        if (rlTop.getVisibility()!=View.VISIBLE) {
            rlTop.setVisibility(View.VISIBLE);
            tvTitle.setText(title);
        }
    }

    /**
     * 设置标题文字颜色
     * @param resid
     */
    public void setTitleTextColor(int resid)
    {
        if (rlTop.getVisibility()!=View.VISIBLE) {
            rlTop.setVisibility(View.VISIBLE);
            tvTitle.setTextColor(resid);
        }
    }

    public void hideTop()
    {
        if (rlTop.getVisibility()==View.VISIBLE)
        {
            rlTop.setVisibility(View.INVISIBLE);
        }
    }

    /**
     * 设置左边文字颜色
     * @param resid
     */
    public void setLeftTvColor(int resid)
    {
        if (tvLeft.getVisibility()!=View.VISIBLE)
        {
            tvLeft.setVisibility(View.VISIBLE);
            tvLeft.setTextColor(resid);
        }

    }

    /**
     * 显示默认左边文字
     */
    public void showLeftTv()
    {
        if (tvLeft.getVisibility()!=View.VISIBLE) {
            tvLeft.setVisibility(View.VISIBLE);
            showLeftTv("返回");
        }
    }

    /**
     * 显示左边文字默认颜色
     * @param str
     */
    public void showLeftTv(String str)
    {
        showLeftTv(str,Color.parseColor("#000000"));
    }

    /**
     * 显示左边文字以及颜色
     * @param str
     * @param resid
     */
    public void showLeftTv(String str,int resid)
    {
        if (tvLeft.getVisibility()!=View.VISIBLE)
        {
            tvLeft.setText(str);
            tvLeft.setTextColor(resid);
            tvLeft.setVisibility(View.VISIBLE);
        }
    }

    /**
     * 隐藏左边文字
     */
    public void hideLeftTv()
    {
        if (tvLeft.getVisibility()==View.VISIBLE)
        {
            tvLeft.setVisibility(View.INVISIBLE);
        }
    }


    /**
     * 显示默认颜色的右边文字
     * @param str
     */
    public void showRightTv(String str) {
        showRightTv(str,Color.parseColor("#000000"));
    }

    /**
     * 显示右边默认颜色和文字
     */
    public void showRightTv() {
        showRightTv("返回");
    }

    /**
     * 显示右边文字颜色
     * @param resid
     */
    public void showRightTvColor(int resid)
    {
        if (tvRight.getVisibility()!=View.VISIBLE) {
            tvRight.setVisibility(View.VISIBLE);
            tvRight.setTextColor(resid);
        }
    }

    /**
     * 显示右边文字和颜色
     * @param str
     * @param resid
     */
    public void showRightTv(String str,int resid)
    {
        if (tvRight.getVisibility()!=View.VISIBLE)
        {
            tvRight.setVisibility(View.VISIBLE);
            tvRight.setTextColor(resid);
            tvRight.setText(str);
        }
    }

    /**
     * 显示默认左边图片
     */
    public void showLeftImg()
    {
        showLeftImg(R.mipmap.main_gray);
    }

    /**
     * 显示左边图片
     * @param resid
     */
    public void showLeftImg(int resid)
    {
        if (imgLeft.getVisibility()!=View.VISIBLE)
        {
            imgLeft.setVisibility(View.VISIBLE);
            imgLeft.setImageResource(resid);
        }
    }

    /**
     * 隐藏左边图片
     */
    public void hideLeftImg()
    {
        if (imgLeft.getVisibility()==View.VISIBLE)
        {
            imgLeft.setVisibility(View.GONE);
        }
    }

    /**
     * 显示默认右边图片
     */
    public void showRightImg()
    {
        showRightImg(R.mipmap.main_gray);
    }

    /**
     * 显示右边图片
     * @param resid
     */
    public void showRightImg(int resid) {
        if (imgRight.getVisibility()!=View.VISIBLE)
        {
            imgRight.setVisibility(View.VISIBLE);
            imgRight.setImageResource(resid);
        }
    }

    /**
     * 隐藏右边图片
     */
    public void hideRightImg() {
        if (imgRight.getVisibility() == View.VISIBLE)
        {
            imgRight.setVisibility(View.GONE);
        }
    }

    /**
     * 显示默认右边1图片
     */
    public void showRightImg1()
    {
        showRightImg1(R.mipmap.main_gray);
    }

    /**
     * 显示右边1图片
     * @param resid
     */
    public void showRightImg1(int resid) {
        if (imgRight1.getVisibility()!=View.VISIBLE)
        {
            imgRight1.setVisibility(View.VISIBLE);
            imgRight1.setImageResource(resid);
        }
    }

    /**
     * 隐藏右边1图片
     */
    public void hideRightImg1() {
        if (imgRight1.getVisibility() == View.VISIBLE)
        {
            imgRight1.setVisibility(View.GONE);
        }
    }



    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.tvLeft:
                this.finish();
                break;
            case R.id.imgLeft:
                this.finish();
                break;
        }
    }


    /**
     * 为了适配使用沉浸式布局
     * @param hasFocus
     */
    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (Build.VERSION.SDK_INT>=19)
        {
            View decorView = getWindow().getDecorView();
            decorView.setSystemUiVisibility(
                    View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                            | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
        }
    }
}
