package com.romens.selfpay.selfhelppayment.ui.test;

import android.content.Context;
import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.os.Handler;
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
import com.romens.selfpay.selfhelppayment.cell.GoodsMoveCell;
import com.romens.selfpay.selfhelppayment.cell.SelectBagCell;
import com.romens.selfpay.selfhelppayment.ui.ManualInputCodeActivity;
import com.romens.selfpay.selfhelppayment.ui.fragment.ManualInputCodeFragment;

import java.util.Timer;
import java.util.TimerTask;

import rx.functions.Action1;

import static android.widget.LinearLayout.HORIZONTAL;

/**
 * @author lm
 * @Created 2018/4/28
 * @description
 */

public class TestActivity extends AppCompatActivity {
    private  GoodsMoveCell moveCell;

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
        moveCell=new GoodsMoveCell(this);
        content.addView(moveCell,LayoutHelper.createLinear(240,LayoutHelper.WRAP_CONTENT,Gravity.CENTER_HORIZONTAL,0,16,0,16));
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
              setAnimation(moveCell);
            }
        }, 500);//3秒后执行Runnable中的run方法

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
