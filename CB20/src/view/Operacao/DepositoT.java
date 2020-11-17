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
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent e) {
				Main.menuPrincipal.show();
				dispose();
			}
		});
		setTitle("Dep\u00F3sito");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 233, 119);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnGerarBoleto = new JButton("Gerar Linha Digit\u00E1vel");
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
					deposito.setValor(valor);
					
					
				} catch (Exception e) {
					JOptionPane.showMessageDialog(f, "Por favor, digite um valor válido!", "Erro", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		btnGerarBoleto.setFont(new Font("Sitka Small", Font.BOLD, 12));
		btnGerarBoleto.setBounds(10, 42, 197, 23);
		contentPane.add(btnGerarBoleto);
		
		txtValor = new JTextField();
		txtValor.setBounds(57, 11, 150, 20);
		contentPane.add(txtValor);
		txtValor.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Valor");
		lblNewLabel.setBounds(10, 14, 37, 14);
		contentPane.add(lblNewLabel);
	}

}
