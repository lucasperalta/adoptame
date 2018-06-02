package ar.edu.davinci.adoptame.service;

import ar.edu.davinci.adoptame.domain.Usuario;
import ar.edu.davinci.adoptame.exception.NotFoundException;

import java.util.List;

public interface LoginService {

	public Usuario findAdmin(String email,String password) throws NotFoundException;



}