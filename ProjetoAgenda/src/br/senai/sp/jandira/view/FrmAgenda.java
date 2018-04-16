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

import br.senai.sp.jandira.dao.ContatoDAO;
import br.senai.sp.jandira.model.Contato;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
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
	private JPanel painelTabela;
	
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
		
		painelTabela = new JPanel();
		painelTabela.setBorder(new TitledBorder(null, "Meus contatos:", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLUE));
		painelTabela.setBounds(10, 78, 414, 228);
		painelPrincipal.add(painelTabela);
		painelTabela.setLayout(null);
		
		//*** Construção da tabela 
		criarTabela();
		
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
				//Pegando o ID da linha que o usuario clicou
				int linha = tabelaContatos.getSelectedRow();
				int coluna = 0;
				System.out.println("ID: "+tabelaContatos.getValueAt(linha, coluna));
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
	
	public void criarTabela(){
		JScrollPane scrollTabela = new JScrollPane();
		scrollTabela.setBounds(10, 23, 394, 201);
		painelTabela.add(scrollTabela);
		
		// **********Tabela***************
		tabelaContatos = new JTable();
		ArrayList<Contato> contatos = new ArrayList<>();
		ContatoDAO dao = new ContatoDAO();
		contatos = dao.getListaContatos();
		
		//****** Título da Tabela ******
		DefaultTableModel modeloTabela = new DefaultTableModel(){
		//Bloqueando edição da tabela
			public boolean isCellEditable(int row, int col){
				return false;
			}
		};
		String [] nomesColunas = {"ID", "Nome", "E-mail"};
		modeloTabela.setColumnIdentifiers(nomesColunas);
		
		//****** Dados da Tabela ******
		Object[] linha = new Object[3];
		
		//****Recebendo os contatos do arraylist, um contato por vez (uma linha por vez) e criando uma nova linha para guardar os dados
		for(Contato contato : contatos){
			linha[0] = contato.getId();
			linha[1] = contato.getNome();
			linha[2] = contato.getEmail();
			modeloTabela.addRow(linha);
		}
		tabelaContatos.setModel(modeloTabela);
		
		//****Formatação das colunas ****
		//****Travando movimentação da coluna*****
		tabelaContatos.getTableHeader().setReorderingAllowed(false);
		
		//*****Largura das colunas******
		tabelaContatos.getColumnModel().getColumn(0).setPreferredWidth(30);
		tabelaContatos.getColumnModel().getColumn(0).setResizable(false);
		
		
		tabelaContatos.getColumnModel().getColumn(1).setPreferredWidth(190);
		tabelaContatos.getColumnModel().getColumn(1).setResizable(false);
		
		tabelaContatos.getColumnModel().getColumn(2).setPreferredWidth(174);
		tabelaContatos.getColumnModel().getColumn(2).setResizable(false);
		
		scrollTabela.setViewportView(tabelaContatos);
		
		
	}
}
