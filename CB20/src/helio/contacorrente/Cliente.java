package helio.contacorrente;

import java.time.LocalDate;
import java.util.Date;

public class Cliente {
	
	public enum Formacao{
		Sem_Escolaridade, Fundamental_Incompleto, Fundamental_Completo, Medio_Incompleto, 
			Medio_Completo, Superior_Incompleto, Superior_Completo;
	}
	public enum Profissao{
		Administração,Administração_Pública,Agrimensura,Agroecologia,Agronegócios_e_Agropecuária,Agronomia,Alimentos,
		Animação,Aquicultura,Arqueologia,Arquitetura_e_Urbanismo,Arquivologia,Artes_Visuais,Astronomia,Automação_Industrial,
		Banco_de_Dados,Biblioteconomia,Biocombustíveis,Biomedicina,Biotecnologia,Biotecnologia_e_Bioquímica,
		Ciência_da_Computação,Ciência_e_Tecnologia,Ciência_e_Tecnologia_de_Alimentos,Ciências_Aeronáuticas,
		Ciências_Agrárias,Ciências_Atuariais,Ciências_Biológicas,Ciências_Contábeis,Ciências_do_Consumo,Ciências_Econômicas,
		Ciências_Humanas,Ciências_Naturais_e_Exatas,Ciências_Sociais,Cinema_e_Audiovisual,Comércio_Exterior,Computação,
		Comunicação_das_Artes_do_Corpo,Comunicação_em_Mídias_Digitais,Comunicação_Institucional,Comunicação_Organizacional,
		Conservação_e_Restauro,Construção_Civil,Construção_Naval,Cooperativismo,Dança,Defesa_e_Gestão_Estratégica_Internacional,
		Design,Design_de_Games,Design_de_Interiores,Design_de_Moda,Direito,Ecologia,Educação_Física,Educomunicação,
		Eletrônica_Industrial,Eletrotécnica_Industrial,Energias_Renováveis,Enfermagem,Engenharia_Acústica,
		Engenharia_Aeronáutica,Engenharia_Agrícola,Engenharia_Ambiental_e_Sanitária,Engenharia_Biomédica,
		Engenharia_Bioquímica,_de_Bioprocessos_e_Biotecnologia,Engenharia_Cartográfica_e_de_Agrimensura,
		Engenharia_Civil,Engenharia_da_Computação,Engenharia_de_Alimentos,Engenharia_de_Biossistemas,
		Engenharia_de_Controle_e_Automação,Engenharia_de_Energia,Engenharia_de_Inovação,Engenharia_de_Materiais,
		Engenharia_de_Minas,Engenharia_de_Pesca,Engenharia_de_Petróleo,Engenharia_de_Produção,
		Engenharia_de_Segurança_no_Trabalho,Engenharia_de_Sistemas,Engenharia_de_Software,Engenharia_de_Telecomunicações,
		Engenharia_de_Transporte_e_da_Mobilidade,Engenharia_Elétrica,Engenharia_Eletrônica,Engenharia_Física,
		Engenharia_Florestal,Engenharia_Hídrica,Engenharia_Industrial_Madeireira,Engenharia_Mecânica,
		Engenharia_Mecatrônica,Engenharia_Metalúrgica,Engenharia_Naval,Engenharia_Nuclear,Engenharia_Química,
		Engenharia_Têxtil,Escrita_Criativa,Esporte,Estatística,Estética_e_Cosmética,Estudos_de_Gênero_e_Diversidade,
		Estudos_de_Mídia,Eventos,Fabricação_Mecânica,Farmácia,Filosofia,Física,Fisioterapia,Fonoaudiologia,Fotografia,
		Gastronomia,Geofísica,Geografia,Geologia,Geoprocessamento,Gerontologia,Gestão_Ambiental,Gestão_Comercial,
		Gestão_da_Informação,Gestão_da_Produção_Industrial,Gestão_da_Qualidade,Gestão_da_Tecnologia_da_Informação,
		Gestão_de_Cooperativas,Gestão_de_Recursos_Humanos,Gestão_de_Segurança_Privada,Gestão_de_Seguros,
		Gestão_de_Turismo,Gestão_Desportiva_e_de_Lazer,Gestão_em_Saúde,Gestão_Financeira,Gestão_Hospitalar,
		Gestão_Pública,História,História_da_Arte,Hotelaria,Informática,Informática_Biomédica,Irrigação_e_Drenagem,
		Jogos_Digitais,Jornalismo,Letras,Libras,Linguística,Logística,Luteria,Manutenção_de_aeronaves,
		Manutenção_Industrial,Marketing,Matemática,Materiais,Mecatrônica_Industrial,Medicina,Medicina_Veterinária,
		Meteorologia,Mineração,Museologia,Música,Musicoterapia,Nanotecnologia,Naturologia,Negócios_Imobiliários,
		Nutrição,Obstetrícia,Oceanografia,Odontologia,Oftálmica,Optometria,Papel_e_Celulose,Pedagogia,Petróleo_e_Gás,
		Pilotagem_profissional_de_aeronaves,Processos_Gerenciais,Processos_Metalúrgicos,Processos_Químicos,
		Produção_Audiovisual,Produção_Cênica,Produção_Cultural,Produção_Editorial,Produção_Fonográfica,
		Produção_Multimídia,Produção_Publicitária,Produção_Sucroalcooleira,Produção_Têxtil,Psicologia,
		Psicopedagogia,Publicidade_e_Propaganda,Química,Quiropraxia,Rádio,_TV_e_Internet,Radiologia,
		Redes_de_Computadores,Relações_Internacionais,Relações_Públicas,Rochas_Ornamentais,Saneamento_Ambiental,
		Saúde_Coletiva,Secretariado,Secretariado_Executivo,Segurança_da_Informação,Segurança_no_Trabalho,
		Segurança_Pública,Serviço_Social,Serviços_Judiciários_e_Notariais,Silvicultura,Sistemas_Biomédicos,
		Sistemas_de_Informação,Sistemas_de_Telecomunicações,Sistemas_Elétricos,Sistemas_Embarcados,
		Sistemas_para_Internet,Teatro,Teologia,Terapia_Ocupacional,Tradutor_e_Intérprete,Transporte,
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
	
	//Verifica se o CPF informado é o do cliente
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

	////////////////////////////////////////////////////////////////////////////////////
	public boolean checkDataNascimento(Date data) {
		//verificar se é a data de nascimento do cliente
		return true;
	}

	private void setDataNascimento(LocalDate dataNascimento) {
		//verificar se a data é válida 
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
