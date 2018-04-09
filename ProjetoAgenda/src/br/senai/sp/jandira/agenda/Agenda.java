package br.senai.sp.jandira.agenda;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import br.senai.sp.jandira.dao.ContatoDAO;
import br.senai.sp.jandira.jdbc.Conexao;

public class Agenda {

	public static void main(String[] args) {
		ContatoDAO consultaNomes = new ContatoDAO();
		ResultSet rs = consultaNomes.getContatos();
		
		try{
			while(rs.next()){
				System.out.println("Nomes: " + rs.getString("nome"));
			}
		}catch(Exception erro){
			JOptionPane.showMessageDialog(null,"Erro na consulta", "Erro!", JOptionPane.ERROR_MESSAGE);
		}
		
		
	}
}
