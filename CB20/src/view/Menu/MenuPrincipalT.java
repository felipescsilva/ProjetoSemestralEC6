package view.Menu;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import view.Cartao.CartaoT;
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
				OpcoesT opcoes = new OpcoesT();
				opcoes.show();
			}
		});
		btnNome.setBounds(15, 25, 130, 40);
		
		JButton btnSaldo = new JButton("Saldo");
		btnSaldo.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {
				SaldoT saldo = new SaldoT();
				saldo.show();
			}
		});
		btnSaldo.setBounds(15, 145, 130, 100);
		
		JButton btnCarto = new JButton("Cart\u00E3o");
		btnCarto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							CartaoT cartaoT = new CartaoT();
							cartaoT.setVisible(true);
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
				TransferenciaT transferencia = new TransferenciaT();
				transferencia.show();
			}
		});
		btnTransferncia.setBounds(203, 25, 130, 160);
		
		JButton btnPagamento = new JButton("Pagamento");
		btnPagamento.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				PagamentoT pagamento = new PagamentoT();
				pagamento.show();
			}
		});
		btnPagamento.setBounds(203, 195, 130, 160);
		
		JButton btnDeposito = new JButton("Deposito");
		btnDeposito.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				DepositoT deposito = new DepositoT();
				deposito.show();
			}
		});
		btnDeposito.setBounds(379, 25, 130, 160);
		
		JButton btnEmprstimo = new JButton("Empr\u00E9stimo");
		btnEmprstimo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EmprestimoT emprestimo = new EmprestimoT();
				emprestimo.show();
			}
		});
		btnEmprstimo.setBounds(379, 195, 130, 160);
		
		JButton btnCmbio = new JButton("C\u00E2mbio");
		btnCmbio.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				CambioT cambio = new CambioT();
				cambio.show();
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
