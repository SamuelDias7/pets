package br.com.pets.app;

import br.com.pets.dao.Conexao;
import br.com.pets.dao.ConexaoDAO;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Conexao objCon = new Conexao();
		ConexaoDAO manDados = new ConexaoDAO();
		
		objCon.Conexao();
		manDados.enviarDados();
		manDados.listarDados();

	}

}
