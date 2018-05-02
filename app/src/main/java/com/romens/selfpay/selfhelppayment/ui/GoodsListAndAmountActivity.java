package com.romens.selfpay.selfhelppayment.ui;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.romens.selfpay.selfhelppayment.cell.AlipayActionBarCell;

/**
 * Created by mMerlin on 2018/5/2.
 */

public class GoodsListAndAmountActivity extends AppCompatActivity {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);

        AlipayActionBarCell alipayActionBarCell = new AlipayActionBarCell(this);


    }
}
