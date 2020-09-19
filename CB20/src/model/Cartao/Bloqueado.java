package model.Cartao;

public enum Bloqueado {
	DESBLOQUEADO("desbloqueado"),
	BLOQUEADO("bloqueado"),
	BLOQUEADO_PERMANENTEMENTE("bloquedoPermanentemente");
	
	private String descricao;
	
	Bloqueado(String descricao) {
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}
}
