package com.anthonyhaspect.anthonyhaspect;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class VoitureAdapteur extends ArrayAdapter<Voiture> {
    private Context context;
    private LayoutInflater inflater;

    public VoitureAdapteur(Context context, ArrayList<Voiture> tabVoiture){
        super(context, 0, (List<Voiture>) tabVoiture);
        this.context = context;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public View getView(int position, View view, ViewGroup parent){
        if(view == null){
            view = inflater.inflate(R.layout.layout_voiture, parent, false);
        }
        TextView tvMarque =  view.findViewById(R.id.tvMarque);
        TextView tvModel =  view.findViewById(R.id.tvModel);
        TextView tvTel =  view.findViewById(R.id.tvNumeroTel);
        TextView tvPrix = view.findViewById(R.id.tvPrix);
        ImageView image = view.findViewById(R.id.imgView);
        Voiture voiture = this.getItem(position);
        tvMarque.setText(voiture.marque);
        tvModel.setText(voiture.model);
        String str = voiture.prix + "$";
        tvPrix.setText(str);
        tvTel.setText(voiture.numTel);
        image.setImageDrawable(context.getDrawable(voiture.id));

        return view;

    }
}
