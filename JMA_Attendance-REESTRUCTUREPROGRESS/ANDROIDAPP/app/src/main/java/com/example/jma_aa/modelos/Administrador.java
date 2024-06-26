package com.example.jma_aa.modelos;

public class Administrador {

    private String codigoAdministrador;
    private String nombre;
    private String apellido;
    private String correoElectronico;
    private String telefono;
    private String codigoUsuario;

    // Constructor vacío requerido para Firebase
    public Administrador() {}

    // Constructor con parámetros
    public Administrador(String codigoAdministrador, String nombre, String apellido, String correoElectronico, String telefono, String codigoUsuario) {
        this.codigoAdministrador = codigoAdministrador;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correoElectronico = correoElectronico;
        this.telefono = telefono;
        this.codigoUsuario = codigoUsuario;
    }

    // Getters y Setters
    public String getCodigoAdministrador() {
        return codigoAdministrador;
    }

    public void setCodigoAdministrador(String codigoAdministrador) {
        this.codigoAdministrador = codigoAdministrador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCodigoUsuario() {
        return codigoUsuario;
    }

    public void setCodigoUsuario(String codigoUsuario) {
        this.codigoUsuario = codigoUsuario;
    }

}
