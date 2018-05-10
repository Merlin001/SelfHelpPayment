package com.romens.selfpay.selfhelppayment.ui;

import android.content.Context;
import android.graphics.Color;
import android.text.InputType;
import android.util.TypedValue;
import android.view.Gravity;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.romens.android.AndroidUtilities;
import com.romens.android.rx.rxbinding.RxViewAction;
import com.romens.android.ui.Components.LayoutHelper;
import com.romens.selfpay.selfhelppayment.R;
import com.romens.selfpay.selfhelppayment.component.NumberKeyboardView;

import rx.functions.Action1;

/**
 * @author lm
 * @Created 2018/5/2
 * @description
 */

public class ManualInputCodeActivity extends TransparentBaseActivity {
    private  EditText inputView;
    private  NumberKeyboardView keyboardView;

    @Override
    public void initView(Context context) {
        LinearLayout content=new LinearLayout(context);
        content.setOrientation(LinearLayout.VERTICAL);
        content.setPadding(AndroidUtilities.dp(32),AndroidUtilities.dp(80),AndroidUtilities.dp(32),AndroidUtilities.dp(80));
        setContentView(content);
        FrameLayout topLayout=new FrameLayout(context);
        topLayout.setBackgroundColor(0xffffffff);
        content.addView(topLayout, LayoutHelper.createLinear(LayoutHelper.MATCH_PARENT,156));
        ImageView imageView=new ImageView(context);
        imageView.setImageResource(R.drawable.ic_code);
        imageView.setScaleType(ImageView.ScaleType.CENTER);
        topLayout.addView(imageView,LayoutHelper.createFrame(132,132,Gravity.LEFT,8,8,8,8));

        ImageView closeView=new ImageView(context);
        closeView.setImageResource(R.drawable.ic_close_grey600_24dp);
        closeView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        topLayout.addView(closeView,LayoutHelper.createFrame(32,32,Gravity.TOP|Gravity.RIGHT,0,8,8,0));

        TextView textView=new TextView(context);
        textView.setText("请输入\n商品条码下方的数字");
        textView.setTextColor(0xff757575);
        textView.setTextSize(TypedValue.COMPLEX_UNIT_DIP,16);
        textView.setMaxLines(2);
        topLayout.addView(textView,LayoutHelper.createFrame(LayoutHelper.WRAP_CONTENT,LayoutHelper.WRAP_CONTENT,Gravity.LEFT|Gravity.CENTER,140,0,8,0));

        LinearLayout bottomLayout=new LinearLayout(context);
        bottomLayout.setOrientation(LinearLayout.VERTICAL);
        bottomLayout.setBackgroundColor(0xfff0f0f0);
        content.addView(bottomLayout,LayoutHelper.createLinear(LayoutHelper.MATCH_PARENT,LayoutHelper.WRAP_CONTENT));

        inputView=new EditText(context);
        inputView.setMaxLines(1);
        inputView.setTextColor(Color.BLACK);
        inputView.setBackground(null);
        inputView.setHint("8 888888 888888");
        inputView.setHintTextColor(0xffaaaaaa);
        inputView.setTextSize(TypedValue.COMPLEX_UNIT_DIP,28);
        inputView.setInputType(InputType.TYPE_CLASS_NUMBER);
        inputView.setGravity(Gravity.CENTER);
        bottomLayout.addView(inputView,LayoutHelper.createLinear(LayoutHelper.MATCH_PARENT,64,16,0,16,0));
        keyboardView=new NumberKeyboardView(context);
        keyboardView.setMargin(AndroidUtilities.dp(16));
        keyboardView.setTextSize(AndroidUtilities.dp(20));
        bottomLayout.addView(keyboardView,LayoutHelper.createLinear(LayoutHelper.MATCH_PARENT,LayoutHelper.WRAP_CONTENT));

        RxViewAction.click(closeView).subscribe(new Action1() {
            @Override
            public void call(Object o) {
                finish();
            }
        });

        keyboardView.setOnNumberClickListener(new NumberKeyboardView.OnNumberClickListener() {
            @Override
            public void onNumberReturn(String number) {
                StringBuilder info=new StringBuilder(inputView.getText());
                info.append(number);
                inputView.setText(info);
                inputView.setSelection(info.length());

            }

            @Override
            public void onNumberDelete() {
                inputView.setText("");
            }

            @Override
            public void onConfirm() {

            }
        });
    }

}
