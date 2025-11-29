package com.example.sori_records.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.sori_records.model.Album;

public interface AlbumRepository extends JpaRepository<Album, Long> {

    
} 