package model.Cambio;

import java.util.List;

import DAO.BancoDAO;
import DAO.CambioDAO;
import DAO.CartaoDAO;
import DAO.ContaDAO;
import model.Banco.Banco;
import model.Cartao.Cartao;
import model.Conta.Conta;

import java.time.LocalDate;


public class Cambio {
	int idCambio;
	Conta conta;
	double valor;
	Moeda moeda;
	String descricao;
	LocalDate dataSolicitacao;
	LocalDate validade;
	String cpf;
	ContaDAO daoConta = new ContaDAO();
	CambioDAO cambioDAO = new CambioDAO();
	CartaoDAO cartaoDAO = new CartaoDAO();
	BancoDAO bancoDAO = new BancoDAO();
	
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
	public double getValor() {
		return valor;
	}
	public void setValor(double valor, Moeda moeda) {		
		if(this.getMoeda() != moeda)
		{			
			this.valor = Cotacao.converter(valor, this.getMoeda(), moeda);
		}
		else
		{
			this.valor = valor;
		}		
	}
	public void setValor(double valor)
	{
		this.valor = valor;
	}
	public void subtrairValor(double valorEmReal)
	{
		if(this.getMoeda() == Moeda.Dolar)
		{
			double valorEmDolar = Cotacao.converter(valorEmReal, Moeda.Real, Moeda.Dolar);
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
	public void setMoeda(String moeda) {
		if(moeda.toUpperCase().equals("REAL"))
		{
			this.moeda = Moeda.Real;
		}
		else if(moeda.toUpperCase().equals("DOLAR") || moeda.toUpperCase().equals("DÓLAR"))
		{
			this.moeda = Moeda.Dolar;
		}		
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public void setDescricao(double valor, Moeda moeda) {
		this.descricao =  "Moeda: " + moeda.toString() + " Comprar: " + valor;
	}
	public void setDescricao() {
		this.descricao = "Moeda: " + this.getMoeda().toString() +  " Comprar: " + this.getValor();
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
	
	public boolean novaOrdem(Conta conta, double valor, Moeda moeda, LocalDate dataSolicitacao, LocalDate dataValidade)
	{
		this.conta = conta;
		this.valor = valor;
		this.moeda = moeda;
		this.dataSolicitacao = dataSolicitacao;
		this.validade = dataValidade;	
		this.setDescricao(valor, moeda);
		CambioDAO cambio = new CambioDAO();
		cambio.Inserir(this);
		return true;
	}
	
	public boolean novaOrdem(Conta conta, double valor, String moeda, LocalDate dataSolicitacao, LocalDate dataValidade)
	{
		Moeda novaMoeda = null;
		if(moeda.equals("Real"))
		{
			novaMoeda = Moeda.Real;
		}
		else if(moeda.equals("Dólar"))
		{
			novaMoeda = Moeda.Dolar;
		}
		this.conta = conta;
		this.valor = valor;
		this.moeda = novaMoeda;
		this.dataSolicitacao = LocalDate.now();
		this.validade = LocalDate.now();;
		this.setDescricao(valor, novaMoeda);		
		CambioDAO cambio = new CambioDAO();
		cambio.Inserir(this);
		return true;
	}
	
	public boolean baterOrdens()
	{		
		boolean bateu = false;
		CambioDAO cambioDAO = new CambioDAO();
		List<Cambio> ordens = cambioDAO.Consultar();
		Cambio auxOrdemA = new Cambio();		
		Cambio auxOrdemB = new Cambio();
		
		for(Cambio ordemA: ordens)
		{
			if(ordemA.getMoeda() == Moeda.Dolar)
			{						
				auxOrdemA.setMoeda(ordemA.getMoeda());
				auxOrdemA.setValor(ordemA.valor, Moeda.Real);									
			}			
			else 
			{				
				auxOrdemA.setMoeda(ordemA.getMoeda());
				auxOrdemA.setValor(ordemA.valor);										
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
					auxOrdemB.setMoeda(ordemB.getMoeda());
					auxOrdemB.setValor(ordemB.valor);											
				}				
				
				if(auxOrdemA.getMoeda() != auxOrdemB.getMoeda())
				{					
					double menorOrdem = menorOrdem(auxOrdemA, auxOrdemB);									
					
					if(ordemA.conta.getSaldo() >= menorOrdem || ordemB.conta.getSaldo() >= menorOrdem)
					{						
						ordemA.subtrairValor(menorOrdem);
						ordemB.subtrairValor(menorOrdem);						
						
						if(ordemA.getMoeda() == Moeda.Real)
						{
							bateu = atualizarBD(ordemA, ordemB, menorOrdem);							
						}
						else 
						{
							bateu = atualizarBD(ordemB, ordemA, menorOrdem);
						}									
					}							
				}
			}
		}	
		return bateu;
	}
	
	private boolean atualizarBD(Cambio ordemA, Cambio ordemB, double menorOrdem)
	{		
		Banco banco = new Banco();
		
		banco = bancoDAO.Consultar().get(0);
		
		ordemA.getConta().setSaldo(ordemA.getConta().getSaldo() + menorOrdem);			
		ordemB.getConta().setSaldo(ordemB.getConta().getSaldo() - (menorOrdem * Cotacao.getTaxa()));	
		//(menorOrdem * Cotacao.getTaxa())
		//Adicionar ao patrimonio do banco
		
		List<Cartao> cartoesA = ordemA.getConta().getCartoes();
		if(cartoesA.size() < 1)
		{
			return false;
		}		
		
		for(Cartao cartao : cartoesA)
		{
			if(cartao.getMoeda() == Moeda.Dolar && cartao.getSaldo() >= Cotacao.converter(menorOrdem, Moeda.Real, Moeda.Dolar))
			{				
				cartao.setSaldo(cartao.getSaldo() - (Cotacao.converter(menorOrdem, Moeda.Real, Moeda.Dolar) * Cotacao.getTaxa()));
				cartaoDAO.Atualizar(cartao);
				//Adicionar ao patrimonio do banco
			}
			else
			{
				return false;
			}
		}
		
		List<Cartao> cartoesB = ordemB.getConta().getCartoes();
		if(cartoesB.size() < 1)
		{
			return false;
		}
		
		for(Cartao cartao : cartoesB)
		{
			if(cartao.getMoeda() == Moeda.Dolar)
			{				
				cartao.setSaldo(cartao.getSaldo() + (Cotacao.converter(menorOrdem, Moeda.Real, Moeda.Dolar)));
				cartaoDAO.Atualizar(cartao);
			}
			else 
			{
				return false;
			}
		}
		
		banco.setFaturamento(banco.getFaturamento() + (menorOrdem * ((Cotacao.getTaxa() - 1) * 2)));
		bancoDAO.Atualizar(banco);
		daoConta.Atualizar(ordemA.getConta());
		daoConta.Atualizar(ordemB.getConta());
		
		if(ordemA.getValor() < 0.001)
		{
			cambioDAO.Remover(String.valueOf(ordemA.getIdCampo()));
		}
		else
		{
			ordemA.setDescricao();
			cambioDAO.Atualizar(ordemA);
		}
		
		if(ordemB.getValor() < 0.001)
		{
			cambioDAO.Remover(String.valueOf(ordemB.getIdCampo()));
		}
		else
		{
			ordemB.setDescricao();
			cambioDAO.Atualizar(ordemB);
		}		
		
		return true;
	}
	
	private double menorOrdem(Cambio ordemA, Cambio ordemB)
	{
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
