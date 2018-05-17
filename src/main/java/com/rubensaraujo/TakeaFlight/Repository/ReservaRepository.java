package com.rubensaraujo.TakeaFlight.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rubensaraujo.TakeaFlight.Model.Reserva;


@Repository
public interface ReservaRepository extends JpaRepository<Reserva, Long>{

}
