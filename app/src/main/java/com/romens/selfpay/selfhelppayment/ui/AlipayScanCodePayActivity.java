package com.romens.selfpay.selfhelppayment.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.util.TypedValue;
import android.view.Gravity;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.romens.android.rx.rxbinding.RxViewAction;
import com.romens.android.ui.Components.LayoutHelper;
import com.romens.selfpay.selfhelppayment.R;
import com.romens.selfpay.selfhelppayment.cell.AlipayActionBarCell;
import com.romens.selfpay.selfhelppayment.cell.CountDownTextView;

import rx.functions.Action1;


/**
 * @author lm
 * @Created 2018/4/23
 * @description
 */

public class AlipayScanCodePayActivity extends AppCompatActivity{
    private CountDownTextView timeView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LinearLayout container=new LinearLayout(this);
        container.setOrientation(LinearLayout.VERTICAL);
        container.setGravity(Gravity.CENTER_HORIZONTAL);
        AlipayActionBarCell actionBar=new AlipayActionBarCell(this);
        container.addView(actionBar, LayoutHelper.createLinear(LayoutHelper.MATCH_PARENT,LayoutHelper.WRAP_CONTENT));
        setContentView(container);

        TextView hintView=new TextView(this);
        hintView.setTextColor(0xff757575);
        hintView.setTextSize(TypedValue.COMPLEX_UNIT_DIP,20);
        hintView.setText("请打开支付宝[付款码]\n对准下方扫码口");
        hintView.setMaxLines(2);
        hintView.setGravity(Gravity.CENTER);
        container.addView(hintView,LayoutHelper.createLinear(LayoutHelper.MATCH_PARENT,LayoutHelper.WRAP_CONTENT,0,36,0,0));
        TextView sumView=new TextView(this);
        sumView.setTextColor(0xff212121);
        sumView.setTextSize(TypedValue.COMPLEX_UNIT_DIP,24);
        sumView.setText("支付￥2965.00");
        sumView.setMaxLines(1);
        sumView.setSingleLine();
        sumView.setGravity(Gravity.CENTER);
        container.addView(sumView,LayoutHelper.createLinear(LayoutHelper.MATCH_PARENT,LayoutHelper.WRAP_CONTENT,0,36,0,0));
        timeView=new CountDownTextView(this);
//        String str="请在 120 秒内支付完成";
//        timeView.setValue(setTextStyle(str));
        container.addView(timeView,LayoutHelper.createLinear(LayoutHelper.MATCH_PARENT,LayoutHelper.WRAP_CONTENT,0,36,0,0));

        ImageView imageView=new ImageView(this);
        imageView.setScaleType(ImageView.ScaleType.CENTER);
        imageView.setImageResource(R.drawable.ic_code_pay);
        container.addView(imageView,LayoutHelper.createLinear(156,156,0,36,0,0));

        RxViewAction.clickNoDouble(imageView).subscribe(new Action1() {
            @Override
            public void call(Object o) {
                startActivity(new Intent(AlipayScanCodePayActivity.this,AlipaySucessPayActivity.class));
            }
        });
        timer.start();
    }

    private CountDownTimer timer = new CountDownTimer(120*1000, 1000) {
        @Override
        public void onTick(long millisUntilFinished) {
            String str="请在 "+millisUntilFinished/1000+" 秒内支付完成";
            timeView.setValue(setTextStyle(str));
        }
        @Override
        public void onFinish() {
//            finish();
        }
    };

    private SpannableString setTextStyle(String str){
        SpannableString span = new SpannableString(str);
        for (int i = 0; i < str.length(); i++) {
            char a = str.charAt(i);
            if (a >= '0' && a <= '9') {
                span.setSpan(new ForegroundColorSpan(0xff757575), i, i + 1, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            }
        }
        return span;
    }
}
