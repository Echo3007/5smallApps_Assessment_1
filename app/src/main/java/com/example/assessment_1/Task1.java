/*Student Name: Angela Pellillo
 * Student ID: 21499500
 * Module: Mobile Web Application Development
 * Module ID: CP5CS93E*/

package com.example.assessment_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class Task1 extends AppCompatActivity {
    Button topLeft, topRight, bottomLeft, bottomRight;
    ImageButton centerBtn;
    TextView homeBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task1);

        topLeft = findViewById(R.id.topLeft);
        topRight = findViewById(R.id.topRight);
        bottomLeft = findViewById(R.id.bottomLeft);
        bottomRight = findViewById(R.id.bottomRight);
        centerBtn = findViewById(R.id.centerBtn);
        homeBtn = findViewById(R.id.homeBtn);

        /* Methods called to put button on listen. When pressed the toast method created
         * will be called.*/

        topRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toastMessage( "top Right");
            }
        });
        topLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toastMessage("Top Left");

            }
        });

        bottomLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                toastMessage("Bottom Left");
            }
        });
        bottomRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toastMessage( "Bottom Right");

            }
        });

        centerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toastMessage( "Center");
            }
        });

        homeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                go_back_main();
            }
        });

    }



    /*Method created for toast message. If else will decide which text to display
     * based on the button pressed.*/
    private void toastMessage(String button){

        LayoutInflater inflater = getLayoutInflater();
        View layout = inflater.inflate(R.layout.custom_toast_task1, null);
        TextView text = (TextView) layout.findViewById(R.id.toastMessage);
        text.setText("You clicked the "+button+ " button!" );
        text.setGravity(Gravity.CENTER);
        Toast toast = new Toast(getApplicationContext());

        /*If-else statements to determine in which part of the screen will the toast
        * message appear, in order to be consistent with its message.*/
        if(button.contains("Top") || button.contains("top")){
            if(button.contains("Left")||button.contains("left")){
                toast.setGravity(Gravity.CENTER_VERTICAL, -100, -300);
            }
            else{
                toast.setGravity(Gravity.CENTER_VERTICAL, 100, -300);
            }
        }
        else if(button.contains("bottom")|| button.contains("Bottom")){

            if(button.contains("Left")||button.contains("left")){
                toast.setGravity(Gravity.CENTER_VERTICAL, -100, 300);
            }
            else{
                toast.setGravity(Gravity.CENTER_VERTICAL, 100, 300);
            }
        }
        else{
            toast.setGravity(Gravity.CENTER_VERTICAL, 0, 70);

        }

        toast.setDuration(Toast.LENGTH_SHORT);
        toast.setView(layout);
        toast.show();
    }

    private void go_back_main(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

}
