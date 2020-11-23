package view.Cartao;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import model.Cambio.Moeda;
import model.Cartao.Tipo;
import view.Main.Main;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class SolicitarCartaoT extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	/*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SolicitarCartao frame = new SolicitarCartao();
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
	public SolicitarCartaoT() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent arg0) {
				Main.cartaoT.show();
				dispose();
			}
		});
		
		setTitle("Solicitar Cart\u00E3o");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 214, 188);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPasswordField txtSenha = new JPasswordField();
		txtSenha.setBounds(20, 84, 168, 20);
		contentPane.add(txtSenha);
		
		JFrame f = new JFrame();
		JButton btnNewButton = new JButton("Enviar");
		
		btnNewButton.setFont(new Font("Sitka Small", Font.BOLD, 12));
		btnNewButton.setBounds(20, 115, 168, 23);
		contentPane.add(btnNewButton);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(30, 144, 255));
		panel.setBounds(10, 11, 188, 137);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JComboBox cbTipo = new JComboBox();
		cbTipo.setBounds(10, 31, 168, 20);
		panel.add(cbTipo);
		cbTipo.setModel(new DefaultComboBoxModel(Tipo.values()));
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setBounds(0, 55, 188, 14);
		panel.add(lblSenha);
		lblSenha.setFont(new Font("Sitka Small", Font.BOLD, 12));
		lblSenha.setHorizontalAlignment(SwingConstants.CENTER);
		
		
		JLabel lblNewLabel = new JLabel("Tipo Cart\u00E3o");
		lblNewLabel.setBounds(10, 11, 168, 14);
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Sitka Small", Font.BOLD, 12));
		lblNewLabel.setToolTipText("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Moeda moeda;				
				if(cbTipo.getSelectedItem().toString().equals("PRÉ_PAGO"))
				{
					moeda = Moeda.Dolar;
				}
				else
				{
					moeda = Moeda.Real;
				}
				
				if (Main.conta.PedirNovoCartao(Tipo.valueOf(cbTipo.getSelectedItem().toString()), moeda, txtSenha.getText(), 1000.00))
				{
					dispose();
					JOptionPane.showMessageDialog(f, "Cartão criado com sucesso!", "Atenção", JOptionPane.INFORMATION_MESSAGE);
				}					
				else
					JOptionPane.showMessageDialog(f, "Não foi possível criar um novo cartão", "Erro", JOptionPane.WARNING_MESSAGE);
				
			}

		});
	}
}
