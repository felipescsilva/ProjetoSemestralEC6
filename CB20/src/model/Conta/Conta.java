package model.Conta;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import DAO.CartaoDAO;
import DAO.ContaDAO;
import model.Cartao.*;

public class Conta {
	private String numeroConta;
	private String CPF;
	private double saldo;
	private LocalDate dataAbertura;
	private String senhaConta;
	private String senhaApp;
	
	public String getSenhaConta() {
		return senhaConta;
	}

	public void setSenhaConta(String senhaConta) {
		this.senhaConta = senhaConta;
	}

	public String getSenhaApp() {
		return senhaApp;
	}

	public void setSenhaApp(String senhaApp) {
		this.senhaApp = senhaApp;
	}
	
	public Conta() {
		super();
	}

	public String getNumeroConta() {
		return numeroConta;
	}

	public Conta(String numeroConta, String cPF, double saldo, LocalDate dataAbertura, String senhaConta,
			String senhaApp) {
		super();
		this.numeroConta = numeroConta;
		CPF = cPF;
		this.saldo = saldo;
		this.dataAbertura = dataAbertura;
		this.senhaConta = senhaConta;
		this.senhaApp = senhaApp;
	}

	public void setNumeroConta(String numeroConta) {
		this.numeroConta = numeroConta;
	}

	public String getCPF() {
		return CPF;
	}

	public void setCPF(String cPF) {
		CPF = cPF;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public LocalDate getDataAbertura() {
		return dataAbertura;
	}

	public void setDataAbertura(LocalDate dataAbertura) {
		this.dataAbertura = dataAbertura;
	}
	
	
	public boolean DesbloquearCartao(String numeroCartao, String senha){
		try {
			CartaoDAO cartaoDAO = new CartaoDAO();
			Cartao cartao = cartaoDAO.Consultar("NumCartao", numeroCartao).get(0);
			if (cartao.getBloqueado() != Bloqueado.BLOQUEADO_PERMANENTEMENTE) {
				if (senha.equals(this.senhaConta)) {
					cartao.setBloqueado(Bloqueado.DESBLOQUEADO);
					cartao.setMotivoBloqueio(Motivo.DESBLOQUEADO);
					cartaoDAO.Atualizar(cartao);
					return true;
				}
			}
				
			return true;
		} catch (Exception e) {
			System.out.println(e.toString());
			return false;
		}
	}
	
	public boolean PedirBloqueioCartao(String numeroCartao, String senha, Motivo motivoBloqueio) {
		try {
		CartaoDAO cartaoDAO = new CartaoDAO();
		Cartao cartao = cartaoDAO.Consultar("NumCartao", numeroCartao).get(0);
		if (cartao.getBloqueado().equals(Bloqueado.DESBLOQUEADO)) {
			if (senha.equals(this.senhaConta)) {
				if (motivoBloqueio.equals(Motivo.PERDA) || motivoBloqueio.equals(Motivo.ROUBO)) {
					cartao.setBloqueado(Bloqueado.BLOQUEADO_PERMANENTEMENTE);
				} else
					cartao.setBloqueado(Bloqueado.BLOQUEADO);
				cartao.setMotivoBloqueio(motivoBloqueio);
				cartaoDAO.Atualizar(cartao);
				return true;
			}
		}
		
			return false;
		} catch (Exception e) {
			System.out.println(e.toString());
			return false;
		}
	}
	
	public boolean PedirNovoCartao(Tipo tipo, Moeda moeda, String senha, double limiteTotal) {
		try {
			CartaoDAO cartaoDAO = new CartaoDAO();
			List<Cartao> listaCartao = new ArrayList<Cartao>();
			listaCartao = cartaoDAO.Consultar("NumConta", this.numeroConta);
			boolean credito = false;
			boolean debito = false;
			boolean prePago = false;
			for (int i = 0; i < listaCartao.size(); i++) {
				Cartao cartao = listaCartao.get(i);
				Tipo tipoCartao = cartao.getTipo();
				Bloqueado bloqueadoCartao = cartao.getBloqueado();
				if (bloqueadoCartao.equals(Bloqueado.DESBLOQUEADO)) {
					switch (tipoCartao) {
						case DÉBITO:
							debito = true;
							break;
						case CRÉDITO:
							credito = true;
							break;
						case PRÉ_PAGO:
							prePago = true;
							break;
					}
				}
				
				else if (bloqueadoCartao.equals(Bloqueado.BLOQUEADO) && tipoCartao.equals(tipo) && senha.equals(this.senhaConta)) {
					cartao.setBloqueado(Bloqueado.BLOQUEADO_PERMANENTEMENTE);
					cartaoDAO.Atualizar(cartao);
				}
			}
			
			Cartao novoCartao;
			switch (tipo) {
				case CRÉDITO:
					if (!credito && senha.equals(this.senhaConta)) {
						novoCartao = new Cartao(this.numeroConta, tipo, moeda, limiteTotal);
						cartaoDAO.Inserir(novoCartao);
						return true;
					}
					break;
				case DÉBITO:
					if (!debito && senha.equals(this.senhaConta)) {
						novoCartao = new Cartao(this.numeroConta, tipo, moeda, 0.00);
						cartaoDAO.Inserir(novoCartao);
						return true;
					}
					break;
				case PRÉ_PAGO:
					if (!prePago && senha.equals(this.senhaConta)) {
						novoCartao = new Cartao(this.numeroConta, tipo, moeda, 0.00);
						cartaoDAO.Inserir(novoCartao);
						return true;
					}
					break;
			}		
		}
		catch (Exception e) {
			return false;
		}
		return false;
	}
	
	public boolean pagarFatura(String numCartao) {
		return true;
	}
	
	public void geraNumConta() {
		boolean jaExiste = false;
		String num = "";
		do {
			Random rand = new Random();
			int sequencia = rand.nextInt(9999);
			num += String.format("%04d", sequencia);
			try {
				ContaDAO dao = new ContaDAO();
				List<Conta> lista = dao.Consultar("NumConta", num);
				if (lista.size() != 0)
					jaExiste = true;
				else
					jaExiste = false;
				
			} catch (Exception e) {
				System.out.println(e.toString());
			}
		} while(jaExiste);
		
		this.numeroConta = num;
	}
}
