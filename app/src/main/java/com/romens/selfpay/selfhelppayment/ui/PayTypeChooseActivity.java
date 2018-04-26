package com.romens.selfpay.selfhelppayment.ui;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.romens.android.ui.ActionBar.ActionBarLayout;
import com.romens.android.ui.Components.LayoutHelper;
import com.romens.selfpay.selfhelppayment.R;

/**
 * Created by mMerlin on 2018/4/24.
 */

public class PayTypeChooseActivity extends Activity{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        statusBarTransparent();
        initView(PayTypeChooseActivity.this);
    }

    public void initView(Context context){
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


    }

    @Override
    protected void onPause() {
        overridePendingTransition(0,0);
        super.onPause();
    }
    public void statusBarTransparent(){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {//5.0及以上
            View decorView = getWindow().getDecorView();
            int option = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
            decorView.setSystemUiVisibility(option);
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {//4.4到5.0
            WindowManager.LayoutParams localLayoutParams = getWindow().getAttributes();
            localLayoutParams.flags = (WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS | localLayoutParams.flags);
        }
    }
}
