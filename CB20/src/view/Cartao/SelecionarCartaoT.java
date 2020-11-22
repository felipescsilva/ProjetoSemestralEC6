package view.Cartao;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import DAO.CartaoDAO;
import model.Cartao.Cartao;
import model.Cartao.Status;
import model.Cartao.Tipo;
import view.Main.Main;

import javax.swing.JScrollPane;
import javax.swing.AbstractListModel;
import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.*;
import javax.swing.SwingConstants;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SelecionarCartaoT extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTable table_1;
	private JTable table_2;
	private JTable table_3;
	private JFrame f = new JFrame();
	public JComboBox cbCartoes = new JComboBox();

	/**
	 * Launch the application.
	 */
	/*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VerCartoes frame = new VerCartoes();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	/*

	/**
	 * Create the frame.
	 */
	public SelecionarCartaoT() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent arg0) {
				Main.cartaoT.show();
				dispose();
			}
		});
		setResizable(false);
		setTitle("Selecionar Cart\u00E3o");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 500, 133);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		table_2 = new JTable();
		table_2.setBounds(10, 11, 1, 1);
		contentPane.add(table_2);
		
		table_3 = new JTable();
		table_3.setBounds(10, 11, 1, 1);
		contentPane.add(table_3);
		
		JButton btnNewButton = new JButton("Ver Cart\u00E3o");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (cbCartoes.getSelectedIndex() == 0)
					JOptionPane.showMessageDialog(f, "Selecione uma opção válida!", "Erro", JOptionPane.WARNING_MESSAGE);
				else {
					Main.verCartao.show();
					int indexSelecionado = cbCartoes.getSelectedIndex();
					Main.cartao = Main.cartoes.get(indexSelecionado - 1);
					
					
					Main.verCartao.txtNumCartao.setText(Main.cartao.getNumeroCartao());
					Main.verCartao.txtStatus.setText(Main.cartao.getStatus().toString());
					Main.verCartao.txtTipo.setText(Main.cartao.getTipo().toString());;
					Main.verCartao.txtValidade.setText(Main.cartao.getDataValidade().toString());
					Main.verCartao.txtMoeda.setText(Main.cartao.getMoeda().toString());
					
					if (Main.cartao.getTipo() != Tipo.CRÉDITO)
						Main.verCartao.btnFaturas.setEnabled(false);
					else 
						Main.verCartao.btnFaturas.setEnabled(true);
					if (Main.cartao.getStatus() != Status.DESBLOQUEADO)
						Main.verCartao.btnBlock.setText("Pedir Desbloqueio");
					else
						Main.verCartao.btnBlock.setText("Bloqueio Temporario");
					if (Main.cartao.getStatus() == Status.CANCELADO) {
						Main.verCartao.btnBlock.setEnabled(false);
						Main.verCartao.btnCancelar.setEnabled(false);
					}
					else {
						Main.verCartao.btnBlock.setEnabled(true);
						Main.verCartao.btnCancelar.setEnabled(true);
					}
					
					hide();
				}
			}
		});
		btnNewButton.setBounds(200, 66, 89, 23);
		contentPane.add(btnNewButton);
		
		cbCartoes.setModel(new DefaultComboBoxModel(new String[] {"Selecione..."}));
		cbCartoes.setBounds(10, 35, 473, 20);
		contentPane.add(cbCartoes);
		
		JLabel lblNewLabel = new JLabel("Selecione o Cart\u00E3o:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 11, 473, 14);
		contentPane.add(lblNewLabel);
	}
}
