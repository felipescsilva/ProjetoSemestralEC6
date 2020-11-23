package view.Operacao;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DAO.DepositoDAO;
import model.Deposito.Deposito;
import view.Main.Main;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.time.LocalDate;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class DepositoT extends JFrame {

	private JPanel contentPane;
	private JTextField txtValor;
	private JFrame f = new JFrame();

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public DepositoT() {
		setResizable(false);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent e) {
				Main.menuPrincipal.show();
				dispose();
			}
		});
		setTitle("Dep\u00F3sito");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 215, 125);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(30, 144, 255));
		panel.setBounds(10, 11, 191, 75);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Valor");
		lblNewLabel.setBounds(10, 8, 24, 14);
		panel.add(lblNewLabel);
		
		txtValor = new JTextField();
		txtValor.setBounds(44, 5, 135, 20);
		panel.add(txtValor);
		txtValor.setColumns(10);
		
		JButton btnGerarBoleto = new JButton("Gerar Linha Digit\u00E1vel");
		btnGerarBoleto.setBounds(10, 39, 169, 25);
		panel.add(btnGerarBoleto);
		btnGerarBoleto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String valorString = txtValor.getText();
				double valor = 0;
				try {
					valor = Double.parseDouble(valorString.replace(",", "."));
					Deposito deposito = new Deposito();
					DepositoDAO dao = new DepositoDAO();
					deposito.setCpf(Main.cliente.getCPF());
					deposito.setDataTransacao(LocalDate.now());
					deposito.setNumConta(Main.conta.getNumeroConta());
					deposito.setLinhaDigitavel(deposito.geraLinhaDigitavel());
					deposito.setValor(valor);
					dao.Inserir(deposito);
					JOptionPane.showMessageDialog(f, "Linha digitável gerada com sucesso\nO código dela é: " + deposito.getLinhaDigitavel());
					
				} catch (Exception e) {
					JOptionPane.showMessageDialog(f, "Por favor, digite um valor válido!", "Erro", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		btnGerarBoleto.setFont(new Font("Sitka Small", Font.BOLD, 12));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 0, 0));
		panel_1.setBounds(0, 0, 212, 108);
		contentPane.add(panel_1);
	}
}