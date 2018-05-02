package com.romens.selfpay.selfhelppayment.cell;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.romens.android.AndroidUtilities;
import com.romens.android.rx.rxbinding.RxViewAction;
import com.romens.android.ui.Components.LayoutHelper;
import com.romens.selfpay.selfhelppayment.R;

import rx.functions.Action1;

/**
 * @author lm
 * @Created 2018/4/27
 * @description
 */

public class TSTextCell extends LinearLayout {
    private TextView captionView;
    private TextView contentView;
    private boolean isSelect;

    public TSTextCell(Context context) {
        super(context);
        initView(context);
    }

    public TSTextCell(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    public TSTextCell(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }

    private void initView(final Context context){
        setBackgroundResource(R.drawable.btn_normal_border);
        setPadding(AndroidUtilities.dp(8),AndroidUtilities.dp(4),AndroidUtilities.dp(8),AndroidUtilities.dp(4));
        setOrientation(VERTICAL);
        captionView=new TextView(context);
        captionView.setTextSize(TypedValue.COMPLEX_UNIT_DIP,14);
        captionView.setTextColor(0xff757575);
        captionView.setSingleLine();
        addView(captionView, LayoutHelper.createLinear(LayoutHelper.WRAP_CONTENT,0,1.0f, Gravity.CENTER));
        contentView=new TextView(context);
        contentView.setTextSize(TypedValue.COMPLEX_UNIT_DIP,14);
        contentView.setTextColor(0xffff9800);
        contentView.setSingleLine();
        addView(contentView, LayoutHelper.createLinear(LayoutHelper.WRAP_CONTENT,0,1.0f, Gravity.CENTER));

    }


    public void setValue(String caption,String content){
        captionView.setText(caption);
        contentView.setText(content);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, View.MeasureSpec.makeMeasureSpec(AndroidUtilities.dp(40),MeasureSpec.EXACTLY));
    }
}
