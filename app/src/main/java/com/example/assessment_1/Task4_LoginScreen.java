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
import android.widget.TextView;

public class Task4_LoginScreen extends AppCompatActivity {
    TextView userlog_task4, welcome_task4;
    Button logout_task4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task4_login_screen);
        userlog_task4 = findViewById(R.id.userlog_task4);
        userlog_task4.setText(getIntent().getExtras().getString("extra_username"));

        logout_task4 = findViewById(R.id.logout_task4);
        logout_task4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logout();
            }
        });
    }

    //Method to return to the login screen
    public void logout(){
        Intent intent = new Intent(this, Task4.class);
        startActivity(intent);
    }

}