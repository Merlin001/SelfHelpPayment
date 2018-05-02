package com.romens.selfpay.selfhelppayment.cell;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
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
import com.romens.android.rx.rxbinding.RxViewAction;
import com.romens.android.ui.Components.LayoutHelper;
import com.romens.selfpay.selfhelppayment.R;

import rx.functions.Action1;

/**
 * @author lm
 * @Created 2018/4/23
 * @description
 */

public class AlipayActionBarCell extends LinearLayout {

    private ImageView  logo;
    private TextView market;
    private TextView leader;
    private LinearLayout cancelBtn;
    private TextView tagView;

    private Paint paint;

    private boolean isCancle=false;

    public AlipayActionBarCell(Context context) {
        super(context);
        initView(context);
    }

    public AlipayActionBarCell(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    public AlipayActionBarCell(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }

    private void initView(Context context){
        if (paint==null){
            paint=new Paint();
            paint.setColor(0xffd9d9d9);
            paint.setStrokeWidth(8);
        }
        setBackgroundColor(getResources().getColor(R.color.white));
        FrameLayout logoLayout=new FrameLayout(context);
        addView(logoLayout, LayoutHelper.createLinear(0,LayoutHelper.MATCH_PARENT,1.0f,8,8,8,8));
        logo=new ImageView(context);
        logo.setImageResource(R.drawable.ic_launcher);
        logo.setScaleType(ImageView.ScaleType.FIT_CENTER);
        logoLayout.addView(logo,LayoutHelper.createFrame(40,40,Gravity.CENTER_VERTICAL));
        LinearLayout linearLayout=new LinearLayout(context);
        linearLayout.setOrientation(VERTICAL);
        logoLayout.addView(linearLayout,LayoutHelper.createFrame(LayoutHelper.WRAP_CONTENT,LayoutHelper.MATCH_PARENT,Gravity.CENTER_VERTICAL,42,0,0,0));
        market=new TextView(context);
        market.setSingleLine();
        market.setTextColor(0xff757575);
        market.setText("青岛雨诺网络科技有限公司");
        market.setTextSize(TypedValue.COMPLEX_UNIT_DIP,16);
        market.setEllipsize(TextUtils.TruncateAt.END);
        market.setGravity(Gravity.CENTER);
        linearLayout.addView(market,LayoutHelper.createLinear(LayoutHelper.WRAP_CONTENT,0,1.0f));
        leader=new TextView(context);
        leader.setTextSize(TypedValue.COMPLEX_UNIT_DIP,14);
        leader.setTextColor(0xffa0a0a0);
        leader.setSingleLine();
        leader.setGravity(Gravity.CENTER);
        leader.setText("雨诺");
        leader.setEllipsize(TextUtils.TruncateAt.END);
        linearLayout.addView(leader,LayoutHelper.createLinear(LayoutHelper.WRAP_CONTENT,0,1.0f));

        cancelBtn=new LinearLayout(context);
        cancelBtn.setOrientation(HORIZONTAL);
        cancelBtn.setBackgroundResource(R.drawable.btn_border_grey);
        cancelBtn.setGravity(Gravity.CENTER);
        addView(cancelBtn,LayoutHelper.createLinear(96,36,Gravity.CENTER_VERTICAL,8,8,8,8));

        tagView=new TextView(context);
        tagView.setBackgroundResource(R.drawable.cancle_btn_grey_circle);
        cancelBtn.addView(tagView,LayoutHelper.createLinear(20,20));

        TextView btnView=new TextView(context);
        btnView.setText("取消交易");
        btnView.setTextSize(TypedValue.COMPLEX_UNIT_DIP,14);
        btnView.setTextColor(0xff212121);
        btnView.setSingleLine();
        cancelBtn.addView(btnView,LayoutHelper.createLinear(LayoutHelper.WRAP_CONTENT,LayoutHelper.WRAP_CONTENT,4,0,0,0));
        RxViewAction.click(cancelBtn).subscribe(new Action1() {
            @Override
            public void call(Object o) {
                isCancle=!isCancle;
                tagView.setBackgroundResource(isCancle?R.drawable.cancle_btn_blue_circle :R.drawable.cancle_btn_grey_circle);
            }
        });

        setWillNotDraw(false);
    }

    public void setCancelBtnVisiblity(boolean visible){
        cancelBtn.setVisibility(visible?VISIBLE:GONE);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, View.MeasureSpec.makeMeasureSpec(AndroidUtilities.dp(56), View.MeasureSpec.EXACTLY));
    }

    @Override
    protected void onDraw(Canvas canvas) {
       canvas.drawLine(0,getHeight(),getWidth(),getHeight(),paint);
    }
}
