package view.Main;

import java.util.ArrayList;
import java.util.List;
import Audit.Audit;
import DAO.BancoDAO;
import model.Banco.Banco;
import model.Cartao.Cartao;
import model.Cartao.Tipo;
import model.Cliente.Cliente;
import model.Cliente.Profissao;
import model.Conta.Conta;
import model.Emprestimo.Emprestimo;
import model.Fatura.Fatura;
import model.Login.Login;
import model.Transferencia.Transferencia;
import view.Cartao.*;
import view.Login.CriarContaT;
import view.Login.LoginT;
import view.Menu.ConsultarT;
import view.Menu.MenuAdminT;
import view.Menu.MenuPrincipalT;
import view.Menu.OpcoesAdminT;
import view.Menu.PesquisarContaT;
import view.Menu.PesquisarCpfT;
import view.Menu.TelaAdmin;
import view.Opcoes.AlterarDadosT;
import view.Opcoes.AlterarSenhaT;
import view.Opcoes.OpcoesT;
import view.Opcoes.TelaSenha;
import view.Operacao.CambioT;
import view.Operacao.ConfirmarDadosT;
import view.Operacao.DepositoT;
import view.Operacao.EmprestimosAtivosT;
import view.Operacao.EmprestimosMenuT;
import view.Operacao.SolicitarEmprestimoT;
import view.Operacao.SaldoT;
import view.Operacao.TransferenciaT;

public class Main {
	
	    public static LoginT telaLogin;
	    public static MenuPrincipalT menuPrincipal;
	    public static CriarContaT novaConta;
	    public static CriarContaT criarConta;
		public static OpcoesT opcoes;
		public static SaldoT saldo;
		public static CartaoT cartaoT;
		public static TransferenciaT transferencia;
		public static OpcoesAdminT opcoesAdmin;
		public static MenuAdminT menuAdmin;
		
		public static DepositoT deposito;
		
		public static SolicitarEmprestimoT telaEmprestimo;
		public static CambioT cambio;
		public static TelaSenha telaSelecionada;
		public static TelaAdmin telaAdminSelecionada;
		public static Conta contaTransferencia;
		public static Transferencia transferir;
		public static EmprestimosMenuT emprestimosMenu;
		public static EmprestimosAtivosT emprestimosAtivos;
		
		public static ConfirmarSenhaT solicitarCancelamento;
		public static SolicitarCartaoT solicitarCartao;
		public static SelecionarCartaoT verCartoes;
		public static SelecionarFaturaT verFaturas;
		public static VisualizarCartaoT verCartao;
		public static VisualizarFaturaT verFatura;
		public static AlterarSenhaT alterarSenha;
		public static AlterarDadosT alterarDados;
		public static ConfirmarDadosT confirmarDados;
		public static PesquisarCpfT pesquisarCpf;
		public static PesquisarContaT pesquisarConta;
		public static ConsultarT consultar;
	    
	    public static Login login;
	    public static Conta conta;	    
		public static Cliente cliente;
		public static List<Cartao> cartoes;
		public static Cartao cartao;
		public static List<Fatura> faturas;
		public static Fatura fatura;
		public static Audit auditoria;
		public static Emprestimo emprestimo;
		private static Banco banco = new Banco();
		public static BancoDAO bancoDAO = new BancoDAO();
		public static Cliente clienteTransferencia;
		
		
	    
		@SuppressWarnings("deprecation")
		public static void main(String[] argv) {
			if(bancoDAO.Consultar().size() < 1)
			{
				banco.setCustosFixos(0);
				banco.setCustosVariaveis(0);
				banco.setFaturamento(0);
				banco.setImpostos(0);
				banco.setPatrimonioProprio(0);
				banco.setPatrimonioTerceiros(0);
				bancoDAO.Inserir(banco);
			}
			
			instanciarTudo();
			telaLogin.show();
		}
		
		public static void instanciarTudo()
		{
			telaLogin = new LoginT();
		    menuPrincipal = new MenuPrincipalT();
		    novaConta = new CriarContaT();
		    criarConta = new CriarContaT();
			opcoes = new OpcoesT();
			saldo = new SaldoT();
			cartaoT = new CartaoT();
			transferencia = new TransferenciaT();			
			deposito = new DepositoT();
			opcoesAdmin = new OpcoesAdminT();
			menuAdmin = new MenuAdminT();
			
			telaEmprestimo = new SolicitarEmprestimoT();
			cambio = new CambioT();
			
			contaTransferencia = new Conta();
			transferir = new Transferencia();
			emprestimosMenu = new EmprestimosMenuT();
			emprestimosAtivos = new EmprestimosAtivosT();
			
			solicitarCancelamento = new ConfirmarSenhaT();
			solicitarCartao = new SolicitarCartaoT();
			verCartoes = new SelecionarCartaoT();
			verFaturas = new SelecionarFaturaT();
			verCartao = new VisualizarCartaoT();
			verFatura = new VisualizarFaturaT();
			alterarSenha = new AlterarSenhaT();
			alterarDados = new AlterarDadosT();
			confirmarDados = new ConfirmarDadosT();
			consultar = new ConsultarT();
			pesquisarCpf = new PesquisarCpfT();
			pesquisarConta = new PesquisarContaT();
		    
		    login = new Login();
		    conta = new Conta();	    
			cliente = new Cliente();
			cartoes = new ArrayList<Cartao>();
			cartao = new Cartao();
			faturas = new ArrayList<Fatura>();
			fatura = new Fatura();
			auditoria = new Audit();
			emprestimo = new Emprestimo();
			clienteTransferencia = new Cliente();
		}
}
