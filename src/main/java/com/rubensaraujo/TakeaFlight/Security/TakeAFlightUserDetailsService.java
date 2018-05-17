package com.rubensaraujo.TakeaFlight.Security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.rubensaraujo.TakeaFlight.Model.Grupo;
import com.rubensaraujo.TakeaFlight.Model.Permissao;
import com.rubensaraujo.TakeaFlight.Model.Usuario;
import com.rubensaraujo.TakeaFlight.Repository.GrupoRepository;
import com.rubensaraujo.TakeaFlight.Repository.PermissaoRepository;
import com.rubensaraujo.TakeaFlight.Repository.UsuarioRepository;

@Component
public class TakeAFlightUserDetailsService implements UserDetailsService {
	   
	@Autowired
	private UsuarioRepository usuarios;
	 
	@Autowired
	private GrupoRepository grupos;
	   
	@Autowired
	private PermissaoRepository permissoes;
	 
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario usuario = usuarios.findByLogin(username);
	     
		if (usuario == null) {
			throw new UsernameNotFoundException("Usuário não encontrado!");
	    }
	     
		return new UsuarioSistema(usuario.getNome(), usuario.getLogin(), usuario.getSenha(), authorities(usuario));
	}
	
	public Collection<? extends GrantedAuthority> authorities(Usuario usuario) {
		return authorities(grupos.findByUsuariosIn(usuario));
	}
	   
	public Collection<? extends GrantedAuthority> authorities(List<Grupo> grupos) {
		Collection<GrantedAuthority> auths = new ArrayList<>();
	     
		for (Grupo grupo: grupos) {
			List<Permissao> lista = permissoes.findByGruposIn(grupo);
	     
			for (Permissao permissao: lista) {
				auths.add(new SimpleGrantedAuthority("ROLE_" + permissao.getNome()));
			}
		}
	     
		return auths;
	}
}
