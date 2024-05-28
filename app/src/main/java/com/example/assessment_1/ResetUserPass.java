package com.example.assessment_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ResetUserPass extends AppCompatActivity {
EditText newUser, newPass;
Button change;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_user_pass);

        newUser = findViewById(R.id.newUser);
        newPass = findViewById(R.id.newPass);
        change = findViewById(R.id.change);

        change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                newCredentials();
            }
        });



    }

    public void newCredentials(){
        Intent intent = new Intent(this, Task4.class);
        intent.putExtra("NewUsername", newUser.getText().toString());
        intent.putExtra("NewPassword ", newPass.getText().toString());
        startActivity(intent);
    }
}