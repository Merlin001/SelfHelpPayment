package com.romens.selfpay.selfhelppayment.ui.test;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import com.romens.android.rx.rxbinding.RxViewAction;
import com.romens.android.ui.Components.LayoutHelper;
import com.romens.selfpay.selfhelppayment.R;
import com.romens.selfpay.selfhelppayment.cell.GoodsListCell;
import com.romens.selfpay.selfhelppayment.cell.SelectBagCell;
import com.romens.selfpay.selfhelppayment.ui.ManualInputCodeActivity;
import com.romens.selfpay.selfhelppayment.ui.fragment.ManualInputCodeFragment;

import rx.functions.Action1;

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
        GoodsListCell cell=new GoodsListCell(this);
        cell.setCount(1);
        cell.setValue("爱他美婴儿奶粉800克", R.drawable.ic_launcher,"¥1500",null);
        content.addView(cell, LayoutHelper.createLinear(LayoutHelper.MATCH_PARENT,LayoutHelper.WRAP_CONTENT));
        SelectBagCell bagcell=new SelectBagCell(this);
        content.addView(bagcell,LayoutHelper.createLinear(LayoutHelper.MATCH_PARENT,LayoutHelper.WRAP_CONTENT));
        RxViewAction.click(content).subscribe(new Action1() {
            @Override
            public void call(Object o) {
                startActivity(new Intent(TestActivity.this, ManualInputCodeActivity.class));
            }
        });

//        ManualInputCodeFragment fragment=new ManualInputCodeFragment();
//        getSupportFragmentManager().beginTransaction().replace()
    }
}
