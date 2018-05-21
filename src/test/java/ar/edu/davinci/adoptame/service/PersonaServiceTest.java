package ar.edu.davinci.adoptame.service;

import static org.junit.Assert.assertEquals;
import java.util.List;


import ar.edu.davinci.adoptame.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import ar.edu.davinci.adoptame.domain.Persona;

@RunWith(SpringRunner.class)
@DataJpaTest
@SpringBootTest(classes = Application.class)
@AutoConfigureTestDatabase(replace=AutoConfigureTestDatabase.Replace.NONE)

public class PersonaServiceTest {
	
	private static final Logger log = LoggerFactory.getLogger(PersonaServiceTest.class);

	@Autowired(required = true)
	private PersonaService personaService;
	
	
	@Test
	public void listAll() throws Exception {
		//Persona persona = new Persona("Pepe", "Gonzalez", "Garcia", "pepe@pepito.com", "1212");
	//	persona = personaService.registrarPersona(persona);
	//	assertEquals(1, persona.getIdPersona().intValue());

		List<Persona> all = personaService.listarPersonas();
		log.info(all.toString());
		assertEquals(1, all.size());
	}
	
	@Test
	public void insertarPepe() throws Exception {
		//Persona persona = new Persona("Juancito", "Garcia", "Gonzalez",  "juancito@pepito.com", "1212");
		//persona = personaService.registrarPersona(persona);
		//assertEquals("Juancito", persona.getNombre());
	}

	
}
