package br.senai.sp.jandira.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Conexao {
	
	private static Connection con;
	
	public static Connection getConexao(){
		
		con = null;
		
		try{
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			String dbURL = "jdbc:ucanaccess:////10.107.134.3/banco2/agenda.accdb";
			//String dbURL = "jdbc:ucanaccess://C:/Users/17259235/Desktop/bancodedados.accdb";
			
			con = DriverManager.getConnection(dbURL);
		}catch(Exception erro){
			JOptionPane.showMessageDialog(null,"Não foi possível se conectar ao Bancos de dados.","ERRO", JOptionPane.ERROR_MESSAGE);
		}
		return con;
		
	}
	
	public static void fecharConexao(){
		if (con != null){
			try {
				con.close();
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null,"O banco já está fechado!","ERRO", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
}
