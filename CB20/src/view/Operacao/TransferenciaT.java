package view.Operacao;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import model.Cliente.Cliente;
import model.Conta.Conta;
import view.Main.Main;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JPasswordField;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TransferenciaT extends JFrame {

	private JPanel contentPane;
	private JTextField txtConta;
	private JFormattedTextField txtCpf;
	private JFrame f = new JFrame();

	/**
	 * Launch the application.
	 */
	/*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TransferenciaT frame = new TransferenciaT();
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
	public TransferenciaT() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent e) {
				
				Main.menuPrincipal.show();
				dispose();
			}
		});
		setTitle("Transfer\u00EAncia");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 217, 163);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 438, 257);
		contentPane.add(panel);
		panel.setLayout(null);
		
		txtConta = new JTextField();
		txtConta.setBounds(51, 61, 135, 20);
		panel.add(txtConta);
		txtConta.setColumns(10);
		
		try {
			txtCpf = new JFormattedTextField(new MaskFormatter("###.###.###-##"));
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		txtCpf.setBounds(51, 36, 135, 20);
		panel.add(txtCpf);
		txtCpf.setColumns(10);
		
		JButton btnTransferir = new JButton("Continuar");
		btnTransferir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Main.transferir.setContaDestino(txtConta.getText());
				Main.transferir.setContaOrigem(Main.conta.getNumeroConta());
				Main.transferir.setCpf(txtCpf.getText());
				List<Conta> listaConta = Main.transferir.getDadosContaTransacao();
				String mensagemDeErro = "";
				if (listaConta.size() != 0) {
					Main.contaTransferencia = listaConta.get(0);
					Main.clienteTransferencia = Main.contaTransferencia.getProprietarioConta().get(0);
					if (txtCpf.getText().trim().equals(Main.clienteTransferencia.getCPF().trim())) {
						Main.confirmarDadosT.show();
						Main.confirmarDadosT.txtConta.setText(Main.contaTransferencia.getNumeroConta());
						Main.confirmarDadosT.txtCPF.setText(Main.contaTransferencia.getCPF());
						Main.confirmarDadosT.txtNome.setText(Main.clienteTransferencia.getNome());
						hide();
					} else {
						mensagemDeErro += "O CPF digitado não confere com o titular da conta!";
						JOptionPane.showMessageDialog(f, mensagemDeErro, "Erro", JOptionPane.WARNING_MESSAGE);
					}
					
				} else {
					mensagemDeErro += "A conta " + txtConta.getText() + " não foi localizada!";
					JOptionPane.showMessageDialog(f, mensagemDeErro, "Erro", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		btnTransferir.setBounds(10, 92, 176, 23);
		panel.add(btnTransferir);
		
		JLabel lblCpf = new JLabel("CPF");
		lblCpf.setBounds(10, 39, 30, 14);
		panel.add(lblCpf);
		
		JLabel lblConta = new JLabel("Conta");
		lblConta.setBounds(10, 64, 42, 14);
		panel.add(lblConta);
		
		JLabel lblNewLabel = new JLabel("Preencha os dados da outra conta:");
		lblNewLabel.setBounds(10, 11, 176, 14);
		panel.add(lblNewLabel);
	}
}
