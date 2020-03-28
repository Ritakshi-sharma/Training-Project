package com.example.nanny_project.BUYER;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.nanny_project.NANI.Vertical;
import com.example.nanny_project.R;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class VerticalBuyerAdapter extends RecyclerView.Adapter<VerticalBuyerAdapter.VerticalAdapter> {
    private ArrayList<VerticalBuyer> list_user2;
    Context context;
    FoodClicked foodClicked;

    public VerticalBuyerAdapter(ArrayList<VerticalBuyer> list_user2, Context context, FoodClicked foodClicked) {
        this.list_user2 = list_user2;
        this.context = context;
        this.foodClicked = foodClicked;
    }

    @NonNull
    @Override
    public VerticalAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.vertical_item,parent,false);
        VerticalAdapter verticalAdapter=new VerticalAdapter(view);
        return verticalAdapter;
    }

    @Override
    public void onBindViewHolder(@NonNull VerticalAdapter holder, int position) {
        holder.imageView.setImageResource(list_user2.get(position).getImages());
        holder.title.setText(list_user2.get(position).getTitles());
    }

    @Override
    public int getItemCount() {
        return list_user2.size();
    }

    public class VerticalAdapter extends RecyclerView.ViewHolder  {
        ImageView imageView;
        TextView title;
        public VerticalAdapter(View view) {
            super(view);
            imageView=view.findViewById(R.id.image);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                 foodClicked.getFoodItemClicked(getAdapterPosition());
                }
            });

            title=view.findViewById(R.id.item_name);
        }


    }
    public interface  FoodClicked{
        public void getFoodItemClicked(int position);
    }
}
