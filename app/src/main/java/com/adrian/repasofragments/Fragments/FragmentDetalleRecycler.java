package com.adrian.repasofragments.Fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.adrian.repasofragments.R;
import com.adrian.repasofragments.Utiles.Persona;

public class FragmentDetalleRecycler  extends Fragment {
    // Elementos
    private ImageView imagen;
    private TextView nombre, apellido;
    static String TAG_ARG1 = "personaPasada";
    private Persona persona;

    // Instancia (Nueva)
    public static FragmentDetalleRecycler newInstance(Persona persona){
        FragmentDetalleRecycler fragmentDetalle = new FragmentDetalleRecycler();
        Bundle bundle = new Bundle();
        bundle.putSerializable(TAG_ARG1, persona);
        fragmentDetalle.setArguments(bundle);
        return fragmentDetalle;
    }
    // Metodos fragment
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        persona = (Persona) this.getArguments().get(TAG_ARG1);
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_dos_layout, container, false);
        imagen = view.findViewById(R.id.imagen_detalle);
        nombre = view.findViewById(R.id.nombre_detalle);
        apellido = view.findViewById(R.id.apellido_detalle);
        return view;
    }
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        imagen.setImageResource(persona.getImagen());
        nombre.setText(persona.getNombre());
        apellido.setText(persona.getApellido());
    }
}
