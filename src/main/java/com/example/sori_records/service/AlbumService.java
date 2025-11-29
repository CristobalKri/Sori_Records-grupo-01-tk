package com.example.sori_records.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.sori_records.model.Album;
import com.example.sori_records.repository.AlbumRepository;

@Service
public class AlbumService {
    
    @Autowired
    private AlbumRepository albumRepository;

    public List<Album> findAllAlbums() {
        return albumRepository.findAll();
    }

    public Optional<Album> findAlbumById(Long id) {
        return albumRepository.findById(id);
    }
    
    public Album saveAlbum(Album album) {
        return albumRepository.save(album);
    }

    public void deleteById(Long id) {
        albumRepository.deleteById(id);
    }

}
