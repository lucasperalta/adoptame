package ar.edu.davinci.adoptame.service;
import java.util.List;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import ar.edu.davinci.adoptame.exception.NotFoundException;
import ar.edu.davinci.adoptame.repository.PersonaRepository;
import org.springframework.stereotype.Service;

import ar.edu.davinci.adoptame.domain.Persona;


@Service
public class PersonaServiceImpl implements PersonaService{

	@Resource
	PersonaRepository personaRepository;
	
	@Override
	@Transactional
	public List<Persona> listarPersonas() {
		//Query query = entityManager.createNamedQuery(Persona.PERSONA_FIND_ALL, Persona.class);
		//return query.getResultList();
		return (List<Persona>) personaRepository.findAll();
	}

	@Override
	@Transactional
	public Persona encontrarPersonaPorId(Persona persona) {
		return personaRepository.findOne(persona.getId().longValue());
	}

	@Override
	@Transactional
	public Persona econtrarPersonaPorEmail(String email) throws NotFoundException {
		Persona personaEncontrada = null;
//		Query query = entityManager.createNamedQuery(Persona.PERSONA_FIND_BY_EMAIL);
//		query.setParameter("email", persona.getEmail());
//		if (query.getResultList() != null && query.getResultList().size() > 1) {
//			result = (Persona) query.getResultList().get(0);
//		}
		personaEncontrada = personaRepository.findByEmail(email);
		if (personaEncontrada == null) {
			throw new NotFoundException();
		}
		return personaEncontrada;
	}

	@Override
	@Transactional
	public Persona registrarPersona(Persona persona) {
		return personaRepository.save(persona);
	}

	@Override
	@Transactional(rollbackOn=NotFoundException.class)
	public Persona modificarPersona(Persona persona) throws NotFoundException {
		Persona personaModificada = personaRepository.findOne(persona.getId().longValue());
		if (personaModificada == null) {
			throw new NotFoundException();
		}
		personaModificada.setNombre(persona.getNombre());

		personaModificada.setEmail(persona.getEmail());

		return personaModificada;
	}

	@Override
	@Transactional(rollbackOn=NotFoundException.class)
	public Persona eliminarPersona(Persona persona) throws NotFoundException {
		Persona personaAEliminar = personaRepository.findOne(persona.getId().longValue());
		if (personaAEliminar == null) {
			throw new NotFoundException();
		}
		personaRepository.delete(personaAEliminar);
		return personaAEliminar;
	}
	
	@Override
	@Transactional
	public List<Persona> listarPersonasPorApellido(String apellido) {
		// TODO Auto-generated method stub
		return personaRepository.findByApellido(apellido);
		
	}

}
