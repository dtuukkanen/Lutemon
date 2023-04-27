package com.example.lutemon;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;

import com.example.lutemon.Lutemons.Lutemon;

import java.util.ArrayList;

public class BattleActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private BattleViewAdapter battleViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_battle);
        recyclerView = findViewById(R.id.rvFighterList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        battleViewAdapter = new BattleViewAdapter(getApplicationContext(), Storage.getInstance().getBattlefield().getLutemons());
        recyclerView.setAdapter(battleViewAdapter);

    }
}