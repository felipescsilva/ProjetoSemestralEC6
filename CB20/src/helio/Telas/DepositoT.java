package helio.Telas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;

public class DepositoT extends JFrame {

	private JPanel contentPane;
	private JTextField txtValor;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DepositoT frame = new DepositoT();
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
	public DepositoT() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 560, 420);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblValor = new JLabel("Valor");
		lblValor.setFont(new Font("Sitka Small", Font.BOLD, 12));
		lblValor.setBounds(130, 193, 46, 14);
		contentPane.add(lblValor);
		
		txtValor = new JTextField();
		txtValor.setText("Valor");
		txtValor.setBounds(186, 189, 86, 20);
		contentPane.add(txtValor);
		txtValor.setColumns(10);
		
		JButton btnGerarBoleto = new JButton("Gerar Boleto");
		btnGerarBoleto.setFont(new Font("Sitka Small", Font.BOLD, 12));
		btnGerarBoleto.setBounds(282, 188, 131, 23);
		contentPane.add(btnGerarBoleto);
	}

}
