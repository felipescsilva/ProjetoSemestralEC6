package helio.Telas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;

public class TransferenciaT extends JFrame {

	private JPanel contentPane;
	private JTextField txtValor;
	private JTextField txtAgncia;
	private JTextField txtConta;
	private JTextField txtNome;
	private JTextField txtCpf;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TransferenciaT frame = new TransferenciaT();
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
	public TransferenciaT() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 560, 420);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(166, 49, 218, 257);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNomeCompleto = new JLabel("Nome Completo");
		lblNomeCompleto.setBounds(10, 107, 102, 14);
		panel.add(lblNomeCompleto);
		
		txtNome = new JTextField();
		txtNome.setBounds(122, 104, 86, 20);
		panel.add(txtNome);
		txtNome.setText("Nome");
		txtNome.setColumns(10);
		
		txtConta = new JTextField();
		txtConta.setBounds(122, 73, 86, 20);
		panel.add(txtConta);
		txtConta.setText("Conta");
		txtConta.setColumns(10);
		
		txtAgncia = new JTextField();
		txtAgncia.setBounds(122, 42, 86, 20);
		panel.add(txtAgncia);
		txtAgncia.setText("Ag\u00EAncia");
		txtAgncia.setColumns(10);
		
		txtCpf = new JTextField();
		txtCpf.setBounds(122, 135, 86, 20);
		panel.add(txtCpf);
		txtCpf.setText("CPF");
		txtCpf.setColumns(10);
		
		txtValor = new JTextField();
		txtValor.setBounds(122, 11, 86, 20);
		panel.add(txtValor);
		txtValor.setText("Valor");
		txtValor.setColumns(10);
		
		JButton btnTransferir = new JButton("Transferir");
		btnTransferir.setBounds(89, 197, 102, 23);
		panel.add(btnTransferir);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setBounds(70, 169, 42, 14);
		panel.add(lblSenha);
		
		JLabel lblCpf = new JLabel("CPF");
		lblCpf.setBounds(82, 138, 30, 14);
		panel.add(lblCpf);
		
		JLabel lblConta = new JLabel("Conta");
		lblConta.setBounds(70, 76, 42, 14);
		panel.add(lblConta);
		
		JLabel lblAgncia = new JLabel("Ag\u00EAncia");
		lblAgncia.setBounds(59, 45, 53, 14);
		panel.add(lblAgncia);
		
		JLabel lblValor = new JLabel("Valor");
		lblValor.setBounds(70, 14, 42, 14);
		panel.add(lblValor);
		
		passwordField = new JPasswordField();
		passwordField.setText("111111");
		passwordField.setBounds(122, 166, 86, 20);
		panel.add(passwordField);
	}
}
