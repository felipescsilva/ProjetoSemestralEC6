package model.Transferencia;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import DAO.ClienteDAO;
import DAO.ContaDAO;
import model.Cliente.Cliente;
import model.Conta.Conta;

public class Transferencia {
	private int idTransferencia;
	private String cpf;
	private String contaOrigem;
	private String contaDestino;
	private double valor;
	private LocalDate dataTransacao;
	public Transferencia(int idTransferencia, String cpf, String contaOrigem, String contaDestino, double valor,
			LocalDate dataTransacao) {
		super();
		this.idTransferencia = idTransferencia;
		this.cpf = cpf;
		this.contaOrigem = contaOrigem;
		this.contaDestino = contaDestino;
		this.valor = valor;
		this.dataTransacao = dataTransacao;
	}
	public Transferencia() {
		super();
	}
	public int getIdTransferencia() {
		return idTransferencia;
	}
	public void setIdTransferencia(int idTransferencia) {
		this.idTransferencia = idTransferencia;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getContaOrigem() {
		return contaOrigem;
	}
	public void setContaOrigem(String contaOrigem) {
		this.contaOrigem = contaOrigem;
	}
	public String getContaDestino() {
		return contaDestino;
	}
	public void setContaDestino(String contaDestino) {
		this.contaDestino = contaDestino;
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
	
	public List<Conta> getDadosContaTransacao() {
		ContaDAO dao = new ContaDAO();
		List<Conta> conta = new ArrayList<Conta>();
		try {
			conta = dao.Consultar("NumConta", this.getContaDestino());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conta;
	}
}
