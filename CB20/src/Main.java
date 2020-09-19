import DAO.*;

import java.time.LocalDate;

import model.Cliente.*;
import model.Conta.Conta;
import model.Endereco.Endereco;


public class Main {

	public static void main(String[] args) throws Exception{
		//testaConta();
		//testaCliente();
		
		
		System.out.println("Acabou");
	}
	
	public static void testaConta() throws Exception {
		ContaDAO dao = new ContaDAO();
		Conta conta = new Conta();
		conta.setCPF("48665993835");
		conta.setDataAbertura(LocalDate.now());
		conta.setNumeroConta("1200");
		conta.setSaldo(1000);
		conta.setSenha("1234567890");
		try {
			//dao.Inserir(conta);
		}
		catch (Exception e) {
			System.out.println("Já existe");
		}
		dao.Atualizar(conta);
		
		dao.Remover("1200");
		
		System.out.println(dao.Consultar().get(0).getDataAbertura());
	}
	public static void testaCliente() throws Exception{
		ClienteDAO dao = new ClienteDAO();
		Cliente cliente = new Cliente();
		
		cliente.setCPF("12345678901");
		cliente.setDataNascimento(LocalDate.of(1976, 04, 24));
		cliente.setEmail("email@gmail.com");
		Endereco endereco = new Endereco();
		endereco.setRua("rua teste");
		cliente.setEndereco(endereco);
		cliente.setFormacao(Formacao.MEDIO);
		cliente.setNome("Rubens");
		cliente.setProfissao(Profissao.OUTROS);
		cliente.setRenda(1000.00);
		cliente.setTelefone("99999-9999");
		
		dao.Remover("12345678901");
		
		System.out.println(dao.Consultar().get(0).getDataNascimento());
		
	}

}
