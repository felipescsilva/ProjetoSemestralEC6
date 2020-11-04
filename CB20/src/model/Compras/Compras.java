package model.Compras;

import java.time.LocalDate;

public class Compras {
	private int idCompras;
	private String numCartao;
	private String descricao;
	private double valor;
	private LocalDate Data;
	
	public int getIdCompras() {
		return idCompras;
	}
	public void setIdCompras(int idCompras) {
		this.idCompras = idCompras;
	}
	public String getNumCartao() {
		return numCartao;
	}
	public void setNumCartao(String numCartao) {
		this.numCartao = numCartao;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	public LocalDate getData() {
		return Data;
	}
	public void setData(LocalDate data) {
		Data = data;
	}
	public Compras() {
		super();
	}
	public Compras(int idCompras, String numCartao, String descricao, double valor, LocalDate data) {
		super();
		this.idCompras = idCompras;
		this.numCartao = numCartao;
		this.descricao = descricao;
		this.valor = valor;
		Data = data;
	}
	
	
}
