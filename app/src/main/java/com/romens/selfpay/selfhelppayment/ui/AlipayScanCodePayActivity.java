package com.romens.selfpay.selfhelppayment.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.TypedValue;
import android.view.Gravity;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.romens.android.rx.rxbinding.RxViewAction;
import com.romens.android.ui.Components.LayoutHelper;
import com.romens.selfpay.selfhelppayment.R;
import com.romens.selfpay.selfhelppayment.cell.AlipayActionBarCell;

import rx.functions.Action1;


/**
 * @author lm
 * @Created 2018/4/23
 * @description
 */

public class AlipayScanCodePayActivity extends AppCompatActivity{
    private TextView timeView;

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
        container.addView(hintView,LayoutHelper.createLinear(LayoutHelper.MATCH_PARENT,LayoutHelper.WRAP_CONTENT,0,40,0,0));
        TextView sumView=new TextView(this);
        sumView.setTextColor(0xff212121);
        sumView.setTextSize(TypedValue.COMPLEX_UNIT_DIP,24);
        sumView.setText("支付￥2965.00");
        sumView.setMaxLines(1);
        sumView.setSingleLine();
        sumView.setGravity(Gravity.CENTER);
        container.addView(sumView,LayoutHelper.createLinear(LayoutHelper.MATCH_PARENT,LayoutHelper.WRAP_CONTENT,0,40,0,0));

        timeView=new TextView(this);
        timeView.setTextColor(0xffaaaaaa);
        timeView.setTextSize(TypedValue.COMPLEX_UNIT_DIP,12);
        timeView.setText("————————     请在120秒内完成支付     ————————");
        timeView.setMaxLines(1);
        timeView.setSingleLine();
        timeView.setGravity(Gravity.CENTER);
        container.addView(timeView,LayoutHelper.createLinear(LayoutHelper.MATCH_PARENT,LayoutHelper.WRAP_CONTENT,0,40,0,0));

        ImageView imageView=new ImageView(this);
        imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        imageView.setImageResource(R.drawable.ic_launcher);
        container.addView(imageView,LayoutHelper.createLinear(156,156,0,40,0,0));

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
            timeView.setText("————————     请在"+millisUntilFinished/1000+"秒内完成支付     ————————");
        }
        @Override
        public void onFinish() {
//            finish();
        }
    };
}
