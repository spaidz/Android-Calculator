package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private Button btnDot, btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9,
                    btnAC, btnDEL, btnPlus, btnMinus, btnMulti, btnDivide, btnEqual;

    private TextView textViewResult, textViewHistory;
    private String number = null;

    double firstNum = 0;
    double secondNum = 0;

    String status = null;
    Boolean operator = false;

    DecimalFormat myFormatter = new DecimalFormat("######.######");

    String history, currentResult;

    Boolean dot = true;

    Boolean btnACcontrol = true;

    boolean btnEqualsControl = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnDot = findViewById(R.id.BtnDot);
        btn0 = findViewById(R.id.Btn0);
        btn1 = findViewById(R.id.Btn1);
        btn2 = findViewById(R.id.Btn2);
        btn3 = findViewById(R.id.Btn3);
        btn4 = findViewById(R.id.Btn4);
        btn5 = findViewById(R.id.Btn5);
        btn6 = findViewById(R.id.Btn6);
        btn7 = findViewById(R.id.Btn7);
        btn8 = findViewById(R.id.Btn8);
        btn9 = findViewById(R.id.Btn9);

        btnPlus = findViewById(R.id.BtnPlus);
        btnMinus = findViewById(R.id.BtnMinus);
        btnMulti = findViewById(R.id.BtnMulti);
        btnDivide = findViewById(R.id.BtnDivide);

        btnAC = findViewById(R.id.BtnAC);
        btnDEL = findViewById(R.id.BtnDEL);
        btnEqual = findViewById(R.id.BtnEqual);

        textViewHistory = findViewById(R.id.textViewHistory);
        textViewResult = findViewById(R.id.textViewResult);

        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                printNum("0");
            }
        });
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                printNum("1");
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                printNum("2");
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                printNum("3");
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                printNum("4");
            }
        });
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                printNum("5");
            }
        });
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                printNum("6");
            }
        });
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                printNum("7");
            }
        });
        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                printNum("8");
            }
        });
        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                printNum("9");
            }
        });

        btnDot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (dot) {

                    if (number == null) {
                        number = "0.";
                    } else {
                        number = number + ".";
                    }
                }

                    textViewResult.setText(number);
                dot = false;


            }
        });
        btnEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (operator)
                {
                    if (status == "sum")
                    {
                        plus();
                    }
                    else if (status == "subtraction")
                    {
                        minus();
                    }
                    else if (status == "multiplication")
                    {
                        multiply();
                    }
                    else if (status == "division")
                    {
                        divide();
                    }
                    else
                    {
                        firstNum = Double.parseDouble(textViewResult.getText().toString());
                    }
                }

                operator = false;
                btnEqualsControl = true;

            }
        });
        btnAC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                number = null;
                status = null;
                textViewResult.setText("0");
                textViewHistory.setText("");
                firstNum = 0;
                secondNum = 0;
                dot = true;
                btnACcontrol = true;


            }
        });
        btnDEL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (btnACcontrol)
                {
                    textViewResult.setText("0");
                }
                else
                {
                    number = number.substring(0, number.length()-1);

                    if (number.length() == 0)
                    {
                        btnDEL.setClickable(false);
                    }
                    else if (number.contains("."))
                    {
                        dot = false;
                    }
                    else
                    {
                        dot = true;
                    }

                    textViewResult.setText(number);
                }

            }
        });
        btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                history = textViewHistory.getText().toString();
                currentResult = textViewResult.getText().toString();
                textViewHistory.setText(history+currentResult+"+");

                if (operator)
                {
                    if (status == "multiplication")
                    {
                        multiply();
                    }
                    else if (status == "division")
                    {
                        divide();
                    }
                    else if (status == "subtraction")
                    {
                        minus();
                    }
                    else
                    {
                        plus();
                    }
                }
                status = "sum";
                operator = false;
                number = null;
            }
        });
        btnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                history = textViewHistory.getText().toString();
                currentResult = textViewResult.getText().toString();
                textViewHistory.setText(history+currentResult+"-");

                if (operator)
                {
                    if (status == "multiplication")
                    {
                        multiply();
                    }
                    else if (status == "division")
                    {
                        divide();
                    }
                    else if (status == "sum")
                    {
                        plus();
                    }
                    else
                    {
                        minus();
                    }
                }
                status = "subtraction";
                operator = false;
                number = null;

            }
        });
        btnMulti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                history = textViewHistory.getText().toString();
                currentResult = textViewResult.getText().toString();
                textViewHistory.setText(history+currentResult+"*");

                if (operator)
                {
                    if (status == "division")
                    {
                        divide();
                    }
                    else if (status == "sum")
                    {
                        plus();
                    }
                    else if (status == "subtraction")
                    {
                        minus();
                    }
                    else
                    {
                        multiply();
                    }
                }
                status = "multiplication";
                operator = false;
                number = null;

            }
        });
        btnDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                history = textViewHistory.getText().toString();
                currentResult = textViewResult.getText().toString();
                textViewHistory.setText(history+currentResult+"/");

                if (operator)
                {
                    if (status == "multiplication")
                    {
                        multiply();
                    }
                    else if (status == "sum")
                    {
                        plus();
                    }
                    else if (status == "subtraction")
                    {
                        minus();
                    }
                    else
                    {
                        divide();
                    }
                }
                status = "division";
                operator = false;
                number = null;

            }
        });



    }

    public void printNum (String view)
    {
        if (number == null)
        {
            number = view;
        }
        else if (btnEqualsControl)
        {
            firstNum = 0;
            secondNum = 0;
            number = view;
        }
        else
        {
            number = number + view;
        }

        textViewResult.setText(number);
        operator = true;
        btnACcontrol = false;
        btnDEL.setClickable(true);
        btnEqualsControl = false;
    }

    public void plus ()
    {
        secondNum = Double.parseDouble(textViewResult.getText().toString());
        firstNum = firstNum + secondNum;

        textViewResult.setText(myFormatter.format(firstNum));
        dot = true;
    }

    public void minus ()
    {
        if (firstNum == 0)
        {
            firstNum = Double.parseDouble(textViewResult.getText().toString());
        }
        else
        {
            secondNum = Double.parseDouble(textViewResult.getText().toString());
            firstNum = firstNum - secondNum;
        }

        textViewResult.setText(myFormatter.format(firstNum));
        dot = true;
    }

    public void multiply ()
    {
        if (firstNum == 0)
        {
            firstNum = 1;
            secondNum = Double.parseDouble(textViewResult.getText().toString());
            firstNum = firstNum * secondNum;
        }
        else
        {
            secondNum = Double.parseDouble(textViewResult.getText().toString());
            firstNum = firstNum * secondNum;
        }

        textViewResult.setText(myFormatter.format(firstNum));
        dot = true;
    }

    public void divide ()
    {
        if (firstNum == 0)
        {
            secondNum = Double.parseDouble(textViewResult.getText().toString());
            firstNum = secondNum / 1;
        }
        else
        {
            secondNum = Double.parseDouble(textViewResult.getText().toString());
            firstNum = firstNum / secondNum;
        }

        textViewResult.setText(myFormatter.format(firstNum));
        dot = true;
    }
}