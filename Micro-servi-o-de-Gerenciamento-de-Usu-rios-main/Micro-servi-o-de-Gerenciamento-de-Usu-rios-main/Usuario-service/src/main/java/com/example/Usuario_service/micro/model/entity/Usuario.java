package com.example.Usuario_service.micro.model.entity;

import java.time.LocalDateTime;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


	
	@Entity
	@Table(name = "usuarios")
	public class Usuario {
		@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    
	    @Column(nullable = false)
	    private String nome;
	    
	    @Column(unique = true, nullable = false)
	    private String email;
	    
	    @Column(nullable = false)
	    private String senhaHash;
	    
	    @Column(nullable = false)
	    @Enumerated(EnumType.STRING)
	    private TipoUsuario tipo;
	    
	    private boolean ativo = true;
	    
	    @CreationTimestamp
	    private LocalDateTime dataCriacao;
	    
	    @UpdateTimestamp
	    private LocalDateTime dataAtualizacao;
	    public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getNome() {
			return nome;
		}

		public void setNome(String nome) {
			this.nome = nome;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getSenhaHash() {
			return senhaHash;
		}

		public void setSenhaHash(String senhaHash) {
			this.senhaHash = senhaHash;
		}

		public TipoUsuario getTipo() {
			return tipo;
		}

		public void setTipo(TipoUsuario tipo) {
			this.tipo = tipo;
		}

		public boolean isAtivo() {
			return ativo;
		}

		public void setAtivo(boolean ativo) {
			this.ativo = ativo;
		}

		public LocalDateTime getDataCriacao() {
			return dataCriacao;
		}

		public void setDataCriacao(LocalDateTime dataCriacao) {
			this.dataCriacao = dataCriacao;
		}

		public LocalDateTime getDataAtualizacao() {
			return dataAtualizacao;
		}

		public void setDataAtualizacao(LocalDateTime dataAtualizacao) {
			this.dataAtualizacao = dataAtualizacao;
		}

		
	
}

