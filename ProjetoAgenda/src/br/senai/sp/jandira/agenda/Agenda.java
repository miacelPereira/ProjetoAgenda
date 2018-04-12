package br.senai.sp.jandira.agenda;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import br.senai.sp.jandira.dao.ContatoDAO;
import br.senai.sp.jandira.jdbc.Conexao;
import br.senai.sp.jandira.view.FrmAgenda;

public class Agenda {

	public static void main(String[] args) {
		FrmAgenda agenda = new FrmAgenda();
			agenda.setVisible(true);
		
	}
}
