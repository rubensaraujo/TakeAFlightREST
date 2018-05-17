package com.rubensaraujo.TakeaFlight.Controller;

import java.util.List;

//import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;

import com.rubensaraujo.TakeaFlight.Execptions.ResourceNotFoundException;
import com.rubensaraujo.TakeaFlight.Model.Voo;
import com.rubensaraujo.TakeaFlight.Repository.VooRepository;

@Controller
public class VooController {
	
	@Autowired
	VooRepository vooRepository;
	
	
	public List<Voo> getAllVoos() {
	    //List<Voo> listaVoos = vooRepository.findAll();
	    return vooRepository.findAll();
	}
	
	public Voo getVooById(@PathVariable(value = "id") Long vooId) {
	    return vooRepository.findById(vooId)
	            .orElseThrow(() -> new ResourceNotFoundException("Voo", "id", vooId));
	}
	
}
