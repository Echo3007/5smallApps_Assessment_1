/*Student Name: Angela Pellillo
 * Student ID: 21499500
 * Module: Mobile Web Application Development
 * Module ID: CP5CS93E*/

package com.example.assessment_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class Task3 extends AppCompatActivity {

    ImageView original_flag, rainbow_flag, philadelphia_flag, intersex_flag;
    TextView homeBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task3);

        original_flag = findViewById(R.id.original_flag_1979);
        rainbow_flag = findViewById(R.id.rainbow_flag);
        philadelphia_flag = findViewById(R.id.philadelphia_flag);
        intersex_flag = findViewById(R.id.intersex_flag);
        homeBtn = findViewById(R.id.homeBtn);

        homeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                go_back_main();
            }
        });

        original_flag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                newActivity(1);
            }
        });

        rainbow_flag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                newActivity(2);
            }
        });

        philadelphia_flag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                newActivity(3);
            }
        });

        intersex_flag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                newActivity(4);
            }
        });


    }

    /* Method creation for instantiation of new Activities. Integer will be passed as argument, depending on its
     * value, a different page will be displayed.*/
    public void newActivity(int flag_num){
        Intent intent;

        if( flag_num ==1){
            intent = new Intent(this, Task3_OriginalFlag.class);

        }
        else if (flag_num==2) {
            intent = new Intent(this, Task3_RainbowFlag.class);
        }
        else if (flag_num==3) {
            intent = new Intent(this, Task3_PhiladelphiaFlag.class);
        }

        else{
            intent = new Intent(this, Task3_InterProgrFlag.class);
        }
        startActivity(intent);
    }

    private void go_back_main(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

}