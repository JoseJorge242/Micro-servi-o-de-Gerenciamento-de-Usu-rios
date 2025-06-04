package com.example.Usuario_service.micro.model.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Usuario_service.micro.model.entity.*;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

	List<Usuario> findByTipo(TipoUsuario tipo);

}
