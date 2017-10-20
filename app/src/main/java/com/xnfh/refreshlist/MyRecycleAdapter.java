package com.xnfh.refreshlist;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by wangxuewei on 2017/10/11.
 */
public class MyRecycleAdapter extends RecyclerView.Adapter<MyRecycleAdapter.myViewHolder> {
    private Context mContext;
    private List<String> mDataList;
    public MyRecycleAdapter(Context context,List<String> list) {
        mContext = context;
        mDataList = list;
    }

    @Override
    public myViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_recyclerview,null);
        myViewHolder holder = new myViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(myViewHolder holder, int position) {
        holder.textView.setText(mDataList.get(position));
    }

    @Override
    public int getItemCount() {
        return mDataList.size();
    }

    static class myViewHolder extends RecyclerView.ViewHolder {
        TextView textView;
        public myViewHolder(View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.tv_recycler_item);
        }
    }
}
