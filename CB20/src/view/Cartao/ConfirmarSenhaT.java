package view.Cartao;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import view.Main.Main;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.SwingConstants;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class ConfirmarSenhaT extends JFrame {

	private JPanel contentPane;
	public JPasswordField txtSenha;
	public JButton btnConfirmar = new JButton("Confirmar");
	private JPanel panel;

	/**
	 * Launch the application.
	 */
	/*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SolicitarCancelamento frame = new SolicitarCancelamento();
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
	public ConfirmarSenhaT() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent arg0) {
				Main.verFatura.enable(true);
				dispose();
			}
		});
		setTitle("Senha");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 262, 122);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel contentPane_1 = new JPanel();
		contentPane_1.setBackground(new Color(0, 0, 0));
		contentPane_1.setLayout(null);
		contentPane_1.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane_1.setBounds(0, 0, 321, 230);
		contentPane.add(contentPane_1);
		
		panel = new JPanel();
		panel.setBackground(new Color(30, 144, 255));
		panel.setBounds(10, 11, 234, 72);
		contentPane_1.add(panel);
		panel.setLayout(null);
		
		txtSenha = new JPasswordField();
		txtSenha.setBounds(121, 7, 103, 20);
		panel.add(txtSenha);
		txtSenha.setColumns(10);
		btnConfirmar.setBounds(10, 36, 214, 23);
		panel.add(btnConfirmar);
		
		btnConfirmar.setFont(new Font("Sitka Small", Font.BOLD, 12));
		
		JLabel lblSenha = new JLabel("Senha Conta");
		lblSenha.setBounds(10, 11, 123, 14);
		panel.add(lblSenha);
		lblSenha.setHorizontalAlignment(SwingConstants.LEFT);
		lblSenha.setFont(new Font("Sitka Small", Font.BOLD, 12));
	}

}
