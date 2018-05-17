package com.rubensaraujo.TakeaFlight.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rubensaraujo.TakeaFlight.Model.Grupo;
import com.rubensaraujo.TakeaFlight.Model.Usuario;

public interface GrupoRepository extends JpaRepository<Grupo, Long> {
	
	List<Grupo> findByUsuariosIn(Usuario usuario);
}
