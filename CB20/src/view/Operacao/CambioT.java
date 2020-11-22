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
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.time.LocalDate;
import java.util.ArrayList;
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
import java.awt.Color;

public class CambioT extends JFrame {

	private JPanel contentPane;
	private JTextField txtCotao;
	private JTextField txtValor;
	private JPasswordField passwordField;
	private JComboBox comboBoxMoeda;
	private JList listaOrdens;

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
				Cambio cambio = new Cambio();
				if(cambio.baterOrdens())
				{
					JFrame f = new JFrame();
					JOptionPane.showMessageDialog(f, "Algumas ordens foram realizadas!" , "Atenção", JOptionPane.INFORMATION_MESSAGE);
				}
				listaOrdens.requestFocusInWindow();
				if(comboBoxMoeda.getSelectedItem().toString().equals("Real"))
				{
					txtCotao.setText(String.valueOf(Cotacao.getRealTaxa()));
				}
				else if(comboBoxMoeda.getSelectedItem().toString().equals("Dólar"))
				{
					txtCotao.setText(String.valueOf(Cotacao.getDolarTaxa()));
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
		contentPane.setBackground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 153, 255));
		panel.setBounds(10, 11, 524, 359);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblMoeda = new JLabel("Moeda");
		lblMoeda.setBounds(10, 15, 46, 14);
		panel.add(lblMoeda);
		lblMoeda.setFont(new Font("Sitka Small", Font.BOLD, 12));
		
		JLabel lblCotao = new JLabel("Cota\u00E7\u00E3o");
		lblCotao.setBounds(10, 46, 74, 14);
		panel.add(lblCotao);
		lblCotao.setFont(new Font("Sitka Small", Font.BOLD, 12));
		
		comboBoxMoeda = new JComboBox();
		comboBoxMoeda.setBounds(94, 11, 75, 20);
		panel.add(comboBoxMoeda);
		
		comboBoxMoeda.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				if(comboBoxMoeda.getSelectedItem().toString().equals("Real"))
				{
					txtCotao.setText(String.valueOf(Cotacao.getRealTaxa()));
				}
				else if(comboBoxMoeda.getSelectedItem().toString().equals("Dólar"))
				{
					txtCotao.setText(String.valueOf(Cotacao.getDolarTaxa()));
				}
				else 
				{
					txtCotao.setText("");
				}
			}
		});
		comboBoxMoeda.setModel(new DefaultComboBoxModel(new String[] {"Real", "D\u00F3lar"}));
		
		txtCotao = new JTextField();
		txtCotao.setBounds(94, 43, 86, 20);
		panel.add(txtCotao);
		
		txtCotao.setEditable(false);
		txtCotao.setText("Cota\u00E7\u00E3o");
		txtCotao.setColumns(10);
		
		JLabel lblValor = new JLabel("Valor");
		lblValor.setBounds(10, 130, 63, 14);
		panel.add(lblValor);
		lblValor.setFont(new Font("Sitka Small", Font.BOLD, 12));
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setBounds(10, 155, 63, 14);
		panel.add(lblSenha);
		lblSenha.setFont(new Font("Sitka Small", Font.BOLD, 12));
		
		JButton btnComprar = new JButton("Comprar");
		btnComprar.setBounds(52, 180, 89, 23);
		panel.add(btnComprar);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(83, 151, 86, 18);
		panel.add(passwordField);
		
		txtValor = new JTextField();
		txtValor.setBounds(83, 126, 86, 20);
		panel.add(txtValor);
		txtValor.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				if(arg0.getKeyChar() == KeyEvent.VK_ENTER)
				{
					passwordField.requestFocusInWindow();
				}
				else if((arg0.getKeyChar() >= '0' && arg0.getKeyChar() <= '9') || arg0.getKeyChar() == 8 || arg0.getKeyChar() == 127)
				{
					txtValor.setEditable(true);
				}
				else 
				{
					txtValor.setEditable(false);
				}
			}
		});
		txtValor.setColumns(10);
		
		JLabel lblOrdensDeCompra = new JLabel("Ordens de Compra");
		lblOrdensDeCompra.setBounds(336, 11, 137, 14);
		panel.add(lblOrdensDeCompra);
		lblOrdensDeCompra.setFont(new Font("Sitka Small", Font.BOLD, 12));
		
		listaOrdens = new JList();
		listaOrdens.setBounds(283, 40, 231, 308);
		panel.add(listaOrdens);
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
				List<Cambio> cambios = cambio.Consultar();
				List<String> descricao = new ArrayList<String>();
				for(Cambio ordem : cambios)
				{
					descricao.add(ordem.getDescricao());
				}
				listaOrdens.setListData(descricao.toArray());				
			}
		});
		passwordField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyChar() == KeyEvent.VK_ENTER)
				{
					btnComprar.doClick();
				}
				else if((e.getKeyChar() >= '0' && e.getKeyChar() <= '9') || e.getKeyChar() == 8 || e.getKeyChar() == 127)
				{
					txtValor.setEditable(true);
				}
				else 
				{
					txtValor.setEditable(false);
				}
			}
		});
		btnComprar.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {	
				JFrame f = new JFrame();
				if(txtValor.getText().length() == 0)
				{
					JOptionPane.showMessageDialog(f, "Insira um valor!" , "Erro", JOptionPane.WARNING_MESSAGE);
				}
				else if(Integer.valueOf(txtValor.getText()) == 0)
				{					
					JOptionPane.showMessageDialog(f, "O valor deve ser maior que zero!" , "Erro", JOptionPane.WARNING_MESSAGE);
				}				
				else if(passwordField.getText().equals(Main.conta.getSenhaConta()))
				{
					Cambio cambio = new Cambio();
					float valor = Float.parseFloat(txtValor.getText());
					
					if(cambio.novaOrdem(Main.conta, valor, comboBoxMoeda.getSelectedItem().toString(), null, null))
					{
						JOptionPane.showMessageDialog(f, "Ordem de compra emitida com sucesso!" , "Atenção", JOptionPane.INFORMATION_MESSAGE);
					}
					else
					{
						JOptionPane.showMessageDialog(f, "Não foi possível emitir a ordem de compra!" , "Atenção", JOptionPane.INFORMATION_MESSAGE);
					}
					
					if(cambio.baterOrdens())
					{						
						JOptionPane.showMessageDialog(f, "Algumas ordens foram realizadas!" , "Atenção", JOptionPane.INFORMATION_MESSAGE);
					}
				}
				else
				{					
					JOptionPane.showMessageDialog(f, "Senha incorreta" , "Erro", JOptionPane.WARNING_MESSAGE);
				}
				listaOrdens.requestFocusInWindow();
			}
		});
	}
}
