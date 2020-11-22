package model.Cartao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import DAO.CartaoDAO;
import DAO.ContaDAO;
import DAO.FaturaDAO;
import model.Cambio.Moeda;
import model.Compras.Compras;
import model.Fatura.Fatura;
import model.Fatura.Situacao;

public class Cartao {
	
	public Cartao() {
		
	}
	
	public Cartao(String numeroConta, Tipo tipo, Moeda moeda, double limiteTotal) {
		super();
		this.numeroCartao = geraNumCartao();
		this.numeroConta = numeroConta;
		this.tipo = tipo;
		this.dataValidade = LocalDate.now().plusYears(4);
		this.moeda = moeda;
		this.saldo = 0;
		switch (tipo) {
			case DÉBITO:
			case PRÉ_PAGO:
				this.limiteTotal = 0;
				break;
			case CRÉDITO:
				this.limiteTotal = limiteTotal;
		}
		this.limiteUsado = 0;
		this.status = Status.DESBLOQUEADO;
		this.motivoBloqueio = Motivo.DESBLOQUEADO;
		this.cvv = geraCvv();
	}
	private String numeroCartao;
	private String numeroConta;
	private Tipo tipo;
	private LocalDate dataValidade;
	private Moeda moeda;
	private double saldo;
	private double limiteTotal;
	private double limiteUsado;
	private Status status;
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
	public void setMoeda(String moeda) {		
		if(moeda.toUpperCase().equals("REAL"))
		{
			this.moeda = Moeda.Real;
		}
		else if(moeda.toUpperCase().equals("DOLAR") || moeda.equals("DÓLAR"))
		{
			this.moeda = Moeda.Dolar;
		}		
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
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
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
		try {
			CartaoDAO dao = new CartaoDAO();
			Cartao cartao = dao.Consultar("NumCartao", numeroCartao).get(0);
			if (cartao.dataValidade.isBefore(LocalDate.now())) {
				if (cartao.status == Status.DESBLOQUEADO) {
					cartao.status = Status.BLOQUEADO;
					cartao.motivoBloqueio = Motivo.VALIDADE_EXPIROU;
				}
				dao.Atualizar(cartao);
				return false;
			}
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	private String geraNumCartao() {
		boolean jaExiste = false;
		String num = "";
		do {
			num = "";
			Random rand = new Random();
			for (int i = 0; i < 4; i++) {
				int sequencia = rand.nextInt(9999);
				num += String.format("%04d", sequencia) + " ";
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
	
	private String geraCvv() {
		Random rand = new Random();
		String num = String.format("%03d", rand.nextInt(999));
		
		return num;
	}
	
	public List<Compras> ListaTodasAsCompras() {
		List<Compras> compras = new ArrayList<Compras>();
		//try {
		//	ComprasDAO comprasDAO = new ComprasDAO();
		//	compras = comprasDAO.Consultar("NumCartao", this.numeroCartao);
		//} catch (Exception e) {
		//	System.out.println(e.toString());
		//}
		return compras;
	}
	
	public List<Fatura> getFaturasNaoPagas() {
		List<Fatura> faturas = new ArrayList();
		try {
			FaturaDAO dao = new FaturaDAO();
			faturas =  dao.Consultar("NumCartao", this.numeroCartao);
			for (int i = 0; i < faturas.size(); i++) {
				if (faturas.get(i).getSituacao() == Situacao.PAGO) {
					faturas.remove(i);
				}
			}
			return faturas;
		
		} catch (Exception e) {
			System.out.println(e.toString());
			return faturas;
		}
	}
	
}
