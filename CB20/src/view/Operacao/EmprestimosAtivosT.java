package view.Operacao;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DAO.ContaDAO;
import DAO.EmprestimoDAO;
import DAO.FaturaEmprestimoDAO;
import model.Banco.Banco;
import model.Emprestimo.Emprestimo;
import model.Fatura.FaturaEmprestimo;
import model.Fatura.Situacao;
import view.Main.Main;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.Color;

public class EmprestimosAtivosT extends JFrame {

	private JPanel contentPane;
	private JList listaFaturas;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EmprestimosAtivosT frame = new EmprestimosAtivosT();
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
	public EmprestimosAtivosT() {
		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent arg0) {
				listaFaturas.requestFocusInWindow();				
			}
		});
		setTitle("Empr\u00E9stimos Ativos");
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent arg0) {
				Main.emprestimosMenu.show();
				dispose();
			}
		});
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 370);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 153, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		listaFaturas = new JList();
		listaFaturas.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				EmprestimoDAO emprestimoDAO = new EmprestimoDAO();
				FaturaEmprestimoDAO faturaEmprestimoDAO = new FaturaEmprestimoDAO();
				List<FaturaEmprestimo> faturas = new ArrayList<FaturaEmprestimo>();
				List<Emprestimo> emprestimos = emprestimoDAO.Consultar("NumConta", Main.conta.getNumeroConta());
				if(emprestimos.size() < 1)
				{
					List<String> lista = new ArrayList<String>();
					listaFaturas.setListData(lista.toArray());
					return;
				}
				Emprestimo emprestimo = emprestimos.get(0);
				try {
					faturas = faturaEmprestimoDAO.Consultar("idEmprestimo", String.valueOf(emprestimo.getIdEmprestimo()));
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				List<String> descricao = new ArrayList<String>();
				for(FaturaEmprestimo fatura : faturas)
				{
					if(fatura.getDataVencimento().isBefore(LocalDate.now()))
					{
						fatura.setDescricao(Situacao.VENCEU.toString());
						fatura.setValor(emprestimo.getValorParcelas() * (emprestimo.getTaxaJurosAtraso() + 1));
					}
					descricao.add("Valor: " + fatura.getValor() + " Vencimento: " + fatura.getDataVencimento() + " Descrição: " + fatura.getDescricao());
				}
				listaFaturas.setListData(descricao.toArray());
				for(FaturaEmprestimo fatura : faturas)
				{
					faturaEmprestimoDAO.Atualizar(fatura);
				}
			}
		});
		listaFaturas.setBounds(10, 11, 414, 239);
		contentPane.add(listaFaturas);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setFont(new Font("Sitka Small", Font.BOLD, 12));
		lblSenha.setBounds(142, 264, 46, 14);
		contentPane.add(lblSenha);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(198, 261, 81, 18);
		contentPane.add(passwordField);
		
		JButton btnPagar = new JButton("Pagar");
		btnPagar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFrame f = new JFrame();
				if(passwordField.getText().equals(Main.conta.getSenhaConta()))
				{
					int posicao = listaFaturas.getSelectedIndex();
					if(posicao < 0)
					{
						JOptionPane.showMessageDialog(f, "Selecione uma fatura!" , "Erro!", JOptionPane.ERROR_MESSAGE);
						return;
					}
					EmprestimoDAO emprestimoDAO = new EmprestimoDAO();
					FaturaEmprestimoDAO faturaEmprestimoDAO = new FaturaEmprestimoDAO();
					FaturaEmprestimo fatura = new FaturaEmprestimo();
					Emprestimo emprestimo = emprestimoDAO.Consultar("NumConta", Main.conta.getNumeroConta()).get(0);
					try {
						fatura = faturaEmprestimoDAO.Consultar("idEmprestimo", String.valueOf(emprestimo.getIdEmprestimo())).get(posicao);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					if(Main.conta.getSaldo() >= fatura.getValor())
					{
						Main.conta.setSaldo(Main.conta.getSaldo() - fatura.getValor());
						ContaDAO contaDAO = new ContaDAO();
						contaDAO.Atualizar(Main.conta);
						Banco banco = new Banco();
						banco = Main.bancoDAO.Consultar().get(0);
						banco.setFaturamento(banco.getFaturamento() + (fatura.getValor() * (fatura.getTaxaJuros() / 100) + (fatura.getValor() - emprestimo.getValorParcelas())));
						banco.setImpostos(banco.getImpostos() + (fatura.getValor() * (emprestimo.getIOF() / 100)));
						Main.bancoDAO.Atualizar(banco);
						faturaEmprestimoDAO.Remover(String.valueOf(fatura.getIdFatEmp()));
						try {
							if(faturaEmprestimoDAO.Consultar("idEmprestimo", String.valueOf(emprestimo.getIdEmprestimo())).size() < 1)
							{								
								emprestimoDAO.Remover(String.valueOf(emprestimo.getIdEmprestimo()));
							}
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						JOptionPane.showMessageDialog(f, "Fatura paga com sucesso!" , "Atenção!", JOptionPane.INFORMATION_MESSAGE);	
						
						listaFaturas.requestFocusInWindow();
					}
					else
					{
						JOptionPane.showMessageDialog(f, "Saldo insuficiente!" , "Erro!", JOptionPane.ERROR_MESSAGE);
					}
				}
				else
				{
					JOptionPane.showMessageDialog(f, "Senha incorreta!" , "Erro!", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnPagar.setBounds(152, 289, 89, 23);
		contentPane.add(btnPagar);
	}
}
