package com.example.lutemon;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

import com.example.lutemon.Lutemons.Lutemon;

import java.util.ArrayList;

public class BattleActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private BattleViewAdapter battleViewAdapter;
    private Button fightButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_battle);
        fightButton = findViewById(R.id.btnFight);
        recyclerView = findViewById(R.id.rvFighterList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        battleViewAdapter = new BattleViewAdapter(getApplicationContext(), Storage.getInstance().getBattlefield().getLutemons());
        recyclerView.setAdapter(battleViewAdapter);
        fightButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fight();
            }
        });

    }

    public void fight() {
        ArrayList<Lutemon> checkedLutemons = battleViewAdapter.getCheckedLutemons();
        Lutemon lutemonOne = checkedLutemons.get(0);
        Lutemon lutemonTwo = checkedLutemons.get(1);
        if (checkedLutemons.size() == 2) {
            Storage.getInstance().getBattlefield().fight(lutemonOne, lutemonTwo);
        }
    }
}