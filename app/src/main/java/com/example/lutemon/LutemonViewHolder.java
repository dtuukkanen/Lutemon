package com.example.lutemon;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class LutemonViewHolder extends RecyclerView.ViewHolder {

    TextView holderName, holderAttack, holderDefence, holderHealth, holderExperience;
    ImageView holderImage;


    public LutemonViewHolder(@NonNull View itemView) {
        super(itemView);

        holderName = itemView.findViewById(R.id.tvName);
        holderAttack = itemView.findViewById(R.id.tvAttack);
        holderDefence = itemView.findViewById(R.id.tvDefence);
        holderHealth = itemView.findViewById(R.id.tvHealth);
        holderExperience = itemView.findViewById(R.id.tvExperience);
        holderImage = itemView.findViewById(R.id.ivImage);
    }
}
