package model.Helio.contacorrente;

import model.Helio.Cliente.Cliente;

public class Login {
	
	boolean logado = false;
	Conta conta;
	private int numeroConta;
	private int numeroAgencia;	
	private double saldo;
	private String senhaApp;
	private String senhaConta;
	private Cliente cliente;
	public Login() {		
		
	}
	
	public boolean signIn(int numeroConta, int numeroAgencia, String senha) {
		if(checkLogin(numeroConta, numeroAgencia, senha) == true) {
			//pegar os dados do BD
			logado = true;
			conta = new Conta(numeroConta, numeroAgencia, saldo, senhaApp, senhaConta, cliente);
			return true;
		}
		return false;
	}
	
	public boolean checkLogin(int numeroConta, int numeroAgencia, String senha) {
		//verifica dados no banco
		return true;
		
	}
	
	public Cliente criaCliente() {
		
		return cliente;
	}
	
	
	

}
