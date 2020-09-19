package model.Conta;

import java.time.LocalDate;

import model.Cartao.Motivo;

public class Conta {
	private String numeroConta;
	private String CPF;
	private double saldo;
	private LocalDate dataAbertura;
	private String senha;
	
	public Conta() {
		super();
	}

	public Conta(String numeroConta, String cPF, String senha) {
		super();
		this.numeroConta = numeroConta;
		CPF = cPF;
		this.saldo = 0;
		this.dataAbertura = LocalDate.now();
		this.senha = senha;
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

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
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
}
