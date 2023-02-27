package com.example.mathdemo.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.mathdemo.R;
import com.example.mathdemo.activity.NextActivity;
import com.example.mathdemo.model.GameModel;

import java.util.List;

public class GameAdapter extends RecyclerView.Adapter<GameAdapter.MyViewHolder> {

    private List<GameModel> list;
    private Context mContext;
    RecyclerView recyclerView;

    public GameAdapter(Context mContext ,List<GameModel> list, RecyclerView recyclerView) {
        this.mContext = mContext;
        this.list = list;
        this.recyclerView = recyclerView;
    }

    @Override
    public GameAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_game_item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position)
    {
        holder.mainText.setText(list.get(position).getQuestion());

        holder.firstText.setText(list.get(position).getFirstAnswer());
        holder.secondText.setText(list.get(position).getSecondAnswer());
        holder.thirdText.setText(list.get(position).getThirdAnswer());
        holder.fourthText.setText(list.get(position).getForthAnswer());

        holder.firstLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(position == list.size()-1){
                    Intent intent = new Intent(mContext, NextActivity.class);
                    mContext.startActivity(intent);
                }else{
                    recyclerView.scrollToPosition(position+1);
                }
            }
        });

        holder.secondLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(position == list.size()-1){
                    Intent intent = new Intent(mContext, NextActivity.class);
                    mContext.startActivity(intent);
                }else{
                    recyclerView.scrollToPosition(position+1);
                }
            }
        });

        holder.thirdLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(position == list.size()-1){
                    Intent intent = new Intent(mContext, NextActivity.class);
                    mContext.startActivity(intent);
                }else{
                    recyclerView.scrollToPosition(position+1);
                }
            }
        });

        holder.fourthLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(position == list.size()-1){
                    Intent intent = new Intent(mContext, NextActivity.class);
                    mContext.startActivity(intent);
                }else{
                    recyclerView.scrollToPosition(position+1);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        if(list.isEmpty()){
            return 0;
        }else {
            return list.size();
        }
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        TextView firstText, secondText, thirdText, fourthText, mainText;
        RelativeLayout firstLayout, secondLayout, thirdLayout, fourthLayout;
        public MyViewHolder(View itemView) {
            super(itemView);

            mainText = itemView.findViewById(R.id.mainText);
            firstText = itemView.findViewById(R.id.firstText);
            secondText = itemView.findViewById(R.id.secondText);
            thirdText = itemView.findViewById(R.id.thirdText);
            fourthText = itemView.findViewById(R.id.fourthText);

            firstLayout = itemView.findViewById(R.id.first);
            secondLayout = itemView.findViewById(R.id.second);
            thirdLayout = itemView.findViewById(R.id.third);
            fourthLayout = itemView.findViewById(R.id.fourth);
        }
    }
}

