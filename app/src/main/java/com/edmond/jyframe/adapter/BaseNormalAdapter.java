package com.edmond.jyframe.adapter;

import android.content.Context;
import android.view.View;

import java.util.List;

/**
 * Created by edmond on 16-9-19.
 */
public abstract class BaseNormalAdapter<T> extends BaseAdapter<T> {
    public BaseNormalAdapter(Context context, List<T> data) {
        super(context, data);
    }

    @Override
    public boolean isFull(int position) {
        return false;
    }

    @Override
    public int getItemViewType(int position) {
        return IS_ITEM;
    }

    public abstract class Item extends BaseItem {
        public Item(View itemView) {
            super(itemView);
        }
    }
}
