package model.Cartao;

public enum Motivo {
	DESBLOQUEADO("desbloqueado"),
	ERRO_DA_SENHA("erro_da_senha"),
	ROUBO("roubo"),
	PERDA("perda"),
	VALIDADE_EXPIROU("validade_expirou"),
	OUTROS("outros");
	
	private String descricao;
	
	Motivo(String descricao){
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}
}
