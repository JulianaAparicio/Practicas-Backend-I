package com.example.clinicaOdontologica.model;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Objects;

public class Paciente {

    private Long id;
    private String nombre;
    private String apellido;
    private String dni;
    private Domicilio domicilio;
    private String email;
    private LocalDate fechaDeIngreso;

    public Paciente(){

    }

    public Paciente(Long id, String apellido, String nombre, String email, String dni, LocalDate fechaDeIngreso) {
        this.id = id;
        this.apellido = apellido;
        this.nombre = nombre;
        this.email = email;
        this.dni = dni;
        this.fechaDeIngreso = fechaDeIngreso;
    }

    public Paciente(String apellido, String nombre, String email) {
        this.apellido = apellido;
        this.nombre = nombre;
        this.email = email;
        this.fechaDeIngreso = LocalDate.now();
    }

    public Paciente(Long id, String apellido, String nombre, String email, Domicilio domicilio) {
        this(apellido, nombre, email);
        this.domicilio = domicilio;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public LocalDate getFechaDeIngreso() {
        return fechaDeIngreso;
    }

    public void setFechaDeIngreso(LocalDate fechaDeIngreso) {
        this.fechaDeIngreso = fechaDeIngreso;
    }

    public Domicilio getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(Domicilio domicilio) {
        this.domicilio = domicilio;
    }
    @Override
    public String toString() {
        return "Paciente{" +
                "id=" + id +
                ", apellido='" + apellido + '\'' +
                ", nombre='" + nombre + '\'' +
                ", email='" + email + '\'' +
                ", dni='" + dni + '\'' +
                ", fechaDeIngreso='" + fechaDeIngreso.toString() + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Paciente)) return false;
        Paciente paciente = (Paciente) o;
        return Objects.equals(id, paciente.id) && Objects.equals(apellido, paciente.apellido) && Objects.equals(nombre, paciente.nombre) && Objects.equals(email, paciente.email) && Objects.equals(dni, paciente.dni) && Objects.equals(fechaDeIngreso, paciente.fechaDeIngreso) && Objects.equals(domicilio, paciente.domicilio);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, apellido, nombre, email, dni, fechaDeIngreso, domicilio);
    }
}
