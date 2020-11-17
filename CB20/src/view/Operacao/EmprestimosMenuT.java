package view.Operacao;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

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
		setTitle("Menu Empr\u00E9stimos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Pedir novo empr\u00E9stimo");
		btnNewButton.setBounds(10, 11, 414, 72);
		contentPane.add(btnNewButton);
		
		JButton btnEmprstimosAtivos = new JButton("Empr\u00E9stimos Ativos");
		btnEmprstimosAtivos.setBounds(10, 94, 414, 67);
		contentPane.add(btnEmprstimosAtivos);
		
		JButton btnLimiteDisponvel = new JButton("Limite Dispon\u00EDvel");
		btnLimiteDisponvel.setBounds(10, 172, 414, 78);
		contentPane.add(btnLimiteDisponvel);
	}
}
