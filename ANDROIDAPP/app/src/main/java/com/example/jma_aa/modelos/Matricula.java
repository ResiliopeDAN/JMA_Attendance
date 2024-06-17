package com.example.jma_aa.modelos;
import java.util.Date;

public class Matricula {

    private String codigoMatricula;
    private String codigoEstudiante;
    private String codigoGrado;
    private String codigoAnioAcademico;
    private Date fechaInscripcion;
    private String estado;

    // Constructor vacío requerido para Firebase
    public Matricula() {}

    // Constructor con parámetros
    public Matricula(String codigoMatricula, String codigoEstudiante, String codigoGrado, String codigoAnoAcademico, Date fechaInscripcion, String estado) {
        this.codigoMatricula = codigoMatricula;
        this.codigoEstudiante = codigoEstudiante;
        this.codigoGrado = codigoGrado;
        this.codigoAnioAcademico = codigoAnoAcademico;
        this.fechaInscripcion = fechaInscripcion;
        this.estado = estado;
    }

    // Getters y Setters
    public String getCodigoMatricula() {
        return codigoMatricula;
    }

    public void setCodigoMatricula(String codigoMatricula) {
        this.codigoMatricula = codigoMatricula;
    }

    public String getCodigoEstudiante() {
        return codigoEstudiante;
    }

    public void setCodigoEstudiante(String codigoEstudiante) {
        this.codigoEstudiante = codigoEstudiante;
    }

    public String getCodigoGrado() {
        return codigoGrado;
    }

    public void setCodigoGrado(String codigoGrado) {
        this.codigoGrado = codigoGrado;
    }

    public String getCodigoAnioAcademico() {
        return codigoAnioAcademico;
    }

    public void setCodigoAnioAcademico(String codigoAnioAcademico) {
        this.codigoAnioAcademico = codigoAnioAcademico;
    }

    public Date getFechaInscripcion() {
        return fechaInscripcion;
    }

    public void setFechaInscripcion(Date fechaInscripcion) {
        this.fechaInscripcion = fechaInscripcion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
