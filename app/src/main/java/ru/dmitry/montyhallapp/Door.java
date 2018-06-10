package ru.dmitry.montyhallapp;

import android.widget.Button;
import android.widget.ImageView;

public class Door {
    ImageView iv_door;
    Button btn_door;
    Boolean win_door;

    Door(ImageView iv_door, Button btn_door) {
        this.iv_door = iv_door;
        this.btn_door = btn_door;
        this.win_door = false;
    }

}
