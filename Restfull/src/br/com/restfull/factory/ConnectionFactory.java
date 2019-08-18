package br.com.restfull.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Classe responsável por conter os métodos criar e fechar o banco de dados.
 * 
 * @author Brauner
 *
 */
public class ConnectionFactory {
	
	//As constantes do caminho do banco de dados
	private static final String DRIVER = "org.postgresql.Driver";
	private static final String URL = "jdbc:postgresql://localhost:5432/webservice";
	private static final String USUARIO = "postgres";
	private static final String SENHA = "123";
	
	/**
	 * Método responsável por criar uma conexão com o banco
	 * 
	 * @return conexao
	 */
	public Connection criaConexao(){
		
		Connection conexao = null;
		
		try {
			
			Class.forName(DRIVER);
			conexao = DriverManager.getConnection(URL, USUARIO, SENHA);
			
		} catch (Exception e) {
			System.out.println("Erro ao criar conexão com o banco: " + URL);
			e.printStackTrace();
		}
		return conexao;
	}

	public void fechaConexao(Connection conexao, PreparedStatement stmt, ResultSet rs){
		
		try {
			
			if(conexao != null){
				conexao.close();
			}
			if(stmt != null){
				stmt.close();
			}
			if(rs != null){
				rs.close();
			}
			
		} catch (Exception e) {
			System.out.println("Erro ao fechar conexão com o banco: " + URL);
		}
		
	}
	
}
