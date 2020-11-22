package view.Operacao;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Cambio.Cambio;
import model.Fatura.Situacao;
import model.Juros.Juros;
import model.Juros.Limites;
import view.Main.Main;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JPasswordField;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Color;

public class SolicitarEmprestimoT extends JFrame {

	private JPanel contentPane;
	private JTextField txtLimite;
	private JTextField txtValor;
	private JTextField txtPrazo;
	private JTextField txtValorTotal;
	private JTextField txtValorParcela;
	private JTextField txtTaxa;
	private JTextField txtPrimeiraParcela;
	private JPasswordField passwordField;
	private JButton btnCalcular;
	private JButton btnSolicitar;
	private JPanel panel;
	private JPanel panel_1;
	private JTextField txtIof;

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
		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent e) {
				Limites limites = new Limites();
				int limite = limites.getLimiteEmprestimo(Main.cliente.getIdade(), Main.cliente.getFormacao(), Main.cliente.getProfissao(), Main.cliente.getRenda());
				txtLimite.setText(String.valueOf(limite));
				txtValor.requestFocusInWindow();				
			}
		});
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent e) {
				Main.emprestimosMenu.show();
				dispose();
			}
		});
		setTitle("Solicitar Empr\u00E9stimo");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 288, 409);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel = new JPanel();
		panel.setBackground(new Color(0, 153, 255));
		panel.setBounds(10, 65, 251, 294);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblValor = new JLabel("Valor");
		lblValor.setBounds(72, 14, 46, 14);
		panel.add(lblValor);
		lblValor.setFont(new Font("Sitka Small", Font.BOLD, 12));
		
		JLabel lblPrazo = new JLabel("Prazo(meses)");
		lblPrazo.setBounds(22, 38, 96, 14);
		panel.add(lblPrazo);
		lblPrazo.setFont(new Font("Sitka Small", Font.BOLD, 12));
		
		txtValor = new JTextField();
		txtValor.setBounds(128, 10, 86, 20);
		panel.add(txtValor);
		txtValor.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				btnSolicitar.setEnabled(false);
				if(e.getKeyChar() == KeyEvent.VK_ENTER)
				{
					txtPrazo.requestFocusInWindow();
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
		txtValor.setColumns(10);
		
		txtPrazo = new JTextField();
		txtPrazo.setBounds(128, 35, 86, 20);
		panel.add(txtPrazo);
		txtPrazo.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				btnSolicitar.setEnabled(false);
				if(arg0.getKeyChar() == KeyEvent.VK_ENTER)
				{
					btnCalcular.doClick();
					passwordField.requestFocusInWindow();
				}
				else if((arg0.getKeyChar() >= '0' && arg0.getKeyChar() <= '9') || arg0.getKeyChar() == 8 || arg0.getKeyChar() == 127)
				{
					txtPrazo.setEditable(true);
				}
				else 
				{
					txtPrazo.setEditable(false);
				}
			}
		});
		txtPrazo.setColumns(10);
		
		btnCalcular = new JButton("Calcular");
		btnCalcular.setBounds(125, 66, 89, 23);
		panel.add(btnCalcular);
		
		txtValorTotal = new JTextField();
		txtValorTotal.setBounds(128, 102, 106, 20);
		panel.add(txtValorTotal);
		txtValorTotal.setEditable(false);
		txtValorTotal.setText("Valor Total");
		txtValorTotal.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(128, 200, 106, 20);
		panel.add(passwordField);
		
		txtTaxa = new JTextField();
		txtTaxa.setBounds(128, 152, 106, 20);
		panel.add(txtTaxa);
		txtTaxa.setEditable(false);
		txtTaxa.setText("Taxa");
		txtTaxa.setColumns(10);
		
		txtValorParcela = new JTextField();
		txtValorParcela.setBounds(128, 127, 106, 20);
		panel.add(txtValorParcela);
		txtValorParcela.setEditable(false);
		txtValorParcela.setText("Valor Parcela");
		txtValorParcela.setColumns(10);
		
		txtPrimeiraParcela = new JTextField();
		txtPrimeiraParcela.setBounds(128, 225, 106, 20);
		panel.add(txtPrimeiraParcela);
		txtPrimeiraParcela.setEditable(false);
		txtPrimeiraParcela.setText("Primeira Parcela");
		txtPrimeiraParcela.setColumns(10);
		
		btnSolicitar = new JButton("Solicitar");
		btnSolicitar.setBounds(125, 256, 89, 23);
		panel.add(btnSolicitar);
		btnSolicitar.setEnabled(false);
		
		JLabel lblPrimeiraParcela = new JLabel("Primeira Parcela");
		lblPrimeiraParcela.setBounds(12, 229, 106, 14);
		panel.add(lblPrimeiraParcela);
		lblPrimeiraParcela.setFont(new Font("Sitka Small", Font.BOLD, 12));
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setBounds(80, 204, 38, 14);
		panel.add(lblSenha);
		lblSenha.setFont(new Font("Sitka Small", Font.BOLD, 12));
		
		JLabel lblTaxaAoMs = new JLabel("Taxa ao m\u00EAs");
		lblTaxaAoMs.setBounds(37, 155, 79, 14);
		panel.add(lblTaxaAoMs);
		lblTaxaAoMs.setFont(new Font("Sitka Small", Font.BOLD, 12));
		
		JLabel lblValorTotal = new JLabel("Valor Total");
		lblValorTotal.setBounds(44, 105, 72, 14);
		panel.add(lblValorTotal);
		lblValorTotal.setFont(new Font("Sitka Small", Font.BOLD, 12));
		
		JLabel lblValorParcela = new JLabel("Valor Parcela");
		lblValorParcela.setBounds(30, 130, 86, 14);
		panel.add(lblValorParcela);
		lblValorParcela.setFont(new Font("Sitka Small", Font.BOLD, 12));
		
		JLabel lblIof = new JLabel("IOF");
		lblIof.setFont(new Font("Sitka Small", Font.BOLD, 12));
		lblIof.setBounds(86, 180, 32, 14);
		panel.add(lblIof);
		
		txtIof = new JTextField();
		txtIof.setText("IOF");
		txtIof.setEditable(false);
		txtIof.setColumns(10);
		txtIof.setBounds(128, 176, 106, 20);
		panel.add(txtIof);
		
		panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 153, 255));
		panel_1.setBounds(10, 11, 251, 43);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		txtLimite = new JTextField();
		txtLimite.setBounds(155, 11, 86, 20);
		panel_1.add(txtLimite);
		txtLimite.addComponentListener(new ComponentAdapter() {
			
		});
		txtLimite.setEditable(false);
		txtLimite.setText("Limite");
		txtLimite.setColumns(10);
		
		JLabel lblLimiteDisponvel = new JLabel("Limite Dispon\u00EDvel");
		lblLimiteDisponvel.setBounds(10, 15, 135, 14);
		panel_1.add(lblLimiteDisponvel);
		lblLimiteDisponvel.setFont(new Font("Sitka Small", Font.BOLD, 12));
		btnSolicitar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFrame f = new JFrame();
				if(passwordField.getText().equals(Main.conta.getSenhaConta()))
				{
					if(Main.emprestimo.novoEmprestimo(Float.valueOf(txtTaxa.getText().replace("%", "")), Integer.valueOf(txtPrazo.getText()), 
							Float.valueOf(txtValorTotal.getText()), Situacao.PENDENTE.getDescricao(), Float.valueOf(txtIof.getText().replace("%", ""))))
					{
						
						JOptionPane.showMessageDialog(f, "Empréstimo solicitado com sucesso!" , "Atenção", JOptionPane.INFORMATION_MESSAGE);
					}
					else
					{
						JOptionPane.showMessageDialog(f, "Não foi possível solicitar o empréstimo!" , "Erro", JOptionPane.WARNING_MESSAGE);
					}
				}
				else
				{					
					JOptionPane.showMessageDialog(f, "Senha incorreta" , "Erro", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		passwordField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyChar() == KeyEvent.VK_ENTER)
				{
					btnSolicitar.doClick();
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
		btnCalcular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if(txtValor.getText().length() == 0)
				{
					JFrame f = new JFrame();
					JOptionPane.showMessageDialog(f, "Insira um valor!" , "Erro", JOptionPane.WARNING_MESSAGE);
				}
				else if(txtPrazo.getText().length() == 0)
				{
					JFrame f = new JFrame();
					JOptionPane.showMessageDialog(f, "Insira um prazo!" , "Erro", JOptionPane.WARNING_MESSAGE);
				}
				else if(Integer.valueOf(txtValor.getText()) > Integer.valueOf(txtLimite.getText()))
				{
					JFrame f = new JFrame();
					JOptionPane.showMessageDialog(f, "O valor excede o limite disponível" , "Erro", JOptionPane.WARNING_MESSAGE);
				}
				else if(Integer.valueOf(txtValor.getText()) == 0)
				{
					JFrame f = new JFrame();
					JOptionPane.showMessageDialog(f, "O valor deve ser maior que zero!" , "Erro", JOptionPane.WARNING_MESSAGE);
				}
				else if(Integer.valueOf(txtPrazo.getText()) == 0)
				{
					JFrame f = new JFrame();
					JOptionPane.showMessageDialog(f, "O prazo deve ser maior que zero!" , "Erro", JOptionPane.WARNING_MESSAGE);
				}
				else if(Integer.valueOf(txtPrazo.getText()) > 24)
				{
					JFrame f = new JFrame();
					JOptionPane.showMessageDialog(f, "O prazo máximo é de 24 mêses!" , "Erro", JOptionPane.WARNING_MESSAGE);
				}
				else
				{
					float taxa = Main.emprestimo.getTaxaMes(Integer.valueOf(txtPrazo.getText()));
					txtTaxa.setText(String.valueOf(taxa * 100).substring(0,4) + "%");
					
					String valorTotal = String.valueOf(Main.emprestimo.getValorTotal(Integer.valueOf(txtValor.getText()), 
							Integer.valueOf(txtPrazo.getText()), taxa));
					int pontoValorTotal = valorTotal.indexOf(".");
					txtValorTotal.setText(valorTotal.substring(0, pontoValorTotal + 3));
					
					String valorParcela = String.valueOf(Main.emprestimo.getValorParcela(Integer.valueOf(txtValor.getText()),
							Integer.valueOf(txtPrazo.getText()), taxa));
					int pontoValorParcela = valorParcela.indexOf(".");
					txtValorParcela.setText(valorParcela.substring(0, pontoValorParcela + 3));
					
					txtIof.setText(String.valueOf(Main.emprestimo.getIOF(Integer.valueOf(txtPrazo.getText()))) + "%");
					
					txtPrimeiraParcela.setText(String.valueOf(Main.emprestimo.getPrimeiraParcela()));
					btnSolicitar.setEnabled(true);
				}
				
			}
		});
	}
}
