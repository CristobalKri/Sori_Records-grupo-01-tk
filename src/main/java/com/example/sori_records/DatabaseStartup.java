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
        albumRepository.save(new Album("Titulo1", "Desc1", "Cover1", "Artista1", "Tipo1"));
        albumRepository.save(new Album("Titulo2", "Desc2", "Cover2", "Artista2", "Tipo2"));
        albumRepository.save(new Album("Titulo3", "Desc3", "Cover3", "Artista3", "Tipo3"));
        albumRepository.save(new Album("Titulo4", "Desc4", "Cover4", "Artista4", "Tipo4"));
        albumRepository.save(new Album("Titulo5", "Desc5", "Cover5", "Artista5", "Tipo5"));

    }
}
