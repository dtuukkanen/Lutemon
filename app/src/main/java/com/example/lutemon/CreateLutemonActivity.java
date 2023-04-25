package com.example.lutemon;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;

public class CreateLutemonActivity extends AppCompatActivity {

    private RadioButton rbArmatuuri, rbSatky, rbLateksii, rbKrk, rbKetek;
    private EditText editName;
    private String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_lutemon);
        rbArmatuuri = findViewById(R.id.rbArmatuuri);
        rbSatky = findViewById(R.id.rbSatky);
        rbLateksii = findViewById(R.id.rbLateksii);
        rbKrk = findViewById(R.id.rbKetek);
        rbKetek = findViewById(R.id.rbKetek);
        editName = findViewById(R.id.editTextName);
    }


    public void createLutemon(View view) {
        name = editName.getText().toString();

        if (rbArmatuuri.isChecked()) {
            //Home.home.createLutemon(new Armatuuri(name));
        }
    }
}