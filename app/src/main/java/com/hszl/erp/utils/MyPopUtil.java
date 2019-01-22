package com.hszl.erp.utils;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.PopupWindow;

/**
 * Created by asus-pc on 2018/3/22.
 */

public class MyPopUtil {

    private PopupWindow mPopupWindow;
    private View contentView;
    private static Context mcontext;

    public MyPopUtil(Builder builder) {
        contentView = LayoutInflater.from(mcontext).inflate(builder.resouceId, null);
        mPopupWindow = new PopupWindow(contentView, builder.width, builder.height, builder.focuse);
        mPopupWindow.setAnimationStyle(builder.animation);
        mPopupWindow.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
    }

    public void dismiss() {
        if (mPopupWindow != null)
            mPopupWindow.dismiss();
    }

    public boolean isShow() {
        if (mPopupWindow != null) {
            return mPopupWindow.isShowing();
        }
        return false;
    }

    /**
     * 获取popwindow布局里的子控件
     *
     * @param viewId popwindow布局的子控件id
     * @return 子view对象
     */
    public View getItemView(int viewId) {
        if (mPopupWindow != null)
            return contentView.findViewById(viewId);
        return null;
    }

    /**
     * 显示popwindow在传入的布局里的具体位置
     *
     * @param rootviewid 传入的布局资源id
     * @param gravity    显示的具体位置GRAVITY的枚举值
     * @param x          x轴的偏移量
     * @param y          y轴的偏移量
     * @return
     */
    public MyPopUtil showAtLocation(int rootviewid, int gravity, int x, int y) {
        if (mPopupWindow != null) {
            View rootView = LayoutInflater.from(mcontext).inflate(rootviewid, null);
            mPopupWindow.showAtLocation(rootView, gravity, x, y);
        }
        return this;
    }

    /**
     * 显示popwindow在传入的控件的具体位置
     *
     * @param view    需要在哪个控件下
     * @param x       x轴偏移量
     * @param y       y轴偏移量
     * @param gravity 显示的具体位置GRAVITY的枚举值 默认值为（Gravity.TOP|Gravity.START）
     * @return
     */
    public MyPopUtil showAsLocation(View view, int x, int y, int gravity) {
        if (mPopupWindow != null) {
            mPopupWindow.showAsDropDown(view, x, y, gravity);
        }
        return this;
    }

    public static class Builder {
        private int resouceId;
        private int width;
        private int height;
        private boolean focuse;
        private int animation;

        public Builder setResouceId(int resouceId) {
            this.resouceId = resouceId;
            return this;
        }

        public Builder setWidth(int width) {
            this.width = width;
            return this;
        }

        public Builder setHeight(int height) {
            this.height = height;
            return this;
        }

        public Builder setFocuse(boolean focuse) {
            this.focuse = focuse;
            return this;
        }

        public Builder(Context context) {
            mcontext = context;
        }

        public MyPopUtil builder() {
            return new MyPopUtil(this);
        }

        public Builder setAnimation(int animation)
        {
            this.animation=animation;
            return this;
        }

    }

}
