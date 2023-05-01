package com.example.lutemon;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity { // the main activity / "front page" of the app

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // Methods for switching to other activities
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

    public void switchToBattle(View view) {
        Intent intent = new Intent(this, BattleActivity.class);
        startActivity(intent);
    }


    public void loadLutemons(View view) { // from user input, loads all previously saved lutemons
        Storage.getInstance().loadLutemons(view.getContext());
        Toast.makeText(this, "Lutemonit ladattu!", Toast.LENGTH_LONG).show();
    }

}