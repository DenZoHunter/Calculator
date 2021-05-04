package ru.geekbrains.calculator.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import ru.geekbrains.calculator.R;

public class SettingsActivity extends AppCompatActivity {

    public static final String ARG_ANSWER = "THEME";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        findViewById(R.id.btn_light).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra(ARG_ANSWER, R.style.Theme_Calculator);
                setResult(RESULT_OK, intent);
                finish();
            }
        });

        findViewById(R.id.btn_dark).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra(ARG_ANSWER, R.style.Theme_CalculatorDark);
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }

    public static void show(Activity activity, int code) {
        Intent intent = new Intent(activity, SettingsActivity.class);
        activity.startActivityForResult(intent, code);
    }


}