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

public class Task3_RainbowFlag extends AppCompatActivity {

    Button go_back_rainb, go_next2, go_previous_rainb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task3_rainbow_flag);

        go_back_rainb = findViewById(R.id.go_back_rainb);
        go_back_rainb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                go_back_main();
            }
        });

        go_next2 = findViewById(R.id.go_next2);
        go_next2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                go_next();
            }
        });

        go_previous_rainb = findViewById(R.id.go_previous_rainb);
        go_previous_rainb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                go_previous();
            }
        });

    }

    public void go_back_main(){
        Intent intent = new Intent(this, Task3.class);
        startActivity(intent);
    }
    public void go_next(){
        Intent intent = new Intent(this, Task3_PhiladelphiaFlag.class);
        startActivity(intent);
    }
    private void go_previous(){
        Intent intent = new Intent(this, Task3_OriginalFlag.class);
        startActivity(intent);
    }


}