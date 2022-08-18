package com.prueba.examen.models;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity //entidad de la tabla usuarios
@Table(name = "usuarios") //referencia a la tabla usuarios de la BD
@ToString @EqualsAndHashCode //generamos el toString para la clase
public class Usuario {

    @Id//indicamos la clave primaria de la bd
    @GeneratedValue(strategy= GenerationType.IDENTITY)//autoincrementable
    @Getter @Setter @Column(name = "id") //nombre de la columna de la bd
    private Long id;

    @Getter @Setter @Column(name = "nombre")
    private String nombre;

    @Getter @Setter @Column(name = "apellido_paterno")
    private String apellidoPaterno;

    @Getter @Setter @Column(name = "apellido_materno")
    private String apellidoMaterno;

    @Getter @Setter @Column(name = "telefono")
    private String telefono;

    @Getter @Setter @Column(name = "email")
    private String email;

    @Getter @Setter @Column(name = "pass")
    private String pass;
}
