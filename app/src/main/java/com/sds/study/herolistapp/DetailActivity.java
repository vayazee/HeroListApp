package com.sds.study.herolistapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class DetailActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.detail_layout);
        TextView txt_msg = (TextView) findViewById(R.id.txt_msg);

        //현재 액티비티에 넘겨진 인텐트가 있을 경우 받는다..
        Intent intent = this.getIntent();
        txt_msg.setText(intent.getStringExtra("data"));
    }

    public void btnClick(View view) {
        this.finish();
    }
}
