package com.romens.selfpay.selfhelppayment.cell;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.Gravity;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.romens.android.AndroidUtilities;
import com.romens.android.ui.Components.LayoutHelper;
import com.romens.erp.library.config.ResourcesConfig;
import com.romens.selfpay.selfhelppayment.R;

/**
 * @author lm
 * @Created 2018/4/26
 * @description
 */
public class ActionCell extends FrameLayout {
    private TextView button;

    public ActionCell(Context context) {
        super(context);
        init(context);
    }

    public ActionCell(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public ActionCell(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        button = new TextView(context);
        button.setBackgroundResource(R.drawable.btn_primary);
        button.setTextColor(0xffffffff);
        button.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 17);
        button.setLines(1);
        button.setMaxLines(1);
        button.setSingleLine(true);
        button.setEllipsize(TextUtils.TruncateAt.END);
        button.setGravity(Gravity.CENTER);
        addView(button, LayoutHelper.createFrame(LayoutHelper.MATCH_PARENT, 40, Gravity.LEFT, 16, 8, 16, 8));
    }

    public void setPrimaryAction() {
        button.setBackgroundResource(R.drawable.btn_primary);
        button.setTextColor(0xffffffff);
    }

    public void setPrimaryBorderAction() {
        button.setBackgroundResource(R.drawable.btn_primary_border);
        button.setTextColor(ResourcesConfig.textPrimary);
    }

    public void setPrimaryBorderAction(int textColor) {
        button.setBackgroundResource(R.drawable.btn_primary_border);
        button.setTextColor(textColor);
    }

    public void setAction(int backgroundRes, int textColor) {
        button.setBackgroundResource(backgroundRes);
        button.setTextColor(textColor);
    }

    public void setNormalAction() {
        button.setBackgroundResource(R.drawable.btn_normal);
        button.setTextColor(ResourcesConfig.bodyText2);
    }

    public void setNormalBorderAction() {
        button.setBackgroundResource(R.drawable.btn_border_grey);
        button.setTextColor(ResourcesConfig.bodyText2);
    }

    public void setNormalAction(int textColor) {
        button.setBackgroundResource(R.drawable.btn_normal);
        button.setTextColor(textColor);
    }

    public void setPadding(int left, int top, int right, int bottom) {
        button.setPadding(AndroidUtilities.dp(left), AndroidUtilities.dp(top), AndroidUtilities.dp(right), AndroidUtilities.dp(bottom));
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, MeasureSpec.makeMeasureSpec(AndroidUtilities.dp(48), MeasureSpec.EXACTLY));
    }

    public void setValue(String text) {
        button.setText(text);
    }

}
