package br.com.sistema.cmd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

public class SelectManuscrito {

	public static void main(String[] args) {
		try {
			Connection conexao = ConnectionFactory.createConnection();
			
			//criar o SQL para extrair os dados
			String sql = "select * from manuscrito";
			//Criando o comando
			PreparedStatement cmd = conexao.prepareStatement(sql);
			//executando o comando
			ResultSet resultado = cmd.executeQuery();
			
			//Cria uma variavel para receber os dados
			String manuscritos;
			manuscritos = "<< Manuscritos encontrados >>\n";
			while (resultado.next()) {
				manuscritos += "ID: " + resultado.getInt("id")
				+ " - Titulo: " + resultado.getString("titulo")
				+ " - Autor: " + resultado.getString("autor")
				+"\n";
				
				
			}
			JOptionPane.showMessageDialog(null, manuscritos);
			conexao.close();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		

	}

}
