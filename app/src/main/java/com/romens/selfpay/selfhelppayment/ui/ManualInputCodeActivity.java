package com.romens.selfpay.selfhelppayment.ui;

import android.content.Context;
import android.graphics.Color;
import android.renderscript.ScriptGroup;
import android.text.InputType;
import android.util.TypedValue;
import android.view.Gravity;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.romens.android.AndroidUtilities;
import com.romens.android.ui.Components.LayoutHelper;
import com.romens.selfpay.selfhelppayment.R;
import com.romens.selfpay.selfhelppayment.component.NumberKeyboardView;

/**
 * @author lm
 * @Created 2018/5/2
 * @description
 */

public class ManualInputCodeActivity extends TransparentBaseActivity {
    @Override
    public void initView(Context context) {
        LinearLayout content=new LinearLayout(context);
        content.setOrientation(LinearLayout.VERTICAL);
//        content.setBackgroundColor(0xffffffff);
        content.setPadding(AndroidUtilities.dp(32),AndroidUtilities.dp(40),AndroidUtilities.dp(32),AndroidUtilities.dp(40));
        setContentView(content);
        FrameLayout topLayout=new FrameLayout(context);
        topLayout.setBackgroundColor(0xffffffff);
        content.addView(topLayout, LayoutHelper.createLinear(LayoutHelper.MATCH_PARENT,148));
        ImageView imageView=new ImageView(context);
//        imageView.setImageResource();
//        imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        imageView.setBackgroundColor(0xfff0f0f0);
        topLayout.addView(imageView,LayoutHelper.createFrame(140,140,Gravity.LEFT,8,8,8,8));

        ImageView closeView=new ImageView(context);
        closeView.setImageResource(R.drawable.ic_close_grey600_24dp);
        closeView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        topLayout.addView(closeView,LayoutHelper.createFrame(24,24,Gravity.TOP|Gravity.RIGHT,8,16,16,16));

        TextView textView=new TextView(context);
        textView.setText("请输入\n商品条码下方的数字");
        textView.setTextColor(0xff757575);
        textView.setTextSize(TypedValue.COMPLEX_UNIT_DIP,16);
        textView.setMaxLines(2);
        topLayout.addView(textView,LayoutHelper.createFrame(LayoutHelper.WRAP_CONTENT,LayoutHelper.WRAP_CONTENT,Gravity.LEFT|Gravity.CENTER,156,0,0,0));

        LinearLayout bottomLayout=new LinearLayout(context);
        bottomLayout.setOrientation(LinearLayout.VERTICAL);
        bottomLayout.setBackgroundColor(0xfff0f0f0);
        content.addView(bottomLayout,LayoutHelper.createLinear(LayoutHelper.MATCH_PARENT,LayoutHelper.WRAP_CONTENT));
        EditText inputView=new EditText(context);
        inputView.setMaxLines(1);
        inputView.setHint("8 888888 888888");
        inputView.setTextColor(Color.BLACK);
        inputView.setTextSize(TypedValue.COMPLEX_UNIT_DIP,20);
        inputView.setInputType(InputType.TYPE_CLASS_NUMBER);
        inputView.setGravity(Gravity.CENTER);
        bottomLayout.addView(inputView,LayoutHelper.createLinear(LayoutHelper.MATCH_PARENT,56,16,0,16,0));
        NumberKeyboardView keyboardView=new NumberKeyboardView(context);
        bottomLayout.addView(keyboardView,LayoutHelper.createLinear(LayoutHelper.MATCH_PARENT,LayoutHelper.WRAP_CONTENT));
    }
}
