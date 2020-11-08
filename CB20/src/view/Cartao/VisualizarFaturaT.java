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

public class VisualizarFaturaT extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_4;
	private JTextField textField_5;

	/**
	 * Launch the application.
	 */
	/*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VerCartaoT frame = new VerCartaoT();
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
	public VisualizarFaturaT() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent arg0) {
				Main.verFaturas.show();
				dispose();
			}
		});
		setTitle("Fatura");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 243);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("N\u00BA Fatura");
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
		
		JLabel lblNewLabel_2 = new JLabel("Valor");
		lblNewLabel_2.setBounds(10, 70, 46, 14);
		panel.add(lblNewLabel_2);
		
		textField_4 = new JTextField();
		textField_4.setEditable(false);
		textField_4.setColumns(10);
		textField_4.setBounds(69, 131, 345, 20);
		panel.add(textField_4);
		
		JLabel lblNewLabel_3_1 = new JLabel("Vencimento");
		lblNewLabel_3_1.setBounds(10, 134, 61, 14);
		panel.add(lblNewLabel_3_1);
		
		JButton btnNewButton_2 = new JButton("Pagar Fatura");
		btnNewButton_2.setBounds(10, 162, 404, 23);
		panel.add(btnNewButton_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Juros");
		lblNewLabel_2_1.setBounds(10, 101, 46, 14);
		panel.add(lblNewLabel_2_1);
		
		textField_5 = new JTextField();
		textField_5.setEditable(false);
		textField_5.setColumns(10);
		textField_5.setBounds(69, 98, 345, 20);
		panel.add(textField_5);
	}
}
