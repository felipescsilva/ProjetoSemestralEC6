package model.Juros;

import model.Cliente.Formacao;
import model.Cliente.Profissao;

public class Limites {

	int valorIniCartao = 600;
	int valorIniEmprestimo = 5000;
	
	public int getLimiteEmprestimo(int idade, Formacao formacao, Profissao profissao, int renda)
	{
		int pesoIdade = getPesoIdade(idade);
		int pesoFormacao = getPesoFormacao(formacao);
		int pesoProfissao = getPesoProfissao(profissao);
		int pesoRenda = getPesoRenda(renda);
		return ((pesoIdade * -5) + pesoFormacao + pesoProfissao + pesoRenda) * 3 + valorIniEmprestimo;
	}
	
	public int getLimiteCartao(int idade, Formacao formacao, Profissao profissao, int renda)
	{
		int pesoIdade = getPesoIdade(idade);
		int pesoFormacao = getPesoFormacao(formacao);
		int pesoProfissao = getPesoProfissao(profissao);
		int pesoRenda = getPesoRenda(renda);
				
		return pesoIdade + pesoFormacao + pesoProfissao + pesoRenda + valorIniCartao;
	}
	
	int getPesoIdade(int idade)
	{
		if(idade >= 18 && idade <= 24)
		{
			return -100;
		}
		else if(idade >= 25 && idade <= 30)
		{
			return 0;
		}
		else if(idade >= 31 && idade <= 40)
		{
			return 100;
		}
		else if(idade >= 41 && idade <= 50)
		{
			return 300;
		}
		else if(idade >= 51 && idade <= 60)
		{
			return 500;
		}
		else if(idade >= 61)
		{
			return 700;
		}
		else 
		{
			return 0;
		}
	}
	
	int getPesoFormacao(Formacao formacao)
	{
		if(formacao.getDescricao() == 1)
		{
			return -200;
		}
		else if(formacao.getDescricao() == 2)
		{
			return -100;
		}
		else if(formacao.getDescricao() == 3)
		{
			return 0;
		}
		else if(formacao.getDescricao() == 4)
		{
			return 50;
		}
		else if(formacao.getDescricao() == 5)
		{
			return 100;
		}
		else if(formacao.getDescricao() == 6)
		{
			return 500;
		}
		else if(formacao.getDescricao() == 7)
		{
			return 1000;
		}
		else 
		{
			return 0;
		}
	}
	
	int getPesoProfissao(Profissao profissao)
	{
		if(profissao.getDescricao() == 1)
		{
			return 500;
		}
		else if(profissao.getDescricao() == 2)
		{
			return 1100;
		}
		else if(profissao.getDescricao() == 3)
		{
			return 2000;
		}
		else if(profissao.getDescricao() == 4)
		{
			return 3500;
		}
		else if(profissao.getDescricao() == 5)
		{
			return 5000;
		}
		else if(profissao.getDescricao() == 6)
		{
			return 7500;
		}
		else if(profissao.getDescricao() == 7)
		{
			return 10000;
		}
		else 
		{
			return 0;
		}
	}
	
	int getPesoRenda(int renda)
	{
		if(renda < 1000)
		{
			return -100; 
		}
		else if(renda >= 1000 && renda <= 1500)
		{
			return 0; 
		}
		else if(renda >= 1501 && renda <= 2000)
		{
			return 300; 
		}
		else if(renda >= 2001 && renda <= 3000)
		{
			return 750; 
		}
		else if(renda >= 3001 && renda <= 5000)
		{
			return 2000; 
		}
		else if(renda >= 5001 && renda <= 10000)
		{
			return 3500; 
		}
		else if(renda >= 10001 && renda <= 20000)
		{
			return 7500; 
		}
		else if(renda >= 20001)
		{
			return 15000; 
		}
		else 
		{
			return 0;
		}
	}
}
