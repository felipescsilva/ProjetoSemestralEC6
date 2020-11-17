package view.Opcoes;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Cartao.Cartao;
import view.Main.Main;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.time.LocalDate;
import java.util.List;
import java.awt.event.ActionEvent;

public class OpcoesT extends JFrame {

	/**
	 * Launch the application.
	 */
	/*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cartao frame = new Cartao();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	*/

	/**
	 * Create the frame.
	 */
	public OpcoesT() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent arg0) {
				Main.menuPrincipal.show();
				dispose();
			}
		});
		setResizable(false);
		setTitle("Op\u00E7\u00F5es");
		getContentPane().setEnabled(false);
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JButton btnAlterarDados = new JButton("Alterar Dados");
		btnAlterarDados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				LocalDate local = Main.cliente.getDataNascimento();
				String data = local.getDayOfMonth() + "/" + local.getMonthValue() + "/" + local.getYear();
				Main.alterarDadosT.show();
				Main.alterarDadosT.txtData.setText(data);
				Main.alterarDadosT.cbFormacao.setSelectedItem(Main.cliente.getFormacao());
				Main.alterarDadosT.cbProfissao.setSelectedItem(Main.cliente.getProfissao());
				Main.alterarDadosT.txtNome.setText(Main.cliente.getNome());
				Main.alterarDadosT.txtRenda.setText(Main.cliente.getRenda().toString());
				hide();
			}
		});
		btnAlterarDados.setFont(new Font("Sitka Small", Font.BOLD, 12));
		btnAlterarDados.setBounds(10, 11, 524, 90);
		panel.add(btnAlterarDados);
		
		JButton btnAlterarSenhaApp = new JButton("Alterar Senha do Aplicativo");
		btnAlterarSenhaApp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.alterarSenha.show();
				Main.alterarSenha.lblSenhaAtual.setText("Senha do Aplicativo Atual");
				Main.alterarSenha.lblNovaSenha.setText("Nova Senha do Aplicativo");
				Main.telaSelecionada = TelaSenha.APP;
				hide();
			}
		});
		btnAlterarSenhaApp.setFont(new Font("Sitka Small", Font.BOLD, 12));
		btnAlterarSenhaApp.setBounds(10, 112, 524, 90);
		panel.add(btnAlterarSenhaApp);
		
		JButton btnAlterarSenhaConta = new JButton("Alterar Senha da Conta");
		btnAlterarSenhaConta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Main.alterarSenha.show();
				Main.alterarSenha.lblSenhaAtual.setText("Senha da Conta Atual");
				Main.alterarSenha.lblNovaSenha.setText("Nova Senha da Conta");
				Main.telaSelecionada = TelaSenha.CONTA;
				hide();
			}
		});
		btnAlterarSenhaConta.setFont(new Font("Sitka Small", Font.BOLD, 12));
		btnAlterarSenhaConta.setBounds(10, 213, 524, 90);
		panel.add(btnAlterarSenhaConta);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 549, 341);
	}
}
