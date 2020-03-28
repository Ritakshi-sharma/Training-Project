package com.example.nanny_project.NANI;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.nanny_project.R;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class HorizontalAdapter extends RecyclerView.Adapter<HorizontalAdapter.HorizontalViewHolder> {
    private ArrayList<Horizontal> foodList;

    public HorizontalAdapter(ArrayList<Horizontal> foodList){this.foodList=foodList;}
    @NonNull
    @Override
    public HorizontalViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View  food= LayoutInflater.from(parent.getContext()).inflate(R.layout.horizontal_item,parent,false);
        HorizontalViewHolder horizontalViewHolder=new HorizontalViewHolder(food);
        return horizontalViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull HorizontalViewHolder holder, int position) {
holder.imageView.setImageResource(foodList.get(position).getImages());
holder.title.setText(foodList.get(position).getTitle());
    }

    @Override
    public int getItemCount() {
        return foodList.size();
    }

    public class HorizontalViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView title;
        public HorizontalViewHolder(View view) {
            super(view);
            imageView=view.findViewById(R.id.image);
            title=view.findViewById(R.id.item_name);
        }
    }
}
