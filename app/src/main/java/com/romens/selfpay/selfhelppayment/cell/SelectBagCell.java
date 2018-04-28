package com.romens.selfpay.selfhelppayment.cell;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;

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

public class SelectBagCell extends LinearLayout{
    private TSTextCell smallCell;
    private TSTextCell medCell;
    private TSTextCell bigCell;
    private boolean isSelectSamll=false;
    private boolean isSelectMed=false;
    private boolean isSelectBig=false;

    public SelectBagCell(Context context) {
        super(context);
        initView(context);
    }

    public SelectBagCell(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    public SelectBagCell(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }

    private void initView(Context context){
        setOrientation(HORIZONTAL);
        setGravity(Gravity.CENTER_VERTICAL);
        smallCell=new TSTextCell(context);
        smallCell.setValue("小购物袋","￥0.2");
        addView(smallCell, LayoutHelper.createLinear(0,LayoutHelper.MATCH_PARENT,1.0f,16,0,8,0));
        medCell=new TSTextCell(context);
        medCell.setValue("中购物袋","￥0.5");
        addView(medCell, LayoutHelper.createLinear(0,LayoutHelper.MATCH_PARENT,1.0f,8,0,8,0));
        bigCell=new TSTextCell(context);
        bigCell.setValue("大购物袋","￥0.8");
        addView(bigCell, LayoutHelper.createLinear(0,LayoutHelper.MATCH_PARENT,1.0f,8,0,16,0));

        RxViewAction.click(smallCell).subscribe(new Action1() {
            @Override
            public void call(Object o) {
                isSelectSamll=!isSelectSamll;
                setSlectStyle(isSelectSamll,false,false);
            }
        });
        RxViewAction.click(medCell).subscribe(new Action1() {
            @Override
            public void call(Object o) {
                isSelectMed=!isSelectMed;
                setSlectStyle(false,isSelectMed,false);
          }
        });
        RxViewAction.click(bigCell).subscribe(new Action1() {
            @Override
            public void call(Object o) {
                isSelectBig=!isSelectBig;
                setSlectStyle(false,false,isSelectBig);
            }
        });
    }

    private void setSlectStyle(boolean isSmall,boolean isMedium,boolean isBig){
        isSelectSamll=isSmall;
        isSelectMed=isMedium;
        isSelectBig=isBig;
        smallCell.setBackgroundResource(isSelectSamll? R.drawable.btn_primary_border:R.drawable.btn_normal_border);
        medCell.setBackgroundResource(isSelectMed? R.drawable.btn_primary_border:R.drawable.btn_normal_border);
        bigCell.setBackgroundResource(isSelectBig? R.drawable.btn_primary_border:R.drawable.btn_normal_border);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, View.MeasureSpec.makeMeasureSpec(AndroidUtilities.dp(56),MeasureSpec.EXACTLY));
    }
}
