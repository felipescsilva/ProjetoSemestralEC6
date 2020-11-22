package view.Login;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import Audit.Audit;
import DAO.ClienteDAO;
import DAO.ContaDAO;
import model.Cliente.*;
import model.Conta.Conta;
import view.Main.Main;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Frame;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.time.LocalDate;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class CriarContaT extends JFrame {

	private JPanel contentPane;
	private JTextField txtNome;
	private JFormattedTextField txtCpf;
	private JTextField txtRenda;
	private JFormattedTextField txtNascimento;
	private JPasswordField txtSenhaApp;
	private JPasswordField txtConfirmarSenhaApp;
	private JPasswordField txtSenhaConta;
	private JPasswordField txtConfirmarSenhaConta;
	private JButton btnCriarConta;
	private ClienteDAO clienteDAO = new ClienteDAO();
	private ContaDAO contaDAO = new ContaDAO();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CriarContaT frame = new CriarContaT();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public CriarContaT() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent arg0) {
				Main.telaLogin.show();
				dispose();
			}
		});
		setTitle("Nova Conta");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 432, 420);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 153, 255));
		panel.setBounds(10, 11, 396, 359);
		contentPane.add(panel);
		
		JLabel lblNomeCompleto = new JLabel("Nome Completo");
		lblNomeCompleto.setBounds(40, 13, 102, 16);
		lblNomeCompleto.setFont(new Font("Sitka Small", Font.BOLD, 12));
		
		JLabel lblCpf = new JLabel("CPF");
		lblCpf.setBounds(112, 45, 30, 14);
		lblCpf.setFont(new Font("Sitka Small", Font.BOLD, 12));
		panel.setLayout(null);
		panel.add(lblNomeCompleto);
		panel.add(lblCpf);
		
		JLabel lblRenda = new JLabel("Renda");
		lblRenda.setBounds(96, 76, 46, 14);
		panel.add(lblRenda);
		lblRenda.setFont(new Font("Sitka Small", Font.BOLD, 12));
		
		JLabel lblDataDeNascimento = new JLabel("Data de Nascimento");
		lblDataDeNascimento.setBounds(10, 107, 132, 14);
		panel.add(lblDataDeNascimento);
		lblDataDeNascimento.setFont(new Font("Sitka Small", Font.BOLD, 12));
		
		JLabel lblFormao = new JLabel("Forma\u00E7\u00E3o");
		lblFormao.setBounds(75, 138, 67, 14);
		panel.add(lblFormao);
		lblFormao.setFont(new Font("Sitka Small", Font.BOLD, 12));
		
		JLabel lblProfisso = new JLabel("Profiss\u00E3o");
		lblProfisso.setBounds(75, 168, 67, 14);
		panel.add(lblProfisso);
		lblProfisso.setFont(new Font("Sitka Small", Font.BOLD, 12));
		
		JLabel lblSenhaDoAplicativo = new JLabel("Senha do Aplicativo");
		lblSenhaDoAplicativo.setBounds(10, 200, 132, 14);
		panel.add(lblSenhaDoAplicativo);
		lblSenhaDoAplicativo.setFont(new Font("Sitka Small", Font.BOLD, 12));
		
		JLabel lblConfirmarSenhaAPP = new JLabel("Confirmar Senha");
		lblConfirmarSenhaAPP.setBounds(35, 231, 107, 14);
		panel.add(lblConfirmarSenhaAPP);
		lblConfirmarSenhaAPP.setFont(new Font("Sitka Small", Font.BOLD, 12));
		
		JLabel lblSenhaDaConta = new JLabel("Senha da Conta");
		lblSenhaDaConta.setBounds(45, 262, 97, 14);
		panel.add(lblSenhaDaConta);
		lblSenhaDaConta.setFont(new Font("Sitka Small", Font.BOLD, 12));
		
		JLabel lblConfirmarSenhaConta = new JLabel("Confirmar Senha");
		lblConfirmarSenhaConta.setBounds(35, 293, 107, 14);
		panel.add(lblConfirmarSenhaConta);
		lblConfirmarSenhaConta.setFont(new Font("Sitka Small", Font.BOLD, 12));
		
		txtNome = new JTextField();
		txtNome.setBounds(152, 10, 102, 20);
		panel.add(txtNome);
		txtNome.setColumns(10);
		
		try {
			txtCpf = new JFormattedTextField(new MaskFormatter("###.###.###-##"));
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		txtCpf.setBounds(152, 41, 102, 20);
		panel.add(txtCpf);
		txtCpf.setColumns(10);
		
		txtRenda = new JTextField();
		txtRenda.setBounds(152, 72, 102, 20);
		panel.add(txtRenda);
		txtRenda.setColumns(10);
		
		
		try {
			txtNascimento = new JFormattedTextField(new MaskFormatter("##/##/####"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		txtNascimento.setBounds(152, 103, 102, 20);
		panel.add(txtNascimento);
		txtNascimento.setColumns(10);
		
		txtSenhaApp = new JPasswordField();
		txtSenhaApp.setBounds(152, 196, 102, 20);
		panel.add(txtSenhaApp);
		txtSenhaApp.setColumns(10);
		
		txtConfirmarSenhaApp = new JPasswordField();
		txtConfirmarSenhaApp.setBounds(152, 227, 102, 20);
		panel.add(txtConfirmarSenhaApp);
		txtConfirmarSenhaApp.setColumns(10);
		
		txtSenhaConta = new JPasswordField();
		txtSenhaConta.setBounds(152, 258, 102, 20);
		panel.add(txtSenhaConta);
		txtSenhaConta.setColumns(10);
		
		txtConfirmarSenhaConta = new JPasswordField();
		txtConfirmarSenhaConta.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyChar() == KeyEvent.VK_ENTER)
				{
					btnCriarConta.doClick();
				}
			}
		});
		txtConfirmarSenhaConta.setBounds(152, 289, 102, 20);
		panel.add(txtConfirmarSenhaConta);
		txtConfirmarSenhaConta.setColumns(10);
		
		JComboBox cbProfissao = new JComboBox();
		cbProfissao.setMaximumRowCount(20);
		cbProfissao.setModel(new DefaultComboBoxModel(Profissao.values()));
		cbProfissao.setBounds(152, 165, 230, 18);
		panel.add(cbProfissao);
		
		JComboBox cbFormacao = new JComboBox();
		cbFormacao.setModel(new DefaultComboBoxModel(Formacao.values()));
		cbFormacao.setBounds(152, 134, 230, 18);
		panel.add(cbFormacao);
		
		btnCriarConta = new JButton("Criar Conta");
		btnCriarConta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String mensagemDeErro = "Preencha os dados corretamente.\n";
				JFrame f = new JFrame();
				boolean dadosCorretos = true;
				if (txtNome.getText().isEmpty())
				{
					mensagemDeErro += "Nome não pode ser vazio.\n";
					dadosCorretos = false;
				}
				if (txtCpf.getText().trim().length() != 14)
				{
					mensagemDeErro += "CPF inválido.\n";
					dadosCorretos = false;
				}
				double renda = 0;
				if (txtRenda.getText().isEmpty())
				{
					mensagemDeErro += "Preencha a renda.\n";
					dadosCorretos = false;
				}
				else {
					if (Double.parseDouble(txtRenda.getText()) < 0) {
						mensagemDeErro += "A renda não pode ser negativa.\n";
						dadosCorretos = false;
					} else {
						renda = Double.parseDouble(txtRenda.getText());
					}
				}
				LocalDate data = LocalDate.now();
				String dataString = txtNascimento.getText();
				if (dataString.trim().length() != 10) {
					mensagemDeErro += "Data inválida.\n";
				} else {
					data = LocalDate.of(Integer.parseInt(dataString.split("/")[2]), Integer.parseInt(dataString.split("/")[1]), Integer.parseInt(dataString.split("/")[0]));
					if (data.isAfter(LocalDate.now()))
					{
						mensagemDeErro += "Data inválida.\n";
						dadosCorretos = false;
					}
				}
				
				if (txtSenhaApp.getText().length() != 8)
				{
					mensagemDeErro += "A senha do aplicativo deve possuir 8 caracteres.\n";
					dadosCorretos = false;
				}
				if (!txtConfirmarSenhaApp.getText().equals(txtSenhaApp.getText())) 
				{
					mensagemDeErro += "A confirmação da senha do aplicativo não pode ser diferente da senha do aplicativo.\n";
					dadosCorretos = false;
				}
				if (txtSenhaConta.getText().length() != 6)
				{
					mensagemDeErro += "A senha da conta deve possuir 6 caracteres.\n";
					dadosCorretos = false;
				}
				if (!txtConfirmarSenhaConta.getText().equals(txtSenhaConta.getText())) 
				{
					mensagemDeErro += "A confirmação da senha da conta não pode ser diferente da senha da conta.\n";
					dadosCorretos = false;
				}
				Profissao.valueOf("Administração");
				
				try {
					Audit auditoria = new Audit();
					if (clienteDAO.Consultar("CPF", txtCpf.getText()).size() != 0) {
						auditoria.getInstancia().gerarRelatorio("mensagem");
						dadosCorretos = false;
						mensagemDeErro += "Já existe uma conta vinculada a esse CPF.\n";
					}
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					System.out.println(e1.toString());
					JOptionPane.showMessageDialog(f, "Ocorreu um erro ao tentar uma conexão com o banco de dados, tente novamente mais tarde!");
				}
				
				
				if (dadosCorretos) {
				// Mensagem caso a conta seja criada
					Profissao profissao;
					Cliente cliente = new Cliente(txtNome.getText(), txtCpf.getText(), data, Formacao.valueOf(cbFormacao.getSelectedItem().toString()), Profissao.valueOf(cbProfissao.getSelectedItem().toString()), renda);
					Conta conta = new Conta();
					conta.geraNumConta();
					conta.setCPF(cliente.getCPF());
					conta.setDataAbertura(LocalDate.now());
					conta.setSaldo(0);
					conta.setSenhaApp(txtSenhaApp.getText());
					conta.setSenhaConta(txtSenhaConta.getText());
					
					try {
						Audit auditoria = new Audit();
						clienteDAO.Inserir(cliente);
						contaDAO.Inserir(conta);
						auditoria.getInstancia().gerarRelatorio("mensagem");
						JOptionPane.showMessageDialog(f, "Sua conta foi criada com sucesso!\nO número da sua conta é " + conta.getNumeroConta());
						dispose();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						JOptionPane.showMessageDialog(f, mensagemDeErro, "Erro", JOptionPane.WARNING_MESSAGE);
					}
				}
				else {
					// Mensagem em caso de erro
					JOptionPane.showMessageDialog(f, mensagemDeErro, "Erro", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		btnCriarConta.setBounds(152, 320, 102, 23);
		panel.add(btnCriarConta);
		
	}
}
