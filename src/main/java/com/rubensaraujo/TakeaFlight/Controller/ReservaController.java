package com.rubensaraujo.TakeaFlight.Controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.rubensaraujo.TakeaFlight.Execptions.ResourceNotFoundException;
import com.rubensaraujo.TakeaFlight.Model.Reserva;
import com.rubensaraujo.TakeaFlight.Model.Usuario;
import com.rubensaraujo.TakeaFlight.Model.Voo;
import com.rubensaraujo.TakeaFlight.Repository.ReservaRepository;
import com.rubensaraujo.TakeaFlight.Repository.UsuarioRepository;
import com.rubensaraujo.TakeaFlight.Repository.VooRepository;

@RestController
@RequestMapping("/reservas")
public class ReservaController {
	
	@Autowired
	ReservaRepository reservaRepository;
	
	@Autowired
	VooRepository vooRepository;
	
	@Autowired
	UsuarioRepository userRepository;
	
	@GetMapping("/list")
	public List<Reserva> getAllReservas() {
	    return reservaRepository.findAll();
	}
	
	 @GetMapping("/listAllVoos")
	 public ModelAndView findAll() {
	         
		 ModelAndView mv = new ModelAndView("tela_reservas");
	 	 mv.addObject("voos", vooRepository.findAll());
	         
	 	 return mv;
	 }
	 
	 @PostMapping("/comprar/{id}")
	 public Reserva comprarReserva(@PathVariable("id") Long idVoo, @Valid @RequestBody Reserva reserva) {
		 
		 Voo voo = vooRepository.findById(idVoo)
		            .orElseThrow(() -> new ResourceNotFoundException("Voo", "id", idVoo));
		 Usuario user = userRepository.findById((long) 1)
		            .orElseThrow(() -> new ResourceNotFoundException("Usuario", "id", 1));
		 
		 reserva.setVooReservado(voo);
		 reserva.setStatus(true);
		 reserva.setUser(user);
		 
		 return reservaRepository.save(reserva);
	 }

}
