package com.romens.selfpay.selfhelppayment.ui.test;

import android.content.Context;
import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.romens.android.AndroidUtilities;
import com.romens.android.rx.rxbinding.RxViewAction;
import com.romens.android.ui.Components.LayoutHelper;
import com.romens.selfpay.selfhelppayment.R;
import com.romens.selfpay.selfhelppayment.cell.GoodsListCell;
import com.romens.selfpay.selfhelppayment.cell.SelectBagCell;
import com.romens.selfpay.selfhelppayment.ui.ManualInputCodeActivity;
import com.romens.selfpay.selfhelppayment.ui.fragment.ManualInputCodeFragment;

import rx.functions.Action1;

import static android.widget.LinearLayout.HORIZONTAL;

/**
 * @author lm
 * @Created 2018/4/28
 * @description
 */

public class TestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LinearLayout content=new LinearLayout(this);
        content.setOrientation(LinearLayout.VERTICAL);
        setContentView(content);
//        GoodsListCell cell=new GoodsListCell(this);
//        cell.setCount(1);
//        cell.setValue("爱他美婴儿奶粉800克", R.drawable.ic_launcher,"¥1500",null);
//        content.addView(cell, LayoutHelper.createLinear(LayoutHelper.MATCH_PARENT,LayoutHelper.WRAP_CONTENT));
//        SelectBagCell bagcell=new SelectBagCell(this);
//        content.addView(bagcell,LayoutHelper.createLinear(LayoutHelper.MATCH_PARENT,LayoutHelper.WRAP_CONTENT));
//        RxViewAction.click(content).subscribe(new Action1() {
//            @Override
//            public void call(Object o) {
//                startActivity(new Intent(TestActivity.this, ManualInputCodeActivity.class));
//            }
//        });
//        ManualInputCodeFragment fragment=new ManualInputCodeFragment();
//        getSupportFragmentManager().beginTransaction().replace()

        content.setBackgroundColor(0xfff0f0f0);
        final LinearLayout linearLayout=new LinearLayout(this);
        linearLayout.setOrientation(LinearLayout.VERTICAL);
        linearLayout.setBackgroundColor(0xffffffff);
        linearLayout.setGravity(Gravity.CENTER);
        content.addView(linearLayout,LayoutHelper.createLinear(260,280,Gravity.CENTER_HORIZONTAL, 0,16,0,16));
        ImageView imageView=new ImageView(this);
        imageView.setScaleType(ImageView.ScaleType.CENTER);
        imageView.setImageResource(R.drawable.ic_launcher);
        linearLayout.addView(imageView,LayoutHelper.createLinear(LayoutHelper.MATCH_PARENT,0,0.6f));

        TextView nameView=new TextView(this);
        nameView.setTextSize(TypedValue.COMPLEX_UNIT_DIP,14);
        nameView.setText("SK-11 R.N.A.超肌能紧致弹力精粹75ml");
        nameView.setTextColor(0xff212121);
        linearLayout.addView(nameView,LayoutHelper.createLinear(LayoutHelper.WRAP_CONTENT,LayoutHelper.WRAP_CONTENT,0,16,0,16));

        TextView priceView=new TextView(this);
        priceView.setTextSize(TypedValue.COMPLEX_UNIT_DIP,18);
        priceView.setText("￥1098");
        priceView.setTextColor(0xffff9800);
        linearLayout.addView(priceView,LayoutHelper.createLinear(LayoutHelper.WRAP_CONTENT,LayoutHelper.WRAP_CONTENT,0,8,0,4));

        LinearLayout primeLayout=new LinearLayout(this);
        primeLayout.setOrientation(HORIZONTAL);
        linearLayout.addView(primeLayout,LayoutHelper.createLinear(LayoutHelper.WRAP_CONTENT,LayoutHelper.WRAP_CONTENT,0,0,0,16));
        TextView textView=new TextView(this);
        textView.setText("原价: ");
        textView.setTextColor(0xffaaaaaa);
        textView.setTextSize(TypedValue.COMPLEX_UNIT_DIP,14);
        primeLayout.addView(textView,LayoutHelper.createLinear(LayoutHelper.WRAP_CONTENT,LayoutHelper.WRAP_CONTENT));
        TextView primePriceView=new TextView(this);
        primePriceView.setTextSize(TypedValue.COMPLEX_UNIT_DIP,14);
        primePriceView.setTextColor(0xffaaaaaa);
        primePriceView.setText("1299");
        primePriceView.getPaint().setFlags(Paint. STRIKE_THRU_TEXT_FLAG);
        primePriceView.setSingleLine();
        primeLayout.addView(primePriceView,LayoutHelper.createLinear(LayoutHelper.WRAP_CONTENT,LayoutHelper.WRAP_CONTENT,4,0,0,0));

        RxViewAction.clickNoDouble(linearLayout).subscribe(new Action1() {
            @Override
            public void call(Object o) {
                setAnimation(linearLayout);
            }
        });
    }

    private void setAnimation(View view){
        Animation mScaleAnimation = new ScaleAnimation(1, 0.4f, 1,0.4f,
                Animation.INFINITE, 0.5f,
                Animation.INFINITE, 0.5f);
        mScaleAnimation.setDuration(1000);
        mScaleAnimation.setFillAfter(true);
        WindowManager wm = (WindowManager) this
                .getSystemService(Context.WINDOW_SERVICE);
        int width = wm.getDefaultDisplay().getWidth();

        Animation mTranslateAnimation = new TranslateAnimation(0,-(width-view.getWidth())/2,0, -AndroidUtilities.dp(16));// 移动
        mTranslateAnimation.setDuration(1000);
        AnimationSet mAnimationSet=new AnimationSet(false);
        mAnimationSet.addAnimation(mScaleAnimation);
        mAnimationSet.setFillAfter(true);
        mAnimationSet.addAnimation(mTranslateAnimation);

        view.startAnimation(mAnimationSet);
    }
}
