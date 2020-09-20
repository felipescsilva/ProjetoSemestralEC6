package helio.contacorrente;

import java.time.LocalDate;
import java.util.Date;

public class Cliente {
	
	public enum Formacao{
		Sem_Escolaridade, Fundamental_Incompleto, Fundamental_Completo, Medio_Incompleto, 
			Medio_Completo, Superior_Incompleto, Superior_Completo;
	}
	public enum Profissao{
		Administra��o,Administra��o_P�blica,Agrimensura,Agroecologia,Agroneg�cios_e_Agropecu�ria,Agronomia,Alimentos,
		Anima��o,Aquicultura,Arqueologia,Arquitetura_e_Urbanismo,Arquivologia,Artes_Visuais,Astronomia,Automa��o_Industrial,
		Banco_de_Dados,Biblioteconomia,Biocombust�veis,Biomedicina,Biotecnologia,Biotecnologia_e_Bioqu�mica,
		Ci�ncia_da_Computa��o,Ci�ncia_e_Tecnologia,Ci�ncia_e_Tecnologia_de_Alimentos,Ci�ncias_Aeron�uticas,
		Ci�ncias_Agr�rias,Ci�ncias_Atuariais,Ci�ncias_Biol�gicas,Ci�ncias_Cont�beis,Ci�ncias_do_Consumo,Ci�ncias_Econ�micas,
		Ci�ncias_Humanas,Ci�ncias_Naturais_e_Exatas,Ci�ncias_Sociais,Cinema_e_Audiovisual,Com�rcio_Exterior,Computa��o,
		Comunica��o_das_Artes_do_Corpo,Comunica��o_em_M�dias_Digitais,Comunica��o_Institucional,Comunica��o_Organizacional,
		Conserva��o_e_Restauro,Constru��o_Civil,Constru��o_Naval,Cooperativismo,Dan�a,Defesa_e_Gest�o_Estrat�gica_Internacional,
		Design,Design_de_Games,Design_de_Interiores,Design_de_Moda,Direito,Ecologia,Educa��o_F�sica,Educomunica��o,
		Eletr�nica_Industrial,Eletrot�cnica_Industrial,Energias_Renov�veis,Enfermagem,Engenharia_Ac�stica,
		Engenharia_Aeron�utica,Engenharia_Agr�cola,Engenharia_Ambiental_e_Sanit�ria,Engenharia_Biom�dica,
		Engenharia_Bioqu�mica,_de_Bioprocessos_e_Biotecnologia,Engenharia_Cartogr�fica_e_de_Agrimensura,
		Engenharia_Civil,Engenharia_da_Computa��o,Engenharia_de_Alimentos,Engenharia_de_Biossistemas,
		Engenharia_de_Controle_e_Automa��o,Engenharia_de_Energia,Engenharia_de_Inova��o,Engenharia_de_Materiais,
		Engenharia_de_Minas,Engenharia_de_Pesca,Engenharia_de_Petr�leo,Engenharia_de_Produ��o,
		Engenharia_de_Seguran�a_no_Trabalho,Engenharia_de_Sistemas,Engenharia_de_Software,Engenharia_de_Telecomunica��es,
		Engenharia_de_Transporte_e_da_Mobilidade,Engenharia_El�trica,Engenharia_Eletr�nica,Engenharia_F�sica,
		Engenharia_Florestal,Engenharia_H�drica,Engenharia_Industrial_Madeireira,Engenharia_Mec�nica,
		Engenharia_Mecatr�nica,Engenharia_Metal�rgica,Engenharia_Naval,Engenharia_Nuclear,Engenharia_Qu�mica,
		Engenharia_T�xtil,Escrita_Criativa,Esporte,Estat�stica,Est�tica_e_Cosm�tica,Estudos_de_G�nero_e_Diversidade,
		Estudos_de_M�dia,Eventos,Fabrica��o_Mec�nica,Farm�cia,Filosofia,F�sica,Fisioterapia,Fonoaudiologia,Fotografia,
		Gastronomia,Geof�sica,Geografia,Geologia,Geoprocessamento,Gerontologia,Gest�o_Ambiental,Gest�o_Comercial,
		Gest�o_da_Informa��o,Gest�o_da_Produ��o_Industrial,Gest�o_da_Qualidade,Gest�o_da_Tecnologia_da_Informa��o,
		Gest�o_de_Cooperativas,Gest�o_de_Recursos_Humanos,Gest�o_de_Seguran�a_Privada,Gest�o_de_Seguros,
		Gest�o_de_Turismo,Gest�o_Desportiva_e_de_Lazer,Gest�o_em_Sa�de,Gest�o_Financeira,Gest�o_Hospitalar,
		Gest�o_P�blica,Hist�ria,Hist�ria_da_Arte,Hotelaria,Inform�tica,Inform�tica_Biom�dica,Irriga��o_e_Drenagem,
		Jogos_Digitais,Jornalismo,Letras,Libras,Lingu�stica,Log�stica,Luteria,Manuten��o_de_aeronaves,
		Manuten��o_Industrial,Marketing,Matem�tica,Materiais,Mecatr�nica_Industrial,Medicina,Medicina_Veterin�ria,
		Meteorologia,Minera��o,Museologia,M�sica,Musicoterapia,Nanotecnologia,Naturologia,Neg�cios_Imobili�rios,
		Nutri��o,Obstetr�cia,Oceanografia,Odontologia,Oft�lmica,Optometria,Papel_e_Celulose,Pedagogia,Petr�leo_e_G�s,
		Pilotagem_profissional_de_aeronaves,Processos_Gerenciais,Processos_Metal�rgicos,Processos_Qu�micos,
		Produ��o_Audiovisual,Produ��o_C�nica,Produ��o_Cultural,Produ��o_Editorial,Produ��o_Fonogr�fica,
		Produ��o_Multim�dia,Produ��o_Publicit�ria,Produ��o_Sucroalcooleira,Produ��o_T�xtil,Psicologia,
		Psicopedagogia,Publicidade_e_Propaganda,Qu�mica,Quiropraxia,R�dio,_TV_e_Internet,Radiologia,
		Redes_de_Computadores,Rela��es_Internacionais,Rela��es_P�blicas,Rochas_Ornamentais,Saneamento_Ambiental,
		Sa�de_Coletiva,Secretariado,Secretariado_Executivo,Seguran�a_da_Informa��o,Seguran�a_no_Trabalho,
		Seguran�a_P�blica,Servi�o_Social,Servi�os_Judici�rios_e_Notariais,Silvicultura,Sistemas_Biom�dicos,
		Sistemas_de_Informa��o,Sistemas_de_Telecomunica��es,Sistemas_El�tricos,Sistemas_Embarcados,
		Sistemas_para_Internet,Teatro,Teologia,Terapia_Ocupacional,Tradutor_e_Int�rprete,Transporte,
		Turismo,Zootecnia
		
