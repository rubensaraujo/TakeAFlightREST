package com.rubensaraujo.TakeaFlight.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "companhia_aerea")
public class CompanhiaAerea {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(nullable = false, name = "nome_companhia")
	private String nomeComp;
	
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getNomeComp() {
		return nomeComp;
	}
	
	public void setNomeComp(String nomeComp) {
		this.nomeComp = nomeComp;
	}
}