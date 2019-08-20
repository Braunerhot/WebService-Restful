package br.com.restfull.resource;

import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import br.com.restfull.controller.ClienteController;
import br.com.restfull.model.Cliente;

/**
 * Classe responsável por conter os métodos REST de acesso ao WebService.
 * 
 * @author Brauner
 *
 */
@Path("/clientes")
public class ClienteResource {
	
	/**
	 * Método responsável por fazer chamada ao Controller
	 * @author Brauner
	 * @return ClienteController().listarTodos()
	 */
	@GET
	@Path("/listartodos")
	@Produces("application/json")
	public ArrayList<Cliente> listarTodos(){
		return new ClienteController().listarTodos();
	}
	
}


