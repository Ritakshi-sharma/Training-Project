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

public class Notification_Adapter extends RecyclerView.Adapter<Notification_Adapter.VerticalViewHolder> {
    private ArrayList<notification_list> foodList;

    public Notification_Adapter(ArrayList<notification_list> foodList) {
        this.foodList=foodList;
    }

    @NonNull
    @Override

    public VerticalViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View foodProductView = LayoutInflater.from(parent.getContext()).inflate(R.layout.notification_list, parent, false);
        VerticalViewHolder gvh = new VerticalViewHolder(foodProductView);
        return gvh;
    }

    @Override
    public void onBindViewHolder(@NonNull VerticalViewHolder holder, int position) {
        holder.imageView.setImageResource(foodList.get(position).getFoodImage());
        holder.comment.setText(foodList.get(position).getComment());
        holder.duration.setText(foodList.get(position).getDuration());
    }

    @Override
    public int getItemCount() {
        return foodList.size();
    }

    public class VerticalViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView comment,duration;
        public VerticalViewHolder(View view) {
            super(view);
            imageView=view.findViewById(R.id.Food_image);
            comment=view.findViewById(R.id.comment);
            duration=view.findViewById(R.id.duration);

        }
    }
}
