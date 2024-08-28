package br.com.sistema.cmd;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.swing.JOptionPane;

public class DeleteManuscrito {

	public static void main(String[] args) {
		try {
			Connection conexao = ConnectionFactory.createConnection();
			JOptionPane.showMessageDialog(null, "Conexão aberta com sucesso!");
			
			Manuscrito manuscrito = new Manuscrito();
			
			manuscrito.setId(JOptionPane.showInputDialog("Entre com o ID: "));
			
			String sql = "delete from manuscrito where id = ?;";
			
			PreparedStatement cmd = conexao.prepareStatement(sql);
			
			cmd.setString(1, manuscrito.getId());
			
			cmd.execute();
			
			JOptionPane.showMessageDialog(null, "Registro excluido com sucesso!");
			
			cmd.close();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
