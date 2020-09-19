package model.Cartao;

import java.time.LocalDate;

public class Cartao {
	
	public Cartao() {
		
	}
	
	public Cartao(String numeroCartao, String numeroConta, Tipo tipo, LocalDate dataValidade, Moeda moeda, double limiteTotal, String cvv) {
		super();
		this.numeroCartao = numeroCartao;
		this.numeroConta = numeroConta;
		this.tipo = tipo;
		this.dataValidade = dataValidade;
		this.moeda = moeda;
		this.saldo = 0;
		switch (tipo) {
			case DEBITO:
			case PRE_PAGO:
				this.limiteTotal = 0;
				break;
			case CREDITO:
				this.limiteTotal = limiteTotal;
		}
		this.limiteUsado = 0;
		this.bloqueado = Bloqueado.DESBLOQUEADO;
		this.motivoBloqueio = Motivo.DESBLOQUEADO;
		this.cvv = cvv;
	}
	private String numeroCartao;
	private String numeroConta;
	private Tipo tipo;
	private LocalDate dataValidade;
	private Moeda moeda;
	private double saldo;
	private double limiteTotal;
	private double limiteUsado;
	private Bloqueado bloqueado;
	private Motivo motivoBloqueio;
	private String cvv;
	
	public Tipo getTipo() {
		return tipo;
	}
	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}
	public String getNumeroCartao() {
		return numeroCartao;
	}
	public void setNumeroCartao(String numeroCartao) {
		this.numeroCartao = numeroCartao;
	}
	public String getNumeroConta() {
		return numeroConta;
	}
	public void setNumeroConta(String numeroConta) {
		this.numeroConta = numeroConta;
	}
	public LocalDate getDataValidade() {
		return dataValidade;
	}
	public void setDataValidade(LocalDate dataValidade) {
		this.dataValidade = dataValidade;
	}
	public Moeda getMoeda() {
		return moeda;
	}
	public void setMoeda(Moeda moeda) {
		this.moeda = moeda;
	}
	public double getSaldo() {
		return saldo;
	}
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	public double getLimiteTotal() {
		return limiteTotal;
	}
	public void setLimiteTotal(double limiteTotal) {
		this.limiteTotal = limiteTotal;
	}
	public double getLimiteUsado() {
		return limiteUsado;
	}
	public void setLimiteUsado(double limiteUsado) {
		this.limiteUsado = limiteUsado;
	}
	public Bloqueado getBloqueado() {
		return bloqueado;
	}
	public void setBloqueado(Bloqueado bloqueado) {
		this.bloqueado = bloqueado;
	}
	public Motivo getMotivoBloqueio() {
		return motivoBloqueio;
	}
	public void setMotivoBloqueio(Motivo motivoBloqueio) {
		this.motivoBloqueio = motivoBloqueio;
	}
	public String getCvv() {
		return cvv;
	}
	public void setCvv(String cvv) {
		this.cvv = cvv;
	}
	
	public boolean verificaValidade () {
		if (this.dataValidade.isBefore(LocalDate.now()))
			return false;
		return true;
	}
	
	
}
