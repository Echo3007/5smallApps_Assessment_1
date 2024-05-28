/*Student Name: Angela Pellillo
 * Student ID: 21499500
 * Module: Mobile Web Application Development
 * Module ID: CP5CS93E*/

package com.example.assessment_1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {
    private final RecycleViewInterface recycleViewInterface;


    Context context;
    ArrayList<TasksModel> tasksList;
    public RecyclerViewAdapter(Context context, ArrayList<TasksModel> tasksList, RecycleViewInterface recycleViewInterface){
        this.context = context;
        this.tasksList = tasksList;
        this.recycleViewInterface = recycleViewInterface;
    }


    @NonNull
    @Override
    public RecyclerViewAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //This will give a look to each of the rows and inflate the layout
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.recycler_view_row, parent,false);
        return new RecyclerViewAdapter.MyViewHolder(view, recycleViewInterface );
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapter.MyViewHolder holder, int position) {
        holder.taskDescr.setText(tasksList.get(position).getTaskDescr());
        holder.taskImage.setImageResource(tasksList.get(position).getTaskImage());
    }

    @Override
    public int getItemCount() {
        //Numbers of items in total
        return tasksList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        //It will take the views from the recycler_view_row
        ImageView taskImage;
        TextView taskDescr;

        public MyViewHolder(@NonNull View itemView, RecycleViewInterface recycleViewInterface) {
            super(itemView);

            taskImage = itemView.findViewById(R.id.taskImage);
            taskDescr = itemView.findViewById(R.id.taskDescr);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(recycleViewInterface != null){
                        int pos = getAdapterPosition();

                        if(pos != RecyclerView.NO_POSITION){
                            recycleViewInterface.onItemClick(pos);
                        }
                    }
                }
            });

        }
    }

}
