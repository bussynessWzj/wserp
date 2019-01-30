package com.hszl.erp.ui;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.View;

import com.hszl.erp.R;

/**
 * 目前不支持layout_width,layout_height属性值为wrap_content,以及match_parent属性，
 * 可优化支持该类属性，重写onMearsure方法，当为wrap_content时在里面给一个默认值，并且该值去
 * 确定padding属性值.
 * 目前不支持从开启到关闭或者从关闭到开启的时候，执行动画在未完成的时候切换状态，滑动的圆从当前未完成的状态
 * 的位置到切换的位置，他的起始位置开始从0或者从distance的位置开始的，这里可以优化当动画未完成切换状态时记
 * 录当前停止位置的距离以及背景颜色，并且在切换状态的时候从当前的位置和起始颜色开始变化。
 * 因时间关系，这个放在后面进行优化onMearsure和记录位置和颜色的优化项放在后面进行优化
 */
public class MySwitchButton extends View implements View.OnClickListener {

    int distance;               //轨道圆的移动路径的距离就应该等于 轨道宽度-2个半径-paddingleft-paddingright
    int padding = 4;            //圆距离轨道左右2遍的距离
    int height;                 //轨道的高度
    int width;                  //轨道的宽度
    int checkColor;             //switchButton处于开启的状态时轨道的背景颜色
    int uncheckColor;           //switchButton处于关闭的状态时轨道的背景颜色
    boolean isOn = true;        //switchButton的状态时开启或者关闭
    int radius;                 //圆的半径
    GradientDrawable pathway;   //这个是轨道的drawable
    int currentColor;           //轨道的背景颜色
    GradientDrawable circle;    //这个是圆的drawable;
    Turn turn;                  //开启关闭的回调接口

    public void setTurn(Turn turn) {
        this.turn = turn;
    }

    public MySwitchButton(Context context) {
        this(context, null);
    }

    public MySwitchButton(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MySwitchButton(Context context, AttributeSet attrs, int defStyleAttr) {
        this(context, attrs, defStyleAttr, 0);
    }

    public MySwitchButton(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        TypedArray array = context.getTheme().obtainStyledAttributes(attrs, R.styleable.MySwitchButton, defStyleAttr, defStyleRes);
        checkColor = array.getColor(R.styleable.MySwitchButton_check_background, Color.parseColor("#11D1CA"));
        uncheckColor = array.getColor(R.styleable.MySwitchButton_uncheck_background, Color.parseColor("#C3C5C8"));
        isOn=array.getBoolean(R.styleable.MySwitchButton_isOn,true);
        this.setOnClickListener(this);
        array.recycle();
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        height = getMeasuredHeight();
        width = getMeasuredWidth();
        radius = height / 2 - padding;
        if (isOn) {
            currentColor = checkColor;
            distance=0;
        }else
        {
            currentColor=uncheckColor;
            distance=width-2*radius-2*padding;
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        final Rect pathwayRect = new Rect(0, 0, width, height);
        pathway = new GradientDrawable();
        pathway.setCornerRadius(height / 2);
        pathway.setColor(currentColor);
        pathway.setSize(width, height);
        pathway.setBounds(pathwayRect);
        pathway.draw(canvas);
        Rect circleRect = new Rect( padding + distance, padding, (radius * 2 + distance) + padding, radius * 2 + padding);
        circle = new GradientDrawable();
        circle.setSize(radius, radius);
        circle.setShape(GradientDrawable.OVAL);
        circle.setColor(Color.parseColor("#ffffff"));
        circle.setBounds(circleRect);
        circle.draw(canvas);
    }

    public void startOff()
    {
        ValueAnimator valueAnimator=ValueAnimator.ofInt(0,width-2*padding-2*radius);
        valueAnimator.setDuration(1000);
        valueAnimator.setRepeatCount(0);
        valueAnimator.setRepeatMode(ValueAnimator.REVERSE);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                distance= (int) animation.getAnimatedValue();
                invalidate();
            }
        });
        valueAnimator.start();
        ValueAnimator valueAnimator1=ValueAnimator.ofArgb(checkColor,uncheckColor);
        valueAnimator1.setDuration(1000);
        valueAnimator1.setRepeatCount(0);
        valueAnimator.setRepeatMode(ValueAnimator.REVERSE);
        valueAnimator1.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                currentColor= (int) animation.getAnimatedValue();
                invalidate();
            }
        });
        valueAnimator1.start();
    }

    /**
     * 控制轨道
     */
    public void startOn()
    {
        ValueAnimator valueAnimator=ValueAnimator.ofInt(width-2*padding-2*radius,0);
        valueAnimator.setDuration(1000);
        valueAnimator.setRepeatCount(0);
        valueAnimator.setRepeatMode(ValueAnimator.REVERSE);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                distance= (int) animation.getAnimatedValue();
                invalidate();
            }
        });
        valueAnimator.start();
        ValueAnimator valueAnimator1=ValueAnimator.ofArgb(uncheckColor,checkColor);
        valueAnimator1.setDuration(1000);
        valueAnimator1.setRepeatCount(0);
        valueAnimator.setRepeatMode(ValueAnimator.REVERSE);
        valueAnimator1.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                currentColor= (int) animation.getAnimatedValue();
                invalidate();
            }
        });
        valueAnimator1.start();
    }

    @Override
    public void onClick(View v) {
        if (isOn)
        {
            isOn=false;
            startOff();
            turn.turnOff();
        }else
        {
            isOn=true;
            startOn();
            turn.turnOn();
        }
    }

    public boolean isOn()
    {
        return isOn;
    }

    public interface Turn
    {
         void turnOn();
         void turnOff();
    }
}
