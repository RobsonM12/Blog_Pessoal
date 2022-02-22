package com.generation.blogpessoal.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tb_postagens")

public class Postagem {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotBlank(message = "O atributo titulo e obrigatorio")
	@Size(min =5, max =100, message = "O atributo título deve ter no mínimo 5 e no máximo 100 caracteres")
	private String titulo;
	
	@NotBlank(message = "O atributo texto e obrigatorio")
	@Size(min =10, max =1000, message = "O atributo texto deve ter no mínimo 10 e no máximo 1000 caracteres")
	private String texto;
	
	@UpdateTimestamp
	private LocalDateTime date;
	
	//Puxando tema da Class tema 
	// many to one setia muitas postagens para um tema
	@ManyToOne
	@JsonIgnoreProperties("postagem")
	private Tema tema;
	
	
	/* metodos getts and setts*/

	public long getId() {
		return id;
	}

	public String getTitulo() {
		return titulo;
	}

	public String getTexto() {
		return texto;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public Tema getTema() {
		return tema;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public void setTema(Tema tema) {
		this.tema = tema;
	}
	
	
	
	
	
	
	

	
	 

}
