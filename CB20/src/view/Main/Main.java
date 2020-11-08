package view.Main;

import Audit.Audit;
import model.Cartao.Tipo;
import model.Cliente.Cliente;
import model.Cliente.Profissao;
import model.Conta.Conta;
import model.Login.Login;
import view.Cartao.*;
import view.Cartao.SolicitarBloqueioT;
import view.Login.CriarContaT;
import view.Login.LoginT;
import view.Menu.MenuPrincipalT;
import view.Opcoes.OpcoesT;
import view.Operacao.CambioT;
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
		public static OpcoesT opcoes = new OpcoesT();
		public static SaldoT saldo = new SaldoT();
		public static CartaoT cartaoT = new CartaoT();
		public static TransferenciaT transferencia = new TransferenciaT();
		public static PagamentoT pagamento = new PagamentoT();
		public static DepositoT deposito = new DepositoT();
		public static EmprestimoT emprestimo = new EmprestimoT();
		public static CambioT cambio = new CambioT();
		
		public static SolicitarBloqueioT solicitarBloqueio = new SolicitarBloqueioT();
		public static SolicitarCancelamentoT solicitarCancelamento = new SolicitarCancelamentoT();
		public static SolicitarCartaoT solicitarCartao = new SolicitarCartaoT();
		public static SolicitarDesbloqueioT solicitarDesbloqueio = new SolicitarDesbloqueioT();
		public static SelecionarCartaoT verCartoes = new SelecionarCartaoT();
		public static SelecionarFaturaT verFaturas = new SelecionarFaturaT();
		public static VisualizarCartaoT verCartao = new VisualizarCartaoT();
		public static VisualizarFaturaT verFatura = new VisualizarFaturaT();
	    
	    
	    public static Login login = new Login();
	    public static Conta conta = new Conta();	    
		public static Cliente cliente = new Cliente();
		public static Audit auditoria = new Audit();
		
	    
		@SuppressWarnings("deprecation")
		public static void main(String[] argv) {
			
			System.out.print(Profissao.valueOf("Administração"));
			telaLogin.show();
		}
}
