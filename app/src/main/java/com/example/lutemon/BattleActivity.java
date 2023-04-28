package com.example.lutemon;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lutemon.Lutemons.Lutemon;

import java.util.ArrayList;

public class BattleActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private BattleViewAdapter battleViewAdapter;
    private Button fightButton;
    private TextView battleLog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_battle);
        fightButton = findViewById(R.id.btnFight);
        battleLog = findViewById(R.id.tvBattleLog);
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
        StringBuilder sb = null;
        if (checkedLutemons.size() == 2) {
            Lutemon lutemonOne = checkedLutemons.get(0);
            Lutemon lutemonTwo = checkedLutemons.get(1);
            sb = Storage.getInstance().getBattlefield().fight(lutemonOne, lutemonTwo);
            Toast.makeText(this, "Taistelu alkoi!", Toast.LENGTH_LONG).show();
            battleLog.setMovementMethod(new ScrollingMovementMethod());
            battleLog.setText(sb);
        }
    }
}