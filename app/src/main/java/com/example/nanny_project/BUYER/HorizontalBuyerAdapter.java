package com.example.nanny_project.BUYER;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.nanny_project.R;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class HorizontalBuyerAdapter extends RecyclerView.Adapter<HorizontalBuyerAdapter.HorizontalViewHolder> {
    private ArrayList<HorizontalBuyer> list_user;
    public HorizontalBuyerAdapter(ArrayList<HorizontalBuyer> list_user){
        this.list_user=list_user;
    }
    @NonNull
    @Override
    public HorizontalViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.circularimage,parent,false);
        HorizontalViewHolder horizontalViewHolder=new HorizontalViewHolder(view);
        return horizontalViewHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull HorizontalViewHolder holder, int position) {
        holder.image.setImageResource(list_user.get(position).getImages());
        holder.title.setText(list_user.get(position).getTitle());

    }

    @Override
    public int getItemCount() {
        return list_user.size();
    }

    public static class HorizontalViewHolder extends RecyclerView.ViewHolder{
        ImageView image;
        TextView title;
        public HorizontalViewHolder(View view) {
            super(view);
            image=view.findViewById(R.id.circular_image);
            title=view.findViewById(R.id.subscription);
        }
    }
}
