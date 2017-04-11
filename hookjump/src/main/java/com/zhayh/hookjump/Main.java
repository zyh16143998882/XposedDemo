package com.zhayh.hookjump;

import android.content.Context;
import android.util.Log;

import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

/**
 * Created by zhayh on 2017/4/2.
 */
public class Main implements IXposedHookLoadPackage{

    @Override
    public void handleLoadPackage(final XC_LoadPackage.LoadPackageParam loadPackageParam) throws Throwable {
        if(loadPackageParam.packageName.equals("com.zhayh.xposeddemo")){
            Log.d("XposedTag","packageName = com.zhayh.xposeddemo 存在");

            XposedHelpers.findAndHookConstructor("com.zhayh.xposeddemo.util.ButtonListener",
                    loadPackageParam.classLoader,
                    Context.class,
                    Class.class,
                    new XC_MethodHook() {
                        @Override
                        protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                            super.beforeHookedMethod(param);
                            Log.d("XposedTag","找到ButtonListener函数");
                            Log.d("XposedTag","param.args[1] == "+param.args[1].toString());
                            if(param.args[1].toString().equals("class com.zhayh.xposeddemo.Layout1Activity")){
                                Log.d("XposedTag","class com.zhayh.xposeddemo.Layout1Activity");

                                Class clazz = XposedHelpers.findClass("com.zhayh.xposeddemo.Layout2Activity",loadPackageParam.classLoader);
                                Log.d("XposedTag","clazz == "+clazz.toString());
                                param.args[1] = clazz;
                                Log.d("XposedTag","param.args[1] == clazz == "+param.args[1].toString());
                            }else if(param.args[1].toString().equals("class com.zhayh.xposeddemo.Layout2Activity")){
                                Log.d("XposedTag","class com.zhayh.xposeddemo.Layout2Activity");

                                Class clazz = XposedHelpers.findClass("com.zhayh.xposeddemo.Layout1Activity",loadPackageParam.classLoader);;
                                Log.d("XposedTag","clazz == "+clazz.toString());
                                param.args[1] = clazz;
                                Log.d("XposedTag","param.args[1] == clazz =="+param.args[1].toString());
                            }else{
                                Log.d("XposedTag","不等于");
                            }
                            Log.d("XposedTag","成功");

                        }
                    });
        }


    }
}

