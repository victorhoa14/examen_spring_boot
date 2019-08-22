package com.example.demo.Entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "Curso")
@Data
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "id_curso")
    private long id_curso;
    @Column(name = "nombre")
    private String nombre;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_maestro")
    private Maestro id_maestro;

}
