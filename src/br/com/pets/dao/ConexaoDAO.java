package br.com.pets.dao;

import javax.swing.JOptionPane;

import java.sql.*;

import br.com.pets.pojo.Usuario;
import java.sql.*;

public class ConexaoDAO {
	
	Usuario dados = new Usuario();
	
	//Conexao ligacao = new Conexao();
	
	public void enviarDados() {
		
		dados.setNome(JOptionPane.showInputDialog("Informe o seu nome:"));
		dados.setEspecie(JOptionPane.showInputDialog("Informe o nome da especie de seu pet:"));
		dados.setNomePet(JOptionPane.showInputDialog("Informe o nome do seu pet:"));
		String idade = JOptionPane.showInputDialog("Informe a idade do seu pet:");
		dados.setIdade(Integer.parseInt(idade));
		
		
		JOptionPane.showMessageDialog(null, dados.getNome() + "\n" + dados.getEspecie() +"\n" + dados.getNomePet() + "\n" + dados.getIdade());
		
		//Realizando a conexao desta classe com o banco
		Connection Conn = Conexao.Conexao();
		String sql = "INSERT INTO animais (nome ,especie, nomePet, idade) VALUES (?,?,?,?)";
		
		try {
			PreparedStatement stmt = Conn.prepareStatement(sql);
			
			stmt.setString(1, dados.getNome());
			stmt.setString(2, dados.getEspecie());
			stmt.setString(3, dados.getNomePet());
			stmt.setInt(4, dados.getIdade());
			
			int resultado = stmt.executeUpdate();
			
			if(resultado>0) {
				System.out.println("Deu certo");
			}
			else {
				System.out.println("Deu erro");
			}
			stmt.close();
			Conn.close();
			
		}catch(SQLException ex) {
			//ex.printStackTrace();
			System.out.println("Erro ao enviar dados");
			
		}
		
				
	}
	
	
	public void listarDados() {
		Connection Conn = Conexao.Conexao();
		String sql = "SELECT * FROM animais";
		
		try {
			
			PreparedStatement stmt = Conn.prepareStatement(sql);
			
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				//String id = rs.getString("Nome:");
				String nome = rs.getString("nome");
				String especie = rs.getString("especie");
				String nomePet = rs.getString("nomePet");
				String idade = rs.getString("idade");
				
				System.out.println("Nome:" + nome + ", Especie:" + especie + ", Nome do pet:" + nomePet + ", Idade:" + idade);
				
			}
			rs.close();
			stmt.close();
			Conn.close();
			
			
			
		}catch(SQLException ex) {
			ex.printStackTrace();
			System.out.println("Erro ao recuperar dados");
			
		}
		
		
	}

}
