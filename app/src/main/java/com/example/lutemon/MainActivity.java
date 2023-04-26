package com.example.lutemon;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void switchToMove(View view) {
        Intent intent = new Intent(this, MoveActivity.class);
        startActivity(intent);
    }

    public void switchToList(View view) {
        Intent intent = new Intent(this, ListActivity.class);
        startActivity(intent);
    }

    public void switchToCreation(View view) {
        Intent intent = new Intent(this, CreateLutemonActivity.class);
        startActivity(intent);
    }


    public void loadLutemons(View view) {
        Storage.getInstance().loadLutemons(view.getContext());
    }

    public void switchToBattle(View view) {
        Intent intent = new Intent(this, BattleActivity.class);
        startActivity(intent);
    }


}