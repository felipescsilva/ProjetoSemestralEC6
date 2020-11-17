package model.Deposito;

import java.time.LocalDate;

public class Deposito {
	private int idDepositos;
	private String cpf;
	private String NumConta;
	private LocalDate DataTransacao;
	private double valor;
	public int getIdDepositos() {
		return idDepositos;
	}
	
	
	public Deposito() {
		super();
	}


	public Deposito(int idDepositos, String cpf, String numConta, LocalDate dataTransacao, double valor) {
		super();
		this.idDepositos = idDepositos;
		this.cpf = cpf;
		NumConta = numConta;
		DataTransacao = dataTransacao;
		this.valor = valor;
	}


	public void setIdDepositos(int idDepositos) {
		this.idDepositos = idDepositos;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getNumConta() {
		return NumConta;
	}
	public void setNumConta(String numConta) {
		NumConta = numConta;
	}
	public LocalDate getDataTransacao() {
		return DataTransacao;
	}
	public void setDataTransacao(LocalDate dataTransacao) {
		DataTransacao = dataTransacao;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	
	
}
