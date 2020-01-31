package com.adrian.repasofragments.Utiles;

import java.io.Serializable;

public class Persona implements Serializable {
    String nombre, apellido;
    int imagen;

    public Persona(String nombre, String apellido, int imagen) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.imagen = imagen;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }
}
