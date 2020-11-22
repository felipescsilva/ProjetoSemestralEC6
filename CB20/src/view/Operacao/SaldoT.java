package view.Operacao;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import view.Main.Main;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;
import javax.swing.JList;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class SaldoT extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SaldoT frame = new SaldoT();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public SaldoT() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent e) {
				Main.menuPrincipal.show();
				dispose();
			}
		});
		setTitle("Saldo");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 560, 420);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPerodo = new JLabel("Per\u00EDodo");
		lblPerodo.setFont(new Font("Sitka Small", Font.BOLD, 12));
		lblPerodo.setBounds(10, 11, 56, 14);
		contentPane.add(lblPerodo);
		
		JComboBox cbPeriodo = new JComboBox();
		cbPeriodo.setFont(new Font("Sitka Small", Font.BOLD, 12));
		cbPeriodo.setModel(new DefaultComboBoxModel(new String[] {"30 dias", "60 dias", "90 dias"}));
		cbPeriodo.setToolTipText("");
		cbPeriodo.setBounds(107, 8, 74, 20);
		contentPane.add(cbPeriodo);
		
		JList list = new JList();
		list.setBounds(10, 36, 524, 334);
		contentPane.add(list);
	}
}
