package com.example.jma_aa.modelos;

public class AnioAcademico {

    private String codigoAnioAcademico;
    private String nombreAnioAcademico;

    // Constructor vacío requerido para Firebase
    public AnioAcademico() {}

    // Constructor con parámetros
    public AnioAcademico(String codigoAnioAcademico, String nombreAnioAcademico) {
        this.codigoAnioAcademico = codigoAnioAcademico;
        this.nombreAnioAcademico = nombreAnioAcademico;
    }

    // Getters y Setters
    public String getCodigoAnioAcademico() {
        return codigoAnioAcademico;
    }

    public void setCodigoAnioAcademico(String codigoAnioAcademico) {
        this.codigoAnioAcademico = codigoAnioAcademico;
    }

    public String getNombreAnioAcademico() {
        return nombreAnioAcademico;
    }

    public void setNombreAnioAcademico(String nombreAnioAcademico) {
        this.nombreAnioAcademico = nombreAnioAcademico;
    }

}
