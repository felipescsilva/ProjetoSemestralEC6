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
import javax.swing.JPasswordField;

public class PagamentoT extends JFrame {

	private JPanel contentPane;
	private JLabel lblCdigo;
	private JTextField txtCdigo;
	private JLabel lblValorSugerido;
	private JLabel lblValorAPagar;
	private JTextField txtValorSugerido;
	private JButton btnPagar;
	private JTextField txtValorAPagar;
	private JLabel lblSenha;
	private JPasswordField passwordField;

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
		setTitle("Pagamentos");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 560, 420);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblCdigo = new JLabel("C\u00F3digo");
		lblCdigo.setFont(new Font("Sitka Small", Font.BOLD, 12));
		lblCdigo.setBounds(173, 120, 46, 14);
		contentPane.add(lblCdigo);
		
		txtCdigo = new JTextField();
		txtCdigo.setText("C\u00F3digo");
		txtCdigo.setBounds(229, 116, 86, 20);
		contentPane.add(txtCdigo);
		txtCdigo.setColumns(10);
		
		lblValorSugerido = new JLabel("Valor Sugerido");
		lblValorSugerido.setFont(new Font("Sitka Small", Font.BOLD, 12));
		lblValorSugerido.setBounds(122, 145, 97, 14);
		contentPane.add(lblValorSugerido);
		
		lblValorAPagar = new JLabel("Valor a Pagar");
		lblValorAPagar.setFont(new Font("Sitka Small", Font.BOLD, 12));
		lblValorAPagar.setBounds(132, 170, 87, 14);
		contentPane.add(lblValorAPagar);
		
		txtValorSugerido = new JTextField();
		txtValorSugerido.setText("Valor Sugerido");
		txtValorSugerido.setBounds(229, 142, 86, 20);
		contentPane.add(txtValorSugerido);
		txtValorSugerido.setColumns(10);
		
		btnPagar = new JButton("Pagar");
		btnPagar.setBounds(226, 223, 89, 23);
		contentPane.add(btnPagar);
		
		txtValorAPagar = new JTextField();
		txtValorAPagar.setText("Valor a Pagar");
		txtValorAPagar.setBounds(229, 167, 86, 20);
		contentPane.add(txtValorAPagar);
		txtValorAPagar.setColumns(10);
		
		lblSenha = new JLabel("Senha");
		lblSenha.setFont(new Font("Sitka Small", Font.BOLD, 12));
		lblSenha.setBounds(181, 195, 38, 14);
		contentPane.add(lblSenha);
		
		passwordField = new JPasswordField();
		passwordField.setText("111111");
		passwordField.setBounds(229, 191, 86, 23);
		contentPane.add(passwordField);
	}

}
