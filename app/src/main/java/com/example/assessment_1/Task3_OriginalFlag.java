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

public class Task3_OriginalFlag extends AppCompatActivity {

    Button go_back_orig, go_next1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task3_original_flag);
        go_back_orig = findViewById(R.id.go_back_orig);

        go_back_orig.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                go_back_main();
            }
        });

        go_next1 = findViewById(R.id.go_next1);
        go_next1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                go_next();
            }
        });

    }
    private void go_back_main(){
        Intent intent2 = new Intent(this, Task3.class);
        startActivity(intent2);
    }
    private void go_next(){
        Intent intent = new Intent(this, Task3_RainbowFlag.class);
        startActivity(intent);
    }

}