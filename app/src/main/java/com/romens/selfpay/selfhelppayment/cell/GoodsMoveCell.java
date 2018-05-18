package com.romens.selfpay.selfhelppayment.cell;

import android.content.Context;
import android.graphics.Paint;
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

import java.util.Timer;
import java.util.TimerTask;

/**
 * @author lm
 * @Created 2018/5/18
 * @description
 */

public class GoodsMoveCell extends LinearLayout {

    public GoodsMoveCell(Context context) {
        super(context);
        initView(context);
    }

    public GoodsMoveCell(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    public GoodsMoveCell(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }

    private void initView(Context context){
        setOrientation(LinearLayout.VERTICAL);
        setBackgroundColor(0xffffffff);
        setGravity(Gravity.CENTER);
        ImageView imageView=new ImageView(context);
        imageView.setScaleType(ImageView.ScaleType.CENTER);
        imageView.setImageResource(R.drawable.ic_launcher);
        addView(imageView,LayoutHelper.createLinear(LayoutHelper.MATCH_PARENT,0,0.6f));

        TextView nameView=new TextView(context);
        nameView.setTextSize(TypedValue.COMPLEX_UNIT_DIP,14);
        nameView.setText("SK-11 R.N.A.超肌能紧致弹力精粹75ml");
        nameView.setTextColor(0xff212121);
        addView(nameView,LayoutHelper.createLinear(LayoutHelper.WRAP_CONTENT,LayoutHelper.WRAP_CONTENT,0,16,0,16));

        TextView priceView=new TextView(context);
        priceView.setTextSize(TypedValue.COMPLEX_UNIT_DIP,18);
        priceView.setText("￥1098");
        priceView.setTextColor(0xffff9800);
        addView(priceView,LayoutHelper.createLinear(LayoutHelper.WRAP_CONTENT,LayoutHelper.WRAP_CONTENT,0,8,0,4));

        LinearLayout primeLayout=new LinearLayout(context);
        primeLayout.setOrientation(HORIZONTAL);
        addView(primeLayout,LayoutHelper.createLinear(LayoutHelper.WRAP_CONTENT,LayoutHelper.WRAP_CONTENT,0,0,0,16));
        TextView textView=new TextView(context);
        textView.setText("原价: ");
        textView.setTextColor(0xffaaaaaa);
        textView.setTextSize(TypedValue.COMPLEX_UNIT_DIP,14);
        primeLayout.addView(textView,LayoutHelper.createLinear(LayoutHelper.WRAP_CONTENT,LayoutHelper.WRAP_CONTENT));
        TextView primePriceView=new TextView(context);
        primePriceView.setTextSize(TypedValue.COMPLEX_UNIT_DIP,14);
        primePriceView.setTextColor(0xffaaaaaa);
        primePriceView.setText("1299");
        primePriceView.getPaint().setFlags(Paint. STRIKE_THRU_TEXT_FLAG);
        primePriceView.setSingleLine();
        primeLayout.addView(primePriceView,LayoutHelper.createLinear(LayoutHelper.WRAP_CONTENT,LayoutHelper.WRAP_CONTENT,4,0,0,0));
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, View.MeasureSpec.makeMeasureSpec(AndroidUtilities.dp(280),MeasureSpec.EXACTLY));
    }
}
