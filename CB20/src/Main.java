import DAO.*;

import java.time.LocalDate;

import model.Cartao.Cartao;
import model.Cartao.Moeda;
import model.Cartao.Tipo;
import model.Cliente.*;
import model.Conta.Conta;


public class Main {

	public static void main(String[] args) throws Exception{
		//testaConta();
		//testaCliente();
		//testaCartao();
		
		CartaoDAO cartaoDAO = new CartaoDAO();
		Cartao cartao = cartaoDAO.Consultar("12345").get(0);
		
		
		
		
		System.out.println("Acabou");
	}
	
	public static void testaConta() throws Exception {
		ContaDAO dao = new ContaDAO();
		//System.out.println(dao.Consultar("consulta").get(0).getNumeroConta().equals("qualquer"));
		Conta conta = new Conta();
		conta.setCPF("48665993835");
		conta.setDataAbertura(LocalDate.now());
		conta.setNumeroConta("1200");
		conta.setSaldo(1000);
		conta.setSenhaConta("123456");
		conta.setSenhaApp("12345678");
		try {
			dao.Inserir(conta);
		}
		catch (Exception e) {
			System.out.println("Já existe");
		}
		//dao.Atualizar(conta);
		
		//dao.Remover("1200");
		
		//System.out.println(dao.Consultar("consulta").get(0).getDataAbertura());
	}
	public static void testaCliente() throws Exception{
		ClienteDAO dao = new ClienteDAO();
		Cliente cliente = new Cliente();
		
		cliente.setCPF("48665993835");
		cliente.setDataNascimento(LocalDate.of(2000, 10, 19));
		cliente.setEmail("lucascaffer@gmail.com");
		cliente.setFormacao(Formacao.MEDIO);
		cliente.setNome("Lucas Caffer");
		cliente.setProfissao(Profissao.OUTROS);
		cliente.setRenda(0.00);
		cliente.setTelefone("99999-9999");
		
		dao.Inserir(cliente);
		
		//System.out.println(dao.Consultar().get(0).getDataNascimento());
		
	}
	
	public static void testaCartao() throws Exception {
		CartaoDAO dao = new CartaoDAO();
		Cartao cartao = new Cartao("12345", "1200", Tipo.DEBITO, LocalDate.now(), Moeda.REAL, 1000.00, "123");
		
		dao.Inserir(cartao);
	}

}