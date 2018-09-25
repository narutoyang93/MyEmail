package com.naruto.myemail.customview.SwipeRefreshLayout;

import android.content.Context;
import android.util.AttributeSet;
import android.view.animation.Animation;
import android.widget.RelativeLayout;

/**
 * @Purpose
 * @Author Naruto Yang
 * @CreateDate 2018/9/25 0025
 * @Note
 */
public class MyRelativeLayout extends RelativeLayout {
    private Animation.AnimationListener mListener;

    public MyRelativeLayout(Context context) {
        super(context);
    }

    public MyRelativeLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyRelativeLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void setAnimationListener(Animation.AnimationListener listener) {
        mListener = listener;
    }


    @Override
    public void onAnimationStart() {
        super.onAnimationStart();
        if (mListener != null) {
            mListener.onAnimationStart(getAnimation());
        }
    }

    @Override
    public void onAnimationEnd() {
        super.onAnimationEnd();
        if (mListener != null) {
            mListener.onAnimationEnd(getAnimation());
        }
    }

}
