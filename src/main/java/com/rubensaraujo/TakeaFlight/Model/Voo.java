package com.rubensaraujo.TakeaFlight.Model;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "voos")
public class Voo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String origem;
	private String destino;
	private float preco;
	private Calendar data_voo;
	private int capacidade;

	
	@ManyToOne
	private CompanhiaAerea companhiaAerea;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getOrigem() {
		return origem;
	}
	public void setOrigem(String origem) {
		this.origem = origem;
	}
	public String getDestino() {
		return destino;
	}
	public void setDestino(String destino) {
		this.destino = destino;
	}
	public float getPreco() {
		return preco;
	}
	public void setPreco(float preco) {
		this.preco = preco;
	}
	public Calendar getData_voo() {
		return data_voo;
	}
	public void setData_voo(Calendar data_voo) {
		this.data_voo = data_voo;
	}
	
	public int getCapacidade() {
		return capacidade;
	}
	public void setCapacidade(int capacidade) {
		this.capacidade = capacidade;
	}
	
	public CompanhiaAerea getCompanhiaAerea() {
		return companhiaAerea;
	}
	public void setCompaniaAerea(CompanhiaAerea companhiaAerea) {
		this.companhiaAerea = companhiaAerea;
	}
}
