package com.example.ruanyulin.tab_23;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by ruanyulin on 17-8-15.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyHolder>{


    private Context context;
    List<String> ls;
    public RecyclerAdapter(Context context, List<String> ls){
        this.context=context;
        this.ls = ls;
    }
    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        MyHolder holder = new MyHolder((LayoutInflater.from(context).inflate(R.layout.item,parent,false)));
        return holder;
    }

    @Override
    public void onBindViewHolder(MyHolder holder, int position) {


        //holder.textView.setText(ls.get(position));
    }

    @Override
    public int getItemCount() {
        return ls.size();
    }

    class MyHolder extends RecyclerView.ViewHolder{

        TextView textView = null;
        public MyHolder(View itemView) {
            super(itemView);
            //textView = (TextView) itemView.findViewById(R.id.itemtext);
        }
    }
}
