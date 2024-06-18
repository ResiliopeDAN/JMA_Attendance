package com.example.jma_aa.modelos;

public class Usuario {

    private String codigoUsuario;
    private String nombreUsuario;
    private String contrasenia;
    private String rol; // Director, Auxiliar, Estudiante

    // Constructor vacío requerido para Firebase
    public Usuario() {}

    // Constructor con parámetros
    public Usuario(String codigoUsuario, String nombreUsuario, String contrasenia, String rol) {
        this.codigoUsuario = codigoUsuario;
        this.nombreUsuario = nombreUsuario;
        this.contrasenia = contrasenia;
        this.rol = rol;
    }

    // Getters y Setters
    public String getCodigoUsuario() {
        return codigoUsuario;
    }

    public void setCodigoUsuario(String codigoUsuario) {
        this.codigoUsuario = codigoUsuario;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }
}
