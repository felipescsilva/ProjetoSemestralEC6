package model.Cambio;

import java.util.ArrayList;
import java.util.List;

import DAO.CambioDAO;
import DAO.ContaDAO;
import model.Cartao.Cartao;
import model.Conta.Conta;

import java.time.LocalDate;


public class Cambio {
	int idCambio;
	Conta conta;
	float valor;
	Moeda moeda;
	String descricao;
	LocalDate dataSolicitacao;
	LocalDate validade;
	String cpf;
	
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public int getIdCampo() {
		return idCambio;
	}
	public void setIdCampo(int idCampo) {
		this.idCambio = idCampo;
	}
	public Conta getConta() {
		return conta;
	}
	public void setConta(String conta) {
		ContaDAO dao = new ContaDAO();
		List<Conta> contas = null;
		try {
			contas = dao.Consultar("NumConta", conta);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.conta = contas.get(0);
	}
	public float getValor() {
		return valor;
	}
	public void setValor(float valor, Moeda moeda) {
		if(this.getMoeda() != moeda)
		{
			Cotacao.converter(valor, this.getMoeda(), moeda);
		}
		this.valor = valor;
	}
	public void setValor(float valor)
	{
		this.valor = valor;
	}
	public void subtrairValor(float valorEmReal)
	{
		if(this.getMoeda() == Moeda.Dolar)
		{
			float valorEmDolar = Cotacao.converter(valorEmReal, Moeda.Real, Moeda.Dolar);
			this.setValor(this.getValor() - valorEmDolar);
		}
		else
		{
			this.setValor(this.getValor() - valorEmReal);
		}
	}
	public Moeda getMoeda() {
		return moeda;
	}
	public void setMoeda(Moeda moeda) {
		this.moeda = moeda;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public LocalDate getDataSolicitacao() {
		return dataSolicitacao;
	}
	public void setDataSolicitacao(LocalDate dataSolicitacao) {
		this.dataSolicitacao = dataSolicitacao;
	}
	
	public LocalDate getDataValidade() {
		return validade;
	}
	public void setValidade(LocalDate validade) {
		this.validade = validade;
	}
	
	public boolean novaOrdem(Conta conta, float valor, Moeda moeda, LocalDate dataSolicitacao, LocalDate dataValidade)
	{
		this.conta = conta;
		this.valor = valor;
		this.moeda = moeda;
		this.dataSolicitacao = dataSolicitacao;
		this.validade = dataValidade;	
		this.descricao = "Comprar " + valor + " " + moeda.toString();
		CambioDAO cambio = new CambioDAO();
		cambio.Inserir(this);
		return true;
	}
	
	public boolean novaOrdem(Conta conta, float valor, String moeda, LocalDate dataSolicitacao, LocalDate dataValidade)
	{
		Moeda novaMoeda = null;
		if(moeda == "Real")
		{
			novaMoeda = Moeda.Real;
		}
		else if(moeda == "Dolar")
		{
			novaMoeda = Moeda.Dolar;
		}
		this.conta = conta;
		this.valor = valor;
		this.moeda = novaMoeda;
		this.dataSolicitacao = dataSolicitacao;
		this.validade = dataValidade;
		this.descricao = "Comprar " + valor + " " + moeda.toString();
		CambioDAO cambio = new CambioDAO();
		cambio.Inserir(this);
		return true;
	}
	
	public boolean baterOrdens()
	{
		
		CambioDAO cambioDAO = new CambioDAO();
		List<Cambio> ordens = cambioDAO.Consultar();
		Cambio auxOrdemA = null;
		Cambio auxOrdemB = null;
		
		for(Cambio ordemA: ordens)
		{
			if(ordemA.getMoeda() == Moeda.Dolar)
			{
				auxOrdemA.setMoeda(ordemA.getMoeda());
				auxOrdemA.setValor(ordemA.valor, Moeda.Real);
			}			
			else 
			{
				auxOrdemA = ordemA;
			}
			
			for(Cambio ordemB: ordens)
			{
				if(ordemB.getMoeda() == Moeda.Dolar)
				{
					auxOrdemB.setMoeda(ordemB.getMoeda());
					auxOrdemB.setValor(ordemB.valor, Moeda.Real);
				}					
				else 
				{
					auxOrdemB = ordemB;
				}
				
				if(auxOrdemA.getMoeda() != auxOrdemB.getMoeda())
				{
					float menorOrdem = menorOrdem(auxOrdemA, auxOrdemB);	
					
					if(ordemA.conta.getSaldo() >= menorOrdem || ordemB.conta.getSaldo() >= menorOrdem)
					{
						ordemA.subtrairValor(menorOrdem);
						ordemB.subtrairValor(menorOrdem);						
						
						if(ordemA.getMoeda() == Moeda.Real)
						{
							atualizarBD(ordemA, ordemB, menorOrdem);							
						}
						else 
						{
							atualizarBD(ordemB, ordemA, menorOrdem);
						}
						cambioDAO.Atualizar(ordemA);
						cambioDAO.Atualizar(ordemB);
					}							
				}
			}
		}
		
		
		return true;
	}
	
	private boolean atualizarBD(Cambio ordemA, Cambio ordemB, float menorOrdem)
	{
		ContaDAO daoConta = new ContaDAO();
		ordemA.getConta().setSaldo(ordemA.getConta().getSaldo() + menorOrdem);		
		ordemB.getConta().setSaldo(ordemB.getConta().getSaldo() - menorOrdem);		
		
		List<Cartao> cartoesA = ordemA.getConta().getCartoes();
		
		for(Cartao cartao : cartoesA)
		{
			if(cartao.getMoeda() == Moeda.Dolar && cartao.getSaldo() >= Cotacao.converter(menorOrdem, Moeda.Real, Moeda.Dolar))
			{
				cartao.setSaldo(cartao.getSaldo() - Cotacao.converter(menorOrdem, Moeda.Real, Moeda.Dolar));
			}
			else
			{
				return false;
			}
		}
		
		List<Cartao> cartoesB = ordemB.getConta().getCartoes();
		
		for(Cartao cartao : cartoesB)
		{
			if(cartao.getMoeda() == Moeda.Dolar)
			{
				cartao.setSaldo(cartao.getSaldo() + Cotacao.converter(menorOrdem, Moeda.Real, Moeda.Dolar));
			}
			else 
			{
				return false;
			}
		}
		
		daoConta.Atualizar(ordemA.getConta());
		daoConta.Atualizar(ordemB.getConta());
		
		return true;
	}
	
	private float menorOrdem(Cambio ordemA, Cambio ordemB)
	{
		if(ordemA.getMoeda() == Moeda.Dolar)
		{
			
		}
		if(ordemA.getValor() < ordemB.getValor())
		{
			return ordemA.getValor();
		}
		else
		{
			return ordemB.getValor();
		}
		
	}
}
