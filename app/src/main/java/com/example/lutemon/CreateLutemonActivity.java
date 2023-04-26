package com.example.lutemon;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;

import com.example.lutemon.Lutemons.Armatuuri;
import com.example.lutemon.Lutemons.KRK;
import com.example.lutemon.Lutemons.KeTek;
import com.example.lutemon.Lutemons.Lateksii;
import com.example.lutemon.Lutemons.Lutemon;
import com.example.lutemon.Lutemons.Satky;

public class CreateLutemonActivity extends AppCompatActivity {

    private RadioButton rbArmatuuri, rbSatky, rbLateksii, rbKrk, rbKetek;
    private EditText editName;
    private String name;
    private int id = -1;
    private Lutemon lutemon;

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
            lutemon = new Armatuuri(name, id);
            rbArmatuuri.setChecked(false);
        }
        else if (rbSatky.isChecked()) {
            lutemon = new Satky(name, id);
            rbSatky.setChecked(false);
        }
        else if (rbLateksii.isChecked()) {
            lutemon = new Lateksii(name, id);
            rbLateksii.setChecked(false);
        }
        else if (rbKrk.isChecked()) {
           lutemon = new KRK(name, id);
            rbKrk.setChecked(false);
        }
        else if (rbKetek.isChecked()) {
            lutemon = new KeTek(name, id);
            rbKetek.setChecked(false);
        }
        editName.setText("");
        Storage.getInstance().getHome().createLutemon(lutemon);
    }
}