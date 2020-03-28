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

public class Allergies_adapter extends RecyclerView.Adapter<Allergies_adapter.ViewHolder> {
    Context context;
    List<String> list2;
    public Allergies_adapter(Context context, List<String> list2){
        this.context=context;
        this.list2=list2;

    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.allergies_list,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        holder.tv_name_recycler.setText(list2.get(position));

        holder.img_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                list2.remove(position);
                notifyDataSetChanged();
            }
        });

    }

    @Override
    public int getItemCount() {
        return list2.size();    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView tv_name_recycler;
        private ImageView img_cancel;
        public ViewHolder(View view) {
            super(view);
            tv_name_recycler=itemView.findViewById(R.id.tv_name_recycler);
            img_cancel=itemView.findViewById(R.id.img_cancel);
        }
    }
}
