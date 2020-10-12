package model.Login;

import java.util.List;

import DAO.ContaDAO;
import model.Cliente.Cliente;
import model.Conta.Conta;

public class Login {
	
	boolean logado = false;
	Conta conta;
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
			//pegar os dados do BD
			logado = true;
			//conta = new Conta(numeroConta, numeroAgencia, saldo, senhaApp, senhaConta);
			return true;
		}
		return false;
	}
	
	public boolean checkLogin(String numeroConta, String senha) {
		ContaDAO contaDAO = new ContaDAO();
		try {
			List<Conta> listaConta = contaDAO.Consultar("NumConta", numeroConta);
			if (listaConta.size() == 0)
				return false;
			else {
				Conta conta = listaConta.get(0);
				if (conta.getSenhaApp().equals(senha))
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
	
	public void criaCliente() {
		
		//return cliente;
	}
	
	
	

}
