package com.zhayh.xposeddemo.util;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.View;

/**
 * Created by zhayh on 2017/4/2.
 */
public class ButtonListener implements View.OnClickListener {
    private Context context = null;
    private Class deste_activity_class = null;

    public ButtonListener(Context context,Class dest_activity_class) {
        this.context = context;
        this.deste_activity_class = dest_activity_class;
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(context,deste_activity_class);
        context.startActivity(intent);
    }
}
