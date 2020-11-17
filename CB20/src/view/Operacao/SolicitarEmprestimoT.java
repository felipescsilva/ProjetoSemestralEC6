package view.Operacao;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;

public class SolicitarEmprestimoT extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SolicitarEmprestimoT frame = new SolicitarEmprestimoT();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public SolicitarEmprestimoT() {
		setTitle("Pedir Empr\u00E9stimo");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 259, 140);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblValor = new JLabel("Valor");
		lblValor.setFont(new Font("Sitka Small", Font.BOLD, 12));
		lblValor.setBounds(10, 13, 46, 14);
		contentPane.add(lblValor);
		
		textField = new JTextField();
		textField.setText("Valor");
		textField.setColumns(10);
		textField.setBounds(108, 9, 127, 20);
		contentPane.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setText("Prazo");
		textField_1.setColumns(10);
		textField_1.setBounds(108, 40, 127, 20);
		contentPane.add(textField_1);
		
		JLabel lblPrazo = new JLabel("Prazo(meses)");
		lblPrazo.setFont(new Font("Sitka Small", Font.BOLD, 12));
		lblPrazo.setBounds(10, 44, 96, 14);
		contentPane.add(lblPrazo);
		
		JButton btnNewButton = new JButton("Solicitar");
		btnNewButton.setBounds(10, 69, 225, 23);
		contentPane.add(btnNewButton);
	}
}
