package br.com.restfull.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import br.com.restfull.factory.ConnectionFactory;
import br.com.restfull.model.Cliente;

/**
 * Classe responsável por conter os métodos do CRUD.
 * 
 * @author Brauner
 *
 */
public class ClienteDAO extends ConnectionFactory {
	
	private static ClienteDAO instance;
	
	/**
	 * Método responsável por criar uma unica instancia da classe ClienteDAO (Singleton)
	 * 
	 * @return instance
	 */
	public static ClienteDAO getInstance(){
		if(instance == null)
			instance = new ClienteDAO();
		return instance;
	}
	
	/**
	 * Método responsável por listar todos os clientes do banco.
	 * 
	 * @return ArrayList<Cliente> clientes
	 * @author Brauner
	 * 
	 */
	public ArrayList<Cliente> listarTodos(){
		
		Connection conexao = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		ArrayList<Cliente> clientes = null;
		
		conexao = criaConexao();
		
		clientes = new ArrayList<Cliente>();
		try {
			stmt = conexao.prepareStatement("select * from cliente order by id");
			rs = stmt.executeQuery();
			
			while(rs.next()){
				Cliente cliente = new Cliente();
				
				cliente.setId(rs.getInt("id"));
				cliente.setNome(rs.getString("nome"));
				cliente.setCpf(rs.getString("cpf"));
				cliente.setEndereco(rs.getString("endereco"));
				
				clientes.add(cliente);
			}
			
		} catch (Exception e) {
			System.out.println("Erro ao listar todos os clientes: " + e);
			e.printStackTrace();
		} finally {
			fechaConexao(conexao, stmt, rs);
		}
		
		return clientes;
	}
	
}
