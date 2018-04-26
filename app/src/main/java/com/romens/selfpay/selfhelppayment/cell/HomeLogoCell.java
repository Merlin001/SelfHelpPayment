package com.romens.selfpay.selfhelppayment.cell;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.romens.android.AndroidUtilities;
import com.romens.android.ui.Components.LayoutHelper;
import com.romens.selfpay.selfhelppayment.R;

/**
 * @author lm
 * @Created 2018/4/24
 * @description
 */

public class LogoCell extends LinearLayout {
    private ImageView  logo;
    private TextView market;
    private TextView leader;
    public LogoCell(Context context) {
        super(context);
        initView(context);
    }

    public LogoCell(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    public LogoCell(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }

    private void initView(Context context){
        setOrientation(HORIZONTAL);
        setGravity(Gravity.CENTER);
        FrameLayout logoLayout=new FrameLayout(context);
        addView(logoLayout, LayoutHelper.createLinear(88,LayoutHelper.MATCH_PARENT));
        logo=new ImageView(context);
//        logo.setImageResource(R.drawable.ic_launcher);
//        logo.setScaleType(ImageView.ScaleType.FIT_CENTER);
        logo.setBackgroundColor(Color.RED);
        logoLayout.addView(logo,LayoutHelper.createFrame(32,40, Gravity.CENTER_VERTICAL));
        LinearLayout linearLayout=new LinearLayout(context);
        linearLayout.setOrientation(VERTICAL);
        logoLayout.addView(linearLayout,LayoutHelper.createFrame(LayoutHelper.WRAP_CONTENT,LayoutHelper.MATCH_PARENT,Gravity.CENTER_VERTICAL,32,0,0,0));
        market=new TextView(context);
        market.setSingleLine();
        market.setTextColor(0xff757575);
        market.setText("Anymarket");
        market.setTextSize(TypedValue.COMPLEX_UNIT_DIP,12);
        market.setEllipsize(TextUtils.TruncateAt.END);
        market.setGravity(Gravity.CENTER);
        linearLayout.addView(market,LayoutHelper.createLinear(LayoutHelper.WRAP_CONTENT,0,1.0f));
        leader=new TextView(context);
        leader.setTextSize(TypedValue.COMPLEX_UNIT_DIP,12);
        leader.setTextColor(0xffa0a0a0);
        leader.setSingleLine();
        leader.setGravity(Gravity.CENTER);
        leader.setText("雨诺");
        leader.setEllipsize(TextUtils.TruncateAt.END);
        linearLayout.addView(leader,LayoutHelper.createLinear(LayoutHelper.WRAP_CONTENT,0,1.0f));

        ImageView andView=new ImageView(context);
//        andView.setImageResource(R.drawable.ic_launcher);
//        andView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        andView.setBackgroundColor(Color.BLUE);
        addView(andView,LayoutHelper.createLinear(40,LayoutHelper.MATCH_PARENT));
        ImageView payImage=new ImageView(context);
//        payImage.setImageResource(R.drawable.ic_launcher);
//        payImage.setScaleType(ImageView.ScaleType.FIT_CENTER);
        payImage.setBackgroundColor(Color.RED);
        addView(payImage,LayoutHelper.createLinear(72,LayoutHelper.MATCH_PARENT));
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, View.MeasureSpec.makeMeasureSpec(AndroidUtilities.dp(40), View.MeasureSpec.EXACTLY));
    }
}
