package com.romens.selfpay.selfhelppayment.cell;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.romens.android.AndroidUtilities;
import com.romens.android.rx.rxbinding.RxViewAction;
import com.romens.android.ui.Components.LayoutHelper;
import com.romens.selfpay.selfhelppayment.R;

import rx.functions.Action1;


/**
 * @author lm
 * @Created 2018/4/27
 * @description
 */

public class GoodsListCell extends LinearLayout {
    private ImageView imageView;
    private TextView nameView;
    private TextView realPriceView;
    private TextView primePriceView;

    private TextView disView;
    private TextView countView;
    private TextView addView;

    private int count;
    private Delegate delegate;

    public void setDelegate(Delegate delegate) {
        this.delegate = delegate;
    }

    public GoodsListCell(Context context) {
        super(context);
        initView(context);
    }

    public GoodsListCell(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    public GoodsListCell(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }

    private void initView(final Context context){
        setPadding(AndroidUtilities.dp(8),AndroidUtilities.dp(8),AndroidUtilities.dp(8),AndroidUtilities.dp(8));
        setOrientation(HORIZONTAL);
        imageView=new ImageView(context);
        imageView.setImageResource(R.drawable.ic_launcher);
        imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        imageView.setBackgroundColor(0xfff0f0f0);
        addView(imageView, LayoutHelper.createLinear(96,96,8,0,0,0));
        LinearLayout linearLayout=new LinearLayout(context);
        linearLayout.setOrientation(VERTICAL);
        addView(linearLayout,LayoutHelper.createLinear(0,LayoutHelper.MATCH_PARENT,1.0f,8,0,8,0));
        LinearLayout topLayout=new LinearLayout(context);
        topLayout.setOrientation(HORIZONTAL);
        topLayout.setGravity(Gravity.CENTER_VERTICAL);
        linearLayout.addView(topLayout,LayoutHelper.createLinear(LayoutHelper.MATCH_PARENT,0,1.0f));
        nameView=new TextView(context);
        nameView.setText("爱他美婴儿奶粉800克");
        nameView.setTextSize(TypedValue.COMPLEX_UNIT_DIP,16);
        nameView.setTextColor(0xff757575);
        nameView.setMaxLines(2);
        nameView.setEllipsize(TextUtils.TruncateAt.END);
        topLayout.addView(nameView,LayoutHelper.createLinear(0,LayoutHelper.WRAP_CONTENT,1.0f));
        ImageView closeView=new ImageView(context);
        closeView.setImageResource(R.drawable.ic_close_grey600_24dp);
        closeView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        topLayout.addView(closeView,LayoutHelper.createLinear(16,16,16,0,0,0));

        LinearLayout bottomLayout=new LinearLayout(context);
        bottomLayout.setOrientation(HORIZONTAL);
        bottomLayout.setGravity(Gravity.CENTER_VERTICAL);
        linearLayout.addView(bottomLayout,LayoutHelper.createLinear(LayoutHelper.MATCH_PARENT,0,1.0f));
        realPriceView=new TextView(context);
        realPriceView.setTextSize(TypedValue.COMPLEX_UNIT_DIP,14);
        realPriceView.setTextColor(0xffff9800);
        realPriceView.setText("¥1500");
        realPriceView.setSingleLine();
        bottomLayout.addView(realPriceView,LayoutHelper.createLinear(LayoutHelper.WRAP_CONTENT,LayoutHelper.WRAP_CONTENT));

        TextView textView=new TextView(context);
        textView.setText("原价: ");
        textView.setTextColor(0xffaaaaaa);
        textView.setTextSize(TypedValue.COMPLEX_UNIT_DIP,14);
        bottomLayout.addView(textView,LayoutHelper.createLinear(LayoutHelper.WRAP_CONTENT,LayoutHelper.WRAP_CONTENT,8,0,0,0));
        primePriceView=new TextView(context);
        primePriceView.setTextSize(TypedValue.COMPLEX_UNIT_DIP,14);
        primePriceView.setTextColor(0xffaaaaaa);
        primePriceView.setText("¥1699");
        primePriceView.getPaint().setFlags(Paint. STRIKE_THRU_TEXT_FLAG);
        primePriceView.setSingleLine();
        bottomLayout.addView(primePriceView,LayoutHelper.createLinear(0,LayoutHelper.WRAP_CONTENT,1.0f));

        LinearLayout numLayout=new LinearLayout(context);
        numLayout.setOrientation(HORIZONTAL);
        bottomLayout.addView(numLayout,LayoutHelper.createLinear(80,LayoutHelper.WRAP_CONTENT));
        disView=new TextView(context);
        disView.setTextColor(0xffaaaaaa);
        disView.setTextSize(TypedValue.COMPLEX_UNIT_DIP,16);
        disView.setSingleLine();
        disView.setText("-");
        disView.setGravity(Gravity.CENTER);
        numLayout.addView(disView,LayoutHelper.createLinear(24,24));
        countView=new TextView(context);
        countView.setTextColor(0xff757575);
        countView.setTextSize(TypedValue.COMPLEX_UNIT_DIP,16);
        countView.setSingleLine();
        countView.setGravity(Gravity.CENTER);
        numLayout.addView(countView,LayoutHelper.createLinear(0,LayoutHelper.WRAP_CONTENT,1.0f,Gravity.CENTER_VERTICAL));
        addView=new TextView(context);
        addView.setTextColor(0xffff9800);
        addView.setTextSize(TypedValue.COMPLEX_UNIT_DIP,16);
        addView.setSingleLine();
        addView.setText("+");
        addView.setGravity(Gravity.CENTER);
        addView.setBackgroundResource(R.drawable.circle_border_orange);
        numLayout.addView(addView,LayoutHelper.createLinear(24,24));

        RxViewAction.click(closeView).subscribe(new Action1() {
            @Override
            public void call(Object o) {
                if (delegate!=null){
                    delegate.onClose();
                }
            }
        });

        RxViewAction.click(disView).subscribe(new Action1() {
            @Override
            public void call(Object o) {
                if (count>1) {
                    countView.setText(--count+"");
                    if (count==1){
                        setDisViewStyle(false);
                    }
                }
            }
        });

        RxViewAction.click(addView).subscribe(new Action1() {
            @Override
            public void call(Object o) {
                countView.setText(++count+"");
                if (count==2){
                    setDisViewStyle(true);
                }
            }
        });
    }
    public void setDisViewStyle(boolean isCLickable){
        if (isCLickable){
            disView.setTextColor(0xffff9800);
            disView.setBackgroundResource(R.drawable.circle_border_orange);
            disView.setClickable(isCLickable);
        }else {
            disView.setTextColor(0xffaaaaaa);
            disView.setBackgroundResource(R.drawable.circle_border_grey);
            disView.setClickable(isCLickable);
        }
    }

    public void setCount(int count){
        countView.setText(count+"");
        this.count=count;
        if (count>1){
            setDisViewStyle(true);
        }else {
            setDisViewStyle(false);
        }
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, View.MeasureSpec.makeMeasureSpec(AndroidUtilities.dp(96),MeasureSpec.EXACTLY));
    }

    public interface  Delegate{
        void onClose();
    }
}
