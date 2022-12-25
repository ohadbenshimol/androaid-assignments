package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.viewmodel.CreationExtras;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    Integer num1;
    String operator;
    String ErrorString = "Err";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textViewResult);

    }

    public void funcNumButton(View view) {
        Button button = (Button) view;
        String res = button.getText().toString();
        textView.append(res);
    }

    public void artmaticClick(View view) {
        if (textView.getText().toString().equals(ErrorString)) {
            textView.setText("");
            return;
        }
        operator = ((Button) view).getText().toString();
        if (!TextUtils.isEmpty(textView.getText().toString())) {
            num1 = Integer.parseInt(textView.getText().toString());
            textView.setText("");
        }
    }

    public void onPrassCalc(View view) {
        if (TextUtils.isEmpty(textView.getText().toString()) || num1 == null) {
            textView.setText(ErrorString);

        } else {
            Integer num2 = Integer.parseInt(textView.getText().toString());
            Integer finalNumber = 0;
            boolean hasError = false;
            switch (operator) {
                case "+":
                    finalNumber = num1 + num2;
                    break;
                case "-":
                    finalNumber = num1 - num2;
                    break;
                case "*":
                    finalNumber = num1 * num2;
                    break;
                case "/":
                    if (num2 != 0) {
                        finalNumber = num1 / num2;
                    } else {
                        textView.setText(ErrorString);
                        hasError = true;
                    }
                    break;
            }

            if (!hasError) {
                textView.setText("");
                textView.append(finalNumber.toString());
            }
        }
    }

    public void reset(View view) {
        textView.setText("");
        num1 = 0;
    }
}