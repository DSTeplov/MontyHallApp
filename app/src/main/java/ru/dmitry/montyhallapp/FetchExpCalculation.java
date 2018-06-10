package ru.dmitry.montyhallapp;

import android.os.AsyncTask;
import android.widget.TextView;

public class FetchExpCalculation extends AsyncTask<Boolean, Integer, Integer> {
    int number;
    TextView tvResult;

    FetchExpCalculation(TextView tvResult, int number) {
        this.tvResult = tvResult;
        this.number = number;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        tvResult.setText("Выполняется...");
    }

    @Override
    protected Integer doInBackground(Boolean... params) {
        int result = 0;
        boolean mode = params[0];
        int car_number, choice_number;

        for (int i = 0; i < number; i++) {
            car_number = random(3);
            choice_number = random(3);
            if (mode) {
                if (choice_number == car_number) choice_number = -1;
                else choice_number = car_number;
            }
            if (car_number == choice_number) result++;
        }
        return result;
    }


    @Override
    protected void onPostExecute(Integer result) {
        super.onPostExecute(result);
        tvResult.setText(result + "/" + number + " = " +
                ((double) result / (double) number) * 100 + "%");
    }

    static int random(int count) {
        return (int) (Math.random() * count);
    }
}
