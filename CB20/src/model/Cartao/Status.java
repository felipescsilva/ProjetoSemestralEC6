package model.Cartao;

public enum Status {
	DESBLOQUEADO("desbloqueado"),
	BLOQUEADO("bloqueado"),
	BLOQUEADO_POR_ERRO_DE_SENHA("bloqueado_por_erro_de_senha"),
	BLOQUEADO_POR_FATURA("bloqueado"),
	CANCELADO("cancelado");
	
	private String descricao;
	
	Status(String descricao) {
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}
}
