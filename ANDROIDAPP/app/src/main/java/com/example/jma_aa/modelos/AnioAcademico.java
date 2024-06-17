package com.example.jma_aa.modelos;

public class AnioAcademico {

    private String codigoAnioAcademico;
    private int anio;

    // Constructor vacío requerido para Firebase
    public AnioAcademico() {}

    // Constructor con parámetros
    public AnioAcademico(String codigoAnioAcademico, int anio) {
        this.codigoAnioAcademico = codigoAnioAcademico;
        this.anio = anio;
    }

    // Getters y Setters
    public String getCodigoAnioAcademico() {
        return codigoAnioAcademico;
    }

    public void setCodigoAnioAcademico(String codigoAnioAcademico) {
        this.codigoAnioAcademico = codigoAnioAcademico;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

}
