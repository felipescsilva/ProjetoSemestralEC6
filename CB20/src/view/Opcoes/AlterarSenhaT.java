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

public class AlterarSenhaT extends JFrame {

	private JPanel contentPane;
	private JPasswordField txtSenhaAtual;
	private JPasswordField txtNovaSenha;
	private JPasswordField txtConfirmarSenha;
	public JLabel lblSenhaAtual;
	public JLabel lblNovaSenha;
	public JLabel lblConfirmarSenha;
	private JFrame f = new JFrame();
	

	/**
	 * Launch the application.
	 */
	/**
	 * Create the frame.
	 */
	public AlterarSenhaT() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent arg0) {
				Main.opcoes.show();
				dispose();
			}
		});
		
		setTitle("Alterar Senha");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 264, 173);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtSenhaAtual = new JPasswordField();
		txtSenhaAtual.setBounds(149, 11, 86, 20);
		contentPane.add(txtSenhaAtual);
		txtSenhaAtual.setColumns(10);
		
		txtNovaSenha = new JPasswordField();
		txtNovaSenha.setBounds(149, 42, 86, 20);
		contentPane.add(txtNovaSenha);
		txtNovaSenha.setColumns(10);
		
		txtConfirmarSenha = new JPasswordField();
		txtConfirmarSenha.setBounds(149, 73, 86, 20);
		contentPane.add(txtConfirmarSenha);
		txtConfirmarSenha.setColumns(10);
		
		lblSenhaAtual = new JLabel("Senha Aplicativo Atual");
		lblSenhaAtual.setBounds(10, 14, 127, 14);
		contentPane.add(lblSenhaAtual);
		
		lblNovaSenha = new JLabel("Nova Senha Aplicativo");
		lblNovaSenha.setBounds(10, 45, 127, 14);
		contentPane.add(lblNovaSenha);
		
		lblConfirmarSenha = new JLabel("Confirmar Senha");
		lblConfirmarSenha.setBounds(10, 76, 112, 14);
		contentPane.add(lblConfirmarSenha);
		
		JButton btnNewButton = new JButton("Confirmar Altera\u00E7\u00E3o");
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
		btnNewButton.setBounds(10, 101, 225, 23);
		contentPane.add(btnNewButton);
	}
}
