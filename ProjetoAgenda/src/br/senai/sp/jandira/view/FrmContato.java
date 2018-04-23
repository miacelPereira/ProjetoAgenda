package br.senai.sp.jandira.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.ImageIcon;
import javax.swing.border.TitledBorder;
import javax.swing.text.MaskFormatter;

import br.senai.sp.jandira.dao.ContatoDAO;
import br.senai.sp.jandira.model.Contato;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;

public class FrmContato extends JFrame {

	private JPanel painelPrincipal;
	private JTextField txtId;
	private JTextField txtNome;
	private JTextField txtEmail;
	//private JTextField txtDtNasc;
	private JTextField txtTelefone;
	private JTextField txtCelular;
	private JComboBox cbSexo;
	private JTextArea textArea;
	private JFormattedTextField txtDtNasc;
	
	public void setTextArea(String area) {
		this.textArea.setText(area);
	}

	public void setTxtId(String id) {
		this.txtId.setText(String.valueOf(id));
	}

	public void setTxtNome(String nome) {
		this.txtNome.setText(nome);
	}

	public void setTxtEmail(String email) {
		this.txtEmail.setText(email);
	}

	public void setTxtDtNasc(String dtNasc) {
		this.txtDtNasc.setText(dtNasc);
	}

	public void setTxtTelefone(String telefone) {
		this.txtTelefone.setText(telefone);
	}

	public void setTxtCelular(String celular) {
		this.txtCelular.setText(celular);
	}

	public void setCbSexo(String sexo) {
		if (sexo.equals("F")){
			cbSexo.setSelectedIndex(0);
		}
		else{
			cbSexo.setSelectedIndex(1);
		}
	}

	
	public FrmContato(String operacao) {
		setBounds(100, 100, 450, 441);
		painelPrincipal = new JPanel();
		painelPrincipal.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(painelPrincipal);
		painelPrincipal.setLayout(null);

		JPanel painelTitulo = new JPanel();
		painelTitulo.setBackground(Color.WHITE);
		painelTitulo.setBounds(10, 0, 414, 53);
		painelPrincipal.add(painelTitulo);
		painelTitulo.setLayout(null);

		JLabel lblContatos = new JLabel("Contatos");
		lblContatos.setForeground(Color.BLUE);
		lblContatos.setBounds(10, 13, 176, 31);
		lblContatos.setIcon(new ImageIcon(FrmContato.class.getResource("/br/senai/sp/jandira/imagens/user32.png")));
		lblContatos.setFont(new Font("Arial Black", Font.PLAIN, 26));
		painelTitulo.add(lblContatos);

		JLabel lblOperao = new JLabel("Opera\u00E7\u00E3o");
		lblOperao.setText(operacao);
		lblOperao.setBounds(338, 28, 66, 14);
		painelTitulo.add(lblOperao);

		JPanel painelDados = new JPanel();
		painelDados.setBorder(
				new TitledBorder(null, "Dados do contato:", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLUE));
		painelDados.setBounds(10, 64, 414, 269);
		painelPrincipal.add(painelDados);
		painelDados.setLayout(null);

		JLabel lblId = new JLabel("ID:");
		lblId.setBounds(10, 21, 20, 14);
		painelDados.add(lblId);

		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(74, 21, 83, 14);
		painelDados.add(lblNome);

		txtId = new JTextField();
		txtId.setEditable(false);
		txtId.setBounds(10, 34, 54, 20);
		painelDados.add(txtId);
		txtId.setColumns(10);

		txtNome = new JTextField();
		txtNome.setColumns(10);
		txtNome.setBounds(74, 34, 330, 20);
		painelDados.add(txtNome);

		JLabel lblEmail = new JLabel("E-mail:");
		lblEmail.setBounds(10, 62, 54, 14);
		painelDados.add(lblEmail);

		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(10, 76, 228, 20);
		painelDados.add(txtEmail);

		JLabel lblSexo = new JLabel("Sexo:");
		lblSexo.setBounds(249, 62, 54, 14);
		painelDados.add(lblSexo);

		cbSexo = new JComboBox();
		cbSexo.setModel(new DefaultComboBoxModel(new String[] { "Feminino", "Masculino" }));
		cbSexo.setBounds(248, 76, 156, 20);
		painelDados.add(cbSexo);

		JLabel lblDtNasc = new JLabel("Dt. Nasc.:");
		lblDtNasc.setBounds(10, 101, 54, 14);
		painelDados.add(lblDtNasc);

		JLabel lblTelefone = new JLabel("Telefone:");
		lblTelefone.setBounds(103, 101, 54, 14);
		painelDados.add(lblTelefone);

		txtTelefone = new JTextField();
		txtTelefone.setBounds(106, 119, 143, 20);
		painelDados.add(txtTelefone);
		txtTelefone.setColumns(10);

		JLabel lblCelular = new JLabel("Celular:");
		lblCelular.setBounds(258, 101, 54, 14);
		painelDados.add(lblCelular);

		txtCelular = new JTextField();
		txtCelular.setColumns(10);
		txtCelular.setBounds(259, 119, 145, 20);
		painelDados.add(txtCelular);

		JLabel lblEndereo = new JLabel("Endere\u00E7o:");
		lblEndereo.setBounds(10, 150, 90, 14);
		painelDados.add(lblEndereo);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 164, 394, 94);
		painelDados.add(scrollPane);

