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
    private int id = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_lutemon);
        rbArmatuuri = findViewById(R.id.rbArmatuuri);
        rbSatky = findViewById(R.id.rbSatky);
        rbLateksii = findViewById(R.id.rbLateksii);
        rbKrk = findViewById(R.id.rbKRK);
        rbKetek = findViewById(R.id.rbKetek);
        editName = findViewById(R.id.editTextName);
    }


    public void createLutemon(View view) {
        ++id;
        name = editName.getText().toString();

        if (rbArmatuuri.isChecked()) {
            Home.getInstance().createLutemon(new Armatuuri(name, id));
        }
        else if (rbSatky.isChecked()) {
            Home.getInstance().createLutemon(new Satky(name, id));
        }
        else if (rbLateksii.isChecked()) {
            Home.getInstance().createLutemon(new Lateksii(name, id));
        }
        else if (rbKrk.isChecked()) {
            Home.getInstance().createLutemon(new KRK(name, id));
        }
        else if (rbKetek.isChecked()) {
            Home.getInstance().createLutemon(new KeTek(name, id));
        }
    }
}