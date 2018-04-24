package com.romens.selfpay.selfhelppayment.cell;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.romens.android.AndroidUtilities;
import com.romens.android.ui.Components.LayoutHelper;
import com.romens.selfpay.selfhelppayment.R;

import org.w3c.dom.Text;

/**
 * @author lm
 * @Created 2018/4/24
 * @description
 */

public class AlipayLogoCell extends LinearLayout {
    public AlipayLogoCell(Context context) {
        super(context);
        initView(context);
    }

    public AlipayLogoCell(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    public AlipayLogoCell(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }

    private void initView(Context context){
        setOrientation(HORIZONTAL);
        setBackgroundResource(R.drawable.btn_border);
        ImageView logoView=new ImageView(context);
        logoView.setImageResource(R.drawable.ic_launcher);
        logoView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        addView(logoView, LayoutHelper.createLinear(96,96));
        LinearLayout linearLayout=new LinearLayout(context);
        linearLayout.setOrientation(VERTICAL);
        linearLayout.setGravity(Gravity.CENTER_VERTICAL);
        addView(linearLayout,LayoutHelper.createLinear(LayoutHelper.WRAP_CONTENT,LayoutHelper.MATCH_PARENT,16,0,0,0));
        TextView topView=new TextView(context);
        topView.setTextColor(0xff757575);
        topView.setTextSize(TypedValue.COMPLEX_UNIT_DIP,20);
        topView.setMaxLines(2);
        topView.setText("欢迎使用你\n支付宝自助收银");
        linearLayout.addView(topView,LayoutHelper.createLinear(LayoutHelper.WRAP_CONTENT,LayoutHelper.WRAP_CONTENT));
        TextView bottomView=new TextView(context);
        bottomView.setTextColor(0xffaaaaaa);
        bottomView.setTextSize(TypedValue.COMPLEX_UNIT_DIP,14);
        bottomView.setSingleLine();
        bottomView.setMaxLines(1);
        bottomView.setText("本店支持花呗");
        linearLayout.addView(bottomView,LayoutHelper.createLinear(LayoutHelper.WRAP_CONTENT,LayoutHelper.WRAP_CONTENT,0,16,0,0));
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, View.MeasureSpec.makeMeasureSpec(AndroidUtilities.dp(96),View.MeasureSpec.EXACTLY));
    }
}
