package view.Menu;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.ParseException;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import DAO.ClienteDAO;
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

public class PesquisarCpfT extends JFrame {

	public JLabel lblPesquisar = new JLabel("N\u00FAmero do CPF");
	public JPanel contentPane;
	public JFormattedTextField txtCpf;
	private JFrame f = new JFrame();

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public PesquisarCpfT() {
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
		
		try {
			txtCpf = new JFormattedTextField(new MaskFormatter("###.###.###-##"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		txtCpf.setBounds(150, 8, 150, 20);
		panel.add(txtCpf);
		txtCpf.setColumns(10);
		
		JButton btnNewButton = new JButton("Pesquisar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ClienteDAO dao = new ClienteDAO();
				List<Cliente> lista = dao.Consultar("CPF", txtCpf.getText());
				if (lista.size() == 0) {
					JOptionPane.showMessageDialog(f, "Não foi localizado nenhum cliente com esse CPF", "Erro", JOptionPane.WARNING_MESSAGE);
				} else {
					Cliente cliente = new Cliente();
					cliente = lista.get(0);
					Main.consultar.show();
					Conta conta = cliente.getContaVinculada().get(0);
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
