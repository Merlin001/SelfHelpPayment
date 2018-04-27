package com.romens.selfpay.selfhelppayment.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.TypedValue;
import android.view.Gravity;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.romens.android.rx.rxbinding.RxViewAction;
import com.romens.android.ui.Components.LayoutHelper;
import com.romens.selfpay.selfhelppayment.R;
import com.romens.selfpay.selfhelppayment.cell.ActionCell;
import com.romens.selfpay.selfhelppayment.cell.GoodsListCell;
import com.romens.selfpay.selfhelppayment.cell.PayResultCell;

import rx.functions.Action1;

/**
 * @author lm
 * @Created 2018/4/25
 * @description
 */

public class AlipayFailPayActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FrameLayout content=new FrameLayout(this);
        setContentView(content);
//        PayResultCell payResultCell=new PayResultCell(this);
//        payResultCell.setValue("支付失败");
//        payResultCell.setStateImge(R.drawable.ic_error_black_36dp);
//        content.addView(payResultCell, LayoutHelper.createFrame(LayoutHelper.MATCH_PARENT,LayoutHelper.WRAP_CONTENT,Gravity.TOP, 20,36,20,20));
        GoodsListCell cell=new GoodsListCell(this);
        cell.setCount(1);
        content.addView(cell,LayoutHelper.createLinear(LayoutHelper.MATCH_PARENT,LayoutHelper.WRAP_CONTENT));

        TextView hintView=new TextView(this);
        hintView.setTextColor(0xff212121);
        hintView.setTextSize(TypedValue.COMPLEX_UNIT_DIP,16);
        hintView.setText("不好意思，遇到了小麻烦，未支付成功\n请您重新支付");
        hintView.setMaxLines(2);
        hintView.setGravity(Gravity.CENTER);
        content.addView(hintView,LayoutHelper.createFrame(LayoutHelper.MATCH_PARENT,LayoutHelper.WRAP_CONTENT,Gravity.CENTER));

        ActionCell payCell=new ActionCell(this);
        payCell.setPrimaryAction();
        payCell.setValue("重新支付");
        content.addView(payCell,LayoutHelper.createFrame(200,LayoutHelper.WRAP_CONTENT,Gravity.BOTTOM|Gravity.CENTER_HORIZONTAL,0,0,0,96));
        ActionCell cancelCell=new ActionCell(this);
        cancelCell.setPrimaryBorderAction();
        cancelCell.setValue("立即关闭");
        content.addView(cancelCell,LayoutHelper.createFrame(200,LayoutHelper.WRAP_CONTENT,Gravity.BOTTOM|Gravity.CENTER_HORIZONTAL,0,0,0,36));

        RxViewAction.clickNoDouble(payCell).subscribe(new Action1() {
            @Override
            public void call(Object o) {
                finish();
            }
        });
        RxViewAction.clickNoDouble(cancelCell).subscribe(new Action1() {
            @Override
            public void call(Object o) {
                finish();
            }
        });
    }

}
