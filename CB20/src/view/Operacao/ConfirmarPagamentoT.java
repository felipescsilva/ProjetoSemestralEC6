package view.Operacao;

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
import javax.swing.JTextField;

public class ConfirmarPagamentoT extends JFrame {

	private JPanel contentPane;
	public JButton btnConfirmar = new JButton("Confirmar");
	private JTextField textField;
	private JTextField textField_1;

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
	public ConfirmarPagamentoT() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent arg0) {
				Main.verCartao.enable(true);
				dispose();
			}
		});
		setTitle("Confirmar");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 206, 130);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel contentPane_1 = new JPanel();
		contentPane_1.setLayout(null);
		contentPane_1.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane_1.setBounds(0, 0, 280, 101);
		contentPane.add(contentPane_1);
		
		btnConfirmar.setFont(new Font("Sitka Small", Font.BOLD, 12));
		btnConfirmar.setBounds(10, 67, 172, 23);
		contentPane_1.add(btnConfirmar);
		
		JLabel lblValor = new JLabel("Valor");
		lblValor.setHorizontalAlignment(SwingConstants.LEFT);
		lblValor.setFont(new Font("Sitka Small", Font.BOLD, 12));
		lblValor.setBounds(10, 11, 88, 14);
		contentPane_1.add(lblValor);
		
		textField = new JTextField();
		textField.setBounds(96, 7, 86, 20);
		contentPane_1.add(textField);
		textField.setColumns(10);
		
		JLabel lblSenha = new JLabel("Senha Conta");
		lblSenha.setBounds(10, 42, 88, 14);
		contentPane_1.add(lblSenha);
		lblSenha.setHorizontalAlignment(SwingConstants.LEFT);
		lblSenha.setFont(new Font("Sitka Small", Font.BOLD, 12));
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(96, 36, 86, 20);
		contentPane_1.add(textField_1);
	}
}
