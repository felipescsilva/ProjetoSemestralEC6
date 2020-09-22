package view.Cartao;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JList;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.AbstractListModel;
import java.awt.Font;

public class VerCartoesAtivosT extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTable table_1;
	private JTable table_2;
	private JTable table_3;
	private JTable table_4;
	private JScrollPane scrollPane;

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
	public VerCartoesAtivosT() {
		setResizable(false);
		setTitle("Cart\u00F5es Ativos");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 557, 127);
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
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 524, 359);
		contentPane.add(scrollPane);
		
		table_4 = new JTable();
		scrollPane.setViewportView(table_4);
		table_4.setFont(new Font("Sitka Small", Font.BOLD, 12));
		table_4.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
			},
			new String[] {
				"N\u00FAmero Cart\u00E3o", "Data Validade", "Titular", "Situa\u00E7\u00E3o", "Tipo"
			}
		));
		table_4.getColumnModel().getColumn(0).setPreferredWidth(152);
		table_4.getColumnModel().getColumn(1).setPreferredWidth(94);
		table_4.getColumnModel().getColumn(2).setPreferredWidth(129);
		table_4.getColumnModel().getColumn(3).setPreferredWidth(129);
		
	}
}
