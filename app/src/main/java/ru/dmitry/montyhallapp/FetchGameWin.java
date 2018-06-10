package ru.dmitry.montyhallapp;

import java.util.ArrayList;

public class FetchGameWin {
    private ArrayList<Door> doors;
    private Door choosenDoor;

    FetchGameWin(ArrayList<Door> doors) {
        this.doors = doors;
    }

    public Door openDoor(int choice, int car) {
        doors.get(car).win_door = true;
        for (Door door : doors)
            door.btn_door.setEnabled(false);
        choosenDoor = doors.get(choice);
        doors.remove(choice);
        int randvalue = FetchExpCalculation.random(2);
        if (doors.get(randvalue).win_door) doors.get(1 - randvalue)
                .iv_door.setImageResource(R.drawable.goat);
        else doors.get(randvalue)
                .iv_door.setImageResource(R.drawable.goat);
        System.out.println("Choose: " + choice + " Car: " + car);
        return choosenDoor;
    }

    public Boolean changeDoor(Door choosenDoor, Boolean change) {
        if (change) {
            if (choosenDoor.win_door) choosenDoor.win_door = false;
            else choosenDoor.win_door = true;
        }
        if (choosenDoor.win_door) return true;
        else return false;
    }
}
