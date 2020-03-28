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

public class VerticalAdapter extends  RecyclerView.Adapter<VerticalAdapter.VerticalViewHolder>  {
private ArrayList<Vertical> foodList;
    public VerticalAdapter(ArrayList<Vertical> foodList) {
        this.foodList=foodList;
    }

    @NonNull
    @Override
    public VerticalViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View food = LayoutInflater.from(parent.getContext()).inflate(R.layout.vertical_item, parent, false);
        VerticalViewHolder verticalViewHolder = new VerticalViewHolder(food);
        return verticalViewHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull VerticalViewHolder holder, int position) {
        holder.imageView.setImageResource(foodList.get(position).getImages());
        holder.title.setText(foodList.get(position).getTitle());

    }

    @Override
    public int getItemCount() {
        return foodList.size();
    }

    public class VerticalViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
    TextView title;
        public VerticalViewHolder(View view) {
            super(view);
            imageView=view.findViewById(R.id.image);
            title=view.findViewById(R.id.item_name);
        }
    }
}
