package com.example.nanny_project.NANI;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.nanny_project.R;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class Order_Adapter extends RecyclerView.Adapter<Order_Adapter.VerticalViewHolder> {
    private ArrayList<Order_list> order_lists;

    public Order_Adapter(ArrayList<Order_list> order_lists){this.order_lists=order_lists;}
    @NonNull
    @Override
    public VerticalViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.order_list,parent,false);
        VerticalViewHolder verticalViewHolder=new VerticalViewHolder(view);
        return verticalViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final VerticalViewHolder holder, int position) {
        holder.imageView.setImageResource(order_lists.get(position).getImages());
        holder.textView.setText(order_lists.get(position).getTitle());




    }

    @Override
    public int getItemCount() {
        return order_lists.size();
    }



    public class VerticalViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView imageView;
        TextView textView,confirm;
       ImageView show_arrow;
       ImageView hide_arrow;
       Button b1,b2,b3,b4;
        Boolean b1Pressed = false, b2Pressed = false,b3Pressed=false,b4Pressesd=false;
      private LinearLayout layout;


        public VerticalViewHolder(View view) {
            super(view);
            imageView=view.findViewById(R.id.Food_image);
            textView=view.findViewById(R.id.title);
            layout=view.findViewById(R.id.buttons);
            confirm=view.findViewById(R.id.order_confirm);
            confirm.setOnClickListener(this);
            show_arrow=view.findViewById(R.id.show);
            show_arrow.setOnClickListener(this);
            hide_arrow = view.findViewById(R.id.hide_button);
            hide_arrow.setOnClickListener(this);
            b1=view.findViewById(R.id.with_nani);
            b1.setOnClickListener(this);
            b2=view.findViewById(R.id.courier);
            b2.setOnClickListener(this);
            b3=view.findViewById(R.id.prepared);
            b3.setOnClickListener(this);
            b4=view.findViewById(R.id.eat);
            b4.setOnClickListener(this);


        }

        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.order_confirm:
                    show_arrow.setVisibility(View.VISIBLE);
                    break;
                case R.id.show:
                    layout.setVisibility(View.VISIBLE);
                    show_arrow.setVisibility(View.GONE);
                    hide_arrow.setVisibility(View.VISIBLE);
                    break;
                case R.id.hide_button:
                    layout.setVisibility(View.GONE);
                    show_arrow.setVisibility(View.VISIBLE);
                    hide_arrow.setVisibility(View.GONE);



            }
        }
    }
}
