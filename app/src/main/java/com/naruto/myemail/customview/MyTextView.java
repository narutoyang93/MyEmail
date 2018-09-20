package com.naruto.myemail.customview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;

import com.naruto.myemail.R;

/**
 * @Purpose 支持设置drawable尺寸
 * @Author Naruto Yang
 * @CreateDate 2018/9/13 0013
 * @Note
 */
public class MyTextView extends android.support.v7.widget.AppCompatTextView {
    private Context context;
    private int drawableWidth;
    private int drawableHeight;

    public MyTextView(Context context) {
        super(context);
        this.context = context;
    }

    public MyTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        init(attrs);
    }

    public MyTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
        init(attrs);
    }

    public void init(AttributeSet attrs) {
        /**
         * 通过这个方法，将attrs.xml中定义的declare-styleable的所有属性的值存储到TypedArray中
         */
        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.MyTextView);
        //从TypedArray中取出对应的值来为要设置的属性赋值
        drawableWidth = ta.getDimensionPixelSize(R.styleable.MyTextView_drawableWidth, 0);
        drawableHeight = ta.getDimensionPixelSize(R.styleable.MyTextView_drawableHeight, 0);
        Rect rect = new Rect(0, 0, drawableWidth, drawableHeight);
        if (drawableWidth > 0 || drawableHeight > 0) {
            Drawable[] drawables = getCompoundDrawables();
            int count = drawables.length;
            for (int i = 0; i < count; i++) {
                Drawable drawable = drawables[i];
                if (drawable != null) {
                    drawable.setBounds(rect);
                }
            }
            setCompoundDrawables(drawables[0], drawables[1], drawables[2], drawables[3]);
        }
    }


}
