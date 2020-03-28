package com.example.nanny_project.NANI;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.nanny_project.R;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

class AdapterRecycler extends RecyclerView.Adapter<AdapterRecycler.ViewHolder> {

    Context context;
    List<String> list;

    public AdapterRecycler(Context context, List<String> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(context).inflate(R.layout.list_recycler,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {

        holder.tv_name_recycler.setText(list.get(position));

        holder.img_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                list.remove(position);
                notifyDataSetChanged();
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tv_name_recycler;
        private ImageView img_cancel;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);


            tv_name_recycler=itemView.findViewById(R.id.tv_name_recycler);
            img_cancel=itemView.findViewById(R.id.img_cancel);
        }
    }
}
