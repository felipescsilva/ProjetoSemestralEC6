package view.Opcoes;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.time.LocalDate;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DAO.ClienteDAO;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import model.Cliente.Formacao;
import model.Cliente.Profissao;
import view.Main.Main;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class AlterarDadosT extends JFrame {

	private JPanel contentPane;
	public JTextField txtNome;
	public JTextField txtData;
	public JTextField txtRenda;
	public JComboBox cbFormacao;
	public JComboBox cbProfissao;
	private JFrame f = new JFrame();
	private JPanel panel;
	private JPanel panel_1;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public AlterarDadosT() {
		setResizable(false);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent arg0) {
				Main.opcoes.show();
				dispose();
			}
		});
		setTitle("Alterar Dados");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 378, 251);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel = new JPanel();
		panel.setBackground(new Color(0, 0, 0));
		panel.setBounds(0, 0, 372, 219);
		contentPane.add(panel);
		panel.setLayout(null);
		
		panel_1 = new JPanel();
		panel_1.setBackground(new Color(30, 144, 255));
		panel_1.setBounds(10, 11, 350, 197);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnNewButton = new JButton("Alterar");
		btnNewButton.setBounds(10, 163, 333, 23);
		panel_1.add(btnNewButton);
		
		JLabel lblNewLabel_4 = new JLabel("Renda");
		lblNewLabel_4.setBounds(10, 135, 46, 14);
		panel_1.add(lblNewLabel_4);
		
		txtRenda = new JTextField();
		txtRenda.setBounds(127, 132, 216, 20);
		panel_1.add(txtRenda);
		txtRenda.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Nome");
		lblNewLabel.setBounds(10, 11, 46, 14);
		panel_1.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Data Nascimento");
		lblNewLabel_1.setBounds(10, 42, 118, 14);
		panel_1.add(lblNewLabel_1);
		
		txtNome = new JTextField();
		txtNome.setBounds(127, 8, 216, 20);
		panel_1.add(txtNome);
		txtNome.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Profiss\u00E3o");
		lblNewLabel_3.setBounds(10, 107, 46, 14);
		panel_1.add(lblNewLabel_3);
		
		JLabel lblNewLabel_2 = new JLabel("Forma\u00E7\u00E3o");
		lblNewLabel_2.setBounds(10, 76, 76, 14);
		panel_1.add(lblNewLabel_2);
		
		cbProfissao = new JComboBox();
		cbProfissao.setBounds(127, 101, 216, 20);
		panel_1.add(cbProfissao);
		cbProfissao.setModel(new DefaultComboBoxModel(Profissao.values()));
		
		cbFormacao = new JComboBox();
		cbFormacao.setBounds(127, 70, 216, 20);
		panel_1.add(cbFormacao);
		cbFormacao.setModel(new DefaultComboBoxModel(Formacao.values()));
		
		txtData = new JTextField();
		txtData.setBounds(127, 39, 216, 20);
		panel_1.add(txtData);
		txtData.setColumns(10);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				boolean dadosCorretos = true;
				String mensagemDeErro = "";
				if (txtNome.getText().isEmpty())
				{
					mensagemDeErro += "Nome não pode ser vazio.\n";
					dadosCorretos = false;
				}
				double renda = 0;
				if (txtRenda.getText().isEmpty())
				{
					mensagemDeErro += "Preencha a renda.\n";
					dadosCorretos = false;
				}
				else {
					if (Double.parseDouble(txtRenda.getText()) < 0) {
						mensagemDeErro += "A renda não pode ser negativa.\n";
						dadosCorretos = false;
					} else {
						renda = Double.parseDouble(txtRenda.getText());
					}
				}
				LocalDate data = LocalDate.now();
				String dataString = txtData.getText();
				if (dataString.trim().length() != 10) {
					mensagemDeErro += "Data inválida.\n";
				} else {
					data = LocalDate.of(Integer.parseInt(dataString.split("/")[2]), Integer.parseInt(dataString.split("/")[1]), Integer.parseInt(dataString.split("/")[0]));
					if (data.isAfter(LocalDate.now()))
					{
						mensagemDeErro += "Data inválida.\n";
						dadosCorretos = false;
					}
				}
				
				if (dadosCorretos) {
					Main.cliente.setNome(txtNome.getText());
					Main.cliente.setDataNascimento(data);
					Main.cliente.setFormacao(Formacao.valueOf(cbFormacao.getSelectedItem().toString()));
					Main.cliente.setProfissao(Profissao.valueOf(cbProfissao.getSelectedItem().toString()));
					Main.cliente.setRenda(renda);
					
					ClienteDAO dao = new ClienteDAO();
					dao.Atualizar(Main.cliente);
					JOptionPane.showMessageDialog(f, "Seus dados foram alterados com sucesso!");
				}
				else
					JOptionPane.showMessageDialog(f, mensagemDeErro, "Erro", JOptionPane.WARNING_MESSAGE);
			}
		});
	}
}
