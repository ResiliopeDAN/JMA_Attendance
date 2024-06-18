package com.example.jma_aa.modelos;
import java.util.Date;

public class Asistencia {

    private String codigoAsistencia;
    private String codigoEstudiante;
    private Date fecha;
    private String estado;


    // Constructor vacío requerido para Firebase
    public Asistencia() {}

    // Constructor con parámetros
    public Asistencia(String codigoAsistencia, String codigoEstudiante, Date fecha, String estado, String codigoMatricula) {
        this.codigoAsistencia = codigoAsistencia;
        this.codigoEstudiante = codigoEstudiante;
        this.fecha = fecha;
        this.estado = estado;
    }

    // Getters y Setters
    public String getCodigoAsistencia() {
        return codigoAsistencia;
    }

    public void setCodigoAsistencia(String codigoAsistencia) {
        this.codigoAsistencia = codigoAsistencia;
    }

    public String getCodigoEstudiante() {
        return codigoEstudiante;
    }

    public void setCodigoEstudiante(String codigoEstudiante) {
        this.codigoEstudiante = codigoEstudiante;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