		; //pegar uma lista de profissoes
	}
	private String CPF;
	private String nomeCliente;
	protected int renda;
	private LocalDate dataNascimento;	
	private Formacao formacao;
	private Profissao profissao;
	
	public Cliente(String CPF, String nomeCliente, int renda, LocalDate dataNascimento, Formacao formacao, Profissao profissao) throws Exception
	{
		this.setCPF(CPF);
		this.setNomeCliente(nomeCliente);
		this.setRenda(renda);
		this.setDataNascimento(dataNascimento);
		this.setFormacao(formacao);
		this.setProfissao(profissao);	
	}
	
	//Verifica se o CPF informado � o do cliente
	public boolean checkCPF(String CPF) {
		if(this.CPF.equals(CPF.replace("^0-9", "").trim())) {
			return true;
		}		
		return false;
	}

	//Define o CPF caso ele seja v�lido
	private void setCPF(String CPF) throws Exception {
		CPF = CPF.replace("^0-9", "").trim();
		if(CPF.length() == 11) {
			this.CPF = CPF;
		}
		else {
			throw new Exception("N�mero de CPF inv�lido!");
		}
		
	}

	//Retorna o primeiro nome do cliente
	public String getNomeCliente() {
		String[] aux = nomeCliente.split(" ");
		return aux[0];
	}
	
	//Verifica se o nome informado � o do cliente
	public boolean checkNomeCliente(String nomeCliente)
	{
		if(this.nomeCliente.trim().equals(nomeCliente.trim())) {
			return true;
		}
		return false;
	}

	//Define o nome do cliente caso ele seja v�lido
	private void setNomeCliente(String nomeCliente) throws Exception {
		if(nomeCliente.isEmpty())
		{
			throw new Exception("Nome inv�lido!");
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
			throw new Exception("A renda n�o pode ser negativa!");
		}
		this.renda = renda;
	}

	////////////////////////////////////////////////////////////////////////////////////
	public boolean checkDataNascimento(Date data) {
		//verificar se � a data de nascimento do cliente
		return true;
	}

	private void setDataNascimento(LocalDate dataNascimento) {
		//verificar se a data � v�lida 
		this.dataNascimento = dataNascimento;
	}

	public int calcularIdade() {
		//calcular idade
		return 0;
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

}
