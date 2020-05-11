package com.example.my_assignment_application;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ExampleAdapter extends RecyclerView.Adapter<ExampleAdapter.ExampleViewHolder> {
   private  ArrayList<exampleitem> mexampleList;


    public static  class ExampleViewHolder extends RecyclerView.ViewHolder{
public ImageView mImageView;

        public TextView mTextView1;
        public TextView mTextView2;
        public ExampleViewHolder(@NonNull View itemView) {

            super(itemView);
            mImageView=itemView.findViewById(R.id.imageView);
            mTextView1=itemView.findViewById(R.id.textview);
            mTextView2=itemView.findViewById(R.id.textview2);
        }
    }
    public ExampleAdapter(ArrayList<exampleitem> exampleList){
        mexampleList=exampleList;
    }

    @NonNull
    @Override
    public ExampleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
          View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.example_item,parent,false);
       ExampleViewHolder evh=new ExampleViewHolder(v);
       return evh;
    }

    @Override
    public void onBindViewHolder(@NonNull ExampleViewHolder holder, int position) {
     exampleitem currentItem=mexampleList.get(position);

     holder.mImageView.setImageResource(currentItem.getImageResource());
     holder.mTextView1.setText(currentItem.getMtext1());
     holder.mTextView2.setText(currentItem.getMtext2());
    }

    @Override
    public int getItemCount() {
        return mexampleList.size();
    }
}
