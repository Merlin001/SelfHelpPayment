package com.romens.selfpay.selfhelppayment.ui;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.CardView;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.romens.android.AndroidUtilities;
import com.romens.android.ui.ActionBar.ActionBarLayout;
import com.romens.android.ui.Components.LayoutHelper;
import com.romens.selfpay.selfhelppayment.R;

/**
 * Created by mMerlin on 2018/4/24.
 */

public class PayTypeChooseActivity extends TransparentBaseActivity{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        statusBarTransparent();

    }









    @Override
    public void initView(Context context) {
            FrameLayout frameLayout = new FrameLayout(context);
            setContentView(frameLayout);
            ImageView aliPayLogoView = new ImageView(context);
            aliPayLogoView.setImageResource(R.drawable.alipay_logo);
            frameLayout.addView(aliPayLogoView,LayoutHelper.createFrame(LayoutHelper.WRAP_CONTENT,LayoutHelper.WRAP_CONTENT,
                    Gravity.LEFT|Gravity.TOP,16f,16f,0f,0f));
            ImageView closeView = new ImageView(context);
            closeView.setImageResource(R.drawable.close);
            frameLayout.addView(closeView,LayoutHelper.createFrame(LayoutHelper.WRAP_CONTENT,LayoutHelper.WRAP_CONTENT,
                    Gravity.RIGHT|Gravity.TOP,0,16,16,0));

            CardView facePayCard = new CardView(context);
            CardView scancodePayCard = new CardView(context);
            WindowManager manager = this.getWindowManager();
            DisplayMetrics outMetrics = new DisplayMetrics();
            manager.getDefaultDisplay().getMetrics(outMetrics);
            int width = outMetrics.widthPixels;
            int width_dp = px2dip(context,width)-64*2;

            frameLayout.addView(facePayCard,LayoutHelper.createFrame((int) width_dp,width_dp,
                    Gravity.TOP|Gravity.CENTER_HORIZONTAL,64,96,64,80));

            frameLayout.addView(scancodePayCard,LayoutHelper.createFrame((int) width_dp,width_dp,
                    Gravity.TOP|Gravity.CENTER_HORIZONTAL,64,96+width_dp+8,64,80));

    }
}
