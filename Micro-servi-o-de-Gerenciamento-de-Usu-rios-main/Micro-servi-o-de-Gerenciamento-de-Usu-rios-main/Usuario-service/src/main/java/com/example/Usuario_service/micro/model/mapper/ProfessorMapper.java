package com.example.Usuario_service.micro.model.mapper;

import com.example.Usuario_service.micro.dto.*;
import com.example.Usuario_service.micro.model.entity.*;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProfessorMapper {

    ProfessorDTO toDto(Professor professor);
    Professor toEntity(ProfessorDTO dto);
}
