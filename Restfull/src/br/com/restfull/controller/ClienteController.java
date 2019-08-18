package br.com.restfull.controller;

import java.util.ArrayList;

import br.com.restfull.dao.ClienteDAO;
import br.com.restfull.model.Cliente;

/**
 * Classe responsável por ser o controlador entre o resource e a camada DAO.
 * 
 * @author Brauner
 *
 */
public class ClienteController {
	
	public ArrayList<Cliente> listarTodos(){
		return ClienteDAO.getInstance().listarTodos();
	}

}
