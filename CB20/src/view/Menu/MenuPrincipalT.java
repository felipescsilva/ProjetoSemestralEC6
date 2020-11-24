package view.Menu;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import view.Cartao.CartaoT;
import view.Main.Main;
import view.Operacao.CambioT;
import view.Operacao.DepositoT;
import view.Operacao.SolicitarEmprestimoT;
import view.Operacao.SaldoT;
import view.Operacao.TransferenciaT;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.Color;

public class MenuPrincipalT extends JFrame {

	private JPanel contentPane;
	public JButton btnNome = new JButton("Op\u00E7\u00F5es");

	/**
	 * Launch the application.
	 */
	/**
	 * Create the frame.
	 */
	public MenuPrincipalT() {
		setResizable(false);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent arg0) {
				if (Main.conta.getNumeroConta().equals("5469"))
					Main.opcoesAdmin.show();
				else
					Main.telaLogin.show();
				dispose();
			}
		});
		setTitle("Menu");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 550, 409);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 153, 255));
		panel.setBounds(10, 11, 524, 359);
		contentPane.add(panel);
		panel.setLayout(null);
		btnNome.setBounds(10, 11, 130, 104);
		panel.add(btnNome);
		
		JButton btnCmbio = new JButton("C\u00E2mbio");
		btnCmbio.setBounds(196, 189, 130, 157);
		panel.add(btnCmbio);
		
		JButton btnSaldo = new JButton("Saldo");
		btnSaldo.setBounds(10, 131, 130, 100);
		panel.add(btnSaldo);
		
		JButton btnCarto = new JButton("Cart\u00E3o");
		btnCarto.setBounds(10, 248, 130, 100);
		panel.add(btnCarto);
		
		JButton btnTransferncia = new JButton("Transfer\u00EAncia");
		btnTransferncia.setBounds(198, 11, 130, 160);
		panel.add(btnTransferncia);
		
		JButton btnDeposito = new JButton("Deposito");
		btnDeposito.setBounds(384, 11, 130, 160);
		panel.add(btnDeposito);
		
		JButton btnEmprstimo = new JButton("Empr\u00E9stimo");
		btnEmprstimo.setBounds(384, 188, 130, 160);
		panel.add(btnEmprstimo);
		btnEmprstimo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
				Main.emprestimosMenu.show();
				hide();
			}
		});
		btnDeposito.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {				
				Main.deposito.show();
				hide();
			}
		});
		btnTransferncia.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {				
				Main.transferencia.show();
				hide();
			}
		});
		btnCarto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							Main.cartaoT.setVisible(true);
							hide();
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		btnSaldo.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {				
				Main.saldo.show();
				hide();
			}
		});
		btnCmbio.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {				
				Main.cambio.show();
				hide();
			}
		});
		
		//btnNome.setText("Seja Bem-Vindo " + Main.cliente.getNome());
		btnNome.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {				
				Main.opcoes.show();
				hide();
			}
		});
	}
}
