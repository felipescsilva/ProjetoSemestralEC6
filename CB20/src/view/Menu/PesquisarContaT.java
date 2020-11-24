package view.Menu;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import DAO.ClienteDAO;
import DAO.ContaDAO;
import model.Cliente.Cliente;
import model.Conta.Conta;
import view.Main.Main;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PesquisarContaT extends JFrame {

	public JLabel lblPesquisar = new JLabel("N\u00FAmero da Conta");
	public JPanel contentPane;
	public JTextField txtNumConta;
	private JFrame f = new JFrame();

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public PesquisarContaT() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent arg0) {
				Main.menuAdmin.show();
				dispose();
			}
		});
		setTitle("Pesquisar");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 339, 122);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(30, 144, 255));
		panel.setBounds(10, 11, 313, 71);
		contentPane.add(panel);
		panel.setLayout(null);
		
		//JLabel lblPesquisar = new JLabel("N\u00FAmero da Conta");
		lblPesquisar.setBounds(10, 11, 119, 14);
		panel.add(lblPesquisar);
		txtNumConta = new JTextField();
		txtNumConta.setBounds(150, 8, 150, 20);
		panel.add(txtNumConta);
		txtNumConta.setColumns(10);
		
		JButton btnNewButton = new JButton("Pesquisar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ContaDAO dao = new ContaDAO();
				List<Conta> lista = new ArrayList<Conta>();
				try {
					lista = dao.Consultar("NumConta", txtNumConta.getText());
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				if (lista.size() == 0) {
					JOptionPane.showMessageDialog(f, "Não foi localizada nenhuma conta com esse Número", "Erro", JOptionPane.WARNING_MESSAGE);
				} else {
					Conta conta = new Conta();
					conta = lista.get(0);
					Main.consultar.show();
					Cliente cliente = conta.getProprietarioConta().get(0);
					Main.consultar.txtCpf.setText(conta.getCPF());;
					Main.consultar.txtDataNascimento.setText((cliente.getDataNascimento().toString()));
					Main.consultar.txtFormacao.setText((cliente.getFormacao().toString()));
					Main.consultar.txtNome.setText(cliente.getNome());;
					Main.consultar.txtNumConta.setText(conta.getNumeroConta());
					Main.consultar.txtProfissao.setText(cliente.getProfissao().toString());
					Main.consultar.txtRenda.setText(String.valueOf(cliente.getRenda()));;
					Main.consultar.txtSaldo.setText(String.valueOf(conta.getSaldo()));
					hide();
				}
			}
		});
		btnNewButton.setBounds(10, 36, 290, 23);
		panel.add(btnNewButton);
	}

}
