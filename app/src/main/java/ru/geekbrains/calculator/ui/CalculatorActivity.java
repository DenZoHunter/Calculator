package ru.geekbrains.calculator.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import ru.geekbrains.calculator.R;
import ru.geekbrains.calculator.logic.CalculatorAndroid;

public class CalculatorActivity extends AppCompatActivity implements CalculatorView {

    private CalculatorPresenter presenter;
    private TextView resultTextView;
    private TextView bufferTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        presenter = new CalculatorPresenter(this, new CalculatorAndroid());
        resultTextView = findViewById(R.id.resultTextView);
        bufferTextView = findViewById(R.id.bufferTextView);

        findViewById(R.id.btn_clear).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resultTextView.setText(null);
                bufferTextView.setText(null);
            }
        });

        findViewById(R.id.btn1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onButtonOneClick();
            }
        });

        findViewById(R.id.btn2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onButtonTwoClick();
            }
        });

        findViewById(R.id.btn3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onButtonThreeClick();
            }
        });

        findViewById(R.id.btn4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onButtonFourClick();
            }
        });

        findViewById(R.id.btn5).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onButtonFiveClick();
            }
        });

        findViewById(R.id.btn6).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onButtonSixClick();
            }
        });

        findViewById(R.id.btn7).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onButtonSevenClick();
            }
        });

        findViewById(R.id.btn8).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onButtonEightClick();
            }
        });

        findViewById(R.id.btn9).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onButtonNineClick();
            }
        });

        findViewById(R.id.btn0).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onButtonZeroClick();
            }
        });

        findViewById(R.id.btn_dot).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onButtonDotClick();
            }
        });

        findViewById(R.id.btn_plus).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.setFirstOperand(Double.parseDouble(resultTextView.getText().toString()));
                presenter.onButtonPlusClick();

                bufferTextView.setText(resultTextView.getText() + "+");
                resultTextView.setText("");
            }
        });

        findViewById(R.id.btn_minus).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.setFirstOperand(Double.parseDouble(resultTextView.getText().toString()));
                presenter.onButtonMinusClick();
                bufferTextView.setText(resultTextView.getText() + "-");
                resultTextView.setText("");
            }
        });

        findViewById(R.id.btn_multiply).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.setFirstOperand(Double.parseDouble(resultTextView.getText().toString()));
                presenter.onButtonMultiplyClick();
                bufferTextView.setText(resultTextView.getText() + "*");
                resultTextView.setText("");
            }
        });

        findViewById(R.id.btn_div).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.setFirstOperand(Double.parseDouble(resultTextView.getText().toString()));
                presenter.onButtonDivClick();
                bufferTextView.setText(resultTextView.getText() + "/");
                resultTextView.setText("");
            }
        });

        findViewById(R.id.btn_equal).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    presenter.setSecondOperand(Double.parseDouble(resultTextView.getText().toString()));
                } catch (NumberFormatException e) {
                    resultTextView.setText("");
                }
                bufferTextView.setText("");
                resultTextView.setText("");
                presenter.onButtonEqualClick();
            }
        });


    }

    @Override
    public void showResult(String result) {
        resultTextView.setText(resultTextView.getText() + result);
    }

}