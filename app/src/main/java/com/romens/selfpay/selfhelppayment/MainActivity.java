package com.romens.selfpay.selfhelppayment;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.romens.selfpay.selfhelppayment.ui.DeleteOrCancleOrderActivity;
import com.romens.selfpay.selfhelppayment.ui.PayTypeChooseActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ((TextView)findViewById(R.id.text)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, DeleteOrCancleOrderActivity.class);
                startActivity(intent);
                overridePendingTransition(0, 0);

            }
        });
    }

}
