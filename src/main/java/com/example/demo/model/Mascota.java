package com.example.demo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.SplittableRandom;

@Entity
@Getter
@Setter
@Table(name = "mascota")
@NoArgsConstructor
@AllArgsConstructor
public class Mascota {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name="nombre")
    private String nombre;

    @Column(name = "especie")
    private String especie;

    @Column(name = "raza")
    private String raza;

    @Column(name = "edad")
    private int edad;

    @Column(name = "nombre_dueno")
    private String nombreDuenio;

    @Column(name = "telefono")
    private String telefono;

    @Column(name = "estado")
    private int estado;

}
