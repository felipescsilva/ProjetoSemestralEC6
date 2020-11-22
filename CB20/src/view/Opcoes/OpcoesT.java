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
		
		JButton btnNewButton = new JButton("Alterar Dados");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Main.alterarDados = new AlterarDadosT();
				Main.alterarDados.show();
				hide();
			}
		});
		btnNewButton.setFont(new Font("Sitka Small", Font.BOLD, 12));
		btnNewButton.setBounds(10, 11, 524, 90);
		panel.add(btnNewButton);
		
		JButton btnSolicitarNovoCarto = new JButton("Alterar Senha do Aplicativo");
		btnSolicitarNovoCarto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.alterarSenha = new AlterarSenhaT();
				Main.alterarSenha.show();
				
				Main.telaSelecionada = TelaSenha.APP;
				Main.alterarSenha.lblSenhaAtual.setText("Senha atual aplicativo");
				Main.alterarSenha.lblNovaSenha.setText("Nova senha aplicativo");
				
				hide();
			}
		});
		btnSolicitarNovoCarto.setFont(new Font("Sitka Small", Font.BOLD, 12));
		btnSolicitarNovoCarto.setBounds(10, 112, 524, 90);
		panel.add(btnSolicitarNovoCarto);
		
		JButton btnAlterarSenhaDa = new JButton("Alterar Senha da Conta");
		btnAlterarSenhaDa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Main.alterarSenha = new AlterarSenhaT();
				Main.alterarSenha.show();
				
				Main.telaSelecionada = TelaSenha.CONTA;
				Main.alterarSenha.lblSenhaAtual.setText("Senha atual conta");
				Main.alterarSenha.lblNovaSenha.setText("Nova senha conta");
				
				hide();
			}
		});
		btnAlterarSenhaDa.setFont(new Font("Sitka Small", Font.BOLD, 12));
		btnAlterarSenhaDa.setBounds(10, 213, 524, 90);
		panel.add(btnAlterarSenhaDa);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 549, 341);
	}
}
