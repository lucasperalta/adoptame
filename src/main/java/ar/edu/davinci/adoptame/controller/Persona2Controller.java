package ar.edu.davinci.adoptame.controller;

import ar.edu.davinci.adoptame.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import ar.edu.davinci.adoptame.domain.Persona;

@Controller    // This means that this class is a Controller
@RequestMapping(path="/sga2") // This means URL's start with /demo (after Application path)
public class Persona2Controller {
	
	@Autowired
	private PersonaService personaService;
	
	@GetMapping(path="/add") // Map ONLY GET Requests
	public @ResponseBody String addRegistrarPersona (
			@RequestParam String nombre, 
			@RequestParam String apePaterno, 
			@RequestParam String apeMaterno, 
			@RequestParam String email,
			@RequestParam String telefono) {
		// @ResponseBody means the returned String is the response, not a view name
		// @RequestParam means it is a parameter from the GET or POST request

		//Persona persona = new Persona(nombre, apePaterno, apeMaterno, email, telefono);
		//personaService.registrarPersona(persona);
		return "Saved";
	}
	
	@GetMapping(path="/all")
	public @ResponseBody Iterable<Persona> getListarPersonas() {
		// This returns a JSON or XML with the users
		return personaService.listarPersonas();
	}	

	@GetMapping(path="/allByApellido")
	public @ResponseBody Iterable<Persona> getListarPersonasPorApellido(
			@RequestParam String apellido) {
		// This returns a JSON or XML with the users
		return personaService.listarPersonasPorApellido(apellido);
	}	
}
