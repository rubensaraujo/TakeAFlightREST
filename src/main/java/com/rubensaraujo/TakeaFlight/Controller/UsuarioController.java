package com.rubensaraujo.TakeaFlight.Controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.rubensaraujo.TakeaFlight.Execptions.ResourceNotFoundException;
import com.rubensaraujo.TakeaFlight.Model.Usuario;
import com.rubensaraujo.TakeaFlight.Repository.UsuarioRepository;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
	
	@Autowired
	UsuarioRepository userRepository;
	
	@Autowired
    private BCryptPasswordEncoder passwordEncoder;
	
	
	@GetMapping
	public ModelAndView formularioUsuario() {
		ModelAndView modelAndView = new ModelAndView();
		Usuario user = new Usuario();
		modelAndView.addObject("usuario", user);
		modelAndView.setViewName("registration");
		return modelAndView;
	}
	
	@GetMapping("/list")
	public List<Usuario> getAllUsers() {
	    return userRepository.findAll();
	}
	
	@PostMapping("/new")
	public Usuario createUser(@Valid Usuario user) {
	    user.setAtivo(true);
	    user.setSenha(passwordEncoder.encode(user.getSenha()));
	    //user.setPermissoes(permissoes);
		return userRepository.save(user);
	}
	
	@GetMapping("/list/{id}")
	public Usuario getUserById(@PathVariable(value = "id") Long userId) {
	    return userRepository.findById(userId)
	            .orElseThrow(() -> new ResourceNotFoundException("Usuario", "id", userId));
	}
	
	@PutMapping("/list/{id}")
	public Usuario updateUser(@PathVariable(value = "id") Long userId, @Valid @RequestBody Usuario userDetails) {

	    Usuario user = userRepository.findById(userId)
	            .orElseThrow(() -> new ResourceNotFoundException("Usuario", "id", userId));

	    user.setNome(userDetails.getNome());
	    user.setDataNascimento(userDetails.getDataNascimento());
	    user.setCpf(userDetails.getCpf());
	    user.setSenha(userDetails.getSenha());

	    Usuario updatedUser = userRepository.save(user);
	    return updatedUser;
	}
	
	@DeleteMapping("/list/{id}")
	public ResponseEntity<?> deleteUser(@PathVariable(value = "id") Long userId) {
	    Usuario user = userRepository.findById(userId)
	            .orElseThrow(() -> new ResourceNotFoundException("Usuario", "id", userId));

	    userRepository.delete(user);

	    return ResponseEntity.ok().build();
	}
}
