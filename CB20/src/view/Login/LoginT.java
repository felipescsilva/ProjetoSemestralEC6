package view.Login;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Login.Login;
import view.Cartao.CartaoT;
import view.Cartao.PagarComprasT;
import view.Cartao.RealizarCompraT;
import view.Main.Main;
import view.Menu.MenuPrincipalT;

import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import javax.swing.JFormattedTextField;
import javax.swing.JPasswordField;
import javax.swing.DropMode;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LoginT extends JFrame {

	private JPanel contentPane;
	private JLabel lblPassword;
	private JTextField txtBankAccount;
	private JPasswordField txtSenhaConta;
	private JButton btnCriarConta;
	private JPanel panel;
	private JTextField txtCarto;
	private JPasswordField senhaCartao;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginT frame = new LoginT();
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
	public LoginT() {
		setTitle("Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 252, 326);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel = new JPanel();
		panel.setBounds(10, 11, 219, 266);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblBankAccount = new JLabel("Conta");
		lblBankAccount.setBounds(24, 42, 36, 16);
		panel.add(lblBankAccount);
		lblBankAccount.setFont(new Font("Sitka Small", Font.BOLD, 12));
		
		txtBankAccount = new JTextField();
		txtBankAccount.setBounds(70, 39, 86, 20);
		panel.add(txtBankAccount);
		txtBankAccount.setColumns(10);
		
		txtSenhaConta = new JPasswordField();
		txtSenhaConta.setBounds(70, 70, 86, 20);
		panel.add(txtSenhaConta);
		
		lblPassword = new JLabel("Senha");
		lblPassword.setBounds(22, 73, 38, 16);
		panel.add(lblPassword);
		lblPassword.setFont(new Font("Sitka Small", Font.BOLD, 12));
		
		JButton btnSignInConta = new JButton("Sign In");
		btnSignInConta.setBounds(70, 101, 73, 23);
		panel.add(btnSignInConta);
		
		JLabel lblPrimeiraVezAqui = new JLabel("Primeira vez aqui?");
		lblPrimeiraVezAqui.setBounds(52, 173, 119, 16);
		panel.add(lblPrimeiraVezAqui);
		lblPrimeiraVezAqui.setFont(new Font("Sitka Small", Font.BOLD, 12));
		
		btnCriarConta = new JButton("Criar Conta");
		btnCriarConta.setBounds(54, 198, 102, 23);
		panel.add(btnCriarConta);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(315, 59, 219, 266);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblCarto = new JLabel("Cart\u00E3o");
		lblCarto.setFont(new Font("Sitka Small", Font.BOLD, 12));
		lblCarto.setBounds(10, 11, 46, 14);
		panel_1.add(lblCarto);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setFont(new Font("Sitka Small", Font.BOLD, 12));
		lblSenha.setBounds(10, 36, 46, 14);
		panel_1.add(lblSenha);
		
		txtCarto = new JTextField();
		txtCarto.setText("Cart\u00E3o");
		txtCarto.setBounds(66, 8, 86, 20);
		panel_1.add(txtCarto);
		txtCarto.setColumns(10);
		
		senhaCartao = new JPasswordField();
		senhaCartao.setText("111111");
		senhaCartao.setBounds(66, 33, 86, 20);
		panel_1.add(senhaCartao);
		
		JButton btnSignInCartao = new JButton("Sign In");
		btnSignInCartao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							RealizarCompraT frame = new RealizarCompraT();
							frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		btnSignInCartao.setBounds(66, 64, 89, 23);
		panel_1.add(btnSignInCartao);
		btnCriarConta.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {				
				Main.criarConta.show();
				hide();
			}
		});
		btnSignInConta.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				Main.menuPrincipal.show();
				hide();
				/*
				if (Main.login.signIn(txtBankAccount.getText(), txtSenhaConta.getText())) {					
					Main.menuPrincipal.show();
					hide();
				} else {
					JFrame f = new JFrame();
					JOptionPane.showMessageDialog(f, "O N�mero da conta ou a senha est�o incorretos.", "Erro", JOptionPane.WARNING_MESSAGE);
				}
				*/
			}
		});
	}
}