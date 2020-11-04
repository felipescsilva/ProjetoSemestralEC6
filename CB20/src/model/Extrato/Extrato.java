package model.Extrato;

import java.time.LocalDate;

public class Extrato {
	private int idExtrato;
	private String numConta;
	private double valor;
	private LocalDate dataTransacao;
	public int getIdExtrato() {
		return idExtrato;
	}
	public void setIdExtrato(int idExtrato) {
		this.idExtrato = idExtrato;
	}
	public String getNumConta() {
		return numConta;
	}
	public void setNumConta(String numConta) {
		this.numConta = numConta;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	public LocalDate getDataTransacao() {
		return dataTransacao;
	}
	public void setDataTransacao(LocalDate dataTransacao) {
		this.dataTransacao = dataTransacao;
	}
	public Extrato(int idExtrato, String numConta, double valor, LocalDate dataTransacao) {
		super();
		this.idExtrato = idExtrato;
		this.numConta = numConta;
		this.valor = valor;
		this.dataTransacao = dataTransacao;
	}
	public Extrato() {
		super();
	}
	
	
}
