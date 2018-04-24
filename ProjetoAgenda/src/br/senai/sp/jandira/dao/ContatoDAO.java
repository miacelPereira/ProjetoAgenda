package br.senai.sp.jandira.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.management.StringValueExp;
import javax.swing.JOptionPane;
import javax.swing.text.html.HTMLEditorKit.Parser;

import br.senai.sp.jandira.jdbc.Conexao;
import br.senai.sp.jandira.model.Contato;

public class ContatoDAO {
	
	private Contato contato;
	private ResultSet resultado;
	private PreparedStatement stm;
	
	public void setContato(Contato contato) {
		this.contato = contato;
	}
	
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
		//imprimindo o formato da data do banco para português BR
		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
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
			contato.setDtNascimento(df.format(resultado.getDate("dtNasc")));
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
	
	//Gravando no banco de dados
	public void gravar(){
		String sql = "INSERT INTO contatos (nome, dtNasc, email, endereco, telefone, celular, sexo) VALUES (?, ?, ?, ?, ?, ?, ?)"; 
		try{
			stm= Conexao.getConexao().prepareStatement(sql);
			stm.setString(1, contato.getNome());
			stm.setString(2, contato.getDtNascimento());
			stm.setString(3, contato.getEmail());
			stm.setString(4, contato.getEndereco());
			stm.setString(5, contato.getTelefone());
			stm.setString(6, contato.getCelular());
			stm.setString(7, contato.getSexo());
			stm.execute();
			JOptionPane.showMessageDialog(null,"Contato gravado com sucesso!");
			Conexao.fecharConexao();
			
		}catch(Exception erro){
			System.out.println("Erro na gravação dos dados!");
			System.out.println(erro.getMessage());
			
		}
	}	
	//Atualizar contato
	public void atualizar(){
		
		
	}
	//Excluir um contato
	public void excluir(String ID){
		String sqlDelete = "DELETE FROM contatos WHERE id = ?";
		try{
			stm = Conexao.getConexao().prepareStatement(sqlDelete);
			int teste = Integer.parseInt(ID);
			stm.setInt(1, teste);
			
			System.out.println(ID);
			stm.executeUpdate();
			JOptionPane.showMessageDialog(null,"Contato excluído");
			Conexao.fecharConexao();
		}catch (Exception erro) {
			System.out.println(erro);
			JOptionPane.showMessageDialog(null, "Erro em excluir contato");
		}
	}
}
