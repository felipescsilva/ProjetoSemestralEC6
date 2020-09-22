package view.Cartao;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;

public class PagarT extends JFrame {

	private JPanel contentPane;
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
					PagarPrePago frame = new PagarPrePago();
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
	public PagarT() {
		setTitle("Pagar");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 360, 236);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel contentPane_1 = new JPanel();
		contentPane_1.setLayout(null);
		contentPane_1.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane_1.setBounds(0, 0, 354, 240);
		contentPane.add(contentPane_1);
		
		JLabel lblNewLabel = new JLabel("Cart\u00E3o");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Sitka Small", Font.BOLD, 12));
		lblNewLabel.setBounds(10, 11, 334, 14);
		contentPane_1.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Valor");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Sitka Small", Font.BOLD, 12));
		lblNewLabel_1.setBounds(10, 67, 334, 14);
		contentPane_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Senha");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Sitka Small", Font.BOLD, 12));
		lblNewLabel_2.setBounds(10, 123, 334, 14);
		contentPane_1.add(lblNewLabel_2);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Selecione o Cart\u00E3o..."}));
		comboBox.setFont(new Font("Sitka Text", Font.BOLD, 12));
		comboBox.setBounds(10, 36, 334, 20);
		contentPane_1.add(comboBox);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(132, 92, 86, 20);
		contentPane_1.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(132, 143, 86, 20);
		contentPane_1.add(textField_1);
		
		JButton btnNewButton = new JButton("Confirmar");
		btnNewButton.setBounds(132, 174, 89, 23);
		contentPane_1.add(btnNewButton);
	}

}
