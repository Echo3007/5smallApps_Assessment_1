/*Student Name: Angela Pellillo
* Student ID: 21499500
* Module: Mobile Web Application Development
* Module ID: CP5CS93E*/


package com.example.assessment_1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements RecycleViewInterface {

    ArrayList<TasksModel> tasksList = new ArrayList<>();

    //Images for each RecycleView Element
    int[] tasksImages = {R.drawable.task1_menu, R.drawable.task2_menu, R.drawable.task3_menu, R.drawable.task4_menu, R.drawable.task5_menu};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView myRecyclerView = findViewById(R.id.myRecyclerView);

        setUpTasksModel();

        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this, tasksList, this);
        myRecyclerView.setAdapter(adapter);
        myRecyclerView.setLayoutManager(new LinearLayoutManager(this));


    }

    //Setting up elements, associating each task name with the task Image
    private void setUpTasksModel(){
        String [] tasksNames = getResources().getStringArray(R.array.items_list);

        for(int i =0; i<tasksNames.length;i++){
            tasksList.add(new TasksModel(tasksNames[i],tasksImages[i]));
        }

    }

    //The position value is taken in the RecyclerViewAdapter class
    @Override
    public void onItemClick(int position) {
        Intent intent = new Intent();

        if(position == 0){
            intent = new Intent(this, Task1.class);
        }
        else if (position == 1) {
            intent = new Intent(this, Task2.class);
        }
        else if (position == 2) {
            intent = new Intent(this, Task3.class);
        }
        else if (position == 3) {
            intent = new Intent(this, Task4.class);
        }
        else if (position == 4) {
            intent = new Intent(this, Task5.class);
        }
        startActivity(intent);

    }
}