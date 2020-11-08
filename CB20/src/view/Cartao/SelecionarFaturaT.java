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
		setBounds(100, 100, 450, 128);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Ver Fatura");
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
		btnNewButton.setBounds(7, 63, 424, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblSelecioneAFatura = new JLabel("Selecione o m\u00EAs de refer\u00EAncia da fatura:");
		lblSelecioneAFatura.setHorizontalAlignment(SwingConstants.CENTER);
		lblSelecioneAFatura.setBounds(7, 7, 429, 14);
		contentPane.add(lblSelecioneAFatura);
		
		cbFaturas.setModel(new DefaultComboBoxModel(new String[] {"Selecione..."}));
		cbFaturas.setBounds(10, 32, 424, 20);
		contentPane.add(cbFaturas);
	}

}
