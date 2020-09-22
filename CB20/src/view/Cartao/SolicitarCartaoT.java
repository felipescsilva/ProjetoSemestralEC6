package view.Cartao;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import model.Cartao.Tipo;
import java.awt.Font;

public class SolicitarCartaoT extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	/*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SolicitarCartao frame = new SolicitarCartao();
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
	public SolicitarCartaoT() {
		setTitle("Solicitar Cart\u00E3o");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 214, 188);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Enviar");
		btnNewButton.setFont(new Font("Sitka Small", Font.BOLD, 12));
		btnNewButton.setBounds(55, 115, 89, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Tipo Cart\u00E3o");
		lblNewLabel.setFont(new Font("Sitka Small", Font.BOLD, 12));
		lblNewLabel.setToolTipText("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 11, 178, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setFont(new Font("Sitka Small", Font.BOLD, 12));
		lblSenha.setHorizontalAlignment(SwingConstants.CENTER);
		lblSenha.setBounds(10, 59, 178, 14);
		contentPane.add(lblSenha);
		
		JPasswordField passwordField = new JPasswordField();
		passwordField.setBounds(20, 84, 168, 20);
		contentPane.add(passwordField);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Selecione o tipo...", "D\u00E9bito", "Cr\u00E9dito", "Pr\u00E9-Pago"}));
		comboBox.setBounds(20, 28, 168, 20);
		contentPane.add(comboBox);
	}
}
