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
import android.widget.EditText;

public class Task5 extends AppCompatActivity {

    Float total = 0.0F, num1= 0.0F, num2 = 0.0F;
    EditText screen_task5;
    String input_onscreen = "", operator = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task5);

        screen_task5 = findViewById(R.id.screen_task5);
        screen_task5.setShowSoftInputOnFocus(false);


        numbersListener();
        operationsListeners();
        equalbtnListener();
        clearBtnListener();
        decBtnListener();


    }

    /*Listener for the numbers button: the numbere entered by user is assigned to the second variable and the screen will display
    * the number entered.*/
    private void numbersListener() {
        int[] numbersIDs = {R.id.btn_0, R.id.btn_1, R.id.btn_2, R.id.btn_3, R.id.btn_4, R.id.btn_5, R.id.btn_6, R.id.btn_7, R.id.btn_8, R.id.btn_9};
        for (int x : numbersIDs) {
            Button btn = findViewById(x);
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    input_onscreen += btn.getText().toString();
                    num2 = Float.parseFloat(input_onscreen);
                    screen_task5.setText(input_onscreen);
                }
            });
        }
    }

    /*Listener for the Operators buttons. When an operator is pressed, it will become the value of the operator variable if this is empty.
    Otherwise, it will call the calculation function, and the value of the first entered input (num2) is
     assigned to the variable num1.*/
    private void operationsListeners() {
        int[] opIDs = {R.id.btn_sum, R.id.btn_sub, R.id.btn_mult, R.id.btn_div};
        for (int x : opIDs) {
            Button btn = findViewById(x);
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    input_onscreen = "";
                    if(!operator.isEmpty()){
                        calculation();
                        operator = btn.getText().toString();

                    }
                    else{
                        operator = btn.getText().toString();

                    }
                    num1 = num2;

                }
            });
        }
    }

    /*Listener for the equal button. When pressed, the calculation function is called, to perform and display the final result.
    * Operator variable's value is set to empty string.*/
    private void equalbtnListener(){
        Button btn_result = findViewById(R.id.btn_result);
        btn_result.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculation();
                operator = "";

            }
        });

    }

    /*Calculation function. This will perform the arithmetic calculations. After it is performed, the value of the
    * total variable is assigned to the variable num2. This allows, when an operator is pressed again, to
    * peform the chain calculation.*/
    private void calculation(){

        if(!operator.isEmpty()){
            switch(operator){
                case "+":
                    total = num1 + num2;
                    break;
                case "-":
                    total = num1 - num2;
                    break;
                case "X":
                    total = num1 * num2;
                    break;
                case "/":
                    /*An if statement will check for division by zero and display the error message*/

                    total = num1 / num2;
                    if(total.toString().contains("Infinity")){
                        screen_task5.setText(num1.toString()+operator+num2.toString()+"\n"+"Error: Division By Zero"+"\n");
                    }
                    break;
            }
            if(!total.toString().contains("Infinity")){
                screen_task5.setText(num1.toString()+operator+num2.toString()+" = \n"+total.toString()+"\n");
                num2 = total;
            }
        }
    }

    /*Clear button listener function will clear all operations and will set initial value
    * to 0.0*/
    private void clearBtnListener(){
        Button btn_clear = findViewById(R.id.btn_clear);
        btn_clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input_onscreen = "";
                screen_task5.setText("0.0");
                num2=0.0f;
                operator="";
            }
        });
    }

    /*Listener for the decimal button, will check if the dot (".") is already present in the number.*/
    private void decBtnListener(){
        Button btn_dec = findViewById(R.id.btn_dec);
        btn_dec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!input_onscreen.contains(btn_dec.getText())){
                    input_onscreen += btn_dec.getText();
                }
            }
        });
    }

    private void go_back_main(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

}