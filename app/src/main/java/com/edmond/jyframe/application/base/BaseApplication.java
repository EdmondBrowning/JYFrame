package com.edmond.jyframe.application.base;

import android.app.Application;
import android.content.Context;
import android.telephony.TelephonyManager;
import android.view.WindowManager;

/**
 * Created by edmond on 16-8-17.
 * @author edmond
 */
public class BaseApplication extends Application{
    private String mPhoneCode;
    private int mWidth;
    private int mHeight;

    @Override
    public void onCreate() {
        super.onCreate();
        WindowManager wm = (WindowManager) this.getSystemService(Context.WINDOW_SERVICE);
        mWidth = wm.getDefaultDisplay().getWidth();
        mHeight = wm.getDefaultDisplay().getHeight();
    }

    public String getPhoneCode(){
        if(mPhoneCode==null||mPhoneCode==""){
            TelephonyManager tm = (TelephonyManager) this.getSystemService(TELEPHONY_SERVICE);
            mPhoneCode = tm.getDeviceId();
        }
        return mPhoneCode;
    }

    public int getWidth() {
        return mWidth;
    }

    public int getHeight() {
        return mHeight;
    }
}
