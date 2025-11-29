package com.example.sori_records.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.sori_records.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
