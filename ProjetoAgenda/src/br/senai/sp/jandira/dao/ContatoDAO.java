package br.senai.sp.jandira.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

import br.senai.sp.jandira.jdbc.Conexao;

public class ContatoDAO {
	
	private ResultSet resultado;
	private PreparedStatement stm;
	
	//M�todo
	public ResultSet getContatos(){

		resultado = null;
		stm = null;
		//Filtrando os nomes pela primeira letra e tamb�m definindo a ordem de "DESC" e "ASC"
		
		String consulta = "SELECT * FROM contatos ORDER BY nome ASC";
		
		try{
			stm = Conexao.getConexao().prepareStatement(consulta);
			resultado = stm.executeQuery(); 
		}catch(Exception erro){
			JOptionPane.showMessageDialog(null,"Falha na consulta!", "ERRO", JOptionPane.ERROR_MESSAGE);
		}
				
		return resultado;
	}

}
