package com.example.nanny_project.NANI;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.nanny_project.R;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class image_listAdapter extends RecyclerView.Adapter<image_listAdapter.HorizontalViewHolder> {
    private ArrayList<image_list> foodList;

    public image_listAdapter(ArrayList<image_list> foodList) {this.foodList=foodList;
    }

    @NonNull
    @Override
    public HorizontalViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View food= LayoutInflater.from(parent.getContext()).inflate(R.layout.image_list,parent,false);
        HorizontalViewHolder horizontalViewHolder= new HorizontalViewHolder(food);
        return horizontalViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull HorizontalViewHolder holder, int position) {
        holder.image.setImageResource(foodList.get(position).getImages());
    }

    @Override
    public int getItemCount() {
        return foodList.size();
    }

    public class HorizontalViewHolder extends RecyclerView.ViewHolder {
        ImageView image;
        public HorizontalViewHolder(View view) {
            super(view);
            image=view.findViewById(R.id.pizza_image);
        }
    }
}
