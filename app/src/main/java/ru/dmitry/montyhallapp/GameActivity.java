package ru.dmitry.montyhallapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class GameActivity extends AppCompatActivity implements View.OnClickListener {
    Button btn_door1, btn_door2, btn_door3, btn_notchange, btn_change, btn_restart;
    ImageView iv_door1, iv_door2, iv_door3, iv_result;
    TextView tv_question, tv_youwin;
    int car;
    Door choosenDoor;
    ArrayList<Door> doors;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        initViews();
        doors = new ArrayList<>();
        doors.add(new Door(iv_door1, btn_door1));
        doors.add(new Door(iv_door2, btn_door2));
        doors.add(new Door(iv_door3, btn_door3));
        car = FetchExpCalculation.random(3);
    }

    @Override
    public void onClick(View v) {
        FetchGameWin game = new FetchGameWin(doors);
        switch (v.getId()) {
            case R.id.btn_door1:
                choosenDoor = game.openDoor(0, car);
                setVisibleViews(tv_question, btn_change, btn_notchange);
                break;

            case R.id.btn_door2:
                choosenDoor = game.openDoor(1, car);
                setVisibleViews(tv_question, btn_change, btn_notchange);
                break;

            case R.id.btn_door3:
                choosenDoor = game.openDoor(2, car);
                setVisibleViews(tv_question, btn_change, btn_notchange);
                break;

            case R.id.btn_notchange:
                btn_change.setEnabled(false);
                btn_notchange.setEnabled(false);
                setVisibleViews(tv_youwin);
                if (game.changeDoor(choosenDoor, false)) iv_result.setImageResource(R.drawable.car);
                else iv_result.setImageResource(R.drawable.goat);
                setVisibleViews(btn_restart);
                break;

            case R.id.btn_change:
                btn_change.setEnabled(false);
                btn_notchange.setEnabled(false);
                setVisibleViews(tv_youwin);
                if (game.changeDoor(choosenDoor, true)) iv_result.setImageResource(R.drawable.car);
                else iv_result.setImageResource(R.drawable.goat);
                setVisibleViews(btn_restart);
                break;

            case R.id.btn_restart:
                this.recreate();
                break;
        }
    }

    private void setVisibleViews(View... views) {
        for (View view : views) {
            view.setVisibility(View.VISIBLE);
        }
    }

    private void initViews() {
        btn_door1 = (Button) findViewById(R.id.btn_door1);
        btn_door2 = (Button) findViewById(R.id.btn_door2);
        btn_door3 = (Button) findViewById(R.id.btn_door3);
        btn_change = (Button) findViewById(R.id.btn_change);
        btn_notchange = (Button) findViewById(R.id.btn_notchange);
        btn_restart = (Button) findViewById(R.id.btn_restart);
        iv_door1 = (ImageView) findViewById(R.id.iv_door1);
        iv_door2 = (ImageView) findViewById(R.id.iv_door2);
        iv_door3 = (ImageView) findViewById(R.id.iv_door3);
        iv_result = (ImageView) findViewById(R.id.iv_result);
        tv_question = (TextView) findViewById(R.id.tv_question);
        tv_youwin = (TextView) findViewById(R.id.tv_youwin);

        btn_door1.setOnClickListener(this);
        btn_door2.setOnClickListener(this);
        btn_door3.setOnClickListener(this);
        btn_change.setOnClickListener(this);
        btn_notchange.setOnClickListener(this);
        btn_restart.setOnClickListener(this);

    }
}
