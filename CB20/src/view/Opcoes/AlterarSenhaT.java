package view.Opcoes;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

import DAO.ContaDAO;
import view.Main.Main;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class AlterarSenhaT extends JFrame {

	private JPanel contentPane;
	private JPasswordField txtSenhaAtual;
	private JPasswordField txtNovaSenha;
	private JPasswordField txtConfirmarSenha;
	public JLabel lblSenhaAtual;
	public JLabel lblNovaSenha;
	public JLabel lblConfirmarSenha;
	private JFrame f = new JFrame();
	private JPanel panel;
	private JPanel panel_1;
	

	/**
	 * Launch the application.
	 */
	/**
	 * Create the frame.
	 */
	public AlterarSenhaT() {
		setResizable(false);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent arg0) {
				Main.opcoes.show();
				dispose();
			}
		});
		
		setTitle("Alterar Senha");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 255, 178);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel = new JPanel();
		panel.setBackground(new Color(30, 144, 255));
		panel.setBounds(10, 11, 225, 123);
		contentPane.add(panel);
		panel.setLayout(null);
		
		lblSenhaAtual = new JLabel("Senha Aplicativo Atual");
		lblSenhaAtual.setBounds(10, 11, 127, 14);
		panel.add(lblSenhaAtual);
		
		txtSenhaAtual = new JPasswordField();
		txtSenhaAtual.setBounds(129, 8, 86, 20);
		panel.add(txtSenhaAtual);
		txtSenhaAtual.setColumns(10);
		
		txtNovaSenha = new JPasswordField();
		txtNovaSenha.setBounds(129, 36, 86, 20);
		panel.add(txtNovaSenha);
		txtNovaSenha.setColumns(10);
		
		lblNovaSenha = new JLabel("Nova Senha Aplicativo");
		lblNovaSenha.setBounds(10, 39, 127, 14);
		panel.add(lblNovaSenha);
		
		txtConfirmarSenha = new JPasswordField();
		txtConfirmarSenha.setBounds(129, 63, 86, 20);
		panel.add(txtConfirmarSenha);
		txtConfirmarSenha.setColumns(10);
		
		lblConfirmarSenha = new JLabel("Confirmar Senha");
		lblConfirmarSenha.setBounds(10, 66, 112, 14);
		panel.add(lblConfirmarSenha);
		
		JButton btnNewButton = new JButton("Confirmar Altera\u00E7\u00E3o");
		btnNewButton.setBounds(10, 94, 205, 22);
		panel.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (Main.telaSelecionada == TelaSenha.APP) {
					Boolean correto = true;
					String mensagemErro = "Não foi possível alterar a senha porque: ";
					String senhaAtual = Main.conta.getSenhaApp();
					if (!senhaAtual.equals(txtSenhaAtual.getText())) {
						mensagemErro += "\nA senha atual está incorreta!";
						correto = false;
					}
					if (txtNovaSenha.getText().length() != 8) {
						mensagemErro += "\nA senha precisa possuir 8 caracteres!";
						correto = false;
					}
					if (!txtConfirmarSenha.getText().equals(txtNovaSenha.getText())) {
						mensagemErro += "\nA confirmação de senha está incorreta!";
						correto = false;
					}
					if (correto) {
						ContaDAO dao = new ContaDAO();
						Main.conta.setSenhaApp(txtNovaSenha.getText());
						dao.Atualizar(Main.conta);
						JOptionPane.showMessageDialog(f, "Sua senha foi alterada com sucesso!");
					} else 
						JOptionPane.showMessageDialog(f, mensagemErro, "Erro", JOptionPane.WARNING_MESSAGE);
				} else {
					Boolean correto = true;
					String mensagemErro = "Não foi possível alterar a senha porque: ";
					String senhaAtual = Main.conta.getSenhaConta();
					if (!senhaAtual.equals(txtSenhaAtual.getText())) {
						mensagemErro += "\nA senha atual está incorreta!";
						correto = false;
					}
					if (txtNovaSenha.getText().length() != 6) {
						mensagemErro += "\nA senha precisa possuir 6 caracteres!";
						correto = false;
					}
					if (!txtConfirmarSenha.getText().equals(txtNovaSenha.getText())) {
						mensagemErro += "\nA confirmação de senha está incorreta!";
						correto = false;
					}
					if (correto) {
						ContaDAO dao = new ContaDAO();
						Main.conta.setSenhaConta(txtNovaSenha.getText());
						dao.Atualizar(Main.conta);
						JOptionPane.showMessageDialog(f, "Sua senha foi alterada com sucesso!");
					} else 
						JOptionPane.showMessageDialog(f, mensagemErro, "Erro", JOptionPane.WARNING_MESSAGE);
						
				}
			}
		});
		
		panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 0, 0));
		panel_1.setBounds(0, 0, 248, 145);
		contentPane.add(panel_1);
	}
}
