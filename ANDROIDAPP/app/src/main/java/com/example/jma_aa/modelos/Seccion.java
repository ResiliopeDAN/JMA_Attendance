package com.example.jma_aa.modelos;

public class Seccion {
    private String codigoSeccion;
    private String nombreSeccion;


    // Constructor vacío requerido para Firebase
    public Seccion() {}

    // Constructor con parámetros
    public Seccion(String codigoSeccion, String nombreSeccion) {
        this.codigoSeccion = codigoSeccion;
        this.nombreSeccion = nombreSeccion;
    }

    // Getters y Setters
    public String getCodigoSeccion() {
        return codigoSeccion;
    }

    public void setCodigoSeccion(String codigoSeccion) {
        this.codigoSeccion = codigoSeccion;
    }

    public String getNombre() {
        return nombreSeccion;
    }

    public void setNombre(String nombre) {
        this.nombreSeccion = nombre;
    }
}
