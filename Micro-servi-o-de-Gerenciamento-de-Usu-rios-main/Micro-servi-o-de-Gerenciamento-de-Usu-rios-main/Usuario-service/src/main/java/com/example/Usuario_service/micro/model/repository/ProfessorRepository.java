package com.example.Usuario_service.micro.model.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Usuario_service.micro.model.entity.*;

public interface ProfessorRepository extends JpaRepository<Professor, Long>{
    Optional<Professor> findByEmail(String email);

}
