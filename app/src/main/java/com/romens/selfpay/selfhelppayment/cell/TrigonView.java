package com.romens.selfpay.selfhelppayment.cell;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.romens.android.AndroidUtilities;

/**
 * @author lm
 * @Created 2018/4/25
 * @description
 */

public class TrigonView extends View {
    public TrigonView(Context context) {
        super(context);
    }

    public TrigonView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public TrigonView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, View.MeasureSpec.makeMeasureSpec(AndroidUtilities.dp(28),MeasureSpec.EXACTLY));
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint p = new Paint();
        p.setColor(0xff42A5F5);
        //实例化路径
        Path path = new Path();
        int width=getWidth()/2;
        int height=getHeight()/2;
        path.moveTo(width-180, height-30);// 此点为多边形的起点
        path.lineTo(width+180, height-30);
        path.lineTo(width, height+30);
        path.close(); // 使这些点构成封闭的多边形
        canvas.drawPath(path, p);

    }
}
