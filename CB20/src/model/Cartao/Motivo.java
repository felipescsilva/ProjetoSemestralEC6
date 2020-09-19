package model.Cartao;

public enum Motivo {
	DESBLOQUEADO("desbloqueado"),
	ERRO_DA_SENHA("erroDaSenha"),
	ROUBO("roubo"),
	PERDA("perda"),
	VALIDADE_EXPIROU("validadeExpirou"),
	OUTROS("outros");
	
	private String descricao;
	
	Motivo(String descricao){
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}
}
