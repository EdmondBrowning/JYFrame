package com.edmond.jyframe.activity.base;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;

import com.edmond.jyframe.R;
import com.edmond.jyframe.presenter.base.BasePresenter;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;

/**
 * Created by edmond on 16-8-15.
 * @author edmond
 */
public abstract class BaseActivity<P extends BasePresenter> extends AppCompatActivity {
    private String TAG = "BaseActivity";
    private PackageManager pm = null;
    private P presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        pm = getPackageManager();
        try {
            PackageInfo pack = pm.getPackageInfo(getPackageName(),PackageManager.GET_PERMISSIONS);
            String[] permissionStrings = pack.requestedPermissions;
            if(permissionStrings!=null){
                for(String permissionString:permissionStrings){
                    int permission = ActivityCompat.checkSelfPermission(this, permissionString);
                    int REQUEST_PERMISSION = 1;

                    if(permission!=PackageManager.PERMISSION_GRANTED){

                        ActivityCompat.requestPermissions(this,permissionStrings,REQUEST_PERMISSION);
                    }
                }
            }
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS
                    | WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
//            window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
//                    | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
//                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(getResources().getColor(R.color.mainColor));
            Log.d(TAG, String.valueOf(getResources().getColor(R.color.mainColor)));
//            window.setNavigationBarColor(getResources().getColor(R.color.mainColor));
        }


        /**
         * start create Presenter*/
        ParameterizedType parameterizedType = (ParameterizedType)this.getClass().getGenericSuperclass();
        Class<P> tClass= (Class<P>)(parameterizedType.getActualTypeArguments()[0]);
        try {
            presenter = tClass.getConstructor(this.getClass(),Class[].class).newInstance(this, initModelName());
        } catch (InstantiationException | InvocationTargetException | IllegalAccessException | NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    public P getPresenter() {
        return presenter;
    }

    public PackageManager getPm() {
        return pm;
    }

    public abstract Class[] initModelName();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.onDestroy();
        presenter = null;
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        Log.d(TAG,"FREE");
    }
}
