package br.senai.sp.jandira.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.border.TitledBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.EtchedBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.SoftBevelBorder;

public class FrmAgenda extends JFrame {

	private JPanel painelPrincipal;
	private JTable tabelaContatos;

	public FrmAgenda() {
		setTitle("Agenda de Contatos");
		setBounds(100, 100, 450, 441);
		painelPrincipal = new JPanel();
		painelPrincipal.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(painelPrincipal);
		painelPrincipal.setLayout(null);
		
		JPanel painelTitulo = new JPanel();
		painelTitulo.setBackground(Color.WHITE);
		painelTitulo.setBounds(0, 0, 434, 67);
		painelPrincipal.add(painelTitulo);
		painelTitulo.setLayout(null);
		
		JLabel lblTitulo = new JLabel("Agenda de Contatos");
		lblTitulo.setForeground(Color.BLUE);
		lblTitulo.setIcon(new ImageIcon(FrmAgenda.class.getResource("/br/senai/sp/jandira/imagens/agenda64.png")));
		lblTitulo.setFont(new Font("Arial Black", Font.PLAIN, 26));
		lblTitulo.setBounds(10, 11, 414, 49);
		painelTitulo.add(lblTitulo);
		
		JPanel painelTabela = new JPanel();
		painelTabela.setBorder(new TitledBorder(null, "Meus contatos:", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLUE));
		painelTabela.setBounds(10, 78, 414, 228);
		painelPrincipal.add(painelTabela);
		painelTabela.setLayout(null);
		
		JScrollPane scrollTabela = new JScrollPane();
		scrollTabela.setBounds(10, 23, 394, 201);
		painelTabela.add(scrollTabela);
		
		tabelaContatos = new JTable();
		tabelaContatos.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
			},
			new String[] {
				"ID", "Nome", "E-mail"
			}
		));
		tabelaContatos.getColumnModel().getColumn(0).setPreferredWidth(30);
		tabelaContatos.getColumnModel().getColumn(1).setPreferredWidth(248);
		tabelaContatos.getColumnModel().getColumn(2).setPreferredWidth(300);
		scrollTabela.setViewportView(tabelaContatos);
		
		JPanel painelBotao = new JPanel();
		painelBotao.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		painelBotao.setBounds(10, 317, 414, 74);
		painelPrincipal.add(painelBotao);
		painelBotao.setLayout(null);
		
		JButton btnNovo = new JButton("");
		btnNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrmContato contato = new FrmContato("Novo");
				contato.setVisible(true);
				
			}
		});
		btnNovo.setIcon(new ImageIcon(FrmAgenda.class.getResource("/br/senai/sp/jandira/imagens/userAdd32.png")));
		btnNovo.setToolTipText("Cadastrar novo contato.");
		btnNovo.setBounds(10, 11, 89, 52);
		painelBotao.add(btnNovo);
		
		JButton btnEditar = new JButton("");
		btnEditar.setIcon(new ImageIcon(FrmAgenda.class.getResource("/br/senai/sp/jandira/imagens/userEdit32.png")));
		btnEditar.setToolTipText("Editar um contato que j\u00E1 existe.");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrmContato contato = new FrmContato("Editar");
				contato.setVisible(true);
			}
		});
		btnEditar.setBounds(111, 11, 89, 52);
		painelBotao.add(btnEditar);
		
		JButton btnExcluir = new JButton("");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrmContato contato = new FrmContato("Excluir");
				contato.setVisible(true);
			}
		});
		btnExcluir.setIcon(new ImageIcon(FrmAgenda.class.getResource("/br/senai/sp/jandira/imagens/userDelete32.png")));
		btnExcluir.setToolTipText("Excluir um contato j\u00E1 existente.");
		btnExcluir.setBounds(215, 11, 89, 52);
		painelBotao.add(btnExcluir);
		
		JButton btnSair = new JButton("");
		btnSair.setIcon(new ImageIcon(FrmAgenda.class.getResource("/br/senai/sp/jandira/imagens/exitApp32.png")));
		btnSair.setToolTipText("Sair da aplica\u00E7\u00E3o.");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		btnSair.setBounds(317, 11, 89, 52);
		painelBotao.add(btnSair);
	}
}
