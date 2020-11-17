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
		setBounds(100, 100, 288, 228);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtValor = new JTextField();
		txtValor.setBounds(82, 101, 172, 20);
		contentPane.add(txtValor);
		txtValor.setColumns(10);
		
		txtConta = new JTextField();
		txtConta.setEditable(false);
		txtConta.setBounds(82, 8, 172, 20);
		contentPane.add(txtConta);
		txtConta.setColumns(10);
		
		txtCPF = new JTextField();
		txtCPF.setEditable(false);
		txtCPF.setBounds(82, 39, 172, 20);
		contentPane.add(txtCPF);
		txtCPF.setColumns(10);
		
		txtNome = new JTextField();
		txtNome.setEditable(false);
		txtNome.setBounds(82, 70, 172, 20);
		contentPane.add(txtNome);
		txtNome.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Conta");
		lblNewLabel_1.setBounds(10, 11, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("Valor");
		lblNewLabel.setBounds(10, 104, 46, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("CPF");
		lblNewLabel_2.setBounds(10, 42, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Nome T\u00EDtular");
		lblNewLabel_3.setBounds(10, 73, 70, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Senha Conta");
		lblNewLabel_4.setBounds(10, 135, 62, 14);
		contentPane.add(lblNewLabel_4);
		
		txtSenha = new JPasswordField();
		txtSenha.setColumns(10);
		txtSenha.setBounds(82, 132, 172, 20);
		contentPane.add(txtSenha);
		
		JButton btnNewButton = new JButton("Confirmar Transfer\u00EAncia");
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
		btnNewButton.setBounds(10, 160, 244, 23);
		contentPane.add(btnNewButton);
	}
}
