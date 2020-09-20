package helio.contacorrente;
import helio.Cliente.Cliente;
import helio.metodos.Metodos;

public class Conta {
	
		
	private int numeroConta;
	private int numeroAgencia;	
	private double saldo;
	private String senhaApp;
	private String senhaConta;
	private Cliente cliente;
	
	public Conta(int numeroConta, int numeroAgencia, double saldo, String senhaApp, String senhaConta, Cliente cliente) 
	{
		this.setNumeroConta(numeroConta);
		this.setNumeroAgencia(numeroAgencia);
		this.setSaldo(saldo);
		this.setSenhaApp(senhaApp);
		this.setSenhaConta(senhaConta);
		this.setCliente(cliente);
	}

	public int getNumeroConta() {
		return numeroConta;
	}

	private void setNumeroConta(int numeroConta) {
		this.numeroConta = numeroConta;
	}

	public int getNumeroAgencia() {
		return numeroAgencia;
	}

	private void setNumeroAgencia(int numeroAgencia) {
		this.numeroAgencia = numeroAgencia;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public String getSenhaApp() {
		return senhaApp;
	}

	public void setSenhaApp(String senhaApp) {
		this.senhaApp = senhaApp;
	}

	public String getSenhaConta() {
		return senhaConta;
	}

	public void setSenhaConta(String senhaConta) {
		this.senhaConta = senhaConta;
	}

	public Cliente getCliente() {
		return cliente;
	}

	private void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
}
