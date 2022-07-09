package com.dh.clinicaOdontologica.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "Odontologos")

public class Odontologo {
    @Id
    @SequenceGenerator(name = "odontologo_sequence", sequenceName = "odontologo_sequence")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "odontologo_sequence")
    private Long id;

    private String apellido;

    private String nombre;

    @Column(name = "numero_matricula", unique = true)
    private String matricula;

    @OneToMany(mappedBy = "odontologo", cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Turno> turnos;

    public Odontologo() {
    }

    public Odontologo(String apellido, String nombre, String matricula, Set<Turno> turnos) {
        this.apellido = apellido;
        this.nombre = nombre;
        this.matricula = matricula;
        this.turnos = turnos;
    }
}
