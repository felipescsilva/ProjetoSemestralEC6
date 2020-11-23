package view.Cartao;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.table.DefaultTableModel;

import model.Cartao.Status;
import model.Cartao.Tipo;
import view.Main.Main;

import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class SelecionarFaturaT extends JFrame {

	private JPanel contentPane;
	private JFrame f = new JFrame();
	public JComboBox cbFaturas = new JComboBox();

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public SelecionarFaturaT() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent arg0) {
				Main.verCartao.show();
				dispose();
			}
		});
		setTitle("Faturas");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 150);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(30, 144, 255));
		panel.setBounds(7, 7, 427, 103);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("Ver Fatura");
		btnNewButton.setBounds(10, 69, 405, 23);
		panel.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (cbFaturas.getSelectedIndex() == 0)
					JOptionPane.showMessageDialog(f, "Selecione uma opção válida!", "Erro", JOptionPane.WARNING_MESSAGE);
				else {
					Main.verCartao.show();
					int indexSelecionado = cbFaturas.getSelectedIndex();
					Main.fatura = Main.faturas.get(indexSelecionado - 1);
					Main.verFatura.txtIdFatura.setText(Integer.toString(Main.fatura.getIdFatura()));
					Main.verFatura.txtJuros.setText(Double.toString(Main.fatura.getTaxaJuros()));
					Main.verFatura.txtVencimento.setText(Main.fatura.getDataVencimento().toString());
					Main.verFatura.txtValor.setText(Double.toString(Main.fatura.getValor()));
					
					hide();
				}
			}
		});
		btnNewButton.setFont(new Font("Sitka Small", Font.BOLD, 12));
		
		JLabel lblSelecioneAFatura = new JLabel("Selecione o m\u00EAs de refer\u00EAncia da fatura:");
		lblSelecioneAFatura.setBounds(0, 11, 429, 14);
		panel.add(lblSelecioneAFatura);
		lblSelecioneAFatura.setHorizontalAlignment(SwingConstants.CENTER);
		cbFaturas.setBounds(10, 36, 405, 20);
		panel.add(cbFaturas);
		
		cbFaturas.setModel(new DefaultComboBoxModel(new String[] {"Selecione..."}));
	}

}
