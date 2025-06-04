package com.example.Usuario_service.micro.model.mapper;

import com.example.Usuario_service.micro.dto.*;
import com.example.Usuario_service.micro.model.entity.*;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UsuarioMapper {
	

	    UsuarioDTO toDto(Usuario usuario);
	    Usuario toEntity(UsuarioDTO dto);
}
