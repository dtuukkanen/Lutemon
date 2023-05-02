package com.example.lutemon;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.lutemon.Lutemons.Armatuuri;
import com.example.lutemon.Lutemons.KRK;
import com.example.lutemon.Lutemons.KeTek;
import com.example.lutemon.Lutemons.Lateksii;
import com.example.lutemon.Lutemons.Lutemon;
import com.example.lutemon.Lutemons.Satky;

public class CreateLutemonActivity extends AppCompatActivity { // Activity, where all new lutemons are created
    private EditText editName;
    private String name;
    private RadioGroup rgLutemonTypes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_lutemon);
        rgLutemonTypes = findViewById(R.id.rgLutemonTypes);
        editName = findViewById(R.id.editTextName);
    }


    public void createLutemon(View view) { // Determines from user input, what kind of Lutemon is created and saves it to the storage. Informs the user of successful creation of Lutemon.
        name = editName.getText().toString();

        switch (rgLutemonTypes.getCheckedRadioButtonId()) {
            case R.id.rbArmatuuri:
                Storage.getInstance().getHome().createLutemon(new Armatuuri(name));
                Toast.makeText(this, "Lutemon pyydystetty!", Toast.LENGTH_LONG).show();
                break;
            case R.id.rbSatky:
                Storage.getInstance().getHome().createLutemon(new Satky(name));
                Toast.makeText(this, "Lutemon pyydystetty!", Toast.LENGTH_LONG).show();
                break;
            case R.id.rbLateksii:
                Storage.getInstance().getHome().createLutemon(new Lateksii(name));
                Toast.makeText(this, "Lutemon pyydystetty!", Toast.LENGTH_LONG).show();
                break;
            case R.id.rbKRK:
                Storage.getInstance().getHome().createLutemon(new KRK(name));
                Toast.makeText(this, "Lutemon pyydystetty!", Toast.LENGTH_LONG).show();
                break;
            case R.id.rbKetek:
                Storage.getInstance().getHome().createLutemon(new KeTek(name));
                Toast.makeText(this, "Lutemon pyydystetty!", Toast.LENGTH_LONG).show();
                break;
            default:
                Toast.makeText(this, "Valitse tyyppi!", Toast.LENGTH_LONG).show();
                break;
        }
        Storage.getInstance().saveLutemons(view.getContext());
        editName.setText("");
        rgLutemonTypes.clearCheck();
    }
}