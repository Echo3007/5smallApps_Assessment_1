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

public class Task3_PhiladelphiaFlag extends AppCompatActivity {

    Button go_back_philly, go_next3, go_previous_philly;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task3_philadelphia_flag);

        go_back_philly = findViewById(R.id.go_back_philly);
        go_back_philly.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                go_back_main();
            }
        });

        go_next3 = findViewById(R.id.go_next3);
        go_next3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                go_next();
            }
        });
        go_previous_philly = findViewById(R.id.go_previous_philly);
        go_previous_philly.setOnClickListener(new View.OnClickListener() {
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

    private void go_next(){
        Intent intent = new Intent(this, Task3_InterProgrFlag.class);
        startActivity(intent);
    }
    private void go_previous(){
        Intent intent = new Intent(this, Task3_RainbowFlag.class);
        startActivity(intent);
    }

}