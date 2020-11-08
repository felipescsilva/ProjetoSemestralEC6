package model.Cliente;

import java.time.LocalDate;

import DAO.CartaoDAO;
import DAO.ContaDAO;
import model.Cartao.Bloqueado;
import model.Cartao.Cartao;
import model.Conta.Conta;

public class Cliente {
	private String nome;
	private String CPF;
	private String telefone;
	private String email;
	private LocalDate DataNascimento;
	public Cliente(String nome, String cPF, LocalDate dataNascimento,
			Formacao formacao, Profissao profissao, Double renda) {
		super();
		this.nome = nome;
		CPF = cPF;
		//this.telefone = telefone;
		//this.email = email;
		DataNascimento = dataNascimento;
		this.formacao = formacao;
		this.profissao = profissao;
		this.renda = renda;
	}
	public Cliente() {
		super();
	}
	private Formacao formacao;
	private Profissao profissao;
	private Double renda;
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCPF() {
		return CPF;
	}
	public void setCPF(String cPF) {
		CPF = cPF;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public LocalDate getDataNascimento() {
		return DataNascimento;
	}
	public void setDataNascimento(LocalDate dataNascimento) {
		DataNascimento = dataNascimento;
	}
	public Formacao getFormacao() {
		return formacao;
	}
	public void setFormacao(Formacao formacao) {
		this.formacao = formacao;
	}
	public Profissao getProfissao() {
		return profissao;
	}
	public void setProfissao(Profissao profissao) {
		this.profissao = profissao;
	}
	public Double getRenda() {
		return renda;
	}
	public void setRenda(Double renda) {
		this.renda = renda;
	}
	
	public boolean pagarCartaoDebito(String numCartao, String senhaConta, double valor) {
		try {
			CartaoDAO cartaoDAO = new CartaoDAO();
			ContaDAO contaDAO = new ContaDAO();
			Conta conta = new Conta();
			Cartao cartao = new Cartao();
			cartao = cartaoDAO.Consultar("NumCartao", numCartao).get(0);
			conta = contaDAO.Consultar("NumConta", cartao.getNumeroConta()).get(0);
			if (cartao.getBloqueado() == Bloqueado.DESBLOQUEADO) {
				if (cartao.verificaValidade()) {
					if (valor <= conta.getSaldo()) {
						if (senhaConta.equals(conta.getSenhaConta())) {
							conta.setSaldo(conta.getSaldo() - valor);
							contaDAO.Atualizar(conta);
							return true;
						}
					}
				}
			}
			return false;
		} catch (Exception e){
			System.out.println(e.toString());
			return false;
		}
		
	}
	public boolean pagarCartaoCredito(String numCartao ,String senhaConta, double valor) {
		try {
			CartaoDAO cartaoDAO = new CartaoDAO();
			ContaDAO contaDAO = new ContaDAO();
			Conta conta = new Conta();
			Cartao cartao = new Cartao();
			cartao = cartaoDAO.Consultar("NumCartao", numCartao).get(0);
			conta = contaDAO.Consultar("NumConta", cartao.getNumeroConta()).get(0);
			if (cartao.getBloqueado() == Bloqueado.DESBLOQUEADO) {
				if (cartao.verificaValidade()) {
					if (valor <= (cartao.getLimiteTotal() - cartao.getLimiteUsado())) {
						if (senhaConta.equals(conta.getSenhaConta())) {
							cartao.setLimiteUsado(cartao.getLimiteUsado() + valor);
							cartaoDAO.Atualizar(cartao);
							return true;
						}
					}
				}
			}
			return false;
		
		}
		catch (Exception e) {
			return false;
		}
	}
	
	public boolean compraOnline(String numCartao, int diaValidade, int mesValidade, int anoValidade, String cvv, double valor) {
		try {
			CartaoDAO cartaoDAO = new CartaoDAO();
			ContaDAO contaDAO = new ContaDAO();
			Conta conta = new Conta();
			Cartao cartao = new Cartao();
			cartao = cartaoDAO.Consultar("NumCartao", numCartao).get(0);
			conta = contaDAO.Consultar("NumConta", cartao.getNumeroConta()).get(0);
			if (cartao.getBloqueado() == Bloqueado.DESBLOQUEADO) {
				if (cartao.verificaValidade()) {
					if (valor <= conta.getSaldo()) {
						if (LocalDate.of(anoValidade, mesValidade, diaValidade).equals(cartao.getDataValidade())) {
							if (cvv.equals(cartao.getCvv())) {
								conta.setSaldo(conta.getSaldo() - valor);
								contaDAO.Atualizar(conta);
								return true;
							}
						}
					}
				}
			}
			return false;
		} catch (Exception e){
			System.out.println(e.toString());
			return false;
		}
	}
	public boolean recarregarPrePago(String numCartao, double valor) {
		try {
			CartaoDAO cartaoDAO = new CartaoDAO();
			Cartao cartao = cartaoDAO.Consultar("NumCartao", numCartao).get(0);
			switch (cartao.getTipo()) {
				case DÉBITO:
				case CRÉDITO:
					return false;
				case PRÉ_PAGO:
					cartao.setSaldo(cartao.getSaldo() + valor);
					break;
			}
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public boolean ComprarNoPrePago(String numCartao, String senhaConta, double valor) {
		try {
			CartaoDAO cartaoDAO = new CartaoDAO();
			ContaDAO contaDAO = new ContaDAO();
			Conta conta = new Conta();
			Cartao cartao = new Cartao();
			cartao = cartaoDAO.Consultar("NumCartao", numCartao).get(0);
			conta = contaDAO.Consultar("NumConta", cartao.getNumeroConta()).get(0);
			if (cartao.getBloqueado() == Bloqueado.DESBLOQUEADO) {
				if (cartao.verificaValidade()) {
					if (valor <= cartao.getSaldo()) {
						if (senhaConta.equals(conta.getSenhaConta())) {
							cartao.setSaldo(conta.getSaldo() - valor);
							cartaoDAO.Atualizar(cartao);
							return true;
						}
					}
				}
			}
			return false;
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
		
		return true;
	}
	
	//Verifica se o CPF informado é o do cliente
		/*
		public boolean checkCPF(String CPF) {
			if(this.CPF.equals(CPF.replace("^0-9", "").trim())) {
				return true;
			}		
			return false;
		}
		

		//Define o CPF caso ele seja válido
		private void setCPF(String CPF) throws Exception {
			CPF = CPF.replace("^0-9", "").trim();
			if(CPF.length() == 11) {
				this.CPF = CPF;
			}
			else {
				throw new Exception("Número de CPF inválido!");
			}
			
		}

		//Retorna o primeiro nome do cliente
		public String getNomeCliente() {
			String[] aux = nomeCliente.split(" ");
			return aux[0];
		}
		
		//Verifica se o nome informado é o do cliente
		public boolean checkNomeCliente(String nomeCliente)
		{
			if(this.nomeCliente.trim().equals(nomeCliente.trim())) {
				return true;
			}
			return false;
		}

		//Define o nome do cliente caso ele seja válido
		private void setNomeCliente(String nomeCliente) throws Exception {
			if(nomeCliente.isEmpty())
			{
				throw new Exception("Nome inválido!");
			}
			this.nomeCliente = nomeCliente;
		}
		

		//Retorna a renda
		protected int getRenda(int senha) {		
			return renda;
		}

		//Define a renda caso ela seja positiva
		private void setRenda(int renda) throws Exception {
			if(renda < 0)
			{
				throw new Exception("A renda não pode ser negativa!");
			}
			this.renda = renda;
		}
		*/
		////////////////////////////////////////////////////////////////////////////////////
}
