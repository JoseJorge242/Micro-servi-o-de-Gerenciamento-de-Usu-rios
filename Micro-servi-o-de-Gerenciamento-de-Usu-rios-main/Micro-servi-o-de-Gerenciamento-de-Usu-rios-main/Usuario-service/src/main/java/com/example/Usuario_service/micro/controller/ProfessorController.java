package com.example.Usuario_service.micro.controller;

import com.example.Usuario_service.micro.dto.*;
import com.example.Usuario_service.micro.model.service.ProfessorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/professors")

public class ProfessorController {

    private final ProfessorService professorService;

    public ProfessorController(ProfessorService professorService) {
		super();
		this.professorService = professorService;
	}

	@GetMapping
    public ResponseEntity<List<ProfessorDTO>> getAll() {
        return ResponseEntity.ok(professorService.getAll()); // Corrigido de findAll() para getAll()
    }

    @PostMapping
    public ResponseEntity<ProfessorDTO> create(@RequestBody ProfessorDTO professorDTO) {
        return ResponseEntity.status(201).body(professorService.create(professorDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        professorService.delete(id);
        return ResponseEntity.noContent().build();
    }
}