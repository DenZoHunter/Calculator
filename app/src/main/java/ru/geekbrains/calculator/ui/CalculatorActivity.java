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

        findViewById(R.id.btn_clear).setOnClickListener(v -> {
            resultTextView.setText(null);
            bufferTextView.setText(null);
        });

        findViewById(R.id.btn1).setOnClickListener(v -> presenter.onButtonOneClick());

        findViewById(R.id.btn2).setOnClickListener(v -> presenter.onButtonTwoClick());

        findViewById(R.id.btn3).setOnClickListener(v -> presenter.onButtonThreeClick());

        findViewById(R.id.btn4).setOnClickListener(v -> presenter.onButtonFourClick());

        findViewById(R.id.btn5).setOnClickListener(v -> presenter.onButtonFiveClick());

        findViewById(R.id.btn6).setOnClickListener(v -> presenter.onButtonSixClick());

        findViewById(R.id.btn7).setOnClickListener(v -> presenter.onButtonSevenClick());

        findViewById(R.id.btn8).setOnClickListener(v -> presenter.onButtonEightClick());

        findViewById(R.id.btn9).setOnClickListener(v -> presenter.onButtonNineClick());

        findViewById(R.id.btn0).setOnClickListener(v -> presenter.onButtonZeroClick());

        findViewById(R.id.btn_dot).setOnClickListener(v -> presenter.onButtonDotClick());

        findViewById(R.id.btn_plus).setOnClickListener(v -> {
            presenter.setFirstOperand(Double.parseDouble(resultTextView.getText().toString()));
            presenter.onButtonPlusClick();
            bufferTextView.setText(getResources().getString(R.string.result_template, resultTextView.getText(), "+"));
            resultTextView.setText("");
        });

        findViewById(R.id.btn_minus).setOnClickListener(v -> {
            presenter.setFirstOperand(Double.parseDouble(resultTextView.getText().toString()));
            presenter.onButtonMinusClick();
            bufferTextView.setText(getResources().getString(R.string.result_template, resultTextView.getText(), "-"));
            resultTextView.setText("");
        });

        findViewById(R.id.btn_multiply).setOnClickListener(v -> {
            presenter.setFirstOperand(Double.parseDouble(resultTextView.getText().toString()));
            presenter.onButtonMultiplyClick();
            bufferTextView.setText(getResources().getString(R.string.result_template, resultTextView.getText(), "*"));
            ;
            resultTextView.setText("");
        });

        findViewById(R.id.btn_div).setOnClickListener(v -> {
            presenter.setFirstOperand(Double.parseDouble(resultTextView.getText().toString()));
            presenter.onButtonDivClick();
            bufferTextView.setText(getResources().getString(R.string.result_template, resultTextView.getText(), "/"));
            resultTextView.setText("");
        });

        findViewById(R.id.btn_equal).setOnClickListener(v -> {
            try {
                presenter.setSecondOperand(Double.parseDouble(resultTextView.getText().toString()));
            } catch (NumberFormatException e) {
                resultTextView.setText("");
            }
            bufferTextView.setText("");
            resultTextView.setText("");
            presenter.onButtonEqualClick();
        });


    }

    @Override
    public void showResult(String result) {
        resultTextView.setText(resultTextView.getText() + result);
    }

}