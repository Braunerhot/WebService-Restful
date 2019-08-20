package br.com.restfull.resource;

import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import br.com.restfull.controller.ProdutoController;
import br.com.restfull.model.Produto;

/**
 * Classe respons�vel por conter os m�todos REST de acesso ao WebService.
 * 
 * @author Brauner
 *
 */
@Path("/produtos")
public class ProdutoResource {
	
	/**
	 * M�todo respons�vel por fazer a chamada ao ProdutoController.
	 * 
	 * @return ProdutoController().listarTodos()
	 */
	@GET
	@Path("/listartodos")
	@Produces("application/xml")
	public ArrayList<Produto> listarTodos(){
		return new ProdutoController().listarTodos();
	}

}
