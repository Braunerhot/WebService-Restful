package br.com.restfull.controller;

import java.util.ArrayList;

import br.com.restfull.dao.ProdutoDAO;
import br.com.restfull.model.Produto;

public class ProdutoController {
	
	public ArrayList<Produto> listarTodos(){
		return ProdutoDAO.getInstance().listarTodos();
	}

}
