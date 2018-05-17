package com.rubensaraujo.TakeaFlight.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rubensaraujo.TakeaFlight.Model.Grupo;
import com.rubensaraujo.TakeaFlight.Model.Permissao;


public interface PermissaoRepository extends JpaRepository<Permissao, Long> {
	
	List<Permissao> findByGruposIn(Grupo grupo);
}
