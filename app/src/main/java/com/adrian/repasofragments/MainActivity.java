package com.adrian.repasofragments;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.Toast;

import com.adrian.repasofragments.Adaptadores.AdaptadorRecycler;
import com.adrian.repasofragments.Adaptadores.AdaptadorSpinner;
import com.adrian.repasofragments.Fragments.FragmentDetalleRecycler;
import com.adrian.repasofragments.Fragments.FragmentEstatico;
import com.adrian.repasofragments.Fragments.FragmentRecycler;
import com.adrian.repasofragments.Utiles.Elementos;
import com.adrian.repasofragments.Utiles.Persona;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener, AdaptadorRecycler.OnRecyclerListener {
    // Elementos
    // Elementos para spinner
    Spinner idSpinner;
    ArrayList elementosSpinner;
    AdaptadorSpinner adaptadorSpinner;
    // Elementos fragment
    FragmentTransaction fragmentTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        instancias();
        rellenarSpinner();
        acciones();
    }
    // Acciones
    private void acciones() {
        idSpinner.setOnItemSelectedListener(this);
    }

    // Instancias
    private void instancias() {
        // Spinner
        idSpinner = this.findViewById(R.id.idSpìnner);
        elementosSpinner = new ArrayList();
        adaptadorSpinner = new AdaptadorSpinner(elementosSpinner,getApplicationContext());
        idSpinner.setAdapter(adaptadorSpinner);
    }
    // Rellenar spinner
    private void rellenarSpinner() {
        elementosSpinner.add(new Elementos("Main",1));
        elementosSpinner.add(new Elementos("Fragment recycler",2));
        elementosSpinner.add(new Elementos("Fragment normal",3));
        adaptadorSpinner.notifyDataSetChanged();
    }
    // Acciones Spinner
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Elementos seleccionada = (Elementos) adaptadorSpinner.getItem(position);
        fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out);
        if(seleccionada.getNombre().equals("Fragment recycler")){
            System.out.println("Fragment reycler");
            fragmentTransaction.replace(R.id.idEspacioFragment, new FragmentRecycler());
        }
        else if(seleccionada.getNombre().equals("Fragment normal")){
            System.out.println("Fragment normal");
            fragmentTransaction.replace(R.id.idEspacioFragment, new FragmentEstatico());
        }
        fragmentTransaction.commit();
    }
    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
    // Interface para pasar datos de fragment a fragment
    @Override
    public void onPersonaSelected(Persona persona) {

        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out);
        ft.replace(R.id.idEspacioFragment, FragmentDetalleRecycler.newInstance(persona));
        ft.addToBackStack(null);
        ft.commit();
    }
}
