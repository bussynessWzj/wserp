package com.hszl.erp.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.support.v7.widget.AppCompatRadioButton;
import android.util.AttributeSet;
import android.view.Gravity;

import com.hszl.erp.R;

/**
 * 在radiobutton上添加小红点，并且通过设置gravity属性可以设置小红点的位置上下左右的大致位置，如果要添加相对位置比如中间等可以在自定义属性
 * 当中添加，位置计算在calcCircleCenter里已经计算出来了通过控制padding属性值来控制小红点的详细位置
 */
public class MyRadioButton extends AppCompatRadioButton {

    //定义2个变量,是否显示红点
    boolean isShow=true;//默认不显示
    float radius=13f;    //默认红点半径为13
    int gravity;        //红点相对于radioButton显示的大致位置
    float paddingTop,paddingRight,paddingBottom,paddingLeft,padding;//红点相对于radioButton的内边距位置根据gravity的相对属性来计算的

    public void setShow(boolean show) {
        isShow = show;
        invalidate();
    }

    public MyRadioButton(Context context) {
        this(context,null);
    }

    public MyRadioButton(Context context, AttributeSet attrs) {
        this(context, attrs, android.support.v7.appcompat.R.attr.radioButtonStyle);
    }

    public MyRadioButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray array=context.getTheme().obtainStyledAttributes(attrs,R.styleable.MyRadioButton,defStyleAttr,0);
        isShow=array.getBoolean(R.styleable.MyRadioButton_isShow,false);
        radius=array.getDimension(R.styleable.MyRadioButton_radius,13);
        gravity=array.getInt(R.styleable.MyRadioButton_gravity,Gravity.TOP|Gravity.RIGHT);
        paddingTop=array.getDimension(R.styleable.MyRadioButton_paddingTop,0);
        paddingRight=array.getDimension(R.styleable.MyRadioButton_paddingRight,0);
        paddingBottom=array.getDimension(R.styleable.MyRadioButton_paddingBottom,0);
        paddingLeft=array.getDimension(R.styleable.MyRadioButton_paddingLeft,0);
        padding=array.getDimension(R.styleable.MyRadioButton_padding,0);
        if (padding!=0)
        {
            paddingTop=paddingRight=paddingLeft=paddingBottom=padding;
        }
        array.recycle();
    }
    //定义消息校园的半径为6
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (isShow) {
            Paint paint = new Paint();
            paint.setStyle(Paint.Style.FILL);
            paint.setColor(Color.RED);
            //根据gravity的位置和padding属性计算圆心坐标
            Point point=calcCircleCenter(gravity,paddingLeft,paddingRight,paddingBottom,paddingTop);
            //校园的圆心坐标为
//            float x = getMeasuredWidth() - radius;
            canvas.drawCircle(point.x, point.y, radius, paint);
        }
    }

    private Point calcCircleCenter(int gravity, float paddingLeft, float paddingRight, float paddingBottom, float paddingTop) {
        float width=getMeasuredWidth();
        float height=getMeasuredHeight();
        Point point=new Point();
        switch (gravity)
        {
            case Gravity.LEFT|Gravity.TOP://左上角
                point.x= (int) (0+paddingLeft+radius);
                point.y= (int) (0+paddingTop+radius);
                return point;
            case Gravity.RIGHT|Gravity.TOP://右上角
                point.x= (int) (width-paddingRight-radius);
                point.y= (int) (0+paddingTop+radius);
                return point;
            case Gravity.BOTTOM|Gravity.LEFT://左下角
                point.x= (int) (0+paddingLeft+radius);
                point.y= (int) (height-paddingBottom-radius);
                return point;
            case Gravity.BOTTOM|Gravity.RIGHT://右下角
                point.x= (int) (width-paddingRight-radius);
                point.y= (int) (height-paddingBottom-radius);
                return point;
            case Gravity.CENTER:
                point.x= (int) (width/2);
                point.y= (int) (height/2);
                return point;
            case Gravity.CENTER_HORIZONTAL:
                point.x= (int) (width/2);
                point.y= (int) (0+paddingTop+radius);
                return point;
            case Gravity.CENTER_VERTICAL:
                point.x= (int) (0+paddingLeft+radius);
                point.y= (int) (height/2);
                return point;
        }
        return point;
    }
}
