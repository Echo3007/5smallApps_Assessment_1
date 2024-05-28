/*Student Name: Angela Pellillo
 * Student ID: 21499500
 * Module: Mobile Web Application Development
 * Module ID: CP5CS93E*/


package com.example.assessment_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Task3_InterProgrFlag extends AppCompatActivity {
    Button go_back_int, go_previous_inter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task3_inter_progr_flag);

        go_back_int = findViewById(R.id.go_back_int);

        go_back_int.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                go_back_main();
            }
        });

        go_previous_inter = findViewById(R.id.go_previous_inter);
        go_previous_inter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                go_previous();
            }
        });

    }

    private void go_back_main(){
        Intent intent = new Intent(this, Task3.class);
        startActivity(intent);
    }

    private void go_previous(){
        Intent intent = new Intent(this, Task3_PhiladelphiaFlag.class);
        startActivity(intent);
    }
}