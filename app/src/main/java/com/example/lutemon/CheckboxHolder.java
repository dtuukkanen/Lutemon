package com.example.lutemon;

import android.view.View;
import android.widget.CheckBox;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CheckboxHolder extends RecyclerView.ViewHolder {

    CheckBox checkBox;

    public CheckboxHolder(@NonNull View itemView) {
        super(itemView);

        checkBox = itemView.findViewById(R.id.checkBox);
    }
}
