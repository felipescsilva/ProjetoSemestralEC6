package model.Conta;

import java.time.LocalDate;

import model.Cartao.Motivo;

public class Conta {
	private String numeroConta;
	private String CPF;
	private double saldo;
	public String getSenhaConta() {
		return senhaConta;
	}

	public void setSenhaConta(String senhaConta) {
		this.senhaConta = senhaConta;
	}

	public String getSenhaApp() {
		return senhaApp;
	}

	public void setSenhaApp(String senhaApp) {
		this.senhaApp = senhaApp;
	}

	private LocalDate dataAbertura;
	private String senhaConta;
	private String senhaApp;
	
	public Conta() {
		super();
	}

	public Conta(String numeroConta, String cPF, String senhaConta, String senhaApp) {
		super();
		this.numeroConta = numeroConta;
		CPF = cPF;
		this.saldo = 0;
		this.dataAbertura = LocalDate.now();
		this.senhaConta = senhaConta;
		this.senhaApp = senhaApp;
	}

	public String getNumeroConta() {
		return numeroConta;
	}

	public void setNumeroConta(String numeroConta) {
		this.numeroConta = numeroConta;
	}

	public String getCPF() {
		return CPF;
	}

	public void setCPF(String cPF) {
		CPF = cPF;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public LocalDate getDataAbertura() {
		return dataAbertura;
	}

	public void setDataAbertura(LocalDate dataAbertura) {
		this.dataAbertura = dataAbertura;
	}

	public boolean DesbloquearCartao(String numeroCartao, String senha){
		return true;
	}
	
	public boolean PedirBloqueioCartao(String numeroCartao, String senha, Motivo motivoBloqueio) {
		return true;
	}
	
	public boolean PedirNovoCartao(boolean creditoHabilitado, String senha) {
		return true;
	}
	
	public boolean pagarFatura(String numCartao) {
		return true;
	}
}
