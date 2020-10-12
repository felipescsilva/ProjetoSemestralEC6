package view.Operacao;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JList;
import javax.swing.JPasswordField;

public class CambioT extends JFrame {

	private JPanel contentPane;
	private JTextField txtCotao;
	private JTextField txtValor;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CambioT frame = new CambioT();
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
	public CambioT() {
		setTitle("C\u00E2mbio");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 560, 420);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblMoeda = new JLabel("Moeda");
		lblMoeda.setFont(new Font("Sitka Small", Font.BOLD, 12));
		lblMoeda.setBounds(10, 11, 46, 14);
		contentPane.add(lblMoeda);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Real", "D\u00F3lar"}));
		comboBox.setBounds(94, 7, 75, 20);
		contentPane.add(comboBox);
		
		JLabel lblCotao = new JLabel("Cota\u00E7\u00E3o");
		lblCotao.setFont(new Font("Sitka Small", Font.BOLD, 12));
		lblCotao.setBounds(10, 42, 74, 14);
		contentPane.add(lblCotao);
		
		txtCotao = new JTextField();
		txtCotao.setEditable(false);
		txtCotao.setText("Cota\u00E7\u00E3o");
		txtCotao.setBounds(94, 39, 86, 20);
		contentPane.add(txtCotao);
		txtCotao.setColumns(10);
		
		JLabel lblValor = new JLabel("Valor");
		lblValor.setFont(new Font("Sitka Small", Font.BOLD, 12));
		lblValor.setBounds(10, 140, 63, 14);
		contentPane.add(lblValor);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setFont(new Font("Sitka Small", Font.BOLD, 12));
		lblSenha.setBounds(10, 165, 63, 14);
		contentPane.add(lblSenha);
		
		JButton btnComprar = new JButton("Comprar");
		btnComprar.setBounds(52, 190, 89, 23);
		contentPane.add(btnComprar);
		
		txtValor = new JTextField();
		txtValor.setText("Valor");
		txtValor.setBounds(83, 136, 86, 20);
		contentPane.add(txtValor);
		txtValor.setColumns(10);
		
		JLabel lblOrdensDeCompra = new JLabel("Ordens de Compra");
		lblOrdensDeCompra.setFont(new Font("Sitka Small", Font.BOLD, 12));
		lblOrdensDeCompra.setBounds(339, 11, 137, 14);
		contentPane.add(lblOrdensDeCompra);
		
		JList list = new JList();
		list.setBounds(289, 42, 245, 328);
		contentPane.add(list);
		
		passwordField = new JPasswordField();
		passwordField.setText("111111");
		passwordField.setBounds(83, 161, 86, 18);
		contentPane.add(passwordField);
	}
}
