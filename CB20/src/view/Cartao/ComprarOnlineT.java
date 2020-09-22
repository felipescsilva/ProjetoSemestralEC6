package view.Cartao;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JTextField;
import java.awt.Font;
import java.text.ParseException;

import javax.swing.SwingConstants;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;

public class ComprarOnlineT extends JFrame {

	private JPanel contentPane;
	private JTextField textField_1;
	private JTextField textField_2;
	private JFormattedTextField txtData;
	private JLabel lblNewLabel_3;
	private JTextField textField;
	private JLabel lblNewLabel_4;
	private JTextField textField_3;
	private JButton btnNewButton;

	/**
	 * Launch the application.
	 */
	/*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ComprarOnline frame = new ComprarOnline();
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
	public ComprarOnlineT() {
		setResizable(false);
		setTitle("Online");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 360, 339);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Cart\u00E3o");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Sitka Small", Font.BOLD, 12));
		lblNewLabel.setBounds(10, 11, 334, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Data V\u00E1lidade");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Sitka Small", Font.BOLD, 12));
		lblNewLabel_1.setBounds(10, 123, 334, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Nome T\u00EDtular");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Sitka Small", Font.BOLD, 12));
		lblNewLabel_2.setBounds(10, 67, 334, 14);
		contentPane.add(lblNewLabel_2);
		
		try {
			txtData = new JFormattedTextField(new MaskFormatter("##/##/####"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		txtData.setBounds(133, 148, 86, 20);
		contentPane.add(txtData);
		txtData.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(20, 92, 324, 20);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Sitka Small", Font.BOLD, 12));
		textField_2.setBounds(20, 36, 324, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		lblNewLabel_3 = new JLabel("CVV");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("Sitka Small", Font.BOLD, 12));
		lblNewLabel_3.setBounds(10, 179, 334, 14);
		contentPane.add(lblNewLabel_3);
		
		textField = new JTextField();
		textField.setBounds(133, 193, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		lblNewLabel_4 = new JLabel("Valor");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setFont(new Font("Sitka Small", Font.BOLD, 12));
		lblNewLabel_4.setBounds(10, 224, 334, 14);
		contentPane.add(lblNewLabel_4);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(133, 245, 86, 20);
		contentPane.add(textField_3);
		
		btnNewButton = new JButton("Confirmar");
		btnNewButton.setBounds(133, 276, 89, 23);
		contentPane.add(btnNewButton);
	}

}
