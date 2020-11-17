package view.Main;

import java.util.ArrayList;
import java.util.List;

import Audit.Audit;
import model.Cartao.Cartao;
import model.Cartao.Tipo;
import model.Cliente.Cliente;
import model.Cliente.Formacao;
import model.Cliente.Profissao;
import model.Conta.Conta;
import model.Fatura.Fatura;
import model.Login.Login;
import model.Transferencia.Transferencia;
import view.Cartao.*;
import view.Cartao.SolicitarBloqueioT;
import view.Login.CriarContaT;
import view.Login.LoginT;
import view.Menu.MenuPrincipalT;
import view.Opcoes.AlterarDadosT;
import view.Opcoes.AlterarSenhaT;
import view.Opcoes.OpcoesAntigasT;
import view.Opcoes.OpcoesT;
import view.Opcoes.TelaSenha;
import view.Operacao.CambioT;
import view.Operacao.ConfirmarDadosT;
import view.Operacao.DepositoT;
import view.Operacao.EmprestimoT;
import view.Operacao.PagamentoT;
import view.Operacao.SaldoT;
import view.Operacao.TransferenciaT;

public class Main {
	
	    public static LoginT telaLogin = new LoginT();
	    public static MenuPrincipalT menuPrincipal = new MenuPrincipalT();
	    public static CriarContaT novaConta = new CriarContaT();
	    public static CriarContaT criarConta = new CriarContaT();
		public static OpcoesAntigasT opcoesAntigas = new OpcoesAntigasT();
		public static SaldoT saldo = new SaldoT();
		public static CartaoT cartaoT = new CartaoT();
		public static TransferenciaT transferencia = new TransferenciaT();
		public static PagamentoT pagamento = new PagamentoT();
		public static DepositoT deposito = new DepositoT();
		public static EmprestimoT emprestimo = new EmprestimoT();
		public static CambioT cambio = new CambioT();
		
		public static SolicitarBloqueioT solicitarBloqueio = new SolicitarBloqueioT();
		public static ConfirmarSenhaT solicitarCancelamento = new ConfirmarSenhaT();
		public static SolicitarCartaoT solicitarCartao = new SolicitarCartaoT();
		public static SolicitarDesbloqueioT solicitarDesbloqueio = new SolicitarDesbloqueioT();
		public static SelecionarCartaoT verCartoes = new SelecionarCartaoT();
		public static SelecionarFaturaT verFaturas = new SelecionarFaturaT();
		public static VisualizarCartaoT verCartao = new VisualizarCartaoT();
		public static VisualizarFaturaT verFatura = new VisualizarFaturaT();
	    
	    
	    public static Login login = new Login();
	    public static Conta conta = new Conta();	  
		public static Cliente cliente = new Cliente();
		public static List<Cartao> cartoes = new ArrayList<Cartao>();
		public static Cartao cartao = new Cartao();
		public static List<Fatura> faturas = new ArrayList<Fatura>();
		public static Fatura fatura = new Fatura();
		public static Audit auditoria = new Audit();
		public static ConfirmarDadosT confirmarDadosT = new ConfirmarDadosT();
		public static Conta contaTransferencia = new Conta();
		public static Cliente clienteTransferencia = new Cliente();
		public static Transferencia transferir = new Transferencia();
		
		public static OpcoesT opcoes = new OpcoesT();
		public static AlterarSenhaT alterarSenha = new AlterarSenhaT();
		public static TelaSenha telaSelecionada;
		public static AlterarDadosT alterarDadosT = new AlterarDadosT();
	    
		@SuppressWarnings("deprecation")
		public static void main(String[] argv) {
			
			System.out.println(Profissao.valueOf("Administração"));
			System.out.println(Formacao.valueOf("Fundamental_Incompleto"));
			//System.out.println(Formacao.valueOf("FUNDAMENTAL_INCOMPLETO"));
			telaLogin.show();
		}
}
