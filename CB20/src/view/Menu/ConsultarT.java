package view.Menu;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import view.Main.Main;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class ConsultarT extends JFrame {

	private JPanel contentPane;
	public JTextField txtNumConta;
	public JTextField txtCpf;
	public JTextField txtNome;
	public JTextField txtDataNascimento;
	public JTextField txtSaldo;
	public JTextField txtProfissao;
	public JTextField txtFormacao;
	public JTextField txtRenda;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public ConsultarT() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent arg0) {
				Main.menuAdmin.show();
				dispose();
			}
		});
		setTitle("Consultar");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 346, 309);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(30, 144, 255));
		panel.setBounds(10, 11, 320, 256);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Numero da Conta");
		lblNewLabel.setBounds(10, 11, 98, 14);
		panel.add(lblNewLabel);
		
		JLabel lblCpf = new JLabel("CPF");
		lblCpf.setBounds(10, 42, 98, 14);
		panel.add(lblCpf);
		
		JLabel lblNewLabel_1 = new JLabel("Saldo");
		lblNewLabel_1.setBounds(10, 228, 46, 14);
		panel.add(lblNewLabel_1);
		
		txtNumConta = new JTextField();
		txtNumConta.setEditable(false);
		txtNumConta.setBounds(150, 8, 150, 20);
		panel.add(txtNumConta);
		txtNumConta.setColumns(10);
		
		txtCpf = new JTextField();
		txtCpf.setEditable(false);
		txtCpf.setColumns(10);
		txtCpf.setBounds(150, 39, 150, 20);
		panel.add(txtCpf);
		
		txtNome = new JTextField();
		txtNome.setEditable(false);
		txtNome.setColumns(10);
		txtNome.setBounds(150, 70, 150, 20);
		panel.add(txtNome);
		
		txtDataNascimento = new JTextField();
		txtDataNascimento.setEditable(false);
		txtDataNascimento.setColumns(10);
		txtDataNascimento.setBounds(150, 101, 150, 20);
		panel.add(txtDataNascimento);
		
		txtSaldo = new JTextField();
		txtSaldo.setEditable(false);
		txtSaldo.setColumns(10);
		txtSaldo.setBounds(150, 225, 150, 20);
		panel.add(txtSaldo);
		
		JLabel lblNewLabel_2 = new JLabel("Nome");
		lblNewLabel_2.setBounds(10, 73, 46, 14);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Data Nascimento");
		lblNewLabel_3.setBounds(10, 104, 98, 14);
		panel.add(lblNewLabel_3);
		
		txtProfissao = new JTextField();
		txtProfissao.setEditable(false);
		txtProfissao.setColumns(10);
		txtProfissao.setBounds(150, 132, 150, 20);
		panel.add(txtProfissao);
		
		JLabel lblNewLabel_3_1 = new JLabel("Profiss\u00E3o");
		lblNewLabel_3_1.setBounds(10, 135, 98, 14);
		panel.add(lblNewLabel_3_1);
		
		txtFormacao = new JTextField();
		txtFormacao.setEditable(false);
		txtFormacao.setColumns(10);
		txtFormacao.setBounds(150, 163, 150, 20);
		panel.add(txtFormacao);
		
		JLabel lblNewLabel_3_1_1 = new JLabel("Forma\u00E7\u00E3o");
		lblNewLabel_3_1_1.setBounds(10, 166, 98, 14);
		panel.add(lblNewLabel_3_1_1);
		
		JLabel lblNewLabel_3_1_1_1 = new JLabel("Renda");
		lblNewLabel_3_1_1_1.setBounds(10, 197, 98, 14);
		panel.add(lblNewLabel_3_1_1_1);
		
		txtRenda = new JTextField();
		txtRenda.setEditable(false);
		txtRenda.setColumns(10);
		txtRenda.setBounds(150, 194, 150, 20);
		panel.add(txtRenda);
	}
}
