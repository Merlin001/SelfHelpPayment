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

public class TextPaintView extends FrameLayout {
    private TextView textView;
    public TextPaintView(Context context) {
        super(context);
        initView(context);
    }

    public TextPaintView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    public TextPaintView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
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
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint=new Paint();
        paint.setColor(0xffaaaaaa);
        paint.setStrokeWidth(2);
//        paint.setTextSize(AndroidUtilities.dp(12));
//        paint.setStyle(Paint.Style.FILL);
        //该方法即为设置基线上那个点究竟是left,center,还是right  这里我设置为center
        paint.setTextAlign(Paint.Align.CENTER);
        canvas.drawLine(getWidth()/6,getHeight()/2,getWidth()/3-AndroidUtilities.dp(16),getHeight()/2,paint);
//        canvas.drawText(text,getWidth()/2,getHeight()/3 *2,paint);
        canvas.drawLine((getWidth()/3) *2+AndroidUtilities.dp(16),getHeight()/2,(getWidth()/6)*5,getHeight()/2,paint);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, View.MeasureSpec.makeMeasureSpec(AndroidUtilities.dp(24),MeasureSpec.EXACTLY));
    }

    public void setValue(CharSequence text) {
        textView.setText(text);
    }


}
