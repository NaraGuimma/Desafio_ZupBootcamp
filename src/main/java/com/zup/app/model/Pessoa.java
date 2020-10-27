package com.zup.app.model;

import java.io.Serializable;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import br.com.safeguard.constraint.annotations.Verify;
import br.com.safeguard.types.ParametroTipo;


import javax.persistence.*;




@Entity
public class Pessoa implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;

	@NotNull(message="O campo nome não pode ser nulo")
	@NotEmpty(message="O campo nome não pode ser vazio")
	private String nome;

	@NotNull(message="O campo nome não pode ser nulo")
	@NotEmpty(message="O campo nome não pode ser vazio")
	private String sobrenome;
	
	@Verify(ParametroTipo.EMAIL)
	private String email;
	
	@Column(nullable = false)
	private String datanasc;
	
	@Verify(ParametroTipo.CPF)
	private String cpf;
	
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

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getDatanasc() {
		
		
		return datanasc;
	}

	
	
	public void setDatanasc(String datanasc) {
		this.datanasc = datanasc;
	}
	

}
