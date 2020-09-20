package helio.Telas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import helio.Cliente.Cliente.Formacao;
import helio.Cliente.Cliente.Profissao;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JTextArea;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;

public class CriarContaT extends JFrame {

	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtCpf;
	private JTextField txtRenda;
	private JTextField txtNascimento;
	private JTextField txtSenhaApp;
	private JTextField txtConfirmarSenhaApp;
	private JTextField txtSenhaConta;
	private JTextField txtConfirmarSenhaConta;

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
		setTitle("Nova Conta");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 560, 420);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(110, 11, 392, 359);
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
		txtNome.setText("Nome");
		txtNome.setBounds(152, 10, 102, 20);
		panel.add(txtNome);
		txtNome.setColumns(10);
		
		txtCpf = new JTextField();
		txtCpf.setText("CPF");
		txtCpf.setBounds(152, 41, 102, 20);
		panel.add(txtCpf);
		txtCpf.setColumns(10);
		
		txtRenda = new JTextField();
		txtRenda.setText("Renda");
		txtRenda.setBounds(152, 72, 102, 20);
		panel.add(txtRenda);
		txtRenda.setColumns(10);
		
		txtNascimento = new JTextField();
		txtNascimento.setText("Nascimento");
		txtNascimento.setBounds(152, 103, 102, 20);
		panel.add(txtNascimento);
		txtNascimento.setColumns(10);
		
		txtSenhaApp = new JTextField();
		txtSenhaApp.setText("Senha App");
		txtSenhaApp.setBounds(152, 196, 102, 20);
		panel.add(txtSenhaApp);
		txtSenhaApp.setColumns(10);
		
		txtConfirmarSenhaApp = new JTextField();
		txtConfirmarSenhaApp.setText("Confirmar Senha");
		txtConfirmarSenhaApp.setBounds(152, 227, 102, 20);
		panel.add(txtConfirmarSenhaApp);
		txtConfirmarSenhaApp.setColumns(10);
		
		txtSenhaConta = new JTextField();
		txtSenhaConta.setText("Senha Conta");
		txtSenhaConta.setBounds(152, 258, 102, 20);
		panel.add(txtSenhaConta);
		txtSenhaConta.setColumns(10);
		
		txtConfirmarSenhaConta = new JTextField();
		txtConfirmarSenhaConta.setText("Confirmar Senha");
		txtConfirmarSenhaConta.setBounds(152, 289, 102, 20);
		panel.add(txtConfirmarSenhaConta);
		txtConfirmarSenhaConta.setColumns(10);
		
		JComboBox cbProfissao = new JComboBox();
		cbProfissao.setMaximumRowCount(20);
		cbProfissao.setModel(new DefaultComboBoxModel(Profissao.values()));
		cbProfissao.setBounds(152, 165, 230, 18);
		panel.add(cbProfissao);
		
		JButton btnCriarConta = new JButton("Criar Conta");
		btnCriarConta.setBounds(152, 320, 102, 23);
		panel.add(btnCriarConta);
		
		JComboBox cbFormacao = new JComboBox();
		cbFormacao.setModel(new DefaultComboBoxModel(Formacao.values()));
		cbFormacao.setBounds(152, 134, 230, 18);
		panel.add(cbFormacao);
	}
}
