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
    private String descripcion;

    @Column(nullable=false)
    private String cover;
    

    @Column(nullable=false)
    private String artista;

    @Column(nullable=false)
    private String tipo; // Should be its own entity but idk if it is necessary to do it rn


    public Album(String title, String descripcion, String cover, String artista, String tipo) {
        this.title = title;
        this.descripcion = descripcion;
        this.cover = cover;
        this.artista = artista;
        this.tipo = tipo;
    }


}
