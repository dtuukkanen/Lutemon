package com.example.lutemon;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lutemon.Lutemons.Lutemon;

import java.util.ArrayList;

public class LutemonViewAdapter extends RecyclerView.Adapter<LutemonViewHolder> { // Card for individual lutemon to be displayed, when listing all saved lutemons.

    private Context context;
    private ArrayList<Lutemon> lutemons = new ArrayList<>();

    public LutemonViewAdapter(Context context, ArrayList<Lutemon> lutemons) {
        this.context = context;
        this.lutemons = lutemons;
    }

    @NonNull
    @Override
    public LutemonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new LutemonViewHolder(LayoutInflater.from(context).inflate(R.layout.lutemon_card_view, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull LutemonViewHolder holder, int position) {

        holder.holderName.setText(lutemons.get(position).getName() + " (" + lutemons.get(position).getColor() + ") - " + lutemons.get(position).getStatus());
        holder.holderAttack.setText("Hyökkäys: " +lutemons.get(position).getAttack());
        holder.holderDefence.setText("Puolustus: " + lutemons.get(position).getDefence());
        holder.holderHealth.setText("Elämä: " + lutemons.get(position).getHealth() + "/" + lutemons.get(position).getMaxHealth());
        holder.holderExperience.setText("Kokemus: " + lutemons.get(position).getExperience());
        holder.holderStats.setText("Voitot: " + lutemons.get(position).getWins() + "\nTaistelut: " + lutemons.get(position).getBattles() + "\nTreenipäivät: " + lutemons.get(position).getTrainingDays());
        holder.holderImage.setImageResource(lutemons.get(position).getImage());

    }

    @Override
    public int getItemCount() {
        return lutemons.size();
    }
}
