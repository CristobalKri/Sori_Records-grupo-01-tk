package com.example.sori_records.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.sori_records.model.Album;
import com.example.sori_records.service.AlbumService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;


@RestController
@RequestMapping("/api/albums")
@Tag(name = "Album", description = "Operaciones album")
public class AlbumController {

    @Autowired
    private AlbumService albumService;

    @GetMapping
    @Operation(summary = "Ver lista albums", 
    responses = {
        @ApiResponse(responseCode = "200", description = "Lista albums"),
        @ApiResponse(responseCode = "204", description = "No hay albums disponibles")
    })
    public ResponseEntity<List<Album>> findAllAlbums() {
        List<Album> albums = albumService.findAllAlbums();

        if (albums.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return new ResponseEntity<>(albums, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Encontrar album especifico",
    responses = {
        @ApiResponse(responseCode = "200", description = "Album encontrado"),
        @ApiResponse(responseCode = "404", description = "Album no encontrado")
    })
    public ResponseEntity<Album> findAlbumById(
        @Parameter(description = "ID del album")@PathVariable Long id
        ) {
        Optional<Album> albumOpt = albumService.findAlbumById(id);

        if (albumOpt.isPresent()) {
            Album album = albumOpt.get();
            return new ResponseEntity<>(album, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        
    }

    @PostMapping
    @Operation(summary = "Agregar album")
    public ResponseEntity<Album> addAlbum(
        @RequestBody @Parameter(description = "Cuerpo a agregar") Album album
        ) {
        albumService.saveAlbum(album);
        return new ResponseEntity<>(album, HttpStatus.CREATED);
        
    }

    @PutMapping("{id}")
    @Operation(summary = "Actualizar album")
    public ResponseEntity<Album> updateAlbum(
        @Parameter(description = "ID del album")@PathVariable Long id,
        @RequestBody @Parameter(description = "Cuerpo actualizar") Album updatedAlbum
        ) {

        Optional<Album> existingAlbumOpt = albumService.findAlbumById(id);

        if (existingAlbumOpt.isPresent()) {
            Album existingAlbum = existingAlbumOpt.get();
            existingAlbum.setTitle(updatedAlbum.getTitle());
            existingAlbum.setDescri(updatedAlbum.getDescri());
            existingAlbum.setArtista(updatedAlbum.getArtista());
            existingAlbum.setCover(updatedAlbum.getCover());
            existingAlbum.setCover(updatedAlbum.getCover());

            Album savedAlbum = albumService.saveAlbum(existingAlbum);
            return new ResponseEntity<>(savedAlbum, HttpStatus.OK);
            
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar album")
    public ResponseEntity<?> deleteAlbum(
        @Parameter(description = "ID Album") @PathVariable Long id
        ) {
        try {
            albumService.deleteById(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}
