package view.Operacao;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.time.LocalDate;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

import DAO.ContaDAO;
import DAO.TransferenciaDAO;
import view.Main.Main;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class ConfirmarDadosT extends JFrame {

	private JPanel contentPane;
	private JFrame f = new JFrame();
	public JTextField txtValor;
	public JTextField txtConta;
	public JTextField txtCPF;
	public JTextField txtNome;
	public JPasswordField txtSenha;

	
	/**
	 * Launch the application.
	 */
	/*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConfirmarDadosT frame = new ConfirmarDadosT();
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
	public ConfirmarDadosT() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent e) {
				Main.transferencia.show();
				dispose();
			}
		});
		setTitle("Confirmar Dados");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 304, 265);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 153, 255));
		panel.setBounds(10, 11, 267, 205);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_4 = new JLabel("Senha Conta");
		lblNewLabel_4.setBounds(10, 138, 62, 14);
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel = new JLabel("Valor");
		lblNewLabel.setBounds(10, 107, 46, 14);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_3 = new JLabel("Nome T\u00EDtular");
		lblNewLabel_3.setBounds(10, 76, 70, 14);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_2 = new JLabel("CPF");
		lblNewLabel_2.setBounds(10, 45, 46, 14);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_1 = new JLabel("Conta");
		lblNewLabel_1.setBounds(10, 14, 46, 14);
		panel.add(lblNewLabel_1);
		
		txtConta = new JTextField();
		txtConta.setBounds(82, 11, 172, 20);
		panel.add(txtConta);
		txtConta.setEditable(false);
		txtConta.setColumns(10);
		
		txtCPF = new JTextField();
		txtCPF.setBounds(82, 42, 172, 20);
		panel.add(txtCPF);
		txtCPF.setEditable(false);
		txtCPF.setColumns(10);
		
		txtNome = new JTextField();
		txtNome.setBounds(82, 73, 172, 20);
		panel.add(txtNome);
		txtNome.setEditable(false);
		txtNome.setColumns(10);
		
		txtValor = new JTextField();
		txtValor.setBounds(82, 104, 172, 20);
		panel.add(txtValor);
		txtValor.setColumns(10);
		
		txtSenha = new JPasswordField();
		txtSenha.setBounds(82, 135, 172, 20);
		panel.add(txtSenha);
		txtSenha.setColumns(10);
		
		JButton btnNewButton = new JButton("Confirmar Transfer\u00EAncia");
		btnNewButton.setBounds(10, 163, 244, 23);
		panel.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String valorString = txtValor.getText();
				valorString = valorString.replace(",", ".");
				double valor = Double.parseDouble(valorString);
				String mensagemErro = "Não foi possível realizar essa transferencia pelos seguintes motivos: \n";
				Boolean possivel = true;
				if (valor > Main.conta.getSaldo()) {
					mensagemErro += "Você não possui saldo suficiente!\n";
					possivel = false;
				} 
				if (!Main.conta.getSenhaConta().equals(txtSenha.getText().trim())) {
					mensagemErro += "Senha incorreta!";
					possivel = false;
				}
				if (possivel) {
					Main.conta.setSaldo(Main.conta.getSaldo() - valor);
					ContaDAO contaDAO = new ContaDAO();
					contaDAO.Atualizar(Main.conta);
					Main.contaTransferencia.setSaldo(Main.contaTransferencia.getSaldo() + valor);
					contaDAO.Atualizar(Main.contaTransferencia);
					TransferenciaDAO transferenciaDAO = new TransferenciaDAO();
					Main.transferir.setDataTransacao(LocalDate.now());
					Main.transferir.setValor(valor);
					transferenciaDAO.Inserir(Main.transferir);
					JOptionPane.showMessageDialog(f, "Sua transferencia foi realizada!");
				}
				else 
					JOptionPane.showMessageDialog(f, mensagemErro, "Erro", JOptionPane.WARNING_MESSAGE);
			}
		});
	}
}
