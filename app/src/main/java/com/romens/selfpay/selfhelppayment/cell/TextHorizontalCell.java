package com.romens.selfpay.selfhelppayment.cell;

import android.content.Context;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.romens.android.AndroidUtilities;
import com.romens.android.ui.Components.LayoutHelper;

/**
 * @author lm
 * @Created 2018/4/24
 * @description
 */

public class TextHorizontalCell extends LinearLayout {
    private TextView titleView;
    private TextView contentView;
    public TextHorizontalCell(Context context) {
        super(context);
        initView(context);
    }

    public TextHorizontalCell(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    public TextHorizontalCell(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }

    private void initView(Context context){
        setOrientation(HORIZONTAL);
        titleView=new TextView(context);
        titleView.setTextSize(TypedValue.COMPLEX_UNIT_DIP,14);
        titleView.setTextColor(0xffaaaaaa);
        titleView.setSingleLine();
        titleView.setEllipsize(TextUtils.TruncateAt.END);
        titleView.setGravity(Gravity.CENTER_VERTICAL);
        addView(titleView, LayoutHelper.createLinear(0,LayoutHelper.MATCH_PARENT,1.0f));
        contentView=new TextView(context);
        contentView.setTextSize(TypedValue.COMPLEX_UNIT_DIP,14);
        contentView.setTextColor(0xffaaaaaa);
        contentView.setSingleLine();
        contentView.setEllipsize(TextUtils.TruncateAt.END);
        contentView.setGravity(Gravity.CENTER);
        addView(contentView, LayoutHelper.createLinear(64,LayoutHelper.MATCH_PARENT));
    }

    public void setValueColor(int color){
        titleView.setTextColor(color);
        contentView.setTextColor(color);
    }

    public void setValue(String title,String content){
        titleView.setText(title);
        contentView.setText(content);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, View.MeasureSpec.makeMeasureSpec(AndroidUtilities.dp(20), View.MeasureSpec.EXACTLY));
    }
}
