package com.example.testontouch;

import android.content.Context;
import android.graphics.Canvas;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.Button;

public class MyView extends View implements OnTouchListener {

    /**
     * 自定义控件实现点击监听的简单实现
     *
     *  1.初始化监听
     *  2.自定义监听接口
     *  3.创建调用监听接口方法
     *  4.判断是否调用
     *
     */

    //点击状态
    private boolean isClick = false;
    //点击监听接口
    private IsClickState isClickState;
    //是否使用了监听
    private boolean isUseInterface;
    //上次开关状态
    private boolean lastClickState = false;

    public MyView(Context context) {
        this(context,null);
    }

    public MyView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public MyView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    //1.初始化点击监听
    private void init(Context context) {
        setOnTouchListener(this);
    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    //点击监听
    @Override
    public boolean onTouch(View view, MotionEvent event) {

        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                //按下状态值改变
                isClick = !isClick;
                break;
            case MotionEvent.ACTION_UP:
                break;
        }

        //4.是否使用自定义监听,并且状态发生改变时调用
        if (isUseInterface&&isClick!=lastClickState){
            //上次状态等于现在状态
            lastClickState = isClick;
            //调用监听
            isClickState.showState(isClick);
        }

        return true;
    }

    //2.自定义监听接口
    interface IsClickState{
        void showState(boolean isClick);
    }

    //3.监听方法
    public void setClickListion(IsClickState isClickstate){
        isClickState = isClickstate;
        isUseInterface = true;
    }

}
