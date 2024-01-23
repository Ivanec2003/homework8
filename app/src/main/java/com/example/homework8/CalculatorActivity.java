package com.example.homework8;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class CalculatorActivity extends AppCompatActivity {

    private TextView textViewDisplay;
    private StringBuilder input;
    private double operand1, operand2;
    private String operator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        // Ініціалізація елементів інтерфейсу
        textViewDisplay = findViewById(R.id.textViewDisplay);
        input = new StringBuilder();

        // Налаштування обробників подій для цифрових кнопок
        setNumericClickListener(R.id.button0);
        setNumericClickListener(R.id.button1);
        setNumericClickListener(R.id.button2);
        setNumericClickListener(R.id.button3);
        setNumericClickListener(R.id.button4);
        setNumericClickListener(R.id.button5);
        setNumericClickListener(R.id.button6);
        setNumericClickListener(R.id.button7);
        setNumericClickListener(R.id.button8);
        setNumericClickListener(R.id.button9);

        // Налаштування обробників подій для кнопок операторів
        setOperatorClickListener(R.id.buttonPlus, "+");
        setOperatorClickListener(R.id.buttonMinus, "-");
        setOperatorClickListener(R.id.buttonMultiply, "*");
        setOperatorClickListener(R.id.buttonDivide, "/");

        // Налаштування обробника події для кнопки крапки (для десяткових чисел)
        Button buttonPoint = findViewById(R.id.buttonPoint);
        buttonPoint.setOnClickListener(v -> {
            if (!input.toString().contains(".")) {
                input.append(".");
                textViewDisplay.setText(input.toString());
            }
        });

        // Налаштування обробника події для кнопки очищення
        Button buttonClean = findViewById(R.id.buttonClean);
        buttonClean.setOnClickListener(v -> {
            input.setLength(0);
            textViewDisplay.setText("");
            operand1 = 0;
            operand2 = 0;
            operator = "";
        });

        // Налаштування обробника події для кнопки рівності
        Button buttonEquals = findViewById(R.id.buttonEquals);
        buttonEquals.setOnClickListener(v -> {
            if (operand1 != 0 && !operator.isEmpty() && input.length() > 0) {
                operand2 = Double.parseDouble(input.toString());
                double result = performOperation(operand1, operand2, operator);
                input.setLength(0);
                input.append(result);
                textViewDisplay.setText(input.toString());
                operand1 = result;
                operator = "";
            }
        });
    }

    // Метод для налаштування обробника події для цифрових кнопок
    private void setNumericClickListener(int buttonId) {
        Button button = findViewById(buttonId);
        button.setOnClickListener(v -> {
            input.append(button.getText());
            textViewDisplay.setText(input.toString());
        });
    }

    // Метод для налаштування обробника події для кнопок операторів
    private void setOperatorClickListener(int buttonId, final String op) {
        Button button = findViewById(buttonId);
        button.setOnClickListener(v -> {
            if (input.length() > 0) {
                operand1 = Double.parseDouble(input.toString());
                operator = op;
                input.setLength(0);
            }
        });
    }

    // Метод для виконання математичних операцій
    private double performOperation(double operand1, double operand2, String operator) {
        switch (operator) {
            case "+":
                return operand1 + operand2;
            case "-":
                return operand1 - operand2;
            case "*":
                return operand1 * operand2;
            case "/":
                if (operand2 != 0) {
                    return operand1 / operand2;
                } else {
                    return 0; // Обробка ділення на нуль
                }
            default:
                return 0;
        }
    }
}