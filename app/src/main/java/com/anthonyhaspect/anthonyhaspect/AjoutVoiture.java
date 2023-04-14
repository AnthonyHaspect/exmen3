package com.anthonyhaspect.anthonyhaspect;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.gson.Gson;

public class AjoutVoiture extends AppCompatActivity {
    Button btnAjouter;
    EditText etmarque;
    EditText etmodel;
    EditText etprix;
    EditText ettel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajout_voiture);

        etmarque = findViewById(R.id.etMarque);
        etmodel = findViewById(R.id.etModel);
        ettel = findViewById(R.id.etTel);
        etprix = findViewById(R.id.etPrix);
        btnAjouter = findViewById(R.id.button);

        btnAjouter.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String marque = etmarque.getText().toString();
                String model = etmodel.getText().toString();
                String tel = ettel.getText().toString();
                String prix = etprix.getText().toString();
                float prixF = Float.parseFloat(prix);

                Voiture nouvelVoiture = new Voiture(marque, model, tel, prixF, R.drawable.voiture);
                String heroJson = new Gson().toJson(nouvelVoiture);
                Intent intent = new Intent();
                intent.putExtra("Hero", heroJson);
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }
}