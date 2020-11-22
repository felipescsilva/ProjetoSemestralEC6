package view.Operacao;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import view.Main.Main;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JPasswordField;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PagamentoT extends JFrame {

	private JPanel contentPane;
	private JLabel lblCdigo;
	private JTextField txtCdigo;
	private JButton btnPagar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PagamentoT frame = new PagamentoT();
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
	public PagamentoT() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent e) {
				Main.menuPrincipal.show();
				dispose();
			}
		});
		setTitle("Pagamentos");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 182, 104);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblCdigo = new JLabel("C\u00F3digo");
		lblCdigo.setFont(new Font("Sitka Small", Font.BOLD, 12));
		lblCdigo.setBounds(10, 11, 46, 14);
		contentPane.add(lblCdigo);
		
		txtCdigo = new JTextField();
		txtCdigo.setBounds(66, 7, 86, 20);
		contentPane.add(txtCdigo);
		txtCdigo.setColumns(10);
		
		btnPagar = new JButton("Pagar");
		btnPagar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnPagar.setBounds(10, 38, 142, 23);
		contentPane.add(btnPagar);
	}

}
