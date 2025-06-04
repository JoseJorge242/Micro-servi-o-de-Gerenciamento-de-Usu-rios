package com.example.Usuario_service.micro.model.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.Usuario_service.micro.dto.*;
import com.example.Usuario_service.micro.model.entity.*;
import com.example.Usuario_service.micro.model.service.*;

@Component
public class AdminInitializer implements CommandLineRunner {

    private final UsuarioService usuarioService;

    public AdminInitializer(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @Override
    public void run(String... args) throws Exception {
        // Verifica se já existe um admin
        if (usuarioService.findByTipo(TipoUsuario.ADMIN) == null) {
            UsuarioDTO adminDto = new UsuarioDTO();
            adminDto.setNome("Admin Padrão");
            adminDto.setEmail("admin@example.com");
            adminDto.setSenhaHash("12345"); // Use uma senha segura
            adminDto.setTipo(TipoUsuario.ADMIN);
            usuarioService.create(adminDto);
        }
    }
}
