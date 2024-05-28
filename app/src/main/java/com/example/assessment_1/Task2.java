/*Student Name: Angela Pellillo
 * Student ID: 21499500
 * Module: Mobile Web Application Development
 * Module ID: CP5CS93E*/


package com.example.assessment_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class Task2 extends AppCompatActivity {

            TextView title, descr, descr_2, result,homeBtn;
            Button submitBtn;
            RadioGroup radioGroup;
            RadioButton guitarBtn, keyBtn, drumBtn;
            Spinner spinnerOptions;
            ArrayAdapter spinnerAdapter;

            ArrayList spinnerList, spinner_one;
            @Override
            protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_task2);

                submitBtn = findViewById(R.id.submitBtn);
                result = findViewById(R.id.result);
                guitarBtn = findViewById(R.id.guitarBtn);
                keyBtn = findViewById(R.id.keyBtn);
                drumBtn = findViewById(R.id.drumBtn);

                title = findViewById(R.id.title);
                title.setText("Music Instruments");
                descr = findViewById(R.id.descr);
                descr.setText("Select a category to inspect: ");
                descr_2 = findViewById(R.id.descr_2);
                homeBtn = findViewById(R.id.homeBtn);

                homeBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        go_back_main();
                    }
                });

                radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
                //Spinner set-up and population
                spinnerOptions = findViewById(R.id.spinnerOptions);

                /*Spinner to display only the Select A Category Item*/
                spinner_one = new ArrayList<String>();
                spinner_one.add("Select a Category");
                spinnerAdapter = new ArrayAdapter<String>(this, R.layout.spinner_layout_task2,spinner_one);
                spinnerAdapter.setDropDownViewResource(R.layout.spinner_layout_task2);
                spinnerOptions.setAdapter(spinnerAdapter);


                spinnerList = new ArrayList<String>();
                spinnerList.add("Classic Guitar");
                spinnerList.add("Acoustic Guitar");
                spinnerList.add("Electric Guitar");
                spinnerList.add("Semi-Acoustic Guitar");
                spinnerList.add("Grand Piano");
                spinnerList.add("Keyboards");
                spinnerList.add("Synthesizers");
                spinnerList.add("Spinet Piano");
                spinnerList.add("Acoustic Drum");
                spinnerList.add("Marching Drum");
                spinnerList.add("Electronic Drum");
                spinnerList.add("Hand Drum");




                /* Method for the submit button created. Based on the radio button checked, different output will be displayed.
                 * If-else statements will decide output.*/
                submitBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String instr = "Selected Instrument: ";
                        String type = "Selected type: ";
                        if(guitarBtn.isChecked()){
                            result.setText(instr+"Guitar"+"\n"+type+spinnerOptions.getSelectedItem().toString());
                        } else if (keyBtn.isChecked()) {
                            result.setText(instr+"Keyboard/Piano"+"\n"+type+spinnerOptions.getSelectedItem().toString());

                        }
                        else{
                            result.setText(instr+"Drums"+"\n"+type+spinnerOptions.getSelectedItem().toString());

                        }
                    }
                });
            }

            /* Method for the Radio Buttons. Based on the radio button checked, different items of the spinner will be displayed.*/
            public void onRadioButtonClicked(View view){

                String x = "";
                ArrayList<String> temp = new ArrayList<String>();

                if(guitarBtn.isChecked()){
                    x = "guitar";
                    descr_2.setText("Select the "+x+" you would like to inspect:");
                    for(int y =0; y<4;y++){
                        temp.add(spinnerList.get(y).toString());
                    }

                }
                else if(keyBtn.isChecked()){
                    x = "keyboard/piano";
                    descr_2.setText("Select the "+x+" you would like to inspect:");
                    for(int y =4; y<8;y++) {
                        temp.add(spinnerList.get(y).toString());
                    }
                }

                else if(drumBtn.isChecked()){
                    x = "drums";
                    descr_2.setText("Select the "+x+" you would like to inspect:");
                    for(int y =8; y<spinnerList.size();y++){
                        temp.add(spinnerList.get(y).toString());
                    }
                }

                else{
                    descr_2.setText("");
                }

                spinnerAdapter = new ArrayAdapter<String>(this, R.layout.spinner_layout_task2,temp);
                spinnerAdapter.setDropDownViewResource(R.layout.spinner_layout_task2);
                spinnerOptions.setAdapter(spinnerAdapter);


            }

            //Method to return to the Home Page
        private void go_back_main(){
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }

    }
