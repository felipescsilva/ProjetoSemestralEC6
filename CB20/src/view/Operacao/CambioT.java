package view.Operacao;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DAO.CambioDAO;
import model.Cambio.Cambio;
import model.Cambio.Cotacao;
import view.Main.Main;

import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JList;
import javax.swing.JPasswordField;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.time.LocalDate;
import java.util.List;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class CambioT extends JFrame {

	private JPanel contentPane;
	private JTextField txtCotao;
	private JTextField txtValor;
	private JPasswordField passwordField;
	private JComboBox comboBoxMoeda;

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
		addComponentListener(new ComponentAdapter() {
			
			@Override
			public void componentShown(ComponentEvent e) {
				if(comboBoxMoeda.getSelectedItem().toString().equals("Real"))
				{
					txtCotao.setText(String.valueOf(Cotacao.getReal()));
				}
				else if(comboBoxMoeda.getSelectedItem().toString().equals("Dólar"))
				{
					txtCotao.setText(String.valueOf(Cotacao.getDolar()));
				}
				else 
				{
					txtCotao.setText("");
				}
			}
		});
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent e) {
				Main.menuPrincipal.show();
				dispose();
			}
		
		});
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
		
		comboBoxMoeda = new JComboBox();
		
		comboBoxMoeda.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				if(comboBoxMoeda.getSelectedItem().toString().equals("Real"))
				{
					txtCotao.setText(String.valueOf(Cotacao.getReal()));
				}
				else if(comboBoxMoeda.getSelectedItem().toString().equals("Dólar"))
				{
					txtCotao.setText(String.valueOf(Cotacao.getDolar()));
				}
				else 
				{
					txtCotao.setText("");
				}
			}
		});
		comboBoxMoeda.setModel(new DefaultComboBoxModel(new String[] {"Real", "D\u00F3lar"}));
		comboBoxMoeda.setBounds(94, 7, 75, 20);
		contentPane.add(comboBoxMoeda);
		
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
		btnComprar.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {
				Cambio cambio = new Cambio();
				float valor = Float.parseFloat(txtValor.getText());
				cambio.novaOrdem(Main.conta, valor, passwordField.getText(), null, null);
				cambio.baterOrdens();
			}
		});
		btnComprar.setBounds(52, 190, 89, 23);
		contentPane.add(btnComprar);
		
		txtValor = new JTextField();
		txtValor.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				if((arg0.getKeyChar() >= '0' && arg0.getKeyChar() <= '9') || arg0.getKeyChar() == 8 || arg0.getKeyChar() == 127)
				{
					txtValor.setEditable(true);
				}
				else 
				{
					txtValor.setEditable(false);
				}
			}
		});
		txtValor.setText("Valor");
		txtValor.setBounds(83, 136, 86, 20);
		contentPane.add(txtValor);
		txtValor.setColumns(10);
		
		JLabel lblOrdensDeCompra = new JLabel("Ordens de Compra");
		lblOrdensDeCompra.setFont(new Font("Sitka Small", Font.BOLD, 12));
		lblOrdensDeCompra.setBounds(339, 11, 137, 14);
		contentPane.add(lblOrdensDeCompra);
		
		JList listaOrdens = new JList();
		listaOrdens.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent arg0) {
				listaOrdens.clearSelection();
				CambioDAO cambio = new CambioDAO();
				listaOrdens.setListData(cambio.Consultar().toArray());
			}
		});
		listaOrdens.setToolTipText("");
		listaOrdens.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				listaOrdens.clearSelection();
				CambioDAO cambio = new CambioDAO();
				listaOrdens.setListData(cambio.Consultar().toArray());				
			}
		});
		listaOrdens.setBounds(289, 42, 245, 328);
		contentPane.add(listaOrdens);
		
		passwordField = new JPasswordField();
		passwordField.setText("111111");
		passwordField.setBounds(83, 161, 86, 18);
		contentPane.add(passwordField);
	}
}
