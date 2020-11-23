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
import java.awt.Color;

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
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 0, 0));
		panel_1.setBounds(0, 0, 543, 312);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(30, 144, 255));
		panel_2.setBounds(10, 11, 512, 290);
		panel_1.add(panel_2);
		panel_2.setLayout(null);
		
		JButton btnAlterarSenhaDa = new JButton("Alterar Senha da Conta");
		btnAlterarSenhaDa.setBounds(10, 191, 493, 88);
		panel_2.add(btnAlterarSenhaDa);
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
		
		JButton btnSolicitarNovoCarto = new JButton("Alterar Senha do Aplicativo");
		btnSolicitarNovoCarto.setBounds(10, 102, 493, 78);
		panel_2.add(btnSolicitarNovoCarto);
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
		
		JButton btnNewButton = new JButton("Alterar Dados");
		btnNewButton.setBounds(10, 20, 493, 71);
		panel_2.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Main.alterarDados = new AlterarDadosT();
				Main.alterarDados.show();
				hide();
			}
		});
		btnNewButton.setFont(new Font("Sitka Small", Font.BOLD, 12));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 540, 342);
	}
}
