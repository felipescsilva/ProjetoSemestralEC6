package model.Cartao;

public enum Bloqueado {
	DESBLOQUEADO("desbloqueado"),
	BLOQUEADO("bloqueado"),
	BLOQUEADO_PERMANENTEMENTE("bloqueado_permanentemente");
	
	private String descricao;
	
	Bloqueado(String descricao) {
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}
}
