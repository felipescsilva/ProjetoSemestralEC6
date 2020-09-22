package view.Helio.Telas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import java.awt.Font;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JList;

public class MenuBancoT extends JFrame {

	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtCpf;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuBancoT frame = new MenuBancoT();
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
	public MenuBancoT() {
		setTitle("Clientes");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 560, 420);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 347, 85);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setFont(new Font("Sitka Small", Font.BOLD, 12));
		lblNome.setBounds(10, 11, 46, 14);
		panel.add(lblNome);
		
		JLabel lblCpf = new JLabel("CPF");
		lblCpf.setFont(new Font("Sitka Small", Font.BOLD, 12));
		lblCpf.setBounds(10, 36, 46, 14);
		panel.add(lblCpf);
		
		txtNome = new JTextField();
		txtNome.setText("Nome");
		txtNome.setBounds(54, 8, 86, 20);
		panel.add(txtNome);
		txtNome.setColumns(10);
		
		txtCpf = new JTextField();
		txtCpf.setText("CPF");
		txtCpf.setBounds(54, 33, 86, 20);
		panel.add(txtCpf);
		txtCpf.setColumns(10);
		
		JRadioButton rdbtnInadiplente = new JRadioButton("Inadiplente");
		rdbtnInadiplente.setFont(new Font("Sitka Small", Font.BOLD, 12));
		rdbtnInadiplente.setBounds(10, 57, 109, 23);
		panel.add(rdbtnInadiplente);
		
		JLabel lblRenda = new JLabel("Renda");
		lblRenda.setFont(new Font("Sitka Small", Font.BOLD, 12));
		lblRenda.setBounds(177, 10, 46, 14);
		panel.add(lblRenda);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"<=1000", ">1000;<=2000", ">2000;<=3000", ">3000;<=4000", ">4000;<=5000", ">5000;<=6000", ">6000;<=7000", ">7000;<=8000", ">8000;<=9000", ">9000;<=10000", ">10000;<=11000"}));
		comboBox.setBounds(233, 7, 97, 20);
		panel.add(comboBox);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(241, 51, 89, 23);
		panel.add(btnBuscar);
		
		JList list = new JList();
		list.setBounds(10, 107, 524, 263);
		contentPane.add(list);
		
		JLabel lblValor = new JLabel("Valor");
		lblValor.setFont(new Font("Sitka Small", Font.BOLD, 12));
		lblValor.setBounds(392, 15, 46, 14);
		contentPane.add(lblValor);
		
		textField = new JTextField();
		textField.setBounds(448, 11, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnDepositar = new JButton("Depositar");
		btnDepositar.setBounds(445, 50, 89, 23);
		contentPane.add(btnDepositar);
	}
}
