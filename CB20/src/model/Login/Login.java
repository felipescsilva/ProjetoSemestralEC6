package model.Login;

import java.util.List;

import Audit.Audit;
import DAO.ClienteDAO;
import DAO.ContaDAO;
import model.Cliente.Cliente;
import model.Conta.Conta;
import view.Main.Main;

public class Login {
	
	boolean logado = false;
	private int numeroConta;
	private int numeroAgencia;	
	private double saldo;
	private String senhaApp;
	private String senhaConta;
	private String cpf;
	public Login() {		
		
	}
	
	public boolean signIn(String numeroConta, String senha) {
		if(checkLogin(numeroConta, senha) == true) {
			ClienteDAO clienteDAO = new ClienteDAO();
			List<Cliente> listaCliente = clienteDAO.Consultar("CPF", Main.conta.getCPF());
			Main.cliente = listaCliente.get(0);			
			return true;
		}
		return false;
	}
	
	public boolean checkLogin(String numeroConta, String senha) {
		ContaDAO contaDAO = new ContaDAO();		
		try {
			List<Conta> listaConta = contaDAO.Consultar("NumConta", numeroConta);
			Main.auditoria.getInstancia().gerarRelatorio("conta localizada com sucesso");
			if (listaConta.size() == 0)
				return false;
			else {
				Main.conta = listaConta.get(0);
				if (Main.conta.getSenhaApp().equals(senha))
					return true;
				else
					return false;
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
	}
	

	
	

}
