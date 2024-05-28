/*Student Name: Angela Pellillo
 * Student ID: 21499500
 * Module: Mobile Web Application Development
 * Module ID: CP5CS93E*/


package com.example.assessment_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class Task4 extends AppCompatActivity {
    Button loginbtn_task4, clearbtn_task4;
    TextInputEditText username_task4_text, password_task4_text;
    private String password, username;
    TextView attempts_task4, homeBtn;
    TextInputLayout username_task4, password_task4;
    boolean x;
    int attempts;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task4);
        attempts = 3;

        attempts_task4 = findViewById(R.id.attempts_task4);
        attempts_task4.setText("Attempts Left: "+ attempts);
        username_task4_text = findViewById(R.id.username_task4_text);
        password_task4_text = findViewById(R.id.password_task4_text);
        username_task4 = findViewById(R.id.username_task4);
        password_task4 = findViewById(R.id.password_task4);
        loginbtn_task4 = findViewById(R.id.loginbtn_task4);
        clearbtn_task4 = findViewById(R.id.clearbtn_task4);

        homeBtn = findViewById(R.id.homeBtn);

        homeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                go_back_main();
            }
        });

//Hint for the floating text
        int userHint = R.string.username_error;
        int passHint = R.string.password_error;
        setupFloatingLabelError(username_task4,userHint);
        setupFloatingLabelError(password_task4,passHint);

       /*setPassword("admin");
        setUsername("admin");*/

        //Extra code to test that in case username and password are setted to different values
        //it still works
        setPassword("Angela");
        setUsername("Stella");


        loginbtn_task4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String pass_input = password_task4_text.getText().toString();
                String user_input = username_task4_text.getText().toString();

                if (pass_input.equals(getPassword()) && user_input.equals(getUsername())){
                    login_task4();
                }
                else{
                    attempts -=1;
                    Toast.makeText(getApplicationContext(), "Username and password combination is incorrect.",Toast.LENGTH_SHORT).show();

                    if(attempts <0){
                        finish();
                    }
                    else{
                        attempts_task4.setText("Attempts Left: "+ attempts);
                    }
                }
            }
        });

        clearbtn_task4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clear_task4();
            }
        });


    }

    // method to validate Username and Password fields.
    private void setupFloatingLabelError(TextInputLayout inputLayout, int hint) {
        final TextInputLayout label = inputLayout;
        label.getEditText().addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            //if length of string entered in username and password is less than 4, floating error message is displayed
            @Override
            public void onTextChanged(CharSequence text, int start, int count, int after) {
                if (text.length() > 0 && text.length() < 4) {
                    if(inputLayout.equals(username_task4)){
                        label.setError(getString(R.string.username_error));
                        label.setErrorEnabled(true);
                    }
                    else if(inputLayout.equals(password_task4)){
                        label.setError(getString(R.string.password_error));
                        label.setErrorEnabled(true);
                    }
                } else {
                    label.setErrorEnabled(false);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }

        });
    }

    public static final String EXTRA_USERNAME = "username";
    public void login_task4(){
        Intent intent = new Intent(this, Task4_LoginScreen.class);
        String x = getUsername();
        intent.putExtra("extra_username", x);
        startActivity(intent);
    }

    public void clear_task4(){
        username_task4_text.setText("");
        password_task4_text.setText("");
    }


    //Setters And Getters for the private variables username and password
    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    private void go_back_main(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

}