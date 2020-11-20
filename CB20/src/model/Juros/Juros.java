package model.Juros;

import model.Cliente.Formacao;
import model.Cliente.Profissao;

public class Juros {
	
	static int valorIniCartao = 15;
	static int valorIniEmprestimo = 13;
	static float multa = (float) 0.2;

	public static float getJurosEmprestimo(int idade, Formacao formacao, Profissao profissao, double renda, int parcelas)
	{
		int pesoIdade = getPesoIdade(idade);
		int pesoFormacao = getPesoFormacao(formacao);
		int pesoProfissao = getPesoProfissao(profissao);
		int pesoRenda = getPesoRenda(renda);
		
		return (float)(pesoIdade + pesoFormacao + pesoProfissao + pesoRenda + valorIniEmprestimo + (parcelas / 5)) / 1250;
	}
	
	public static float getJurosCartao(int idade, Formacao formacao, Profissao profissao, double renda)
	{
		int pesoIdade = getPesoIdade(idade);
		int pesoFormacao = getPesoFormacao(formacao);
		int pesoProfissao = getPesoProfissao(profissao);
		int pesoRenda = getPesoRenda(renda);
		return (pesoIdade + pesoFormacao + pesoProfissao + pesoRenda + valorIniCartao) / 1000;
	}
	
	public static float getJurosEmprestimoAtraso(int idade, Formacao formacao, Profissao profissao, int renda, int parcelas)
	{
		return getJurosEmprestimo(idade, formacao, profissao, renda, parcelas) * 6;
	}
	
	public static float getJurosCartaoAtraso(int idade, Formacao formacao, Profissao profissao, int renda)
	{
		return getJurosCartao(idade, formacao, profissao, renda) * 6;
	}
	
	public static float getMulta()
	{
		return multa;
	}
	
	private static int getPesoIdade(int idade)
	{
		if(idade >= 18 && idade <= 24)
		{
			return 6;
		}
		else if(idade >= 25 && idade <= 30)
		{
			return 4;
		}
		else if(idade >= 31 && idade <= 40)
		{
			return 1;
		}
		else if(idade >= 41 && idade <= 50)
		{
			return -1;
		}
		else if(idade >= 51 && idade <= 60)
		{
			return 4;
		}
		else if(idade >= 61)
		{
			return 6;
		}
		else 
		{
			return 0;
		}
	}
	
	private static int getPesoFormacao(Formacao formacao)
	{
		if(formacao.getDescricao() == 1)
		{
			return 8;
		}
		else if(formacao.getDescricao() == 2)
		{
			return 7;
		}
		else if(formacao.getDescricao() == 3)
		{
			return 6;
		}
		else if(formacao.getDescricao() == 4)
		{
			return 5;
		}
		else if(formacao.getDescricao() == 5)
		{
			return 5;
		}
		else if(formacao.getDescricao() == 6)
		{
			return 2;
		}
		else if(formacao.getDescricao() == 7)
		{
			return 1;
		}
		else 
		{
			return 0;
		}
	}
	
	private static int getPesoProfissao(Profissao profissao)
	{
		if(profissao.getDescricao() == 1)
		{
			return 6;
		}
		else if(profissao.getDescricao() == 2)
		{
			return 6;
		}
		else if(profissao.getDescricao() == 3)
		{
			return 5;
		}
		else if(profissao.getDescricao() == 4)
		{
			return 5;
		}
		else if(profissao.getDescricao() == 5)
		{
			return 4;
		}
		else if(profissao.getDescricao() == 6)
		{
			return 4;
		}
		else if(profissao.getDescricao() == 7)
		{
			return 3;
		}
		else 
		{
			return 0;
		}
	}
	
	private static int getPesoRenda(double renda)
	{
		if(renda < 1000)
		{
			return 8; 
		}
		else if(renda >= 1000 && renda <= 1500)
		{
			return 8; 
		}
		else if(renda >= 1501 && renda <= 2000)
		{
			return 7; 
		}
		else if(renda >= 2001 && renda <= 3000)
		{
			return 7; 
		}
		else if(renda >= 3001 && renda <= 5000)
		{
			return 5; 
		}
		else if(renda >= 5001 && renda <= 10000)
		{
			return 3; 
		}
		else if(renda >= 10001 && renda <= 20000)
		{
			return 1; 
		}
		else if(renda >= 20001)
		{
			return -1; 
		}
		else 
		{
			return 0;
		}
	}
}
