package model.Deposito;

import java.time.LocalDate;
import java.util.List;
import java.util.Random;

import DAO.CartaoDAO;
import model.Cartao.Cartao;

public class Deposito {
	private int idDepositos;
	private String cpf;
	private String NumConta;
	private LocalDate DataTransacao;
	private String linhaDigitavel;
	private double valor;
	public int getIdDepositos() {
		return idDepositos;
	}
	
	
	public Deposito() {
		super();
	}

	public String getLinhaDigitavel() {
		return linhaDigitavel;
	}


	public void setLinhaDigitavel(String linhaDigitavel) {
		this.linhaDigitavel = linhaDigitavel;
	}


	public Deposito(int idDepositos, String cpf, String numConta, LocalDate dataTransacao, String linhaDigitavel,
			double valor) {
		super();
		this.idDepositos = idDepositos;
		this.cpf = cpf;
		NumConta = numConta;
		DataTransacao = dataTransacao;
		this.linhaDigitavel = linhaDigitavel;
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
	
	public String geraLinhaDigitavel() {
		boolean jaExiste = false;
		String num = "";
		do {
			num = "";
			Random rand = new Random();
			for (int i = 0; i < 2; i++) {
				int sequencia = rand.nextInt(9999);
				num += String.format("%04d", sequencia);
			}
			try {
				CartaoDAO dao = new CartaoDAO();
				List<Cartao> lista = dao.Consultar("NumCartao", num);
				if (lista.size() != 0)
					jaExiste = true;
				else
					jaExiste = false;
				
			} catch (Exception e) {
				System.out.println(e.toString());
			}
		} while(jaExiste);
		
		return num;
	}
	
}
