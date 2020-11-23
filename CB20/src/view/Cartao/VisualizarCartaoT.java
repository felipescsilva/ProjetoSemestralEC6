package view.Cartao;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Cartao.Status;
import view.Main.Main;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class VisualizarCartaoT extends JFrame {

	private JPanel contentPane;
	public JTextField txtNumCartao;
	public JTextField txtTipo;
	public JTextField txtMoeda;
	public JTextField txtStatus;
	public JTextField txtValidade;
	public JFrame f = new JFrame();
	public JButton btnFaturas = new JButton("Ver Faturas em aberto");
	public JButton btnBlock = new JButton("Bloqueio Temporario");
	public JButton btnCancelar = new JButton("Cancelar Cart\u00E3o");
	private JPanel panel_1;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public VisualizarCartaoT() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent arg0) {
				Main.verCartoes.show();
				dispose();
			}
		});
		setTitle("Cart\u00E3o");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 312);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(5, 5, 424, 263);
		panel.setBackground(new Color(30, 144, 255));
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("N\u00BA Cart\u00E3o");
		lblNewLabel.setBounds(10, 11, 67, 14);
		panel.add(lblNewLabel);
		
		txtNumCartao = new JTextField();
		txtNumCartao.setEditable(false);
		txtNumCartao.setBounds(69, 8, 345, 20);
		panel.add(txtNumCartao);
		txtNumCartao.setColumns(10);
		
		txtTipo = new JTextField();
		txtTipo.setEditable(false);
		txtTipo.setBounds(69, 36, 345, 20);
		panel.add(txtTipo);
		txtTipo.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Tipo");
		lblNewLabel_1.setBounds(10, 39, 46, 14);
		panel.add(lblNewLabel_1);
		
		txtMoeda = new JTextField();
		txtMoeda.setEditable(false);
		txtMoeda.setBounds(69, 67, 345, 20);
		panel.add(txtMoeda);
		txtMoeda.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Moeda");
		lblNewLabel_2.setBounds(10, 70, 46, 14);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Status");
		lblNewLabel_3.setBounds(10, 100, 46, 14);
		panel.add(lblNewLabel_3);
		
		txtStatus = new JTextField();
		txtStatus.setEditable(false);
		txtStatus.setColumns(10);
		txtStatus.setBounds(69, 98, 345, 20);
		panel.add(txtStatus);
		
		txtValidade = new JTextField();
		txtValidade.setEditable(false);
		txtValidade.setColumns(10);
		txtValidade.setBounds(69, 131, 345, 20);
		panel.add(txtValidade);
		
		JLabel lblNewLabel_3_1 = new JLabel("V\u00E1lidade");
		lblNewLabel_3_1.setBounds(10, 134, 46, 14);
		panel.add(lblNewLabel_3_1);
		
		btnFaturas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.faturas = Main.cartao.getFaturasNaoPagas();
				
				for (int i = 0; i < Main.faturas.size(); i++) {
					Main.verFaturas.cbFaturas.addItem(Main.faturas.get(i).getIdFatura());
				}
				Main.verFaturas.show();
				hide();
			}
		});
		btnFaturas.setBounds(10, 162, 404, 23);
		panel.add(btnFaturas);
		btnBlock.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (Main.cartao.getStatus() == Status.DESBLOQUEADO) {
					if (Main.conta.PedirBloqueioCartao(Main.cartao)) {
						btnBlock.setText("Pedir desbloqueio");
						txtStatus.setText("BLOQUEADO");
					}
				} else if (Main.cartao.getStatus() == Status.BLOQUEADO_POR_ERRO_DE_SENHA || Main.cartao.getStatus() == Status.BLOQUEADO) {
					if (Main.conta.PedirDesbloqueioCartao(Main.cartao)) {
						btnBlock.setText("Bloqueio Temporario");
						txtStatus.setText("DESBLOQUEADO");
					}
				} else if (Main.cartao.getStatus() == Status.BLOQUEADO_POR_FATURA) {
					JOptionPane.showMessageDialog(f, "Não foi possível desbloquear o  seu cartão. Você possui faturas que não foram pagas.", "Erro", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		
		btnBlock.setBounds(10, 196, 404, 23);
		panel.add(btnBlock);
		
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				enable(false);
				ConfirmarSenhaT confirmarSenha = new ConfirmarSenhaT();
				confirmarSenha.show();
				confirmarSenha.btnConfirmar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if (confirmarSenha.txtSenha.getText().equals(Main.conta.getSenhaConta())) {
							JOptionPane.showMessageDialog(f, "Cartão cancelado com sucesso!");
							confirmarSenha.dispose();
							Main.conta.PedirCancelamento(Main.cartao);
							txtStatus.setText("CANCELADO");
							btnBlock.setEnabled(false);
							btnCancelar.setEnabled(false);
							enable(true);
						} else {
							JOptionPane.showMessageDialog(f, "Senha incorreta, não foi possível cancelar o seu cartão", "Erro", JOptionPane.WARNING_MESSAGE);
							confirmarSenha.txtSenha.setText("");
						}
					}
				});
			}
		});
		btnCancelar.setBounds(10, 230, 404, 23);
		panel.add(btnCancelar);
		
		panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 0, 0));
		panel_1.setBounds(0, 0, 434, 273);
		contentPane.add(panel_1);
	}
}
