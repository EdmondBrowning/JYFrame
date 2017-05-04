package com.edmond.jyframe.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by edmond on 17-3-25.
 */

public abstract class BaseHeaderAdapter<T> extends BaseAdapter<T> {
    public BaseHeaderAdapter(Context context, List<T> data) {
        super(context, data);
    }

    @Override
    public BaseAdapter.BaseItem onCreateViewHolder(ViewGroup parent, int viewType) {
        BaseAdapter.BaseItem item = null;
        if(viewType==IS_HEADER){
            item = initHeader(parent);
        }else{
            item = initItem(parent);
        }
        return item;
    }

    @Override
    public void onBindViewHolder(BaseAdapter.BaseItem item, int position) {
        if(position==getItemCount()-1){
            bindFooter(item);
        }else{
            bindItem(item,position);
        }
    }

    @Override
    public boolean isFull(int position) {
        if(position == 0)
            return true;
        return false;
    }

    @Override
    public int getItemCount() {
        return super.getItemCount()+1;
    }

    @Override
    public int getItemViewType(int position) {
        if(isFull(position)){
            return IS_HEADER;
        }else{
            return IS_ITEM;
        }
    }

    public abstract BaseHeaderAdapter.Header initHeader(ViewGroup parent);
    public abstract void bindFooter(BaseItem item);

    abstract class Header extends BaseItem{

        public Header(View itemView) {
            super(itemView);
        }
    }

    abstract class Item extends BaseItem{

        public Item(View itemView) {
            super(itemView);
        }
    }
}
