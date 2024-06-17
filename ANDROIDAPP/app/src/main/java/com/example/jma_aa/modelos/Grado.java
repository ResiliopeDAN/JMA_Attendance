package com.example.jma_aa.modelos;

public class Grado {

    private String codigoGrado;
    private String nombre;
    private String descripcion;

    // Constructor vacío requerido para Firebase
    public Grado() {}

    // Constructor con parámetros
    public Grado(String codigoGrado, String nombre, String descripcion) {
        this.codigoGrado = codigoGrado;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    // Getters y Setters
    public String getCodigoGrado() {
        return codigoGrado;
    }

    public void setCodigoGrado(String codigoGrado) {
        this.codigoGrado = codigoGrado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
