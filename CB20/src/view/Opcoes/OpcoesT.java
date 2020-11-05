package view.Opcoes;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Cliente.Formacao;
import model.Cliente.Profissao;
import view.Main.Main;

import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class OpcoesT extends JFrame {

	private JPanel contentPane;
	private JPasswordField senhaApp;
	private JPasswordField novaSenhaApp;
	private JPasswordField confirmarSenhaApp;
	private JPasswordField senhaConta;
	private JPasswordField novaSenhaConta;
	private JPasswordField confirmarSenhaConta;
	private JTextField txtRenda;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OpcoesT frame = new OpcoesT();
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
	public OpcoesT() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent e) {
				Main.menuPrincipal.show();
				dispose();
			}
		});
		setTitle("Op\u00E7\u00F5es");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 560, 420);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 253, 162);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblMudarSenhaDo = new JLabel("Mudar senha do aplicativo");
		lblMudarSenhaDo.setFont(new Font("Sitka Small", Font.BOLD, 12));
		lblMudarSenhaDo.setBounds(10, 11, 207, 14);
		panel.add(lblMudarSenhaDo);
		
		senhaApp = new JPasswordField();
		senhaApp.setText("111111");
		senhaApp.setBounds(149, 36, 94, 14);
		panel.add(senhaApp);
		
		novaSenhaApp = new JPasswordField();
		novaSenhaApp.setText("111111");
		novaSenhaApp.setBounds(149, 61, 94, 14);
		panel.add(novaSenhaApp);
		
		confirmarSenhaApp = new JPasswordField();
		confirmarSenhaApp.setText("111111");
		confirmarSenhaApp.setBounds(149, 86, 94, 14);
		panel.add(confirmarSenhaApp);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setFont(new Font("Sitka Small", Font.BOLD, 12));
		lblSenha.setBounds(10, 36, 46, 14);
		panel.add(lblSenha);
		
		JLabel lblNovaSenha = new JLabel("Nova senha");
		lblNovaSenha.setFont(new Font("Sitka Small", Font.BOLD, 12));
		lblNovaSenha.setBounds(10, 61, 84, 14);
		panel.add(lblNovaSenha);
		
		JLabel lblConfirmarSenha = new JLabel("Confirmar Senha");
		lblConfirmarSenha.setFont(new Font("Sitka Small", Font.BOLD, 12));
		lblConfirmarSenha.setBounds(10, 86, 129, 14);
		panel.add(lblConfirmarSenha);
		
		JButton btnTrocarSenhaApp = new JButton("Trocar Senha");
		btnTrocarSenhaApp.setBounds(71, 114, 115, 23);
		panel.add(btnTrocarSenhaApp);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBounds(281, 11, 253, 162);
		contentPane.add(panel_1);
		
		JLabel lblMudarSenhaDa = new JLabel("Mudar senha da conta");
		lblMudarSenhaDa.setFont(new Font("Sitka Small", Font.BOLD, 12));
		lblMudarSenhaDa.setBounds(10, 11, 207, 14);
		panel_1.add(lblMudarSenhaDa);
		
		senhaConta = new JPasswordField();
		senhaConta.setText("111111");
		senhaConta.setBounds(149, 36, 94, 14);
		panel_1.add(senhaConta);
		
		novaSenhaConta = new JPasswordField();
		novaSenhaConta.setText("111111");
		novaSenhaConta.setBounds(149, 61, 94, 14);
		panel_1.add(novaSenhaConta);
		
		confirmarSenhaConta = new JPasswordField();
		confirmarSenhaConta.setText("111111");
		confirmarSenhaConta.setBounds(149, 86, 94, 14);
		panel_1.add(confirmarSenhaConta);
		
		JLabel label_1 = new JLabel("Senha");
		label_1.setFont(new Font("Sitka Small", Font.BOLD, 12));
		label_1.setBounds(10, 36, 46, 14);
		panel_1.add(label_1);
		
		JLabel label_2 = new JLabel("Nova senha");
		label_2.setFont(new Font("Sitka Small", Font.BOLD, 12));
		label_2.setBounds(10, 61, 84, 14);
		panel_1.add(label_2);
		
		JLabel label_3 = new JLabel("Confirmar Senha");
		label_3.setFont(new Font("Sitka Small", Font.BOLD, 12));
		label_3.setBounds(10, 86, 129, 14);
		panel_1.add(label_3);
		
		JButton btnTrocarSenhaConta = new JButton("Trocar Senha");
		btnTrocarSenhaConta.setBounds(71, 114, 115, 23);
		panel_1.add(btnTrocarSenhaConta);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(10, 184, 524, 186);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblAlterarDadosCadastrais = new JLabel("Alterar Dados Cadastrais");
		lblAlterarDadosCadastrais.setFont(new Font("Sitka Small", Font.BOLD, 12));
		lblAlterarDadosCadastrais.setBounds(10, 11, 197, 14);
		panel_2.add(lblAlterarDadosCadastrais);
		
		txtRenda = new JTextField();
		txtRenda.setText("Renda");
		txtRenda.setBounds(97, 36, 86, 20);
		panel_2.add(txtRenda);
		txtRenda.setColumns(10);
		
		JLabel lblRenda = new JLabel("Renda");
		lblRenda.setFont(new Font("Sitka Small", Font.BOLD, 12));
		lblRenda.setBounds(20, 40, 60, 14);
		panel_2.add(lblRenda);
		
		JComboBox cbFormacao = new JComboBox();
		cbFormacao.setModel(new DefaultComboBoxModel(Formacao.values()));
		cbFormacao.setBounds(97, 67, 224, 20);
		panel_2.add(cbFormacao);
		
		JComboBox cbprofissao = new JComboBox();
		cbprofissao.setModel(new DefaultComboBoxModel(Profissao.values()));
		cbprofissao.setBounds(97, 98, 224, 20);
		panel_2.add(cbprofissao);
		
		JLabel lblFormao = new JLabel("Forma\u00E7\u00E3o");
		lblFormao.setFont(new Font("Sitka Small", Font.BOLD, 12));
		lblFormao.setBounds(10, 70, 86, 14);
		panel_2.add(lblFormao);
		
		JLabel lblProfisso = new JLabel("Profiss\u00E3o");
		lblProfisso.setFont(new Font("Sitka Small", Font.BOLD, 12));
		lblProfisso.setBounds(10, 101, 77, 14);
		panel_2.add(lblProfisso);
		
		JLabel lblSenha_1 = new JLabel("Senha");
		lblSenha_1.setFont(new Font("Sitka Small", Font.BOLD, 12));
		lblSenha_1.setBounds(34, 133, 46, 14);
		panel_2.add(lblSenha_1);
		
		passwordField = new JPasswordField();
		passwordField.setText("111111");
		passwordField.setBounds(97, 129, 86, 20);
		panel_2.add(passwordField);
		
		JButton btnAlterarDados = new JButton("Alterar Dados");
		btnAlterarDados.setBounds(336, 128, 115, 23);
		panel_2.add(btnAlterarDados);
	}
}
