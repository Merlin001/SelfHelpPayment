package com.romens.selfpay.selfhelppayment.ui;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.TextAppearanceSpan;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.romens.android.AndroidUtilities;
import com.romens.android.rx.rxbinding.RxViewAction;
import com.romens.android.ui.Components.LayoutHelper;
import com.romens.selfpay.selfhelppayment.R;
import com.romens.selfpay.selfhelppayment.cell.AlipayLogoCell;
import com.romens.selfpay.selfhelppayment.cell.HomeLogoCell;
import com.romens.selfpay.selfhelppayment.cell.TrigonView;

import rx.functions.Action1;

/**
 * @author lm
 * @Created 2018/4/24
 * @description
 */

public class HomeActivity extends AppCompatActivity {

    private TextView emptyView;
    private TrigonView trigonView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LinearLayout container=new LinearLayout(this);
        container.setOrientation(LinearLayout.VERTICAL);
        setContentView(container);

        FrameLayout topLayout=new FrameLayout(this);
        topLayout.setBackgroundColor(0xfff0f0f0);
        container.addView(topLayout, LayoutHelper.createLinear(LayoutHelper.MATCH_PARENT,0,1.1f));
        AlipayLogoCell logoCell=new AlipayLogoCell(this);
        topLayout.addView(logoCell,LayoutHelper.createFrame(LayoutHelper.MATCH_PARENT,LayoutHelper.WRAP_CONTENT,Gravity.TOP,20,20,20,0));
        HomeLogoCell cell=new HomeLogoCell(this);
        topLayout.addView(cell,LayoutHelper.createFrame(LayoutHelper.MATCH_PARENT,LayoutHelper.WRAP_CONTENT,Gravity.BOTTOM,20,0,20,20));
        emptyView=new TextView(this);
        emptyView.setBackgroundColor(0x88323232);
        emptyView.setVisibility(View.GONE);
        topLayout.addView(emptyView,LayoutHelper.createFrame(LayoutHelper.MATCH_PARENT,LayoutHelper.MATCH_PARENT));

        LinearLayout bottomLayout=new LinearLayout(this);
        bottomLayout.setOrientation(LinearLayout.VERTICAL);
        container.addView(bottomLayout, LayoutHelper.createLinear(LayoutHelper.MATCH_PARENT,0,1.9f));
        TextView handView=new TextView(this);
        handView.setTextSize(TypedValue.COMPLEX_UNIT_DIP,14);
        handView.setTextColor(0xff42A5F5);
        handView.setText("手动结账");
        handView.setSingleLine();
        bottomLayout.addView(handView,LayoutHelper.createLinear(LayoutHelper.WRAP_CONTENT,LayoutHelper.WRAP_CONTENT,Gravity.RIGHT,0,8,16,0));

        TextView hintView=new TextView(this);
        hintView.setText(setTextStyle("把商品条码对准下方扫码口\n开始自助结账"));
        hintView.setTextColor(0xff757575);
        hintView.setTextSize(TypedValue.COMPLEX_UNIT_DIP,18);
        hintView.setMaxLines(2);
        hintView.setGravity(Gravity.CENTER);
        bottomLayout.addView(hintView,LayoutHelper.createLinear(LayoutHelper.MATCH_PARENT,LayoutHelper.WRAP_CONTENT,0,8,0,0));

        ImageView scanCodeImage=new ImageView(this);
        scanCodeImage.setImageResource(R.drawable.ic_launcher);
        scanCodeImage.setBackgroundColor(0xffaaaaaa);
        bottomLayout.addView(scanCodeImage,LayoutHelper.createLinear(164,120,Gravity.CENTER_HORIZONTAL, 0,20,0,20));
        trigonView=new TrigonView(this);
        bottomLayout.addView(trigonView,LayoutHelper.createLinear(LayoutHelper.WRAP_CONTENT,LayoutHelper.WRAP_CONTENT));

        RxViewAction.clickNoDouble(topLayout).subscribe(new Action1() {
            @Override
            public void call(Object o) {
                emptyView.setVisibility(View.GONE);
                startActivity(new Intent(HomeActivity.this,AlipayScanCodePayActivity.class));
            }
        });
        RxViewAction.clickNoDouble(bottomLayout).subscribe(new Action1() {
            @Override
            public void call(Object o) {
                emptyView.setVisibility(View.VISIBLE);
                animation(trigonView);
            }
        });

        RxViewAction.clickNoDouble(scanCodeImage).subscribe(new Action1() {
            @Override
            public void call(Object o) {
                startActivity(new Intent(HomeActivity.this,AlipayFailPayActivity.class));
            }
        });
    }

    private CharSequence setTextStyle(String str){
        SpannableString span = new SpannableString(str);
        ColorStateList textColor = ColorStateList.valueOf(0xff212121);
        span.setSpan(new TextAppearanceSpan(null,0,AndroidUtilities.dp(20),textColor,null),
                13,span.length(), Spanned.SPAN_EXCLUSIVE_INCLUSIVE);
        return span;
    }

    private void animation(View view){
        Animation animation = new TranslateAnimation(0, 0,
                view.getHeight()- AndroidUtilities.dp(16), view.getHeight()+ AndroidUtilities.dp(16));
        animation.setDuration(400);
        animation.setRepeatCount(500000);
        view.startAnimation(animation);
//        animation.setAnimationListener(new Animation.AnimationListener() {
//            @Override
//            public void onAnimationStart(Animation animation) {
//
//            }
//
//            @Override
//            public void onAnimationEnd(Animation animation) {
//                animation.reset();
//                animation.setAnimationListener(this);
//                animation.start();
//            }
//
//            @Override
//            public void onAnimationRepeat(Animation animation) {
//
//            }
//        });
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        trigonView.clearAnimation();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        trigonView.clearAnimation();
    }
}
