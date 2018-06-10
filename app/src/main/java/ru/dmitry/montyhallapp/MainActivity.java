package ru.dmitry.montyhallapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import br.com.bloder.magic.view.MagicButton;

public class MainActivity extends AppCompatActivity {
    MagicButton mbtn_exp, mbtn_game;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mbtn_exp = (MagicButton) findViewById(R.id.mgcbtn_exp);
        mbtn_game = (MagicButton) findViewById(R.id.mgcbtn_game);

        mbtn_exp.setMagicButtonClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ExperimentActivity.class));
            }
        });
        mbtn_game.setMagicButtonClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, GameActivity.class));
            }
        });
    }
}
