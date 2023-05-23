package com.algaworks.algalog.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class Destinatario {

	@Column(name = "destinatario_nome")
	private String nome;
	@Column(name = "destinatario_lougradouro")
	private String lougradouro;
	@Column(name = "destinatario_numero")
	private String numero;
	@Column(name = "destinatario_complemento")
	private String complemento;
	@Column(name = "destinatario_bairro")
	private String bairro;
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getLougradouro() {
		return lougradouro;
	}

	public void setLougradouro(String lougradouro) {
		this.lougradouro = lougradouro;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	
	
}
