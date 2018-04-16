package br.senai.sp.jandira.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import br.senai.sp.jandira.jdbc.Conexao;
import br.senai.sp.jandira.model.Contato;

public class ContatoDAO {
	
	private ResultSet resultado;
	private PreparedStatement stm;
	
	//Método
	public ResultSet getContatos(){

		resultado = null;
		stm = null;
	
		//Filtrando os nomes pela primeira letra e também definindo a ordem de "DESC" e "ASC"
		String consulta = "SELECT * FROM contatos ORDER BY nome ASC";
		
		try{
			stm = Conexao.getConexao().prepareStatement(consulta);
			resultado = stm.executeQuery();
			Conexao.fecharConexao();
		}catch(Exception erro){
			JOptionPane.showMessageDialog(null,"Falha na consulta!", "ERRO", JOptionPane.ERROR_MESSAGE);
		}
				
		return resultado;
	}
	
	public ArrayList<Contato> getListaContatos(){

		ArrayList<Contato> contatos = new ArrayList<>();		
		resultado = null;
		stm = null;
	
		//Filtrando os nomes pela primeira letra e também definindo a ordem de "DESC" e "ASC"
		String consulta = "SELECT * FROM contatos ORDER BY nome ASC";
		
		try{
			stm = Conexao.getConexao().prepareStatement(consulta);
			resultado = stm.executeQuery(); 
			
			while(resultado.next()){
				Contato contato = new Contato();
				contato.setId(resultado.getInt("id"));
				contato.setNome(resultado.getString("nome"));
				contato.setDtNascimento(resultado.getString("dtNasc"));
				contato.setEmail(resultado.getString("email"));
				contato.setEndereco(resultado.getString("endereco"));
				contato.setTelefone(resultado.getString("telefone"));
				contato.setCelular(resultado.getString("celular"));
				contato.setSexo(resultado.getString("sexo"));
				contatos.add(contato);
				Conexao.fecharConexao();
			}
		}catch(Exception erro){
			JOptionPane.showMessageDialog(null,"Falha na consulta!", "ERRO", JOptionPane.ERROR_MESSAGE);
		}
				
		return contatos;
	}
	
	public Contato getContato(int id){

		Contato contato = new Contato();
		resultado = null;
		stm = null;
	
		//Filtrando os nomes pela primeira letra e também definindo a ordem de "DESC" e "ASC"
		String consulta = "SELECT * FROM contatos WHERE id = ?";
		
		try{
			stm = Conexao.getConexao().prepareStatement(consulta);
			//Transformando a "?" da consulta pelo ID
			stm.setInt(1, id);
			resultado = stm.executeQuery(); 
			
			resultado.next();
			contato.setId(resultado.getInt("id"));
			contato.setNome(resultado.getString("nome"));
			contato.setDtNascimento(resultado.getString("dtNasc"));
			contato.setEmail(resultado.getString("email"));
			contato.setEndereco(resultado.getString("endereco"));
			contato.setTelefone(resultado.getString("telefone"));
			contato.setCelular(resultado.getString("celular"));
			contato.setSexo(resultado.getString("sexo"));
			
			Conexao.fecharConexao();
			
		}catch(Exception erro){
			JOptionPane.showMessageDialog(null,"Falha na consulta!", "ERRO", JOptionPane.ERROR_MESSAGE);
		}
				
		return contato;
	}
}
