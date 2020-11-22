package model.Emprestimo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import DAO.EmprestimoDAO;
import model.Juros.Juros;
import view.Main.Main;

public class Emprestimo {

	int idEmprestimo;
	String cpf;
	String numConta;
	LocalDate dataSolicitacao;
	float taxaJuros;
	LocalDate prazoPagamento;
	float valorTotal;
	int quantidadeParcelas;
	float valorParcelas;
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
	public String getTaxaJuros(int prazo) {
		return String.valueOf(getTaxaMes(prazo));
	}
	public float getTaxaJuros() {
		return taxaJuros;
	}
	public void setTaxaJuros(float taxaJuros) {
		this.taxaJuros = taxaJuros;
	}
	public LocalDate getPrazoPagamento() {
		return prazoPagamento;
	}
	public void setPrazoPagamento(LocalDate prazoPagamento) {
		this.prazoPagamento = prazoPagamento;
	}	
	public void setValorTotal(float valorTotal) {
		this.valorTotal = valorTotal;
	}
	public double getValorTotal() {		
		return valorTotal;
	}
	public int getQuantidadeParcelas() {
		return quantidadeParcelas;
	}
	public void setQuantidadeParcelas(int quantidadeParcelas) {
		this.quantidadeParcelas = quantidadeParcelas;
	}
	public float getValorParcelas() {
		return valorParcelas;
	}
	public void setValorParcelas(float valorParcelas) {
		this.valorParcelas = valorParcelas;
	}
	public String getSituacao() {
		return situacao;
	}
	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}
	
	public double getValorTotal(double valor, int prazo, float taxaMes) {		
		return valor * Math.pow(taxaMes + 1, prazo) * ((getIOF(prazo)/100) + 1);
	}
	
	public double getValorParcela(double valor, int prazo, float taxaMes)
	{		
		return getValorTotal(valor, prazo, taxaMes) / prazo;
	}
	
	public float getTaxaMes(int prazo)
	{		
		taxaJuros = Juros.getJurosEmprestimo(Main.cliente.getIdade(), Main.cliente.getFormacao(), Main.cliente.getProfissao(), 
				Main.cliente.getRenda(), prazo);
		return taxaJuros;
	}
	
	public LocalDate getPrimeiraParcela()
	{
		return LocalDate.now().plusMonths(1);
	}	
	
	public float getIOF(int prazo)
	{
		float iof = (float) (0.38 + (0.0082 * prazo * 30));
		if(iof > 3.38)
		{
			iof = (float) 3.38;
		}
		return iof;
	}
	
	public boolean novoEmprestimo(float taxaJuros, int quantidadeParcelas, float valorTotal, String situacao)
	{
		EmprestimoDAO emprestimoDAO = new EmprestimoDAO();
		List<Emprestimo> emprestimos = new ArrayList<Emprestimo>();
		emprestimos = emprestimoDAO.Consultar("NumConta", Main.conta.getNumeroConta());
		if(emprestimos.size() != 0)
		{
			return false;
		}
		setCpf(Main.cliente.getCPF());
		setNumConta(Main.conta.getNumeroConta());
		setDataSolicitacao(LocalDate.now());
		setTaxaJuros(taxaJuros);
		setPrazoPagamento(LocalDate.now().plusMonths(quantidadeParcelas));
		setValorTotal(valorTotal);
		setQuantidadeParcelas(quantidadeParcelas);
		setValorParcelas((float)getValorTotal() / quantidadeParcelas);
		setSituacao(situacao);	
		System.out.println("Chegou");
		emprestimoDAO.Inserir(this);
		return true;	
		
	}
}
