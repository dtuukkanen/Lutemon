package com.example.lutemon;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lutemon.Lutemons.Lutemon;

import java.util.ArrayList;

public class BattleActivity extends AppCompatActivity { // Activity, where Lutemons do battle

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
                Storage.getInstance().saveLutemons(view.getContext());
            }
        });

    }

    public void fight() { // Method, which is linked to the "Taisteluun"-button. Gets the chosen lutemons and passes them to the "fight" method of the "BattleField"-habitat, which return a StringBuilder to be displayed.
        ArrayList<Lutemon> checkedLutemons = battleViewAdapter.getCheckedLutemons();
        StringBuilder sb = null;
        if (checkedLutemons.size() == 2) {
            Lutemon lutemon1 = checkedLutemons.get(0);
            Lutemon lutemon2 = checkedLutemons.get(1);
            sb = Storage.getInstance().getBattlefield().fight(lutemon1, lutemon2);
            battleLog.setText(sb);
            battleViewAdapter.notifyDataSetChanged();
        }
        else {
            Toast.makeText(this, "Valitse kaksi lutemonia aloittaaksesi taistelun.", Toast.LENGTH_LONG).show();
        }
    }
}