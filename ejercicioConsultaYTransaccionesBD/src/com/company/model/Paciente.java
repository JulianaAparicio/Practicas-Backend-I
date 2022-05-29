package com.company.model;

//  campos: nombre, apellido, domicilio, DNI, fecha de alta, usuario y password.

import java.util.Date;

public class Paciente {
    private String nombre;
    private String apellido;
    private String domicilio;
    private int DNI;
    private String fechaDeAlta;
    private String usuario;
    private String contrasenia;

    public Paciente(String nombre, String apellido, String domicilio, int DNI, String fechaDeAlta, String usuario, String contrasenia) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.domicilio = domicilio;
        this.DNI = DNI;
        this.fechaDeAlta = fechaDeAlta;
        this.usuario = usuario;
        this.contrasenia = contrasenia;
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

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public int getDNI() {
        return DNI;
    }

    public void setDNI(int DNI) {
        this.DNI = DNI;
    }

    public String getFechaDeAlta() {
        return fechaDeAlta;
    }

    public void setFechaDeAlta(String fechaDeAlta) {
        this.fechaDeAlta = fechaDeAlta;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public String cambiarContrasenia(String nuevaContrasenia){
        contrasenia = nuevaContrasenia;
        return contrasenia;
    }
}
