package com.example.recycleview_v0.View;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;

import androidx.annotation.Nullable;

/**
 * 專案名稱:recycleview_v0
 * 類描述:
 * 建立人:yujie
 * 建立時間:2020/9/11 上午 11:29
 * 修改人:yujie
 * 修改時間:2020/9/11 上午 11:29
 * 修改備註:專門製作寬度適應高度的正方形imageView
 */
public class SquareImageView extends androidx.appcompat.widget.AppCompatImageView {
    public SquareImageView(Context context) {
        super(context);
    }

    public SquareImageView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public SquareImageView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    //傳入引數widthMeasureSpec、heightMeasureSpec
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(heightMeasureSpec, heightMeasureSpec);//則表示寬度適應高度
        //super.onMeasure(widthMeasureSpec, widthMeasureSpec);//則表示高度適應寬度
    }
}
