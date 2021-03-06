package view.Cartao;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DAO.ContaDAO;
import DAO.FaturaDAO;
import model.Fatura.Situacao;
import view.Main.Main;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class VisualizarFaturaT extends JFrame {

	private JPanel contentPane;
	public JTextField txtIdFatura;
	public JTextField txtVencimento;
	public JTextField txtJuros;
	public JTextField txtValor;
	private JFrame f = new JFrame();

	/**
	 * Launch the application.
	 */
	/*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VerCartaoT frame = new VerCartaoT();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	*/

	/**
	 * Create the frame.
	 */
	public VisualizarFaturaT() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent arg0) {
				Main.verFaturas.show();
				dispose();
			}
		});
		setTitle("Fatura");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 207);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(5, 5, 424, 158);
		panel.setBackground(new Color(30, 144, 255));
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("N\u00BA Fatura");
		lblNewLabel.setBounds(10, 11, 67, 14);
		panel.add(lblNewLabel);
		
		txtIdFatura = new JTextField();
		txtIdFatura.setEditable(false);
		txtIdFatura.setBounds(69, 8, 345, 20);
		panel.add(txtIdFatura);
		txtIdFatura.setColumns(10);
		
		txtValor = new JTextField();
		txtValor.setEditable(false);
		txtValor.setBounds(69, 36, 345, 20);
		panel.add(txtValor);
		txtValor.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Valor");
		lblNewLabel_2.setBounds(10, 39, 46, 14);
		panel.add(lblNewLabel_2);
		
		txtVencimento = new JTextField();
		txtVencimento.setEditable(false);
		txtVencimento.setColumns(10);
		txtVencimento.setBounds(69, 98, 345, 20);
		panel.add(txtVencimento);
		
		JLabel lblNewLabel_3_1 = new JLabel("Vencimento");
		lblNewLabel_3_1.setBounds(10, 101, 61, 14);
		panel.add(lblNewLabel_3_1);
		
		JButton btnPagarFatura = new JButton("Pagar Fatura");
		btnPagarFatura.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				enable(false);
				ConfirmarSenhaT confirmarSenha = new ConfirmarSenhaT();
				confirmarSenha.show();
				confirmarSenha.btnConfirmar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if (confirmarSenha.txtSenha.getText().equals(Main.conta.getSenhaConta()) && Main.conta.getSaldo() >= Main.fatura.getValor()) {
							Main.fatura.setSituacao(Situacao.PAGO);
							Main.conta.setSaldo(Main.conta.getSaldo() - Main.fatura.getValor());
							FaturaDAO faturadao = new FaturaDAO();
							faturadao.Atualizar(Main.fatura);
							ContaDAO contadao = new ContaDAO();
							contadao.Atualizar(Main.conta);
							JOptionPane.showMessageDialog(f, "Fatura Paga!");
							Main.faturas = Main.cartao.getFaturasNaoPagas();
							Main.verFaturas.cbFaturas.removeAllItems();
							Main.verFaturas.cbFaturas.addItem("Selecione...");
							for (int i = 0; i < Main.faturas.size(); i++) {
								Main.verFaturas.cbFaturas.addItem(Main.faturas.get(i).getIdFatura());
							}
							confirmarSenha.dispose();
							enable(true);
							dispose();
						} else {
							JOptionPane.showMessageDialog(f, "Senha incorreta ou valor insufiente, n�o foi poss�vel pagar sua fatura", "Erro", JOptionPane.WARNING_MESSAGE);
							confirmarSenha.txtSenha.setText("");
						}
					}
				});
			}
		});
		btnPagarFatura.setBounds(10, 129, 404, 23);
		panel.add(btnPagarFatura);
		
		JLabel lblNewLabel_2_1 = new JLabel("Juros");
		lblNewLabel_2_1.setBounds(10, 70, 46, 14);
		panel.add(lblNewLabel_2_1);
		
		txtJuros = new JTextField();
		txtJuros.setEditable(false);
		txtJuros.setColumns(10);
		txtJuros.setBounds(69, 67, 345, 20);
		panel.add(txtJuros);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 0, 0));
		panel_1.setBounds(0, 0, 434, 168);
		contentPane.add(panel_1);
	}
}
