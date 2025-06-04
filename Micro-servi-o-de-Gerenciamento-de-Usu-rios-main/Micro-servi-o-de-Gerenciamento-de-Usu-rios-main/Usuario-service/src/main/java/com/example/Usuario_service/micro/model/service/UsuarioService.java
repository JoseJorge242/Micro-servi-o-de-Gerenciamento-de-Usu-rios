package com.example.Usuario_service.micro.model.service;


import com.example.Usuario_service.micro.dto.*;
import com.example.Usuario_service.micro.model.entity.*;
import com.example.Usuario_service.micro.model.exception.*;
import com.example.Usuario_service.micro.model.mapper.*;
import com.example.Usuario_service.micro.model.repository.*;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    private final UsuarioRepository usuarioRepository;
    @Autowired
    private final UsuarioMapper usuarioMapper;
    @Autowired
    private final PasswordEncoder passwordEncoder;

    public UsuarioService(UsuarioRepository usuarioRepository, UsuarioMapper usuarioMapper, PasswordEncoder passwordEncoder) {
        this.usuarioRepository = usuarioRepository;
        this.usuarioMapper = usuarioMapper;
        this.passwordEncoder = passwordEncoder;
    }

    public UsuarioDTO create(UsuarioDTO usuarioDto) {
        Usuario usuario = usuarioMapper.toEntity(usuarioDto);
        usuario.setSenhaHash(passwordEncoder.encode(usuarioDto.getSenhaHash()));
        usuario.setTipo(usuarioDto.getTipo()); // Define o tipo conforme o DTO
        usuario = usuarioRepository.save(usuario);
        return usuarioMapper.toDto(usuario);
    }
    
    public List<UsuarioDTO> findByTipo(TipoUsuario tipo) {
        List<Usuario> usuarios = usuarioRepository.findByTipo(tipo);
        return usuarios.stream()
                .map(usuarioMapper::toDto)
                .collect(Collectors.toList());
    }
    
    public void delete(Long id) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Professor não encontrado"));
        usuarioRepository.delete(usuario);
    }

	 public List<UsuarioDTO> getAll() {
        return usuarioRepository.findAll().stream()
                .map(usuarioMapper::toDto)
                .toList();
    }
}

