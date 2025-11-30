package com.example.sori_records;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.example.sori_records.model.Album;
import com.example.sori_records.model.Usuario;
import com.example.sori_records.repository.AlbumRepository;
import com.example.sori_records.repository.UsuarioRepository;

@Component
public class DatabaseStartup {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private AlbumRepository albumRepository;

    @EventListener(ApplicationReadyEvent.class)
    public void populateDatabase() {
        System.out.println("Agregando detalles");


        // Users
        usuarioRepository.save(new Usuario("Nombre1", "Contraseña1", "Email1", "Direccion1"));
        usuarioRepository.save(new Usuario("Nombre2", "Contraseña2", "Email2", "Direccion2"));
        usuarioRepository.save(new Usuario("Nombre3", "Contraseña3", "Email3", "Direccion3"));
        usuarioRepository.save(new Usuario("Nombre4", "Contraseña4", "Email4", "Direccion4"));

        //Albumes
        albumRepository.save(new Album("Titulo1", "Artista1", "Cover1", 1000, "Descri1", "Tipo1"));
        albumRepository.save(new Album("Titulo2", "Artista2", "Cover2", 2000, "Descri2", "Tipo2"));
        albumRepository.save(new Album("Titulo3", "Artista3", "Cover3", 3000, "Descri3", "Tipo3"));
        albumRepository.save(new Album("Titulo4", "Artista4", "Cover4", 4000, "Descri4", "Tipo4"));
        albumRepository.save(new Album("Titulo5", "Artista5", "Cover5", 5000, "Descri5", "Tipo5"));

    }
}
