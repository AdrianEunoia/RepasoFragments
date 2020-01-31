package com.adrian.repasofragments.Fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.adrian.repasofragments.Adaptadores.AdaptadorRecycler;
import com.adrian.repasofragments.R;
import com.adrian.repasofragments.Utiles.Persona;

import java.util.ArrayList;

public class FragmentRecycler extends Fragment {
    // Elementos
    private RecyclerView recyclerView;
    private AdaptadorRecycler adatadorRecycler;
    private ArrayList<Persona> listaPersonas;
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        listaPersonas = new ArrayList();
        listaPersonas.add(new Persona ("Nombre 1", "Apellido 1", R.drawable.f1));
        listaPersonas.add(new Persona ("Nombre 2", "Apellido 2", R.drawable.f2));
        listaPersonas.add(new Persona ("Nombre 3", "Apellido 3", R.drawable.f3));
        listaPersonas.add(new Persona ("Nombre 4", "Apellido 4", R.drawable.f4));
        listaPersonas.add(new Persona ("Nombre 5", "Apellido 5", R.drawable.f5));
        listaPersonas.add(new Persona ("Nombre 6", "Apellido 6", R.drawable.f6));
        listaPersonas.add(new Persona ("Nombre 7", "Apellido 7", R.drawable.f7));
        listaPersonas.add(new Persona ("Nombre 8", "Apellido 8", R.drawable.f8));
        listaPersonas.add(new Persona ("Nombre 9", "Apellido 9", R.drawable.f9));
        listaPersonas.add(new Persona ("Nombre 10", "Apellido 10", R.drawable.f10));
        adatadorRecycler = new AdaptadorRecycler(context, listaPersonas);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        recyclerView.setAdapter(adatadorRecycler);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_uno_layout, container, false);
        recyclerView = view.findViewById(R.id.idRecyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(),2, RecyclerView.VERTICAL, false));
        return view;
    }

}
