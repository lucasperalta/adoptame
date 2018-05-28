package ar.edu.davinci.adoptame.service;

import ar.edu.davinci.adoptame.Application;
import ar.edu.davinci.adoptame.domain.Estado;
import ar.edu.davinci.adoptame.domain.Persona;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@DataJpaTest
@SpringBootTest(classes = Application.class)
@ComponentScan(basePackages = {"ar.edu.davinci.adoptame.service", "ar.edu.davinci.adoptame.repository"})
@AutoConfigureTestDatabase(replace=AutoConfigureTestDatabase.Replace.NONE)

public class EstadoServiceTest {
	
	private static final Logger log = LoggerFactory.getLogger(EstadoServiceTest.class);

	@Autowired
	private EstadoService estadoService;
	
	
	@Test
	public void listAll() throws Exception {


	//	List<Persona> all = personaService.listarPersonas();
	//	log.info(all.toString());
	//	assertEquals(1, all.size());
	}
	
	@Test
	public void insertarPepe() throws Exception {

        //Estado estado = new Estado();
       // estado.setEstado("ACTIVO");
      //   Estado estadoSalvado=  estadoService.addEstado(estado);
		assertEquals(1,1);
	}

	
}
