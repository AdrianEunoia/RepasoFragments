package com.adrian.repasofragments.Adaptadores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.adrian.repasofragments.R;
import com.adrian.repasofragments.Utiles.Elementos;

import java.util.ArrayList;

public class AdaptadorSpinner extends BaseAdapter {
    // Elementos
    ArrayList elementosSpinner;
    Context context;
    // Constructor
    public AdaptadorSpinner(ArrayList elementosSpinner, Context context) {
        this.elementosSpinner = elementosSpinner;
        this.context = context;
    }

    @Override
    public int getCount() {
        return elementosSpinner.size();
    }

    @Override
    public Object getItem(int i) {
        return elementosSpinner.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = LayoutInflater.from(context).inflate(R.layout.spinner_layout, viewGroup, false);
        //Persona
        Elementos elementosEncontrados = (Elementos) elementosSpinner.get(i);
        // Instancias
        TextView nombre = view.findViewById(R.id.idNombre);
        TextView numero = view.findViewById(R.id.idNumero);
        // Set
        nombre.setText(elementosEncontrados.getNombre());
        numero.setText(String.valueOf(elementosEncontrados.getNumero()));

        return view;
    }
}
