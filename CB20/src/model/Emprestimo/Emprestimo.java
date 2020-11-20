package model.Emprestimo;

import java.time.LocalDate;

import model.Juros.Juros;
import view.Main.Main;

public class Emprestimo {

	int idEmprestimo;
	String cpf;
	String numConta;
	LocalDate dataSolicitacao;
	//String taxaJuros;
	LocalDate prazoPagamento;
	//float valorTotal;
	int quantidadeParcelas;
	//float valorParcelas;
	String situacao;
	
	public int getIdEmprestimo() {
		return idEmprestimo;
	}
	public void setIdEmprestimo(int idEmprestimo) {
		this.idEmprestimo = idEmprestimo;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getNumConta() {
		return numConta;
	}
	public void setNumConta(String numConta) {
		this.numConta = numConta;
	}
	public LocalDate getDataSolicitacao() {
		return dataSolicitacao;
	}
	public void setDataSolicitacao(LocalDate dataSolicitacao) {
		this.dataSolicitacao = dataSolicitacao;
	}
	//public String getTaxaJuros() {
	//	return taxaJuros;
	//}
	//public void setTaxaJuros(String taxaJuros) {
	//	this.taxaJuros = taxaJuros;
	//}
	public LocalDate getPrazoPagamento() {
		return prazoPagamento;
	}
	public void setPrazoPagamento(LocalDate prazoPagamento) {
		this.prazoPagamento = prazoPagamento;
	}
	
	//public void setValorTotal(float valorTotal) {
	//	this.valorTotal = valorTotal;
	//}
	public int getQuantidadeParcelas() {
		return quantidadeParcelas;
	}
	public void setQuantidadeParcelas(int quantidadeParcelas) {
		this.quantidadeParcelas = quantidadeParcelas;
	}
	//public float getValorParcelas() {
	//	return valorParcelas;
	//}
	//public void setValorParcelas(float valorParcelas) {
	//	this.valorParcelas = valorParcelas;
	//}
	public String getSituacao() {
		return situacao;
	}
	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}
	
	public double getValorTotal(double valor, int prazo, float taxaMes) {		
		return valor * Math.pow(taxaMes + 1, prazo);
	}
	
	public double getValorParcela(double valor, int prazo, float taxaMes)
	{		
		return getValorTotal(valor, prazo, taxaMes) / prazo;
	}
	
	public float getTaxaMes(int prazo)
	{		
		return Juros.getJurosEmprestimo(Main.cliente.getIdade(), Main.cliente.getFormacao(), Main.cliente.getProfissao(), 
				Main.cliente.getRenda(), prazo);
	}
	
	public LocalDate getPrimeiraParcela()
	{
		return LocalDate.now().plusMonths(1);
	}
}
