package helio.Telas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JPasswordField;

public class EmprestimoT extends JFrame {

	private JPanel contentPane;
	private JTextField txtLimite;
	private JTextField txtValor;
	private JTextField txtPrazo;
	private JTextField txtValorTotal;
	private JTextField txtValorParcela;
	private JTextField txtTaxa;
	private JTextField txtPrimeiraParcela;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EmprestimoT frame = new EmprestimoT();
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
	public EmprestimoT() {
		setTitle("Empr\u00E9stimo");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 560, 420);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblLimiteDisponvel = new JLabel("Limite Dispon\u00EDvel");
		lblLimiteDisponvel.setFont(new Font("Sitka Small", Font.BOLD, 12));
		lblLimiteDisponvel.setBounds(10, 11, 135, 14);
		contentPane.add(lblLimiteDisponvel);
		
		txtLimite = new JTextField();
		txtLimite.setText("Limite");
		txtLimite.setBounds(155, 7, 86, 20);
		contentPane.add(txtLimite);
		txtLimite.setColumns(10);
		
		JLabel lblValor = new JLabel("Valor");
		lblValor.setFont(new Font("Sitka Small", Font.BOLD, 12));
		lblValor.setBounds(161, 126, 46, 14);
		contentPane.add(lblValor);
		
		JLabel lblPrazo = new JLabel("Prazo(meses)");
		lblPrazo.setFont(new Font("Sitka Small", Font.BOLD, 12));
		lblPrazo.setBounds(111, 150, 96, 14);
		contentPane.add(lblPrazo);
		
		txtValor = new JTextField();
		txtValor.setText("Valor");
		txtValor.setBounds(219, 123, 86, 20);
		contentPane.add(txtValor);
		txtValor.setColumns(10);
		
		txtPrazo = new JTextField();
		txtPrazo.setText("Prazo");
		txtPrazo.setBounds(219, 147, 86, 20);
		contentPane.add(txtPrazo);
		txtPrazo.setColumns(10);
		
		JButton btnCalcular = new JButton("Calcular");
		btnCalcular.setBounds(216, 178, 89, 23);
		contentPane.add(btnCalcular);
		
		JLabel lblValorTotal = new JLabel("Valor Total");
		lblValorTotal.setFont(new Font("Sitka Small", Font.BOLD, 12));
		lblValorTotal.setBounds(135, 217, 72, 14);
		contentPane.add(lblValorTotal);
		
		JLabel lblValorParcela = new JLabel("Valor Parcela");
		lblValorParcela.setFont(new Font("Sitka Small", Font.BOLD, 12));
		lblValorParcela.setBounds(121, 242, 86, 14);
		contentPane.add(lblValorParcela);
		
		JLabel lblTaxaAoMs = new JLabel("Taxa ao m\u00EAs");
		lblTaxaAoMs.setFont(new Font("Sitka Small", Font.BOLD, 12));
		lblTaxaAoMs.setBounds(128, 267, 79, 14);
		contentPane.add(lblTaxaAoMs);
		
		txtValorTotal = new JTextField();
		txtValorTotal.setText("Valor Total");
		txtValorTotal.setBounds(219, 214, 106, 20);
		contentPane.add(txtValorTotal);
		txtValorTotal.setColumns(10);
		
		txtValorParcela = new JTextField();
		txtValorParcela.setText("Valor Parcela");
		txtValorParcela.setBounds(219, 239, 106, 20);
		contentPane.add(txtValorParcela);
		txtValorParcela.setColumns(10);
		
		txtTaxa = new JTextField();
		txtTaxa.setText("Taxa");
		txtTaxa.setBounds(219, 264, 106, 20);
		contentPane.add(txtTaxa);
		txtTaxa.setColumns(10);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setFont(new Font("Sitka Small", Font.BOLD, 12));
		lblSenha.setBounds(169, 292, 38, 14);
		contentPane.add(lblSenha);
		
		JButton btnSolicitar = new JButton("Solicitar");
		btnSolicitar.setBounds(219, 347, 89, 23);
		contentPane.add(btnSolicitar);
		
		JButton btnEmprstimosAtivos = new JButton("Empr\u00E9stimos Ativos");
		btnEmprstimosAtivos.setFont(new Font("Sitka Small", Font.BOLD, 12));
		btnEmprstimosAtivos.setBounds(347, 6, 187, 23);
		contentPane.add(btnEmprstimosAtivos);
		
		JLabel lblPrimeiraParcela = new JLabel("Primeira Parcela");
		lblPrimeiraParcela.setFont(new Font("Sitka Small", Font.BOLD, 12));
		lblPrimeiraParcela.setBounds(101, 317, 106, 14);
		contentPane.add(lblPrimeiraParcela);
		
		txtPrimeiraParcela = new JTextField();
		txtPrimeiraParcela.setText("Primeira Parcela");
		txtPrimeiraParcela.setBounds(219, 314, 106, 20);
		contentPane.add(txtPrimeiraParcela);
		txtPrimeiraParcela.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setText("111111");
		passwordField.setBounds(219, 288, 106, 20);
		contentPane.add(passwordField);
	}

}
