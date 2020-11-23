package view.Operacao;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import view.Main.Main;

import javax.swing.JButton;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class EmprestimosMenuT extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EmprestimosMenuT frame = new EmprestimosMenuT();
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
	public EmprestimosMenuT() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent arg0) {
				Main.menuPrincipal.show();
				dispose();
			}
		});
		setTitle("Menu Empr\u00E9stimos");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 470, 244);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 153, 255));
		panel.setBounds(10, 11, 434, 184);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnEmprstimosAtivos = new JButton("Empr\u00E9stimos Ativos");
		btnEmprstimosAtivos.setBounds(10, 101, 414, 72);
		panel.add(btnEmprstimosAtivos);
		
		JButton btnNewButton = new JButton("Pedir novo empr\u00E9stimo");
		btnNewButton.setBounds(10, 11, 414, 72);
		panel.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Main.telaEmprestimo.show();
				hide();
			}
		});
		btnEmprstimosAtivos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Main.emprestimosAtivos.show();
				hide();
			}
		});
	}
}
