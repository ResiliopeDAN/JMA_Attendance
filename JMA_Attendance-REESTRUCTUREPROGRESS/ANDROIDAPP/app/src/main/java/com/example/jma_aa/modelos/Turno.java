package com.example.jma_aa.modelos;

public class Turno {

    private String codigoTurno;
    private String nombre;
    private String horario;

    // Constructor vacío requerido para Firebase
    public Turno() {}

    // Constructor con parámetros
    public Turno(String codigoTurno, String nombre, String horario) {
        this.codigoTurno = codigoTurno;
        this.nombre = nombre;
        this.horario = horario;
    }

    // Getters y Setters
    public String getCodigoTurno() {
        return codigoTurno;
    }

    public void setCodigoTurno(String codigoTurno) {
        this.codigoTurno = codigoTurno;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }
}
