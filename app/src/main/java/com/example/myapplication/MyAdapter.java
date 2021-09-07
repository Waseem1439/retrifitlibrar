package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyAdView>{
    Context context;
    List<Model> modelList=new ArrayList<>();

    public MyAdapter(Context context, List<Model> modelList) {
        this.context = context;
        this.modelList = modelList;
    }

    @NonNull
    @Override
    public MyAdView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater=LayoutInflater.from(parent.getContext());
        View view=layoutInflater.inflate(R.layout.recyviedata,parent,false);
        return new MyAdView(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdView holder, int position) {
         Model model=modelList.get(position);
         holder.title.setText(model.getTitle());
         holder.body.setText(model.getBody());
    }

    @Override
    public int getItemCount() {
        return modelList.size();
    }

    class MyAdView extends RecyclerView.ViewHolder{
        TextView title,body;
        public MyAdView(@NonNull View itemView) {
            super(itemView);
            title=itemView.findViewById(R.id.title);
            body=itemView.findViewById(R.id.body);
        }
    }
}
