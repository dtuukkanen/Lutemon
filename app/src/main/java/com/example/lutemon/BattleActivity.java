package com.example.lutemon;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.CheckBox;

public class BattleActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private CheckBox checkBox;
    private CheckboxAdapter checkboxAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_battle);
        recyclerView = findViewById(R.id.rvFighterList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new CheckboxAdapter(getApplicationContext(), Storage.getInstance().getBattlefield().getLutemons()));

    }
}