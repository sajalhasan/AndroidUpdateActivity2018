package com.blog.sajal.coolcalculatorofudmy;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
    Button one, two, three, four, five, six, seven, eight, nine, zero, sub, mult, add, divit, dot, equal, plus_minus;
    ImageButton imgClear;

    TextView result, input;

    String runningNumberStr = "";
    String leftNumberStr = "";
    String rightNumberStr = "";
    double output = 0;

    public enum Operation {
        DIVI, SUB, MULT, ADD, EQUAL
    }

    Operation currentOperation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        result = (TextView) findViewById(R.id.txtResult);
        input = (TextView) findViewById(R.id.txtInput);

        one = (Button) findViewById(R.id.btn_one);
        two = (Button) findViewById(R.id.btn_two);
        three = (Button) findViewById(R.id.btn_three);
        four = (Button) findViewById(R.id.btn_four);
        five = (Button) findViewById(R.id.btn_five);
        six = (Button) findViewById(R.id.btn_six);
        seven = (Button) findViewById(R.id.btn_seven);
        eight = (Button) findViewById(R.id.btn_eight);
        nine = (Button) findViewById(R.id.btn_nine);
        zero = (Button) findViewById(R.id.btn_zero);

        dot = (Button) findViewById(R.id.btn_dot);

        mult = (Button) findViewById(R.id.btn_mult);
        divit = (Button) findViewById(R.id.btn_divit);
        sub = (Button) findViewById(R.id.btn_sub);
        add = (Button) findViewById(R.id.btn_add);

        plus_minus = (Button) findViewById(R.id.btn_plus_minus);
        equal = (Button) findViewById(R.id.btn_equal);

        imgClear = (ImageButton) findViewById(R.id.btn_Clear);

        result.setText("");
        input.setText("");

        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberPressed(1);
            }
        });

        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberPressed(2);
            }
        });

        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberPressed(3);
            }
        });
        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberPressed(4);
            }
        });
        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberPressed(5);
            }
        });
        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberPressed(6);
            }
        });
        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberPressed(7);
            }
        });
        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberPressed(8);
            }
        });

        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberPressed(9);
            }
        });
        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberPressed(0);
            }
        });

        imgClear.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                result.setText("");
                input.setText("");
                leftNumberStr = "";
                rightNumberStr = "";
                currentOperation = null;
            }
        });
        dot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                processOperation(Operation.SUB);
            }
        });
        mult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                processOperation(Operation.MULT);
            }
        });
        divit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                processOperation(Operation.DIVI);
            }
        });
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                processOperation(Operation.ADD);
            }
        });
    }

    public void processOperation(Operation operation) {

            if (currentOperation != null) {

                if (runningNumberStr != null) {
                    rightNumberStr = runningNumberStr;
                    runningNumberStr = "";

                    switch (operation) {
                        case ADD:
                            output = Integer.parseInt(leftNumberStr) + Integer.parseInt(rightNumberStr);
                            break;
                        case SUB:
                            output = Integer.parseInt(leftNumberStr) - Integer.parseInt(rightNumberStr);
                            break;
                        case MULT:
                            output = Integer.parseInt(leftNumberStr) * Integer.parseInt(rightNumberStr);
                            break;
                        case DIVI:
                            output = Integer.parseInt(leftNumberStr) / Integer.parseInt(rightNumberStr);
                            break;
                    }
                    leftNumberStr = String.valueOf(output);
                    result.setText(leftNumberStr);
                }
                currentOperation = operation;
            } else {
                leftNumberStr = runningNumberStr;
                runningNumberStr = "";
                input.setText("");
            }
            currentOperation = operation;

    }

    public void numberPressed(int number) {
        runningNumberStr += String.valueOf(number);
        input.setText(runningNumberStr);
    }

}
