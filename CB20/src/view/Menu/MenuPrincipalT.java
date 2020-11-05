package view.Menu;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import view.Cartao.CartaoT;
import view.Main.Main;
import view.Opcoes.OpcoesT;
import view.Operacao.CambioT;
import view.Operacao.DepositoT;
import view.Operacao.EmprestimoT;
import view.Operacao.PagamentoT;
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

public class MenuPrincipalT extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuPrincipalT frame = new MenuPrincipalT();
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
	public MenuPrincipalT() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent arg0) {
				Main.telaLogin.show();
				dispose();
			}
		});
		setTitle("Menu");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 560, 420);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JButton btnNome = new JButton("Op\u00E7\u00F5es");
		btnNome.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {				
				Main.opcoes.show();
				hide();
			}
		});
		btnNome.setBounds(15, 25, 130, 40);
		
		JButton btnSaldo = new JButton("Saldo");
		btnSaldo.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {				
				Main.saldo.show();
				hide();
			}
		});
		btnSaldo.setBounds(15, 145, 130, 100);
		
		JButton btnCarto = new JButton("Cart\u00E3o");
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
		btnCarto.setBounds(15, 265, 130, 100);
		
		JButton btnTransferncia = new JButton("Transfer\u00EAncia");
		btnTransferncia.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {				
				Main.transferencia.show();
				hide();
			}
		});
		btnTransferncia.setBounds(203, 25, 130, 160);
		
		JButton btnPagamento = new JButton("Pagamento");
		btnPagamento.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {				
				Main.pagamento.show();
				hide();
			}
		});
		btnPagamento.setBounds(203, 195, 130, 160);
		
		JButton btnDeposito = new JButton("Deposito");
		btnDeposito.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {				
				Main.deposito.show();
				hide();
			}
		});
		btnDeposito.setBounds(379, 25, 130, 160);
		
		JButton btnEmprstimo = new JButton("Empr\u00E9stimo");
		btnEmprstimo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
				Main.emprestimo.show();
				hide();
			}
		});
		btnEmprstimo.setBounds(379, 195, 130, 160);
		
		JButton btnCmbio = new JButton("C\u00E2mbio");
		btnCmbio.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {				
				Main.cambio.show();
				hide();
			}
		});
		btnCmbio.setBounds(15, 85, 130, 40);
		contentPane.setLayout(null);
		contentPane.add(btnCarto);
		contentPane.add(btnNome);
		contentPane.add(btnSaldo);
		contentPane.add(btnCmbio);
		contentPane.add(btnTransferncia);
		contentPane.add(btnPagamento);
		contentPane.add(btnDeposito);
		contentPane.add(btnEmprstimo);
	}
}
