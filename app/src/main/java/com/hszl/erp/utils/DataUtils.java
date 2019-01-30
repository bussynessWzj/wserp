package com.hszl.erp.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Map;

public class DataUtils {
    /**
     * 将数据组装成json
     * @param map
     * @return
     */
    public static String toJson(Map<String,Object> map)
    {
        Gson gson=new Gson();
        return gson.toJson(map);
    }

    public static boolean isEmpty(CharSequence charSequence)
    {
        if (charSequence==null)
            return true;
        if (charSequence.toString().equals(""))
            return true;
        return false;
    }

    /**
     * 判断是否为手机号码
     * @param str
     * @return
     */
    public static boolean isPhoneNum(String str)
    {

        return str.matches("^(\\+86|86)?1((3[0-9])|(4[5|7])|(5([0-3]|[5-9]))|(8[0,5-9]))\\d{8}$");
    }

    /**
     * 判断是否为邮箱
     * @param str
     * @return
     */
    public static boolean isEmail(String str)
    {

        return str.matches("\"^[\\\\w-]+@[\\\\w-]+(\\\\.[\\\\w-]+)+$\"");
    }

    /**
     * 高斯模糊效果
     * @param context
     * @param bitmap
     * @return
     */
    public static Bitmap blurBitmap(Context context, Bitmap bitmap)
    {
        Bitmap outBitmap=Bitmap.createBitmap(1500,1000,Bitmap.Config.ARGB_8888);
        RenderScript rs=RenderScript.create(context);
        ScriptIntrinsicBlur blur=ScriptIntrinsicBlur.create(rs,Element.U8_4(rs));
        Allocation allin=Allocation.createFromBitmap(rs,bitmap);
        Allocation allout=Allocation.createFromBitmap(rs,outBitmap);
        blur.setRadius(20.f);
        blur.setInput(allin);
        blur.forEach(allout);
        allout.copyTo(outBitmap);
        //        bitmap.recycle();
        //        rs.destroy();
        return outBitmap;
    }
}
