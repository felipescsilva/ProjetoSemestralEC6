package view.Cartao;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import view.Main.Main;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;

public class VisualizarCartaoT extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public VisualizarCartaoT() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent arg0) {
				Main.verCartoes.show();
				dispose();
			}
		});
		setTitle("Cart\u00E3o");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 312);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("N\u00BA Cart\u00E3o");
		lblNewLabel.setBounds(10, 11, 67, 14);
		panel.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setBounds(69, 8, 345, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setBounds(69, 36, 345, 20);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Tipo");
		lblNewLabel_1.setBounds(10, 39, 46, 14);
		panel.add(lblNewLabel_1);
		
		textField_2 = new JTextField();
		textField_2.setEditable(false);
		textField_2.setBounds(69, 67, 345, 20);
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Moeda");
		lblNewLabel_2.setBounds(10, 70, 46, 14);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Status");
		lblNewLabel_3.setBounds(10, 100, 46, 14);
		panel.add(lblNewLabel_3);
		
		textField_3 = new JTextField();
		textField_3.setEditable(false);
		textField_3.setColumns(10);
		textField_3.setBounds(69, 98, 345, 20);
		panel.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setEditable(false);
		textField_4.setColumns(10);
		textField_4.setBounds(69, 131, 345, 20);
		panel.add(textField_4);
		
		JLabel lblNewLabel_3_1 = new JLabel("V\u00E1lidade");
		lblNewLabel_3_1.setBounds(10, 134, 46, 14);
		panel.add(lblNewLabel_3_1);
		
		JButton btnNewButton = new JButton("Ver Faturas em aberto");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.verFaturas.show();
				hide();
			}
		});
		btnNewButton.setBounds(10, 162, 404, 23);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Bloqueio Temporario");
		btnNewButton_1.setBounds(10, 196, 404, 23);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Cancelar Cart\u00E3o");
		btnNewButton_2.setBounds(10, 230, 404, 23);
		panel.add(btnNewButton_2);
	}
}
