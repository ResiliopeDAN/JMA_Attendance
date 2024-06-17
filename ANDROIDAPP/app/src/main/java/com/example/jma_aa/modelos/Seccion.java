package com.example.jma_aa.modelos;

public class Seccion {
    private String codigoSeccion;
    private String nombre;
    private String codigoGrado;

    // Constructor vacío requerido para Firebase
    public Seccion() {}

    // Constructor con parámetros
    public Seccion(String codigoSeccion, String nombre, String codigoGrado) {
        this.codigoSeccion = codigoSeccion;
        this.nombre = nombre;
        this.codigoGrado = codigoGrado;
    }

    // Getters y Setters
    public String getCodigoSeccion() {
        return codigoSeccion;
    }

    public void setCodigoSeccion(String codigoSeccion) {
        this.codigoSeccion = codigoSeccion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigoGrado() {
        return codigoGrado;
    }

    public void setCodigoGrado(String codigoGrado) {
        this.codigoGrado = codigoGrado;
    }
}
