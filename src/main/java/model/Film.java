/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import jakarta.persistence.*;

import java.util.Collections;
import java.util.List;

/**
 *
 * @author Alex
 */
@Entity
@Table(name="Film")
public class Film {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name="titulo")
    private String titulo;
     @Column(name="year")
    private String year;

    @Column(name = "generos")
    private String generos;

    public Film(String titulo, String year, String generos) {
        this.titulo = titulo;
        this.year = year;
        this.generos = generos;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getGeneros() {
        return generos;
    }

    public void setGeneros(String generos) {
        this.generos = generos;
    }

    @Override
    public String toString() {
        return "Film{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", year='" + year + '\'' +
                ", generos=" + generos +
                '}';
    }

    public Film(){}

}
