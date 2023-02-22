package com.narvasoft.bd;

import android.widget.ImageView;

public class Hoteles {
    private String nombre, direccion;
    private int imagen;

    public Hoteles(String nombre, String direccion, int imagen) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.imagen = imagen;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public int getImagen() {
        return imagen;
    }
}
