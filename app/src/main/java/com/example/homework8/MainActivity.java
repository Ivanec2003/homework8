package com.example.homework8;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonClickConverter = findViewById(R.id.buttonClickConverter);
        Button buttonClickNews = findViewById(R.id.buttonClickNews);
        Button buttonClickCalculator = findViewById(R.id.buttonClickCalculator);
        Button buttonClickLogin = findViewById(R.id.buttonClickLogin);

        buttonClickConverter.setOnClickListener(view -> {
            Intent intent = new Intent(this, ConverterActivity.class);
            startActivity(intent);
        });
        buttonClickNews.setOnClickListener(view -> {
            Intent intent = new Intent(this, NewsActivity.class);
            startActivity(intent);
        });
        buttonClickCalculator.setOnClickListener(view -> {
            Intent intent = new Intent(this, CalculatorActivity.class);
            startActivity(intent);
        });
        buttonClickLogin.setOnClickListener(view -> {
            Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);
        });

    }
}