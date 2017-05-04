package com.edmond.jyframe.presenter.base;

import android.util.Log;

import com.edmond.jyframe.module.BaseModel;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by edmond on 16-11-25.
 * @author edmond
 */

public abstract class BasePresenter<V> {
    private static final String TAG="BasePresenter";

    private V view;

    private Map<Class, BaseModel> map = new HashMap<>();

    public BasePresenter(V view,Class... classes){
        this.view = view;
        for(int loop=0;loop<classes.length;loop++){
            try {
                map.put(classes[loop],(BaseModel) classes[loop].getConstructor().newInstance());
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }
    }

    public V getView() {
        return view;
    }

    public void onDestroy(){
        if(view!=null){
            view = null;
        }
        map.clear();
    }

    public Object getModel(Class classType){
        return map.get(classType);
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        Log.d(TAG,"FREE");
    }
}
