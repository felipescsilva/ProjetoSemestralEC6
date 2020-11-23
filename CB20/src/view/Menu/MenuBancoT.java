package view.Menu;

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
import java.awt.Color;

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
		setBounds(100, 100, 583, 444);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 153, 255));
		panel_1.setBounds(10, 11, 545, 382);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 347, 85);
		panel_1.add(panel);
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
		
		JLabel lblValor = new JLabel("Valor");
		lblValor.setBounds(392, 15, 46, 14);
		panel_1.add(lblValor);
		lblValor.setFont(new Font("Sitka Small", Font.BOLD, 12));
		
		textField = new JTextField();
		textField.setBounds(448, 11, 86, 20);
		panel_1.add(textField);
		textField.setColumns(10);
		
		JButton btnDepositar = new JButton("Depositar");
		btnDepositar.setBounds(445, 50, 89, 23);
		panel_1.add(btnDepositar);
		
		JList list = new JList();
		list.setBounds(10, 107, 524, 263);
		panel_1.add(list);
	}
}
