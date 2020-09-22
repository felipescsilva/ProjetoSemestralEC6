package view.Cartao;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;

public class SolicitarDesbloqueioT extends JFrame {

	private JPanel contentPane;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	/*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SolicitarDesbloqueio frame = new SolicitarDesbloqueio();
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
	public SolicitarDesbloqueioT() {
		setTitle("Solicitar Desbloqueio");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 360, 193);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel contentPane_1 = new JPanel();
		contentPane_1.setLayout(null);
		contentPane_1.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane_1.setBounds(0, 0, 344, 153);
		contentPane.add(contentPane_1);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Selecione o Cart\u00E3o..."}));
		comboBox.setBounds(10, 36, 324, 20);
		contentPane_1.add(comboBox);
		
		JLabel lblNewLabel = new JLabel("Cart\u00E3o");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Sitka Small", Font.BOLD, 12));
		lblNewLabel.setBounds(10, 11, 324, 14);
		contentPane_1.add(lblNewLabel);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setHorizontalAlignment(SwingConstants.CENTER);
		lblSenha.setFont(new Font("Sitka Small", Font.BOLD, 12));
		lblSenha.setBounds(10, 67, 324, 14);
		contentPane_1.add(lblSenha);
		
		passwordField = new JPasswordField();
		passwordField.setColumns(10);
		passwordField.setBounds(115, 92, 115, 20);
		contentPane_1.add(passwordField);
		
		JButton btnSolicitar = new JButton("Solicitar");
		btnSolicitar.setFont(new Font("Sitka Small", Font.BOLD, 12));
		btnSolicitar.setBounds(115, 123, 115, 23);
		contentPane_1.add(btnSolicitar);
	}
}
