package com.example.Usuario_service.micro.model.service;

import com.example.Usuario_service.micro.dto.*;
import com.example.Usuario_service.micro.model.entity.*;
import com.example.Usuario_service.micro.model.exception.*;
import com.example.Usuario_service.micro.model.mapper.*;
import com.example.Usuario_service.micro.model.repository.*;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class ProfessorService {

	 @Autowired
	 private final ProfessorRepository professorRepository;
	 @Autowired
	 private final ProfessorMapper professorMapper;
	 @Autowired
	 private final PasswordEncoder passwordEncoder;
	    
	   
	    public ProfessorService(ProfessorRepository professorRepository, ProfessorMapper professorMapper, PasswordEncoder passwordEncoder) {
	        this.professorRepository = professorRepository;
	        this.professorMapper = professorMapper;
	        this.passwordEncoder = passwordEncoder;
	    }
	  
    public List<ProfessorDTO> getAll() {
        return professorRepository.findAll().stream()
                .map(professorMapper::toDto)
                .toList();
    }

    public ProfessorDTO create(ProfessorDTO dto) {
        Professor professor = professorMapper.toEntity(dto);
        professor.setPassword(passwordEncoder.encode(dto.getPassword()));
        if (dto.getTipo() == null) {
            professor.setTipo(TipoUsuario.PROFESSOR);
        } else {
            professor.setTipo(dto.getTipo());
        }
        
        professor = professorRepository.save(professor);
        return professorMapper.toDto(professor);
    }

    public void delete(Long id) {
        Professor professor = professorRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Professor não encontrado"));
        professorRepository.delete(professor);
    }

    public Professor getProfessorByEmail(String email) {
        return professorRepository.findByEmail(email)
                .orElseThrow(() -> new NotFoundException("Professor não encontrado para o email: " + email));
    }

}
