package com.anthonyhaspect.anthonyhaspect;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ListView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView lvVoiture;
    ArrayList<Voiture> tabVoiture;
    VoitureAdapteur adapteur;
    ImageButton btnAjout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAjout = findViewById(R.id.imgBtn);
        lvVoiture = findViewById(R.id.lsView);

        SharedPreferences preferences = getSharedPreferences("cle", MODE_PRIVATE);
        String listeVoiture = preferences.getString("liste", "");
        Type type = new TypeToken<ArrayList<Voiture>>(){}.getType();
        tabVoiture = new Gson().fromJson(listeVoiture, type);

        if(tabVoiture == null || tabVoiture.isEmpty()){
            tabVoiture = new ArrayList<Voiture>();
            tabVoiture.add(new Voiture("Toyota", "corola", "819-666-1234", 3000, R.drawable.voiture));
            tabVoiture.add(new Voiture("Honda", "je sais pas", "819-666-1234", 3000, R.drawable.voiture));
            tabVoiture.add(new Voiture("Ford", "F-150", "819-666-1234", 3000, R.drawable.voiture));
            tabVoiture.add(new Voiture("Jeep", "Compass", "819-666-1234", 3000, R.drawable.voiture));
            tabVoiture.add(new Voiture("Tesla", "Model 3", "819-666-1234", 3000, R.drawable.voiture));
        }
        adapteur = new VoitureAdapteur(this, tabVoiture);
        lvVoiture.setAdapter(adapteur);

        btnAjout.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(MainActivity.this, AjoutVoiture.class);
                startActivityForResult(intent, 1);
            }
        });

    }
}