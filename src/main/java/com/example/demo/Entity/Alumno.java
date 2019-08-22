package com.example.demo.Entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name = "alumno")
@Data
public class Alumno implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "id_alumno")
    private long id_alumno;
     @Column(name = "nombre")
    private String nombre;
    @Column(name = "apellido")
    private String apellido;

    @Column(name = "matricula",unique = true)
    private Long matricula;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_expediente")
    private Expediente  id_expediente ;


}
