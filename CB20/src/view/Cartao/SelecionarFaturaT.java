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

import view.Main.Main;

import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SelecionarFaturaT extends JFrame {

	private JPanel contentPane;

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
				Main.verFatura.show();
				hide();
			}
		});
		btnNewButton.setFont(new Font("Sitka Small", Font.BOLD, 12));
		btnNewButton.setBounds(7, 63, 424, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblSelecioneAFatura = new JLabel("Selecione o m\u00EAs de refer\u00EAncia da fatura:");
		lblSelecioneAFatura.setHorizontalAlignment(SwingConstants.CENTER);
		lblSelecioneAFatura.setBounds(7, 7, 429, 14);
		contentPane.add(lblSelecioneAFatura);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Selecione..."}));
		comboBox.setBounds(10, 32, 424, 20);
		contentPane.add(comboBox);
	}

}
