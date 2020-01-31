package com.adrian.repasofragments.Adaptadores;

import android.content.Context;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;

import com.adrian.repasofragments.R;
import com.adrian.repasofragments.Utiles.Persona;

import java.util.ArrayList;

public class AdaptadorRecycler extends RecyclerView.Adapter<AdaptadorRecycler.HolderAdapterPropio> {
    // Elementos
    private Context context;
    private ArrayList<Persona> listaPersonas;
    private OnRecyclerListener listener;
    public AdaptadorRecycler(Context context, ArrayList<Persona> personas) {
        this.context = context;
        this.listaPersonas = personas;
        try{
            listener = (OnRecyclerListener) context;
        }
        catch (ClassCastException e){
            e.printStackTrace();
        }
    }

    @NonNull
    @Override
    public HolderAdapterPropio onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recycler_layout, parent,
                false);
        return new HolderAdapterPropio(view);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onBindViewHolder(@NonNull HolderAdapterPropio holder, final int position) {
        final Persona personaActual = listaPersonas.get(position);
        holder.getImagen().setImageResource(personaActual.getImagen());
        holder.getBoton().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onPersonaSelected(personaActual);
            }
        });

    }

    @Override
    public int getItemCount() {
        return listaPersonas.size();
    }

    class HolderAdapterPropio extends RecyclerView.ViewHolder{

        private ImageView imagen;
        private Button boton;

        public ImageView getImagen() {
            return imagen;
        }

        public Button getBoton() {
            return boton;
        }

        public HolderAdapterPropio(@NonNull View itemView) {
            super(itemView);
            imagen = itemView.findViewById(R.id.idImagenPersona);
            boton = itemView.findViewById(R.id.idButtonPersona);
        }
    }

    public interface OnRecyclerListener{
        void onPersonaSelected(Persona persona);
    }
}
