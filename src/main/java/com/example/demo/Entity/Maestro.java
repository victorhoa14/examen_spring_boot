package com.example.demo.Entity;

import lombok.Data;

import javax.persistence.*;


    @Entity
    @Table(name = "maestro")
    @Data
    public class Maestro {

        @Column(name = "matricula")
        private long matricula;
        @Column(name = "nombre")
        private String nombre;
        @Column(name = "apellido")
        private String apellido;
        @Column(name = "telefono")
        private long telefono;
        @Id
        @GeneratedValue(strategy = GenerationType.TABLE)
        @Column(name = "id_maestro")
        private long id_maestro;


    }
