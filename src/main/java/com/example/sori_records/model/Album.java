package com.example.sori_records.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "album")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Album {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable=false)
    private String title;

    @Column(nullable=false)
    private String artista;

    @Column(nullable=false)
    private String cover;

    @Column(nullable=false)
    private int precio;

    @Column(nullable=false)
    private String descri;

    @Column(nullable=false)
    private String tipo;


    public Album(String title, String artista, String cover, int precio, String descri, String tipo) {
        this.title = title;
        this.artista = artista;
        this.cover = cover;
        this.precio = precio;
        this.descri = descri;
        this.tipo = tipo;
    }


}
