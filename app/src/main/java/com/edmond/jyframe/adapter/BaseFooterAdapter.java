package com.edmond.jyframe.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by edmond on 17-3-25.
 */

public abstract class BaseFooterAdapter<T> extends BaseAdapter<T> {
    public BaseFooterAdapter(Context context, List data) {
        super(context, data);
    }

    @Override
    public BaseAdapter.BaseItem onCreateViewHolder(ViewGroup parent, int viewType) {
        BaseAdapter.BaseItem item = null;
        if(viewType==IS_FOOTER){
            item = initFooter(parent);
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
        if(position == getItemCount()-1)
            return true;
        else
            return false;
    }

    @Override
    public int getItemCount() {
        return super.getItemCount()+1;
    }

    @Override
    public int getItemViewType(int position) {
        if(isFull(position)){
            return IS_FOOTER;
        }else{
            return IS_ITEM;
        }
    }

    public abstract Footer initFooter(ViewGroup parent);
    public abstract void bindFooter(BaseItem item);

    abstract class Footer extends BaseItem {

        public Footer(View itemView) {
            super(itemView);
        }
    }

    abstract class Item extends BaseItem{

        public Item(View itemView) {
            super(itemView);
        }
    }
}
