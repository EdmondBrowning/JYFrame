package com.edmond.jyframe.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import com.edmond.jyframe.R;

import java.util.List;

/**
 * Created by edmond on 17-3-25.
 */

public class TestAdapter extends BaseHeaderAdapter<Integer> {
    public TestAdapter(Context context, List data) {
        super(context, data);
    }

    @Override
    public  Header initHeader(ViewGroup parent) {
        return new TestFooter(getInflater().inflate(R.layout.item, parent, false)) {
        };
    }

    @Override
    public void bindFooter(BaseItem item) {

    }

    @Override
    public BaseItem initItem(ViewGroup parent) {
        return new TestItem(getInflater().inflate(R.layout.item,parent,false));
    }

    @Override
    public void bindItem(BaseItem item, int position) {

    }

    class TestFooter extends Header{
        public TestFooter(View itemView) {
            super(itemView);
        }

        @Override
        public void initViews(View view) {

        }
    }

    class TestItem extends Item{

        public TestItem(View itemView) {
            super(itemView);
        }

        @Override
        public void initViews(View view) {

        }
    }
}