		textArea = new JTextArea();
		textArea.setLineWrap(true);
		scrollPane.setViewportView(textArea);
		
		//colocando mascra no txt
		MaskFormatter dataMask = null;
		try {
			dataMask= new MaskFormatter("##/##/####");
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		txtDtNasc = new JFormattedTextField();
		txtDtNasc.setBounds(33, 119, 63, 20);
		painelDados.add(txtDtNasc);

		JPanel painelBotao = new JPanel();
		painelBotao.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		painelBotao.setBounds(10, 338, 414, 60);
		painelPrincipal.add(painelBotao);
		painelBotao.setLayout(null);

		//**********Listener para o botão salvar***********//
		JButton btnSalvar = new JButton("");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				////***Antes de tudo devo criar um contato***///
				Contato contato = new Contato();
				contato.setNome(txtNome.getText());
				contato.setDtNascimento(txtDtNasc.getText());
				contato.setTelefone(txtTelefone.getText());
				contato.setCelular(txtCelular.getText());
				contato.setEmail(txtEmail.getText());
				contato.setEndereco(textArea.getText());
				//tratando para pegar a primeira letra do sexo
				contato.setSexo(cbSexo.getSelectedItem().toString().substring(0,1));
				
				ContatoDAO contatoDAO = new ContatoDAO();
				contatoDAO.setContato(contato);
				
				if(lblOperao.getText().equals("Novo")){
					contatoDAO.gravar();
					limparControles();
				}
			}
		});
		
		btnSalvar.setIcon(new ImageIcon(FrmContato.class.getResource("/br/senai/sp/jandira/imagens/save32.png")));
		btnSalvar.setBounds(10, 11, 45, 45);
		painelBotao.add(btnSalvar);

		JButton btnFechar = new JButton("");
		btnFechar.setIcon(new ImageIcon(FrmContato.class.getResource("/br/senai/sp/jandira/imagens/exitApp32.png")));
		btnFechar.setBounds(359, 11, 45, 45);
		painelBotao.add(btnFechar);
		btnFechar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				FrmContato.this.dispose();
			}
		});
	}
	
	private void limparControles(){
		txtId.setText("");
		txtNome.setText("");
		txtEmail.setText("");
		txtTelefone.setText("");
		txtCelular.setText("");
		txtDtNasc.setText("");
		textArea.setText("");
		cbSexo.setSelectedIndex(0);
		//Posicionando o cursor em um dos text//
		txtNome.grabFocus();
		
	}
}
