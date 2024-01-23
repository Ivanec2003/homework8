package com.example.homework8;

import androidx.appcompat.app.AppCompatActivity;


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ConverterActivity extends AppCompatActivity {
    @SuppressLint({"DefaultLocale", "SetTextI18n"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_converter);
        EditText editTextEnterSum = findViewById(R.id.editTextEnterSum);
        EditText editTextExchangeRate = findViewById(R.id.editTextExchangeRate);
        Button buttonClickConversion = findViewById(R.id.buttonClickConversion);
        TextView textViewResultConversion = findViewById(R.id.textViewResultСonversion);

        buttonClickConversion.setOnClickListener(view -> {
            String sumStr = editTextEnterSum.getText().toString();
            String exchangeRateStr = editTextExchangeRate.getText().toString();
            if(!sumStr.isEmpty() && !exchangeRateStr.isEmpty()){
                double sum = Double.parseDouble(sumStr);
                double exchangeRate = Double.parseDouble(exchangeRateStr);
                double result = sum * exchangeRate;
                textViewResultConversion.setText(String.format("Result: %.2f", result));
            }
            else{
                textViewResultConversion.setText("Error of entering!");
            }
        });
    }
}