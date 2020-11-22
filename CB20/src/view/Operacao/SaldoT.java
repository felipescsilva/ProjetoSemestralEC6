package view.Operacao;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import view.Main.Main;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;
import javax.swing.JList;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JTextField;

public class SaldoT extends JFrame {

	private JPanel contentPane;
	public JTextField txtSaldo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SaldoT frame = new SaldoT();
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
	public SaldoT() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent e) {
				Main.menuPrincipal.show();
				dispose();
			}
		});
		setTitle("Saldo");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 167, 80);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtSaldo = new JTextField();
		txtSaldo.setEditable(false);
		txtSaldo.setBounds(45, 11, 97, 20);
		contentPane.add(txtSaldo);
		txtSaldo.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Saldo");
		lblNewLabel.setBounds(10, 14, 36, 14);
		contentPane.add(lblNewLabel);
	}
}
