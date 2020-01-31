package com.adrian.repasofragments.Utiles;

public class Elementos {
    String nombre;
    int numero;
    // Constructor
    public Elementos(String nombre, int numero) {
        this.nombre = nombre;
        this.numero = numero;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    @Override
    public String toString() {
        return "Elementos{" +
                "nombre='" + nombre + '\'' +
                ", numero=" + numero +
                '}';
    }
}
