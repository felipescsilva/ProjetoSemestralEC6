package view.Cartao;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CartaoT extends JFrame {

	/**
	 * Launch the application.
	 */
	/*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cartao frame = new Cartao();
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
	public CartaoT() {
		setResizable(false);
		setTitle("Cart\u00E3o");
		getContentPane().setEnabled(false);
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("Visualizar Cart\u00F5es Ativos");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							VerCartoesAtivosT frame = new VerCartoesAtivosT();
							frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		btnNewButton.setFont(new Font("Sitka Small", Font.BOLD, 12));
		btnNewButton.setBounds(10, 11, 524, 42);
		panel.add(btnNewButton);
		
		JButton btnSolicitarNovoCarto = new JButton("Solicitar Novo Cart\u00E3o");
		btnSolicitarNovoCarto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							SolicitarCartaoT frame = new SolicitarCartaoT();
							frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		btnSolicitarNovoCarto.setFont(new Font("Sitka Small", Font.BOLD, 12));
		btnSolicitarNovoCarto.setBounds(10, 64, 524, 42);
		panel.add(btnSolicitarNovoCarto);
		
		JButton btnNewButton_1_1 = new JButton("Ver Faturas");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							VerFaturasT frame = new VerFaturasT();
							frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		btnNewButton_1_1.setFont(new Font("Sitka Small", Font.BOLD, 12));
		btnNewButton_1_1.setBounds(10, 117, 524, 42);
		panel.add(btnNewButton_1_1);
		
		JButton btnNewButton_1_2 = new JButton("Solicitar Bloqueio do Cart\u00E3o");
		btnNewButton_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							SolicitarBloqueioT frame = new SolicitarBloqueioT();
							frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		btnNewButton_1_2.setFont(new Font("Sitka Small", Font.BOLD, 12));
		btnNewButton_1_2.setBounds(10, 170, 524, 42);
		panel.add(btnNewButton_1_2);
		
		JButton btnNewButton_1_2_1 = new JButton("Realizar Compra");
		btnNewButton_1_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							RealizarCompraT frame = new RealizarCompraT();
							frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		btnNewButton_1_2_1.setFont(new Font("Sitka Small", Font.BOLD, 12));
		btnNewButton_1_2_1.setBounds(10, 328, 524, 42);
		panel.add(btnNewButton_1_2_1);
		
		JButton btnNewButton_1_2_1_1 = new JButton("Solicitar Desbloqueio do Cart\u00E3o");
		btnNewButton_1_2_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							SolicitarDesbloqueioT frame = new SolicitarDesbloqueioT();
							frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		btnNewButton_1_2_1_1.setFont(new Font("Sitka Small", Font.BOLD, 12));
		btnNewButton_1_2_1_1.setBounds(10, 223, 524, 42);
		panel.add(btnNewButton_1_2_1_1);
		
		JButton btnNewButton_1_2_1_2 = new JButton("Solicitar Cancelamento do Cart\u00E3o");
		btnNewButton_1_2_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							SolicitarCancelamentoT frame = new SolicitarCancelamentoT();
							frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		btnNewButton_1_2_1_2.setFont(new Font("Sitka Small", Font.BOLD, 12));
		btnNewButton_1_2_1_2.setBounds(10, 276, 524, 42);
		panel.add(btnNewButton_1_2_1_2);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 560, 420);
	}
}
