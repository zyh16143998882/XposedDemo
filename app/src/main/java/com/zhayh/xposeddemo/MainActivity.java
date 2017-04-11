package com.zhayh.xposeddemo;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;

import com.zhayh.xposeddemo.util.ButtonListener;

public class MainActivity extends Activity {
    private Button btn_01 = null;
    private Button btn_02 = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_01 = (Button) findViewById(R.id.btn_01);
        btn_02 = (Button) findViewById(R.id.btn_02);

        btn_01.setOnClickListener(new ButtonListener(MainActivity.this,Layout1Activity.class));
        btn_02.setOnClickListener(new ButtonListener(MainActivity.this,Layout2Activity.class));
    }
}
