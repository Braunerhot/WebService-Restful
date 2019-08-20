package br.com.restfull.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import br.com.restfull.factory.ConnectionFactory;
import br.com.restfull.model.Produto;

public class ProdutoDAO extends ConnectionFactory {
	
	private static ProdutoDAO instance;
	
	/**
	 * Método responsável por criar uma única instancia da classe ProdutoDAO.
	 * 
	 * @return instance
	 */
	public static ProdutoDAO getInstance(){
		if(instance == null)
			instance = new ProdutoDAO();
		return instance;
	}
	
	/**
	 * Método responsável por listar todos os produtos do banco de dados.
	 * 
	 * @return produtos
	 */
	public ArrayList<Produto> listarTodos(){
		
		Connection conexao = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		ArrayList<Produto> produtos = null;
		
		conexao = criaConexao();
		
		produtos = new ArrayList<Produto>();
		try {
			stmt = conexao.prepareStatement("select * from produto order by descricao");
			rs = stmt.executeQuery();
			
			while(rs.next()){
				Produto produto = new Produto();
				
				produto.setId(rs.getInt("id"));
				produto.setDescricao(rs.getString("descricao"));
				produto.setLocal(rs.getString("local"));
				produto.setQuantidade(rs.getString("quantidade"));
				produto.setValor(rs.getString("valor"));
				
				produtos.add(produto);
			}
			
		} catch (Exception e) {
			System.out.println("Erros ao listar todos os produtos: " + e);
			e.printStackTrace();
		} finally {
			fechaConexao(conexao, stmt, rs);
		}
		
		return produtos;
	}

}
