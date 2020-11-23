package view.Menu;

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

public class OpcoesAdminT extends JFrame {

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
	public OpcoesAdminT() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent arg0) {
				Main.menuPrincipal.show();
				dispose();
			}
		});
		setResizable(false);
		setTitle("Op\u00E7\u00F5es Administra\u00E7\u00E3o");
		getContentPane().setEnabled(false);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 0, 0));
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 153, 255));
		panel_1.setBounds(10, 11, 544, 330);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnNewButton = new JButton("Op\u00E7\u00F5es do Administrador");
		btnNewButton.setBounds(10, 11, 524, 144);
		panel_1.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Main.verCartoes.show();
				Main.cartoes = Main.conta.getCartoes();
				for (int i = 0; i < Main.cartoes.size(); i++) {
					Main.verCartoes.cbCartoes.addItem(Main.cartoes.get(i).getNumeroCartao());
				}
				hide();
			}
		});
		btnNewButton.setFont(new Font("Sitka Small", Font.BOLD, 12));
		
		JButton btnSolicitarNovoCarto = new JButton("Menu Principal");
		btnSolicitarNovoCarto.setBounds(10, 164, 524, 155);
		panel_1.add(btnSolicitarNovoCarto);
		btnSolicitarNovoCarto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.solicitarCartao.show();
				hide();
			}
		});
		btnSolicitarNovoCarto.setFont(new Font("Sitka Small", Font.BOLD, 12));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 571, 381);
	}
}
