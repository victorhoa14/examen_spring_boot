package com.example.demo.Entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "Curso_alumno")
@Data
public class Curso_alumno {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "id_cursoalu")
    private long id_cursoalu;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_alumno")
    private Alumno id_alumno;
    @Column(name = "calificacion")
    private Long calificacion;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_curso")
    private Curso id_curso;
}


