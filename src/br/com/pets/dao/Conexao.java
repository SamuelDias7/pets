package br.com.pets.dao;

import java.sql.*;

public class Conexao {
	private final static String url = "jdbc:mysql://localhost:3306/pets";
	private final static String usuario = "root";
	private final static String senha = "sdh7xpx8521S";
	
	public static Connection Conexao() {
		
		//Declarando a variavel Conn
		Connection Conn = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Conn = DriverManager.getConnection(url, usuario, senha);
			System.out.println("Conexão com banco de dados realizada com sucesso");
		}catch(ClassNotFoundException | SQLException ex) {
			ex.printStackTrace();
			System.out.println("Erro ao se conectar com o banco de dados");
			
		}
		
		
		return Conn;
	}

}
