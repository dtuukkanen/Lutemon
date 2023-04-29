package com.example.lutemon;

import android.content.Context;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lutemon.Lutemons.Lutemon;

import java.util.ArrayList;

public class BattleViewAdapter extends RecyclerView.Adapter<CheckboxHolder> {
    private Context context;
    private ArrayList<Lutemon> lutemons = new ArrayList<>();
    private SparseBooleanArray checkedLutemons;
    private final int maxChecked = 2;
    private int counter;

    public BattleViewAdapter(Context context, ArrayList<Lutemon> lutemons) {
        this.context = context;
        this.lutemons = lutemons;
        checkedLutemons = new SparseBooleanArray();
        counter = 0;
    }


    @NonNull
    @Override
    public CheckboxHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CheckboxHolder(LayoutInflater.from(context).inflate(R.layout.checkbox_view, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull CheckboxHolder holder, int position) {
        holder.checkBox.setText(lutemons.get(position).getName());
        holder.checkBox.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                if (counter >= maxChecked) {
                    buttonView.setChecked(false);
                } else {
                    checkedLutemons.put(position, true);
                    counter++;
                }
            } else {
                checkedLutemons.delete(position);
                counter--;
            }
        });
    }

    @Override
    public int getItemCount() {
        return lutemons.size();
    }

    public ArrayList<Lutemon> getCheckedLutemons() {
        ArrayList<Lutemon> lutemonsChecked = new ArrayList<>();
        for (int i = 0; i < lutemons.size(); i++) {
            if (checkedLutemons.get(i)) {
                lutemonsChecked.add(lutemons.get(i));
            }
        }
        return lutemonsChecked;
    }
}
