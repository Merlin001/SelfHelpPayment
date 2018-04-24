package com.romens.selfpay.selfhelppayment.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.TypedValue;
import android.view.Gravity;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.romens.android.rx.rxbinding.RxViewAction;
import com.romens.android.ui.Components.LayoutHelper;
import com.romens.selfpay.selfhelppayment.cell.AlipayLogoCell;

import rx.functions.Action1;

/**
 * @author lm
 * @Created 2018/4/24
 * @description
 */

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LinearLayout container=new LinearLayout(this);
        setContentView(container);
        LinearLayout topLayout=new LinearLayout(this);
        topLayout.setBackgroundColor(0xffaaaaaa);
        container.addView(topLayout, LayoutHelper.createLinear(LayoutHelper.MATCH_PARENT,0,1.0f));
        AlipayLogoCell logoCell=new AlipayLogoCell(this);
        topLayout.addView(logoCell,LayoutHelper.createLinear(LayoutHelper.WRAP_CONTENT,LayoutHelper.WRAP_CONTENT, Gravity.CENTER));

        LinearLayout bottomLayout=new LinearLayout(this);
        bottomLayout.setGravity(Gravity.CENTER_HORIZONTAL);
        container.addView(bottomLayout, LayoutHelper.createLinear(LayoutHelper.MATCH_PARENT,0,2.0f));
        TextView hintView=new TextView(this);
        hintView.setText("请把商品条码对准下方扫码口\n开始自助结账");
        hintView.setTextColor(0xff757575);
        hintView.setTextSize(TypedValue.COMPLEX_UNIT_DIP,20);
        hintView.setMaxLines(2);
        hintView.setGravity(Gravity.CENTER);
        bottomLayout.addView(hintView,LayoutHelper.createLinear(LayoutHelper.WRAP_CONTENT,LayoutHelper.MATCH_PARENT,0,20,0,0));

        RxViewAction.clickNoDouble(logoCell).subscribe(new Action1() {
            @Override
            public void call(Object o) {
                startActivity(new Intent(HomeActivity.this,AlipayScanCodePayActivity.class));
            }
        });

    }
}
