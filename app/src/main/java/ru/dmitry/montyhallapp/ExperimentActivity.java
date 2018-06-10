package ru.dmitry.montyhallapp;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ExperimentActivity extends AppCompatActivity implements View.OnClickListener {
    final int MAX_NUMBER = 3000000;
    int number;
    Button btn_change, btn_notchange;
    EditText et_number;
    TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_experiment);
        initViews();
    }

    @Override
    public void onClick(View v) {
        hideInput();
        if (!et_number.getText().toString().isEmpty()
                && !et_number.getText().toString().equals("0")) {
            number = Integer.parseInt(et_number.getText().toString());
            if (number > MAX_NUMBER) {
                tvResult.setText("");
                Toast.makeText(this, "Введите меньшее количество испытаний",
                        Toast.LENGTH_SHORT).show();
            } else {
                switch (v.getId()) {
                    case R.id.btn_change:
                        new FetchExpCalculation(tvResult, number).execute(true);

                        break;
                    case R.id.btn_notchange:
                        new FetchExpCalculation(tvResult, number).execute(false);
                        break;
                }
            }
        } else {
            tvResult.setText("");
            Toast.makeText(this, "Минимальное количество испытаний: 1", Toast.LENGTH_SHORT).show();
        }
    }

    private void initViews() {
        et_number = (EditText) findViewById(R.id.et_number);
        tvResult = (TextView) findViewById(R.id.tvResult);
        btn_change = (Button) findViewById(R.id.btn_change);
        btn_notchange = (Button) findViewById(R.id.btn_notchange);

        btn_change.setOnClickListener(this);
        btn_notchange.setOnClickListener(this);
    }

    private void hideInput() {
        InputMethodManager inputMethodManager =
                (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        try {
            inputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(),
                    InputMethodManager.HIDE_NOT_ALWAYS);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
