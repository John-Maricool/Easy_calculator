package com.example.normalcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText question, answer;
    Button one, two, three, four, five, six, seven, eight, nine, zero;
    Button multiply, divide, plus, minus, reset, equals, decimal;
    String process;
    boolean lastNumeric, decimalPt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        question = (EditText)findViewById(R.id.question);
        answer = (EditText)findViewById(R.id.answer);

        one = (Button)findViewById(R.id.one);
        two = (Button)findViewById(R.id.two);
        three = (Button)findViewById(R.id.three);
        four = (Button)findViewById(R.id.four);
        five = (Button)findViewById(R.id.five);
        six = (Button)findViewById(R.id.six);
        seven = (Button)findViewById(R.id.seven);
        eight = (Button)findViewById(R.id.eight);
        nine = (Button)findViewById(R.id.nine);
        zero = (Button)findViewById(R.id.zero);

        decimal = (Button)findViewById(R.id.decimal);
        multiply = (Button)findViewById(R.id.multiply);
        divide = (Button)findViewById(R.id.divide);
        equals = (Button)findViewById(R.id.equal);
        plus = (Button)findViewById(R.id.plus);
        minus = (Button)findViewById(R.id.minus);
        reset = (Button)findViewById(R.id.delete);

        one.setOnClickListener(this);
        two.setOnClickListener(this);
        three.setOnClickListener(this);
        four.setOnClickListener(this);
        five.setOnClickListener(this);
        six.setOnClickListener(this);
        seven.setOnClickListener(this);
        eight.setOnClickListener(this);
        nine.setOnClickListener(this);
        zero.setOnClickListener(this);
        minus.setOnClickListener(this);
        divide.setOnClickListener(this);
        plus.setOnClickListener(this);
        reset.setOnClickListener(this);
        decimal.setOnClickListener(this);
        multiply.setOnClickListener(this);
        equals.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.one:
                process = question.getText().toString();
                question.setText(process + "1");
                lastNumeric = true;
                break;
            case R.id.two:
                process = question.getText().toString();
                question.setText(process + "2");
                lastNumeric = true;
                break;
            case R.id.three:
                process = question.getText().toString();
                question.setText(process + "3");
                lastNumeric = true;
                break;
            case R.id.four:
                process = question.getText().toString();
                question.setText(process + "4");
                lastNumeric = true;
                break;
            case R.id.five:
                process = question.getText().toString();
                question.setText(process + "5");
                lastNumeric = true;
                break;
            case R.id.six:
                process = question.getText().toString();
                question.setText(process + "6");
                lastNumeric = true;
                break;
            case R.id.seven:
                process = question.getText().toString();
                question.setText(process + "7");
                lastNumeric = true;
                break;
            case R.id.eight:
                process = question.getText().toString();
                question.setText(process +"8");
                lastNumeric = true;
                break;
            case R.id.nine:
                process = question.getText().toString();
                question.setText(process + "9");
                lastNumeric = true;
                break;
            case R.id.zero:
                process = question.getText().toString();
                question.setText(process + "0");
                lastNumeric = true;
                break;
            case R.id.minus:
                if(lastNumeric) {
                    process = question.getText().toString();
                    question.setText(process + "-");
                    lastNumeric = false;
                }
                break;
            case R.id.divide:
                if(lastNumeric) {
                    process = question.getText().toString();
                    question.setText(process + "/");
                    lastNumeric = false;
                }
                break;
            case R.id.plus:
                if(lastNumeric) {
                    process = question.getText().toString();
                    question.setText(process + "+");
                    lastNumeric = false;
                }
                break;
            case R.id.multiply:
                if (lastNumeric) {
                    process = question.getText().toString();
                    question.setText(process + "x");
                    lastNumeric = true;
                }
                break;
            case R.id.decimal:
                if (lastNumeric) {
                    process = question.getText().toString();
                    question.setText(process + ".");
                    lastNumeric = true;
                }
                break;
            case R.id.delete:
                question.setText("");
                answer.setText("");
                lastNumeric = false;

            case  R.id.equal:
                process = question.getText().toString();
                process = process.replaceAll("x", "*");
                if(lastNumeric){
                    Expression expression  = new ExpressionBuilder(process).build();
                    try{
                        double result = expression.evaluate();
                        answer.setText(Double.toString(result));

                    }catch (Exception e){
                        answer.setText("Error");
                        lastNumeric = false;
                    }
                }




        }
}
}