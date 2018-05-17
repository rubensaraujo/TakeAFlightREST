package com.rubensaraujo.TakeaFlight.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rubensaraujo.TakeaFlight.Model.Voo;

@Repository
public interface VooRepository extends JpaRepository<Voo, Long> {

}
