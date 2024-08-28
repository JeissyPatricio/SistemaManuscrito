package br.com.sistema.cmd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

public class SelectItemManuscrito {

	public static void main(String[] args) {
		try {
			//abrir conexão com o banco de dados
			Connection conexao = ConnectionFactory.createConnection();
			
			//criar variavel para buscar o registro no banco
			String id;
			
			id = JOptionPane.showInputDialog("Dige o ID do manuscrito: ");
			
			//criar o sql para extrair os dados do banco
			String sql;
			
			sql = "select * from manuscrito where id = " + id + ";"; 
			
			//Linha abaixo para fazer o teste no banco de dados
			//System.out.println(sql);
			
			
			//Preparar para receber os dados
			PreparedStatement cmd = conexao.prepareStatement(sql);
			
			//executar o comando
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
