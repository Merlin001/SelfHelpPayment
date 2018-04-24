package com.romens.selfpay.selfhelppayment.ui;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.romens.android.ui.Components.LayoutHelper;
import com.romens.selfpay.selfhelppayment.R;
import com.romens.selfpay.selfhelppayment.cell.AlipayActionBarCell;
import com.romens.selfpay.selfhelppayment.cell.PaySucessCell;
import com.romens.selfpay.selfhelppayment.cell.TextHorizontalCell;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lm
 * @Created 2018/4/23
 * @description
 */

public class AlipaySucessPayActivity extends AppCompatActivity {
    private TextView hintView;
    private TextView closeBtn;
    private ListView listView;
    private MyAdapter mAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LinearLayout container=new LinearLayout(this);
        container.setOrientation(LinearLayout.VERTICAL);
        container.setGravity(Gravity.CENTER_HORIZONTAL);
        AlipayActionBarCell actionBar=new AlipayActionBarCell(this);
        actionBar.setCancelBtnVisiblity(false);
        container.addView(actionBar, LayoutHelper.createLinear(LayoutHelper.MATCH_PARENT,LayoutHelper.WRAP_CONTENT));
        setContentView(container);
        listView=new ListView(this);
        listView.setDivider(null);
        listView.setDividerHeight(0);
        container.addView(listView,LayoutHelper.createLinear(LayoutHelper.MATCH_PARENT,LayoutHelper.WRAP_CONTENT,24,32,24,0));

        hintView=new TextView(this);
        hintView.setTextColor(0xff757575);
        hintView.setTextSize(TypedValue.COMPLEX_UNIT_DIP,20);
        hintView.setText("请拿好小票，欢迎下次光临");
        hintView.setMaxLines(1);
        hintView.setSingleLine();
        hintView.setGravity(Gravity.CENTER);
        container.addView(hintView,LayoutHelper.createLinear(LayoutHelper.MATCH_PARENT,LayoutHelper.WRAP_CONTENT,0,56,0,0));

        closeBtn=new TextView(this);
        closeBtn.setTextColor(0xffffffff);
        closeBtn.setTextSize(TypedValue.COMPLEX_UNIT_DIP,18);
        closeBtn.setText("关闭（30s）");
        closeBtn.setMaxLines(1);
        closeBtn.setSingleLine();
        closeBtn.setGravity(Gravity.CENTER);
        closeBtn.setBackgroundResource(R.color.md_blue_400);
        container.addView(closeBtn,LayoutHelper.createLinear(LayoutHelper.MATCH_PARENT,42,56,40,56,0));

        mAdapter=new MyAdapter(this);
        listView.setAdapter(mAdapter);
        timer.start();
        List<SumEntity> dataMap=new ArrayList<>();
        SumEntity entity;
        entity=new SumEntity("订单金额","¥2999.00");
        dataMap.add(entity);
        entity=new SumEntity("商家优惠","-¥12.00");
        dataMap.add(entity);
        entity=new SumEntity("奖励金抵扣","-¥15.00");
        dataMap.add(entity);
        entity=new SumEntity("支付宝优惠","-¥8.00");
        dataMap.add(entity);
        mAdapter.bindData(dataMap);
        updateAdapter(dataMap);
    }

    private int rowCount;
    private int paySumRow;
    private int orderSumRow;
    private int couponStartRow;
    private int couponEndRow;

    private void updateAdapter(List<SumEntity> datas){
        rowCount=0;
        paySumRow=rowCount++;
        orderSumRow=rowCount++;
        couponStartRow=rowCount;
        if (datas!=null && datas.size()>0){
          rowCount=rowCount+datas.size()-1;
        }
        couponEndRow=rowCount;
        mAdapter.notifyDataSetChanged();
    }
    private CountDownTimer timer = new CountDownTimer(30*1000, 1000) {
        @Override
        public void onTick(long millisUntilFinished) {
            closeBtn.setText("关闭（"+millisUntilFinished/1000+"s）");
            if (millisUntilFinished/1000==25){
                hintView.setText("宣传一下");
            }
        }
        @Override
        public void onFinish() {
//            finish();
        }
    };

    private class MyAdapter extends BaseAdapter{
        private Context context;
        private List<SumEntity> dataMap=new ArrayList<>();

        public MyAdapter(Context context) {
            this.context = context;
        }

        public void bindData(List<SumEntity> datas){
            dataMap.clear();
            if (datas!=null && datas.size()>0){
                dataMap.addAll(datas);
            }
            notifyDataSetChanged();
        }

        @Override
        public boolean areAllItemsEnabled() {
            return false;
        }

        @Override
        public int getItemViewType(int position) {
            if (position==paySumRow){
                return 0;
            }else {
                return 1;
            }

        }

        @Override
        public int getViewTypeCount() {
            return 2;
        }

        @Override
        public int getCount() {
            return rowCount;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            int type=getItemViewType(position);
            if (type==0) {
                if (convertView == null) {
                    convertView = new PaySucessCell(context);
                }
                PaySucessCell cell = (PaySucessCell) convertView;
            }else {
                if (convertView == null) {
                    convertView = new TextHorizontalCell(context);
                }
                TextHorizontalCell cell=(TextHorizontalCell)convertView;
                if (position==orderSumRow){
                    cell.setValueColor(0xffaaaaaa);
                }else {
                    cell.setValueColor(Color.RED);
                }
                SumEntity entity=dataMap.get(position-couponStartRow+1);
                cell.setValue(entity.type,entity.sum);

            }
            return convertView;
        }
    }

    private class SumEntity{
        private String type;
        private String sum;

        public SumEntity(String type, String sum) {
            this.type = type;
            this.sum = sum;
        }
    }
}
