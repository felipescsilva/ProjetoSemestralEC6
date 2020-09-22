package view.Cartao;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import java.awt.Font;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JButton;

public class VerFaturasT extends JFrame {

	private JPanel contentPane;
	private final JTable table = new JTable();

	/**
	 * Launch the application.
	 */
	/*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VerFaturas frame = new VerFaturas();
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
	public VerFaturasT() {
		setTitle("Faturas");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 237);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 424, 154);
		contentPane.add(scrollPane);
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
			},
			new String[] {
				"Id", "Cart\u00E3o", "Valor", "Situa\u00E7\u00E3o", "Juros Mensais %"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(58);
		table.getColumnModel().getColumn(1).setPreferredWidth(143);
		table.getColumnModel().getColumn(2).setPreferredWidth(61);
		table.getColumnModel().getColumn(3).setPreferredWidth(83);
		table.getColumnModel().getColumn(4).setPreferredWidth(97);
		table.setFont(new Font("Sitka Small", Font.BOLD, 12));
		
		JButton btnNewButton = new JButton("Pagar Fatura");
		btnNewButton.setFont(new Font("Sitka Small", Font.BOLD, 12));
		btnNewButton.setBounds(10, 176, 424, 23);
		contentPane.add(btnNewButton);
	}

}
