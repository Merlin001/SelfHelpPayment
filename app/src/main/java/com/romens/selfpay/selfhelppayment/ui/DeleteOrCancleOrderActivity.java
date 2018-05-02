package com.romens.selfpay.selfhelppayment.ui;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.romens.android.ui.Components.LayoutHelper;
import com.romens.images.ui.CloudImageView;
import com.romens.selfpay.selfhelppayment.R;

/**
 * Created by mMerlin on 2018/4/25.
 */

public class DeleteOrCancleOrderActivity extends TransparentBaseActivity {

    private CloudImageView goodImageView;
    private TextView titleView;
    private ImageView goodcarView;
    private TextView goodDetailView;
    private TextView priceView;
    private TextView makesureBtn;
    private TextView cancleBtn;
    public static String DELETE_GOODS = "DELETE_GOODS";
    public static String CANCLE_DEAL = "CANCEL_DEAL";
    private String activityType;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void initView(Context context) {
        WindowManager manager = this.getWindowManager();
        DisplayMetrics outMetrics = new DisplayMetrics();
        manager.getDefaultDisplay().getMetrics(outMetrics);
        int width = outMetrics.widthPixels;
        int width_dp = px2dip(context,width)-32*2;
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setBackgroundColor(Color.WHITE);
        setContentView(linearLayout, LayoutHelper.createFrame(width_dp, (int) (width_dp*1.1),Gravity.CENTER));
        linearLayout.setOrientation(LinearLayout.VERTICAL);
        titleView = new TextView(context);
        titleView.setTextSize(TypedValue.COMPLEX_UNIT_DIP,18);
        titleView.setTextColor(getResources().getColor(R.color.body_text_1));
        titleView.setText("确认删除该产品？");
        linearLayout.addView(titleView,LayoutHelper.createLinear(LayoutHelper.WRAP_CONTENT,LayoutHelper.WRAP_CONTENT, Gravity.CENTER_HORIZONTAL
        ,8,16,8,0));
        goodImageView = CloudImageView.create(context);
        goodImageView.setImagePath(R.drawable.alipay_logo);
        linearLayout.addView(goodImageView,LayoutHelper.createLinear(120,120,Gravity.CENTER_HORIZONTAL,8,16,8,0));

        goodDetailView = new TextView(context);
        goodDetailView.setTextSize(TypedValue.COMPLEX_UNIT_DIP,14);
        goodDetailView.setTextColor(getResources().getColor(R.color.body_text_1));
        goodDetailView.setText("超级能紧致弹力精粹75ml");
        linearLayout.addView(goodDetailView,LayoutHelper.createLinear(LayoutHelper.WRAP_CONTENT,LayoutHelper.WRAP_CONTENT, Gravity.CENTER_HORIZONTAL
                ,8,16,8,0));

        priceView = new TextView(context);
        priceView.setTextSize(TypedValue.COMPLEX_UNIT_DIP,16);
        priceView.setTextColor(getResources().getColor(R.color.md_deep_orange_500));
        priceView.setText("$300");
        linearLayout.addView(priceView,LayoutHelper.createLinear(LayoutHelper.WRAP_CONTENT,LayoutHelper.WRAP_CONTENT, Gravity.CENTER_HORIZONTAL
                ,8,16,8,0));


        LinearLayout btnContainer = new LinearLayout(context);
        btnContainer.setOrientation(LinearLayout.HORIZONTAL);

        cancleBtn = new TextView(context);
        cancleBtn.setClickable(true);
        cancleBtn.setTextSize(TypedValue.COMPLEX_UNIT_DIP,18);
        cancleBtn.setText("取消");
        cancleBtn.setGravity(Gravity.CENTER);
        cancleBtn.setBackgroundResource(R.drawable.btn_normal);

        makesureBtn = new TextView(context);
        makesureBtn.setClickable(true);
        makesureBtn.setTextSize(TypedValue.COMPLEX_UNIT_DIP,18);
        makesureBtn.setText("删除");
        makesureBtn.setGravity(Gravity.CENTER);
        makesureBtn.setBackgroundResource(R.drawable.btn_primary);

        btnContainer.addView(cancleBtn,LayoutHelper.createLinear(0,36,1f,Gravity.CENTER_VERTICAL,8,8,4,8));
        btnContainer.addView(makesureBtn,LayoutHelper.createLinear(0,36,1f,Gravity.CENTER_VERTICAL,8,8,4,8));

        linearLayout.addView(btnContainer,LayoutHelper.createLinear(LayoutHelper.MATCH_PARENT,LayoutHelper.WRAP_CONTENT,8,16,8,8));
    }
}
