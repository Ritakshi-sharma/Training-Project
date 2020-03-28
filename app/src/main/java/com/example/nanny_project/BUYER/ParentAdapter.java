package com.example.nanny_project.BUYER;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.nanny_project.R;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class ParentAdapter extends RecyclerView.Adapter<ParentAdapter.VerticalHolder> {
    private ArrayList<parent> list_parent;
    int adapterPosition;
    Context context;
    public ParentAdapter(ArrayList<parent> list_parent,Context context){
        this.list_parent=list_parent;
        this.context=context;
    }
    @NonNull
    @Override
    public ParentAdapter.VerticalHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.parent,parent,false);
        VerticalHolder verticalHolder=new VerticalHolder(view);
        return verticalHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ParentAdapter.VerticalHolder holder, int position) {


            holder.textView.setText(list_parent.get(position).getTitle());
//        }
//        else if (adapterPosition==0){
            holder.textView.setText(list_parent.get(position).getTitle());



    }


    @Override
    public int getItemCount() {
        return list_parent.size();
    }

    public class VerticalHolder extends RecyclerView.ViewHolder{
        TextView textView;
        ImageView imageView1,imageView2;
        RecyclerView child_recycler;
        ArrayList<child> list_child;
        ArrayList<child> child2;

        public VerticalHolder(@NonNull View view) {
            super(view);
            adapterPosition=getAdapterPosition();
            textView=view.findViewById(R.id.item_name);
           textView.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                   child_recycler.setVisibility((child_recycler.getVisibility() == View.VISIBLE)
                           ? View.GONE : View.VISIBLE);
               }
           });
            child_items();
//            child_items1();
//            child_items2();
//            child_items3();
//

            child_recycler=view.findViewById(R.id.child);
            child_recycler.setLayoutManager(new LinearLayoutManager(context,RecyclerView.VERTICAL,false));
            child_recycler.setAdapter(new ChildAdapter(list_child,child2,adapterPosition));

        }

        private void child_items3() {
            list_child=new ArrayList<>();
            list_child.add(new child(R.drawable.pizza,"Pizza"));
            list_child.add(new child(R.drawable.south,"Dosa"));
        }

        private void child_items2() {
            list_child=new ArrayList<>();
            list_child.add(new child(R.drawable.pizza,"Pizza"));
            list_child.add(new child(R.drawable.south,"Dosa"));
            list_child.add(new child(R.drawable.pizza,"Pizza"));
            list_child.add(new child(R.drawable.south,"Dosa"));
        }

        private void child_items1() {
            list_child=new ArrayList<>();
            list_child.add(new child(R.drawable.pizza,"Pizza"));
            list_child.add(new child(R.drawable.south,"Dosa"));
            list_child.add(new child(R.drawable.pizza,"Pizza"));
            list_child.add(new child(R.drawable.south,"Dosa"));
            list_child.add(new child(R.drawable.south,"Pizza"));
        }

        private void child_items() {
            list_child=new ArrayList<>();
            list_child.add(new child(R.drawable.pizza,"Pizza"));
            list_child.add(new child(R.drawable.south,"Dosa"));
            list_child.add(new child(R.drawable.pizza,"Pizza"));

            child2 = new ArrayList<>();
            child2.add(new child(R.drawable.pizza,"Pizza"));
            child2.add(new child(R.drawable.south,"Dosa"));

        }
    }
}
