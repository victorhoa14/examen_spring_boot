package com.example.demo.Entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "expediente")
@Data
public class Expediente {
@Id
@GeneratedValue(strategy = GenerationType.TABLE)
@Column(name = "id_expediente")
private long id_expediente;
@Column(name = "sexo")
private String sexo;
@Column(name = "telefono")
private long telefono;
@Column(name = "direccion")
private String direccion;



}
