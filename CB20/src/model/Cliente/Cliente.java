package model.Cliente;

import java.time.LocalDate;

import model.Endereco.Endereco;

public class Cliente {
	private String nome;
	private String CPF;
	private String telefone;
	private String email;
	private LocalDate DataNascimento;
	public Cliente(String nome, String cPF, String telefone, String email, LocalDate dataNascimento, Endereco endereco,
			Formacao formacao, Profissao profissao, Double renda) {
		super();
		this.nome = nome;
		CPF = cPF;
		this.telefone = telefone;
		this.email = email;
		DataNascimento = dataNascimento;
		this.endereco = endereco;
		this.formacao = formacao;
		this.profissao = profissao;
		this.renda = renda;
	}
	public Cliente() {
		super();
	}
	private Endereco endereco;
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
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
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
	
	
}
