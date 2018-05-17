package com.rubensaraujo.TakeaFlight.Model;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "reservas")
@EntityListeners(AuditingEntityListener.class)
public class Reserva {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@OneToOne
	private Usuario user;
	
	@OneToOne
	private Voo vooReservado;
	
	private boolean status;
	
	@Column(nullable = false, updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
	private Calendar dataReserva;
	
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	
	public Calendar getDataReserva() {
		return dataReserva;
	}
	public void setDataReserva(Calendar dataReserva) {
		this.dataReserva = dataReserva;
	}
	public Usuario getUser() {
		return user;
	}
	public void setUser(Usuario user) {
		this.user = user;
	}
	public Voo getVooReservado() {
		return vooReservado;
	}
	public void setVooReservado(Voo vooReservado) {
		this.vooReservado = vooReservado;
	}
}
