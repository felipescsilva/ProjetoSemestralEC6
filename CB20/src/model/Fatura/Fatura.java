package model.Fatura;

import java.time.LocalDate;

public class Fatura {
	private int idFatura;
	private String numCartao;
	private LocalDate DataVencimento;
	private double valor;
	private Situacao situacao;
	private double taxaJuros;
	public Fatura() {
		super();
	}
	
	public Fatura(int idFatura, String numCartao, LocalDate dataVencimento, double valor, Situacao situacao, double taxaJuros) {
		super();
		this.idFatura = idFatura;
		this.numCartao = numCartao;
		DataVencimento = dataVencimento;
		this.valor = valor;
		this.situacao = situacao;
		this.taxaJuros = taxaJuros;
	}

	public int getIdFatura() {
		return idFatura;
	}
	public void setIdFatura(int idFatura) {
		this.idFatura = idFatura;
	}
	public String getNumCartao() {
		return numCartao;
	}
	public void setNumCartao(String numCartao) {
		this.numCartao = numCartao;
	}
	public LocalDate getDataVencimento() {
		return DataVencimento;
	}
	public void setDataVencimento(LocalDate dataVencimento) {
		DataVencimento = dataVencimento;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	public Situacao getSituacao() {
		return situacao;
	}
	public void setSituacao(Situacao situacao) {
		this.situacao = situacao;
	}
	public double getTaxaJuros() {
		return taxaJuros;
	}
	public void setTaxaJuros(double taxaJuros) {
		this.taxaJuros = taxaJuros;
	}
	
}
