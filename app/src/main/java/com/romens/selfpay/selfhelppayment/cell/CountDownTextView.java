package com.romens.selfpay.selfhelppayment.cell;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.romens.android.AndroidUtilities;
import com.romens.android.ui.Components.LayoutHelper;

/**
 * @author lm
 * @Created 2018/4/25
 * @description
 */

public class CountDownTextView extends FrameLayout {
    private TextView textView;

    public CountDownTextView(Context context) {
        super(context);
        initView(context);
    }

    public CountDownTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    public CountDownTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }
    private void initView(Context context){
        textView=new TextView(context);
        textView.setTextColor(0xffaaaaaa);
        textView.setTextSize(TypedValue.COMPLEX_UNIT_DIP,12);
        textView.setMaxLines(1);
        textView.setSingleLine();
        textView.setGravity(Gravity.CENTER);
        addView(textView, LayoutHelper.createFrame(LayoutHelper.WRAP_CONTENT,LayoutHelper.WRAP_CONTENT,Gravity.CENTER));
        setWillNotDraw(false);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint=new Paint();
        paint.setColor(0xffaaaaaa);
        paint.setStrokeWidth(2);
        int height=getHeight()/2;
        canvas.drawLine(getWidth()/6,height,getWidth()/3-AndroidUtilities.dp(16),height,paint);
        canvas.drawLine((getWidth()/3) *2+AndroidUtilities.dp(16),height,(getWidth()/6)*5,height,paint);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, View.MeasureSpec.makeMeasureSpec(AndroidUtilities.dp(24),MeasureSpec.EXACTLY));
    }

    public void setValue(CharSequence text) {
        textView.setText(text);
    }


}
