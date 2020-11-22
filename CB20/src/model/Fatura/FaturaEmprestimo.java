package model.Fatura;

import java.time.LocalDate;

public class FaturaEmprestimo {

	int idFatEmp;
	int idEmprestimo;
	LocalDate dataVencimento;
	float valor;
	String descricao;
	float taxaJuros;
	
	public int getIdFatEmp() {
		return idFatEmp;
	}
	public void setIdFatEmp(int idFatEmp) {
		this.idFatEmp = idFatEmp;
	}
	public int getIdEmprestimo() {
		return idEmprestimo;
	}
	public void setIdEmprestimo(int idEmprestimo) {
		this.idEmprestimo = idEmprestimo;
	}
	public LocalDate getDataVencimento() {
		return dataVencimento;
	}
	public void setDataVencimento(LocalDate dataVencimento) {
		this.dataVencimento = dataVencimento;
	}
	public float getValor() {
		return valor;
	}
	public void setValor(float valor) {
		this.valor = valor;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public float getTaxaJuros() {
		return taxaJuros;
	}
	public void setTaxaJuros(float taxaJuros) {
		this.taxaJuros = taxaJuros;
	}
	
}
