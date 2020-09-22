package view.Cartao;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import model.Cartao.Motivo;

public class SolicitarBloqueioT extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	/*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SolicitarBloqueio frame = new SolicitarBloqueio();
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
	public SolicitarBloqueioT() {
		setTitle("Solicitar Bloqueio");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 360, 250);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Selecione o Cart\u00E3o..."}));
		comboBox.setBounds(10, 36, 324, 20);
		contentPane.add(comboBox);
		
		JLabel lblNewLabel = new JLabel("Cart\u00E3o");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Sitka Small", Font.BOLD, 12));
		lblNewLabel.setBounds(10, 11, 324, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblSelecioneOMotivo = new JLabel("Selecione o Motivo do Bloqueio");
		lblSelecioneOMotivo.setHorizontalAlignment(SwingConstants.CENTER);
		lblSelecioneOMotivo.setFont(new Font("Sitka Small", Font.BOLD, 12));
		lblSelecioneOMotivo.setBounds(10, 67, 324, 14);
		contentPane.add(lblSelecioneOMotivo);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Selecione o motivo...", "Erro da senha", "Roubo", "Perda", "Validade Expirou", "Outros"}));
		comboBox_1.setBounds(10, 92, 324, 20);
		contentPane.add(comboBox_1);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setHorizontalAlignment(SwingConstants.CENTER);
		lblSenha.setFont(new Font("Sitka Small", Font.BOLD, 12));
		lblSenha.setBounds(10, 123, 324, 14);
		contentPane.add(lblSenha);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(116, 148, 114, 20);
		contentPane.add(passwordField);
		passwordField.setColumns(10);
		
		JButton btnNewButton = new JButton("Solicitar");
		btnNewButton.setFont(new Font("Sitka Small", Font.BOLD, 12));
		btnNewButton.setBounds(116, 179, 114, 23);
		contentPane.add(btnNewButton);
	}
}
