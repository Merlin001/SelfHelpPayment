package com.romens.selfpay.selfhelppayment.cell;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.text.SpannableString;
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
import com.romens.android.utils.TextSpannableStringUtils;
import com.romens.selfpay.selfhelppayment.R;

/**
 * @author lm
 * @Created 2018/4/23
 * @description
 */

public class PayResultCell extends LinearLayout {
    private ImageView imageView;
    private TextView payStateView;
    private TextView userView;
    private TextView sumView;
    private TextView numView;

    private Paint paint;
    public PayResultCell(Context context) {
        super(context);
        initView(context);
    }

    public PayResultCell(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    public PayResultCell(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }

    private void initView(Context context){
        if (paint==null){
            paint=new Paint();
            paint.setColor(0xffd9d9d9);
            paint.setStrokeWidth(1);
        }
        setGravity(Gravity.CENTER_VERTICAL);
        FrameLayout frameLayout=new FrameLayout(context);
        addView(frameLayout, LayoutHelper.createLinear(0,LayoutHelper.MATCH_PARENT,1.0f,0,0,8,0));
        imageView=new ImageView(context);
        imageView.setImageResource(R.drawable.done_circle);
        imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        frameLayout.addView(imageView,LayoutHelper.createFrame(32,32, Gravity.CENTER_VERTICAL));
        LinearLayout linearLayout=new LinearLayout(context);
        linearLayout.setOrientation(VERTICAL);
        linearLayout.setGravity(Gravity.LEFT|Gravity.CENTER_VERTICAL);
        frameLayout.addView(linearLayout,LayoutHelper.createFrame(LayoutHelper.WRAP_CONTENT,LayoutHelper.MATCH_PARENT,Gravity.CENTER_VERTICAL,36,0,0,0));
        payStateView =new TextView(context);
        payStateView.setSingleLine();
        payStateView.setTextColor(0xff757575);
        payStateView.setText("支付宝付款成功");
        payStateView.setTextSize(TypedValue.COMPLEX_UNIT_DIP,20);
        payStateView.setEllipsize(TextUtils.TruncateAt.END);
        payStateView.setGravity(Gravity.CENTER);
        linearLayout.addView(payStateView,LayoutHelper.createLinear(LayoutHelper.WRAP_CONTENT,LayoutHelper.WRAP_CONTENT));
        userView=new TextView(context);
        userView.setTextSize(TypedValue.COMPLEX_UNIT_DIP,12);
        userView.setTextColor(0xffbbbbbb);
        userView.setSingleLine();
        userView.setGravity(Gravity.CENTER);
        userView.setText("支付宝账号185****570");
        userView.setEllipsize(TextUtils.TruncateAt.END);
        linearLayout.addView(userView,LayoutHelper.createLinear(LayoutHelper.WRAP_CONTENT,LayoutHelper.WRAP_CONTENT));

        LinearLayout sumLayout=new LinearLayout(context);
        sumLayout.setOrientation(VERTICAL);
        sumLayout.setGravity(Gravity.RIGHT|Gravity.CENTER_VERTICAL);
        addView(sumLayout,LayoutHelper.createLinear(96,LayoutHelper.MATCH_PARENT,Gravity.CENTER_VERTICAL));

        sumView=new TextView(context);
        sumView.setText("¥2965.00");
        sumView.setTextSize(TypedValue.COMPLEX_UNIT_DIP,20);
        sumView.setTextColor(0xff212121);
        sumView.setSingleLine();
        sumLayout.addView(sumView,LayoutHelper.createLinear(LayoutHelper.WRAP_CONTENT,LayoutHelper.WRAP_CONTENT));

        numView=new TextView(context);
        String str="共 5 件商品";
        SpannableString span = new SpannableString(str);
        TextSpannableStringUtils.setForegroundColorSpan(span,0xff757575,2,3);
        numView.setText(span);
        numView.setTextSize(TypedValue.COMPLEX_UNIT_DIP,12);
        numView.setTextColor(0xffaaaaaa);
        numView.setSingleLine();
        sumLayout.addView(numView,LayoutHelper.createLinear(LayoutHelper.WRAP_CONTENT,LayoutHelper.WRAP_CONTENT));

        setWillNotDraw(false);
    }

    public void setValue(String payState){
        payStateView.setText(payState);
    }

    public void setStateImge(int resId){
        imageView.setImageResource(resId);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, View.MeasureSpec.makeMeasureSpec(AndroidUtilities.dp(78), View.MeasureSpec.EXACTLY));
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawLine(0,getHeight()-AndroidUtilities.dp(8),getWidth(),getHeight()-AndroidUtilities.dp(8),paint);
    }
}
