package view.Menu;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.ParseException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import view.Login.LoginT;
import view.Main.Main;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MenuAdminT extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public MenuAdminT() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent arg0) {
				Main.opcoesAdmin.show();
				dispose();
			}
		});
		setTitle("Administrador");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 440, 290);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(30, 144, 255));
		panel.setBounds(10, 11, 415, 239);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("Consultar por N\u00FAmero da Conta");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Main.pesquisarConta = new PesquisarContaT();
				Main.pesquisarConta.show();
				hide();
			}
		});
		btnNewButton.setBounds(10, 11, 394, 106);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Consultar por CPF");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.pesquisarCpf = new PesquisarCpfT();
				Main.pesquisarCpf.show();
				hide();
			}
		});
		btnNewButton_1.setBounds(10, 122, 394, 106);
		panel.add(btnNewButton_1);
	}
}
