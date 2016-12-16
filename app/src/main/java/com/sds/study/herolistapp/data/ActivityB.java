package com.sds.study.herolistapp.data;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.sds.study.herolistapp.R;


public class ActivityB extends Activity {
    EditText receive_msg;
    EditText send_msg;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.b_layout);

        Intent intent = getIntent();
        String data = intent.getStringExtra("data");
        receive_msg = (EditText) findViewById(R.id.receive_msg);
        send_msg=(EditText) findViewById(R.id.send_msg);
        receive_msg.setText(data);

        System.out.print("넘겨받은 데이터는"+data);
    }

    public void btnClick(View view) {
        Intent intent=new Intent();
        intent.putExtra("data",send_msg.getText().toString());

        setResult(2002,intent);
        finish();
    }
}
