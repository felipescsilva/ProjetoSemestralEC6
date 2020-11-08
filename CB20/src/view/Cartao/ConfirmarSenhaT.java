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

public class ConfirmarSenhaT extends JFrame {

	private JPanel contentPane;
	public JPasswordField txtSenha;
	public JButton btnConfirmar = new JButton("Confirmar");

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
				Main.verCartao.enable(true);
				dispose();
			}
		});
		setTitle("Senha");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 163, 130);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel contentPane_1 = new JPanel();
		contentPane_1.setLayout(null);
		contentPane_1.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane_1.setBounds(0, 0, 157, 101);
		contentPane.add(contentPane_1);
		
		JLabel lblSenha = new JLabel("Senha Conta");
		lblSenha.setHorizontalAlignment(SwingConstants.CENTER);
		lblSenha.setFont(new Font("Sitka Small", Font.BOLD, 12));
		lblSenha.setBounds(0, 11, 157, 14);
		contentPane_1.add(lblSenha);
		
		txtSenha = new JPasswordField();
		txtSenha.setColumns(10);
		txtSenha.setBounds(20, 36, 115, 20);
		contentPane_1.add(txtSenha);
		
		btnConfirmar.setFont(new Font("Sitka Small", Font.BOLD, 12));
		btnConfirmar.setBounds(20, 67, 115, 23);
		contentPane_1.add(btnConfirmar);
	}

}
