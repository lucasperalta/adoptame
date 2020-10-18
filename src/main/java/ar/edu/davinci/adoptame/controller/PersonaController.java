package ar.edu.davinci.adoptame.controller;

import ar.edu.davinci.adoptame.domain.Persona;
import ar.edu.davinci.adoptame.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;



@Controller
@RequestMapping(path="/adoptame")
public class PersonaController {
	
	@Autowired
	private PersonaRepository personaRepository;
	
	@GetMapping(path="/add") // Map ONLY GET Requests
	public @ResponseBody String addNewPersona (
			@RequestParam String nombre, 
			@RequestParam String apePaterno, 
			@RequestParam String apeMaterno, 
			@RequestParam String email, 
			@RequestParam String telefono) {
		// @ResponseBody means the returned String is the response, not a view name
		// @RequestParam means it is a parameter from the GET or POST request

		/*Persona persona = new Persona(nombre, apePaterno, apeMaterno, email, telefono);
		personaRepository.save(persona);*/
		return "Saved";
	}
	
	@GetMapping(path="/all")
	public @ResponseBody Iterable<Persona> getAllUsers() {
		// This returns a JSON or XML with the users
		return personaRepository.findAll();
	}	
}
